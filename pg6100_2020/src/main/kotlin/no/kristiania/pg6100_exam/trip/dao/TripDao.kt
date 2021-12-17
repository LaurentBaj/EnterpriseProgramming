package no.kristiania.pg6100_exam.trip.dao

// Adapted from: https://github.com/MarianoLopez/SpringKotlinBuildingRestApiTutorial/blob/develop/src/main/kotlin/com/z/springkotlinz/dao/PersonDao.kt

import no.kristiania.pg6100_exam.trip.entity.Trip
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TripDao: JpaRepository<Trip, Long>