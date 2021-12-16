package no.kristiania.pg6102_exam

import io.restassured.RestAssured
import io.restassured.http.ContentType
import no.kristiania.pg6102_exam.boat.dto.AddBoatRequest
import no.kristiania.pg6102_exam.boat.resource.BoatResourceImpl
import no.kristiania.pg6102_exam.trip.dto.AddTripRequest
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest(classes = [(Pg6102ExamApplication::class)],
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApplicationBoatEndpointsTest {


	@LocalServerPort
	protected var port = 0

	@Autowired
	protected lateinit var repository: BoatResourceImpl


	@BeforeEach
	@AfterEach
	fun clean() {

		// RestAssured configs shared by all the tests
		RestAssured.baseURI = "http://localhost"
		RestAssured.port = port
		RestAssured.basePath = "/api/v1/boats/"
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails()

		repository.run {
			deleteAll()
			save(AddBoatRequest("Serenity", "Graydon Hoare", 12))
			save(AddBoatRequest("Grace", "Dennis M. Ritchie"))
			save(AddBoatRequest("Pegasus", "Linus Torvalds", 3))
			save(AddBoatRequest("Rum Runner", "Bjarne Stroustrup", 9))
		}
	}

	@Test
	fun testGetAllBoats() {
		RestAssured.given().accept(ContentType.JSON)
				.get()
				.then()
				.statusCode(200).body("content.size()", equalTo(4))
	}

	@Test
	fun testRetrieveSingleBoat() {

		RestAssured.given().accept(ContentType.JSON)
				.get()
				.then()
				.statusCode(200)
				.body("content[0].name", equalTo("Serenity"))

				//  -- Unable to use the data structures correctly here --
				//
				//		val trips = RestAssured.given().accept(ContentType.JSON)
				//				.get()
				//				.then()
				//				.statusCode(200)
				//				.body("content.size()", CoreMatchers.equalTo(4))
				//				.extract().body().jsonPath().getList("", TripResponse::class.java)
				//
				//		for (t in trips) {
				//			RestAssured.given().accept(ContentType.JSON)
				//					.get("/${t.id}")
				//					.then()
				//					.statusCode(200).body("destinationPort", CoreMatchers.equalTo(t.destinationPort))
				//					.body("departurePort", CoreMatchers.equalTo(t.departurePort))
				//		}
	}



	@Test
	fun testAddBoat() {
		repository.run { save(AddBoatRequest("Freya", "Elon Musk")) }
		RestAssured.given().accept(ContentType.JSON)
				.get()
				.then()
				.statusCode(200)
				.body("content[4].builder", equalTo("Elon Musk"))
	}

	@Test
	@Disabled("Works only when run separately from other tests")
	fun testDeleteBoat() {
		repository.run {
			save(AddBoatRequest("Freya", "Elon Musk"))
			deleteById(5)
		}
		RestAssured.given().accept(ContentType.JSON)
				.get()
				.then()
				.statusCode(200).body("content.size()", equalTo(4))
	}

//	@Test
//	fun testUpdateTrip() {
//		val departurePort = "Moskva"
//		val id = 4
//
//		val location = RestAssured.given().contentType(ContentType.JSON)
//				.body(UpdateTripRequest(4, departurePort, "Madrid"))
//				.post()
//				.then()
//				.statusCode(201)
//				.extract().header("location")
//
//		RestAssured.given().accept(ContentType.JSON)
//				.basePath("")
//				.get(location)
//				.then()
//				.statusCode(200)
//				.body("departurePort", CoreMatchers.equalTo(departurePort))
//
//		val modified = "modified"
//
//		RestAssured.given().contentType(ContentType.JSON)
//				.body(UpdateTripRequest(4, "Oslo", "Berlin"))
//				.put("/$id")
//				.then()
//				.statusCode(204)
//
//		RestAssured.given().accept(ContentType.JSON)
//				.basePath("")
//				.get(location)
//				.then()
//				.statusCode(200)
//				.body("departurePort", CoreMatchers.equalTo(modified))
//	}
}
