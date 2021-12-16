package no.kristiania.pg6102_exam.boat.dao

import no.kristiania.pg6102_exam.boat.entity.Boat
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BoatDao: JpaRepository<Boat, Long>