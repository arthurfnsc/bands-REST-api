package br.com.arthurfnsc.bandsapi.configs.security.oauth2.user

class GoogleOAuth2UserInfo(private val attributes: Map<String, Any>) {

    val id: String
        get() = attributes.get("sub") as String

    val name: String
        get() = attributes.get("name") as String

    val email: String
        get() = attributes.get("email") as String

    val imageUrl: String
        get() = attributes.get("picture") as String
}
