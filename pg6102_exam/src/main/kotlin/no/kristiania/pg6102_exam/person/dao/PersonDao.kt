package no.kristiania.pg6102_exam.person.dao

import no.kristiania.pg6102_exam.person.domain.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonDao: JpaRepository<Person, Long>