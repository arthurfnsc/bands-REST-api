package br.com.arthurfnsc.bandsapi.configs.security.oauth2.user

class GoogleOAuth2UserInfo(
        private val attributes: MutableMap<String, Any>
) {
    fun getId(): String = this.attributes["sub"] as String

    fun getEmail(): String = this.attributes["email"] as String

    fun getName(): String = this.attributes["name"] as String
}
