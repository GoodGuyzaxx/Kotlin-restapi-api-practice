package me.zaxx.restfullapi.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "api_key")
data class ApiKey(

        @Id
        val id: String
)

