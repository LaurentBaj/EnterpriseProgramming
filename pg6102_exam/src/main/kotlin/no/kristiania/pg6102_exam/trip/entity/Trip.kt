package no.kristiania.pg6102_exam.trip.entity

import no.kristiania.pg6102_exam.boat.entity.Boat
import no.kristiania.pg6102_exam.shared.URLs.TRIP_SEQUENCE
import javax.persistence.*

@Entity
class Trip(

    @Id
    @SequenceGenerator(name = TRIP_SEQUENCE, sequenceName = TRIP_SEQUENCE, initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TRIP_SEQUENCE)
    val id: Long = 1,

    var departurePort: String = "",

    var destinationPort: String? = null,

    @OneToMany(mappedBy = "trip", cascade = [(CascadeType.ALL)], fetch = FetchType.EAGER)
    var boats: MutableList<Boat>? = null
)

// Adapted from: https://github.com/MarianoLopez/SpringKotlinBuildingRestApiTutorial/blob/develop/src/main/kotlin/com/z/springkotlinz/domain/Person.kt
