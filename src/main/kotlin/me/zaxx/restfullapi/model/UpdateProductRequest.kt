package me.zaxx.restfullapi.model

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.util.Date

data class UpdateProductRequest(

        @field:NotBlank
        val name: String,

        @field:NotNull
        @field:Min(1)
        val price: Long,

        @field:NotNull
        @field:Min(0)
        val quantity: Int,

        val updatedAt: Date
)