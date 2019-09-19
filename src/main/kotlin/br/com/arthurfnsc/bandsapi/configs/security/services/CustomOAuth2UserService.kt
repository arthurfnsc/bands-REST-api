package br.com.arthurfnsc.bandsapi.configs.security.services

import br.com.arthurfnsc.bandsapi.configs.security.UserPrincipal
import br.com.arthurfnsc.bandsapi.configs.security.oauth2.user.GoogleOAuth2UserInfo
import br.com.arthurfnsc.bandsapi.exceptions.OAuth2AuthenticationProcessingException
import br.com.arthurfnsc.bandsapi.models.User
import br.com.arthurfnsc.bandsapi.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.InternalAuthenticationServiceException
import org.springframework.security.core.AuthenticationException
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest
import org.springframework.security.oauth2.core.OAuth2AuthenticationException
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.stereotype.Service
import org.springframework.util.StringUtils

@Service
class CustomOAuth2UserService : DefaultOAuth2UserService() {

    @Autowired
    private val userRepository: UserRepository? = null

    @Throws(OAuth2AuthenticationException::class)
    override fun loadUser(oAuth2UserRequest: OAuth2UserRequest): OAuth2User {
        val oAuth2User = super.loadUser(oAuth2UserRequest)

        try {
            return processOAuth2User(oAuth2UserRequest, oAuth2User)
        } catch (ex: AuthenticationException) {
            throw ex
        } catch (ex: Exception) {
            // Throwing an instance of AuthenticationException will trigger the OAuth2AuthenticationFailureHandler
            throw InternalAuthenticationServiceException(ex.message, ex.cause)
        }

    }

    private fun processOAuth2User(oAuth2UserRequest: OAuth2UserRequest, oAuth2User: OAuth2User): OAuth2User {
        val oAuth2UserInfo = GoogleOAuth2UserInfo(oAuth2User.attributes)

        if (StringUtils.isEmpty(oAuth2UserInfo.email)) {
            throw OAuth2AuthenticationProcessingException("Email not found from OAuth2 provider")
        }

        val userOptional = userRepository!!.findByEmail(oAuth2UserInfo.email)
        var user: User
        if (userOptional.isPresent) {
            user = userOptional.get()

            user = updateExistingUser(user, oAuth2UserInfo)
        } else {
            user = registerNewUser(oAuth2UserRequest, oAuth2UserInfo)
        }

        return UserPrincipal.create(user, oAuth2User.attributes)
    }

    private fun registerNewUser(oAuth2UserRequest: OAuth2UserRequest, oAuth2UserInfo: GoogleOAuth2UserInfo): User {
        val user = User(name = oAuth2UserInfo.name, email = oAuth2UserInfo.email, image = oAuth2UserInfo.imageUrl)

        return userRepository!!.save(user)
    }

    private fun updateExistingUser(existingUser: User, oAuth2UserInfo: GoogleOAuth2UserInfo): User {
        existingUser.name = oAuth2UserInfo.name
        existingUser.image = oAuth2UserInfo.imageUrl
        return userRepository!!.save(existingUser)
    }

}
