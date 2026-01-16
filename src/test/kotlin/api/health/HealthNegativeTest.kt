package api.health

import io.restassured.RestAssured.given
import org.junit.jupiter.api.Test
import api.BaseApiTest

class HealthNegativeTest : BaseApiTest() {

    @Test
    fun `should return 405 for invalid method POST`() {
        given()
            .body("{ \"status\": \"UP\" }")
            .`when`()
            .post("/health")
            .then()
            .statusCode(405) // Ajuste se seu backend retorna outro código
    }

    @Test
    fun `should fail for missing headers`() {
        given()
            .header("X-Custom", "")
            .`when`()
            .get("/health")
            .then()
            .statusCode(400) // Ajuste conforme comportamento real
    }

}
