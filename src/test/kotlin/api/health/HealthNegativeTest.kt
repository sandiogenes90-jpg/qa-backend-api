package api.health

import io.restassured.RestAssured
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

class HealthNegativeTest {

    companion object {
        @JvmStatic
        @BeforeAll
        fun setup() {
            RestAssured.baseURI = "http://localhost"
            RestAssured.port = 8080
        }
    }

    @Test
    fun `deve retornar 404 para endpoint inexistente`() {
        RestAssured
            .given()
            .`when`()
            .get("/health/invalid")
            .then()
            .statusCode(404)
    }
}
