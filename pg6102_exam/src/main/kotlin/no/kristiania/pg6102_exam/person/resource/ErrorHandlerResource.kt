package no.kristiania.pg6102_exam.person.resource

import no.kristiania.pg6102_exam.person.dto.ErrorResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ErrorHandlerResource {

    @ExceptionHandler(IllegalStateException::class)
    fun handleIllegalState(ex: IllegalStateException) : ResponseEntity<ErrorResponse> {
        return ResponseEntity.badRequest().body(ErrorResponse(message = ex.localizedMessage))
    }
}