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
            save(AddBoatRequest("Laurent", "Bajrami"))
            save(AddBoatRequest("Ben", "Bajrami"))
            save(AddBoatRequest("Arzana", "Bajrami"))
            save(AddBoatRequest("Osman", "Bajrami"))
        }
    }
}