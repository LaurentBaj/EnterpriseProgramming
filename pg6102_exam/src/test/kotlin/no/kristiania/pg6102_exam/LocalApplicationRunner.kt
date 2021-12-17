package no.kristiania.pg6102_exam

import org.springframework.boot.SpringApplication


fun main(args: Array<String>) {
    SpringApplication.run(Pg6102ExamApplication::class.java, "--spring.profiles.active=test")
}