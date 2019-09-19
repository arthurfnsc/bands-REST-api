package br.com.arthurfnsc.bandsapi.configs.security

import br.com.arthurfnsc.bandsapi.models.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.oauth2.core.user.OAuth2User
import java.util.*


class UserPrincipal(
    private val id: Long?,
    private val email: String?,
    private val password: String?,
    private val authorities: Collection<GrantedAuthority>?
) : OAuth2User, UserDetails {

    private var attributes: Map<String, Any>? = null

    fun getId(): Long? = this.id

    override fun getPassword(): String? = this.password

    override fun getUsername(): String? =this.email

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isEnabled(): Boolean = true

    override fun getAuthorities(): Collection<GrantedAuthority>? = this.authorities

    override fun getAttributes(): Map<String, Any>? = this.attributes

    fun setAttributes(attributes: Map<String, Any>) {
        this.attributes = attributes
    }

    override fun getName(): String = id.toString()

    companion object {

        fun create(user: User): UserPrincipal {
            val authorities = Collections.singletonList(SimpleGrantedAuthority("ROLE_USER"))

            return UserPrincipal(
                user.id,
                user.email,
                user.password!!,
                authorities
            )
        }

        fun create(user: User, attributes: Map<String, Any>): UserPrincipal {
            val userPrincipal = UserPrincipal.create(user)
            userPrincipal.setAttributes(attributes)
            return userPrincipal
        }
    }
}
