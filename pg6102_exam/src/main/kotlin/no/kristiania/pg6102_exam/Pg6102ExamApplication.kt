package no.kristiania.pg6102_exam

import no.kristiania.pg6102_exam.boat.dto.BoatResponse
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController



@SpringBootApplication
@RestController
class Pg6102ExamApplication {


	@GetMapping("")
	fun hi(): BoatResponse {
		return BoatResponse(17, "Laurent Bajrami")
	}
}



fun main(args: Array<String>) {
	runApplication<Pg6102ExamApplication>(*args)
}
