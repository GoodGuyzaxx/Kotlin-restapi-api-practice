package me.zaxx.restfullapi.controller

import jakarta.validation.ConstraintViolationException
import me.zaxx.restfullapi.model.WebResponse
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice


@RestControllerAdvice
class ErrorController {
    @ExceptionHandler(value = [ConstraintViolationException::class])
    fun validationHandler(constraintViolationException: ConstraintViolationException): WebResponse<String>{
        return WebResponse(
            code = 400,
            status = "BAD_REQUEST",
            data = constraintViolationException.message!!
        )
    }
}