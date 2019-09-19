package br.com.arthurfnsc.bandsapi.models

import java.io.Serializable
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table
data class User(

    @Id
    var id: Long? = null,
    var name: String,
    var email: String,
    var image: String,
    var password: String? = null
): Serializable
