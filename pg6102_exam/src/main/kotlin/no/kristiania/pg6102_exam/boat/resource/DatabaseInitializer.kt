package no.kristiania.pg6102_exam.boat.resource

import no.kristiania.pg6102_exam.boat.dto.AddBoatRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct

@Service
class DatabaseInitializer(
        @Autowired val repository: BoatResourceImpl
) {

    @PostConstruct
    fun initialize(){
        repository.run {
            deleteAll()
            save(AddBoatRequest("Serenity", "Graydon Hoare", 12))
            save(AddBoatRequest("Grace", "Dennis M. Ritchie"))
            save(AddBoatRequest("Pegasus", "Linus Torvalds", 3))
            save(AddBoatRequest("Rum Runner", "Bjarne Stroustrup", 9))
        }
    }
}