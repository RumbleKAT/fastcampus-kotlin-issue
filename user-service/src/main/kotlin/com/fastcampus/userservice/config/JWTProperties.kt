package com.fastcampus.userservice.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding //불변으로 처리한다.
@ConfigurationProperties(prefix = "jwt")
data class JWTProperties(
    val issuer : String,
    val subject : String,
    val expiresTime : Long,
    val secret : String,
)