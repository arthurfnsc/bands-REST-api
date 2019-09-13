package br.com.arthurfnsc.bandsapi.configs.security.oauth2

import br.com.arthurfnsc.bandsapi.configs.security.UserPrincipal
import br.com.arthurfnsc.bandsapi.configs.security.oauth2.user.GoogleOAuth2UserInfo
import br.com.arthurfnsc.bandsapi.models.User
import br.com.arthurfnsc.bandsapi.repositories.UserRepository
import org.springframework.security.authentication.InternalAuthenticationServiceException
import org.springframework.security.core.AuthenticationException
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.stereotype.Service

@Service
class CustomOAuth2UserService(
    private val userRepository: UserRepository
): DefaultOAuth2UserService() {

    override fun loadUser(userRequest: OAuth2UserRequest): OAuth2User {

        val oAuth2User = super.loadUser(userRequest)

        try {
            return processOAuth2User(oAuth2User)
        } catch (ex: AuthenticationException) {
            throw ex
        } catch (ex: Exception) {
            // Throwing an instance of AuthenticationException will trigger the OAuth2AuthenticationFailureHandler
            throw InternalAuthenticationServiceException(ex.message, ex.cause)
        }
    }

    private fun processOAuth2User(oAuth2User: OAuth2User): OAuth2User {

        val oAuth2UserInfo = GoogleOAuth2UserInfo(oAuth2User.attributes)

        val userOptional = userRepository.findByEmail(oAuth2UserInfo.getEmail())

        var user: User
        if (userOptional.isPresent) {

            user = userOptional.get()
            user = updateExistingUser(user, oAuth2UserInfo)
        } else {

            user = registerNewUser(oAuth2UserInfo)
        }

        return UserPrincipal.create(user, oAuth2User.attributes)
    }

    private fun registerNewUser(oAuth2UserInfo: GoogleOAuth2UserInfo): User {

        val user = User(name = oAuth2UserInfo.getName(), email = oAuth2UserInfo.getEmail())

        return userRepository.save(user)
    }

    private fun updateExistingUser(existingUser: User, oAuth2UserInfo: GoogleOAuth2UserInfo): User {

        existingUser.name = oAuth2UserInfo.getName()

        return userRepository.save(existingUser)
    }
}
