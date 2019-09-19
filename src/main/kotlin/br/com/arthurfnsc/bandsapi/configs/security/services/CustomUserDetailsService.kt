package br.com.arthurfnsc.bandsapi.configs.security.services

import br.com.arthurfnsc.bandsapi.configs.security.UserPrincipal
import br.com.arthurfnsc.bandsapi.exceptions.ResourceNotFoundException
import br.com.arthurfnsc.bandsapi.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CustomUserDetailsService : UserDetailsService {

    @Autowired
    internal var userRepository: UserRepository? = null

    @Transactional
    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(email: String): UserDetails {
        val user = userRepository!!.findByEmail(email)
            .orElseThrow { UsernameNotFoundException("User not found with email : $email") }

        return UserPrincipal.create(user)
    }

    @Transactional
    fun loadUserById(id: Long?): UserDetails {
        val user = userRepository!!.findById(id!!).orElseThrow { ResourceNotFoundException("User", "id", id!!) }

        return UserPrincipal.create(user)
    }
}
