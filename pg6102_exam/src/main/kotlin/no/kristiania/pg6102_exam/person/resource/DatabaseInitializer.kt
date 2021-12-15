package no.kristiania.pg6102_exam.person.resource

import no.kristiania.pg6102_exam.person.dto.AddPersonRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct

@Service
class DatabaseInitializer(
        @Autowired val repository: PersonResourceImpl
) {

    @PostConstruct
    fun initialize(){
        repository.run {
            deleteAll()
            save(AddPersonRequest("Laurent", "Bajrami"))
            save(AddPersonRequest("Ben", "Bajrami"))
            save(AddPersonRequest("Arzana", "Bajrami"))
            save(AddPersonRequest("Osman", "Bajrami"))
        }
    }
}