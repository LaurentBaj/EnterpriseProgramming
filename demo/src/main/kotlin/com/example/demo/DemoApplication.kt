package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import springfox.documentation.builders.PathSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket

@SpringBootApplication
class DemoApplication {

	@Bean
	fun swaggerApi(): Docket {
		return Docket(DocumentationType.OAS_30)
				.select()
				.paths(PathSelectors.any())
				.build()
	}
}

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}
