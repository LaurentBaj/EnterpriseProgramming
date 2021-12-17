package no.kristiania.pg6100_exam.shared

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