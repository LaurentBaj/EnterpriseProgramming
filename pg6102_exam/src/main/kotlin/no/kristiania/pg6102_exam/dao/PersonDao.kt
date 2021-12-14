package no.kristiania.pg6102_exam.dao

import no.kristiania.pg6102_exam.domain.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonDao: JpaRepository<Person, Long>