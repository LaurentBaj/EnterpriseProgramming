package no.kristiania.pg6102_exam

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.RestController


@SpringBootApplication
@RestController
class Pg6102ExamApplication {

	// Swagger does not work though I have followed the steps in Arcuri's repository
//	@Bean
//	fun swaggerApi(): Docket {
//		return Docket(DocumentationType.OAS_30)
//				.select()
//				.paths(PathSelectors.any())
//				.build()
//	}
}



fun main(args: Array<String>) {
	runApplication<Pg6102ExamApplication>(*args)
}
