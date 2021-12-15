package no.kristiania.pg6102_exam.trip.dao

import no.kristiania.pg6102_exam.trip.entity.Trip
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TripDao: JpaRepository<Trip, Long>