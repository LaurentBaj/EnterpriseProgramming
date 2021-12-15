package no.kristiania.pg6102_exam

import no.kristiania.pg6102_exam.person.domain.Person
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController



@SpringBootApplication
@RestController
class Pg6102ExamApplication {


	@GetMapping("")
	fun hi(): Person {
		return Person(name = "Laurent", lastName = "Bajrami")
	}
}



fun main(args: Array<String>) {
	runApplication<Pg6102ExamApplication>(*args)
}
