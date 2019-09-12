package br.com.arthurfnsc.bandsapi.configs.security

import br.com.arthurfnsc.bandsapi.models.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.security.core.authority.SimpleGrantedAuthority
import java.util.*

class UserPrincipal(
        val id: Long?,
        private val email: String,
        private val password: String?,
        private val authorities: Collection<GrantedAuthority>
): OAuth2User, UserDetails {

    companion object{

        fun create(user: User): UserPrincipal {

            val authorities = Collections.singletonList(SimpleGrantedAuthority("ROLE_USER"))

            return UserPrincipal(
                    user.id,
                    user.email,
                    null,
                    authorities
            )
        }

        fun create(user: User, attributes: MutableMap<String, Any>): UserPrincipal {
            val userPrincipal = create(user)
            userPrincipal.setAttributes(attributes)
            return userPrincipal
        }
    }

    private lateinit var attributes: MutableMap<String, Any>

    override fun getAttributes(): MutableMap<String, Any> = this.attributes

    override fun getAuthorities(): Collection<GrantedAuthority> = this.authorities

    override fun getName(): String = id.toString()

    override fun getPassword(): String? = this.password

    override fun getUsername(): String = this.email

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isEnabled(): Boolean = true

    fun setAttributes(attributes: MutableMap<String, Any>) {
        this.attributes = attributes
    }
}
