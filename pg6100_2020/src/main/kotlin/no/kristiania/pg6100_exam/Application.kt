package no.kristiania.pg6100_exam

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.bind.annotation.RestController
import springfox.documentation.builders.PathSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket


@SpringBootApplication
@RestController
class Application {

	// http://localhost:8080/swagger-ui/index.html#/
	@Bean
	fun swaggerApi(): Docket {
		return Docket(DocumentationType.OAS_30)
				.select()
				.paths(PathSelectors.any())
				.build()
	}
}



fun main(args: Array<String>) {
	runApplication<Application>(*args)
}
