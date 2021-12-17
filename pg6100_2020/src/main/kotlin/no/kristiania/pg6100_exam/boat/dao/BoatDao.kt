package no.kristiania.pg6100_exam.boat.dao

import no.kristiania.pg6100_exam.boat.entity.Boat
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

// Adapted from: https://github.com/MarianoLopez/SpringKotlinBuildingRestApiTutorial/blob/develop/src/main/kotlin/com/z/springkotlinz/dao/PersonDao.kt


@Repository
interface BoatDao: JpaRepository<Boat, Long>