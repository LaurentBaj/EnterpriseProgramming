package no.kristiania.pg6102_exam.shared

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

// THIS USED TO WORK IN THE BEGINNING, BUT AS I CONTINUED DEVELOPING THE PROJECT
// IT THEN STARTED TO ACT VERY STRANGE, SO I JUST REMOVED IT

//@ControllerAdvice
//class ErrorHandlerResource {
//
//    @ExceptionHandler(IllegalStateException::class)
//    fun handleIllegalState(ex: IllegalStateException) : ResponseEntity<ErrorResponse> {
//        return ResponseEntity.badRequest().body(ErrorResponse(message = ex.localizedMessage))
//    }
//}