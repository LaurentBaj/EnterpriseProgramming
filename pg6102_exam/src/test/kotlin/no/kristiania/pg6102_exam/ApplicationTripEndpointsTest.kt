package no.kristiania.pg6102_exam

import io.restassured.RestAssured
import io.restassured.http.ContentType
import no.kristiania.pg6102_exam.trip.dto.AddTripRequest
import no.kristiania.pg6102_exam.trip.dto.TripResponse
import no.kristiania.pg6102_exam.trip.entity.Trip
import no.kristiania.pg6102_exam.trip.resource.TripResourceImpl
import org.hamcrest.CoreMatchers
import org.hamcrest.Matchers.equalTo
import org.hamcrest.Matchers.hasItem
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.stereotype.Repository
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest(classes = [(Pg6102ExamApplication::class)],
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApplicationTripEndpointsTest {


	@LocalServerPort
	protected var port = 0

	@Autowired
	protected lateinit var repository: TripResourceImpl


	@BeforeEach
	@AfterEach
	fun clean() {

		// RestAssured configs shared by all the tests
		RestAssured.baseURI = "http://localhost"
		RestAssured.port = port
		RestAssured.basePath = "/api/v1/trips/"
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails()

		repository.run {
			deleteAll()
			save(AddTripRequest("Oslo", "Reykjavik"))
			save(AddTripRequest("Milan", "Johannesburg"))
			save(AddTripRequest("Dublin", "London"))
			save(AddTripRequest("Bratislava", "Cairo"))
		}
	}

	@Test
	fun testGetAllTrips() {
		RestAssured.given().accept(ContentType.JSON)
				.get()
				.then()
				.statusCode(200).body("content.size()", equalTo(4))
	}

	@Test
	fun testRetrieveSingleTrip() {

		var trip = RestAssured.given().accept(ContentType.JSON)
				.get()
				.then()
				.statusCode(200)
				.body("content[0].destinationPort", equalTo("Reykjavik"))

				// Unable to use the data structures correctly here
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
}
