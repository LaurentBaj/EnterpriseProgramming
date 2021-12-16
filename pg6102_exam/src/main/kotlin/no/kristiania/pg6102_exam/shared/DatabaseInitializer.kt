package no.kristiania.pg6102_exam.shared

import no.kristiania.pg6102_exam.boat.dto.AddBoatRequest
import no.kristiania.pg6102_exam.boat.dto.UpdateBoatResponse
import no.kristiania.pg6102_exam.boat.entity.Boat
import no.kristiania.pg6102_exam.boat.resource.BoatResourceImpl
import no.kristiania.pg6102_exam.trip.dto.AddTripRequest
import no.kristiania.pg6102_exam.trip.dto.UpdateTripResponse
import no.kristiania.pg6102_exam.trip.entity.Trip
import no.kristiania.pg6102_exam.trip.resource.TripResourceImpl
import no.kristiania.pg6102_exam.trip.service.TripManagementServiceImpl
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

            update(UpdateBoatResponse(1, "Ser", "Gray", 12))
            deleteById(1)
        }
    }
}