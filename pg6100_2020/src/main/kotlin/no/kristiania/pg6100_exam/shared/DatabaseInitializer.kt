package no.kristiania.pg6100_exam.shared

import no.kristiania.pg6100_exam.boat.dto.AddBoatRequest
import no.kristiania.pg6100_exam.boat.resource.BoatResourceImpl
import no.kristiania.pg6100_exam.trip.dto.AddTripRequest
import no.kristiania.pg6100_exam.trip.resource.TripResourceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct

/*
    Default Boats and Trips
*/

@Service
class DatabaseInitializer(
        @Autowired val boatRepository: BoatResourceImpl,
        @Autowired val tripRepository: TripResourceImpl
) {

    @PostConstruct
    fun initialize(){
        tripRepository.run {
            deleteAll()
            save(AddTripRequest("Oslo", "Reykjavik"))
            save(AddTripRequest("Amsterdam", "Milan"))
            save(AddTripRequest("Dublin", "London"))
            save(AddTripRequest("Bratislava", "Johannesburg"))
        }

        boatRepository.run {
            deleteAll()
            save(AddBoatRequest("Serenity", "Graydon Hoare", 12))
            save(AddBoatRequest("Grace", "Dennis M. Ritchie"))
            save(AddBoatRequest("Pegasus", "Linus Torvalds", 3))
            save(AddBoatRequest("Rum Runner", "Bjarne Stroustrup", 9))
        }
    }
}


// Adapted from: https://github.com/arcuri82/testing_security_development_enterprise_systems/blob/master/advanced/rest/gui-v1/src/main/kotlin/org/tsdes/advanced/rest/guiv1/db/DatabaseInitializer.kt