package no.kristiania.pg6102_exam

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.RestController



@SpringBootApplication
@RestController
class Pg6102ExamApplication



fun main(args: Array<String>) {
	runApplication<Pg6102ExamApplication>(*args)
}
