package me.zaxx.restfullapi.repository

import me.zaxx.restfullapi.entity.ApiKey
import org.springframework.data.jpa.repository.JpaRepository

interface ApiKeyRepository: JpaRepository<ApiKey, String> {
}