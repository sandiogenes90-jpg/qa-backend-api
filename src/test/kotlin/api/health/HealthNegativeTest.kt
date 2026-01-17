package api.health

import api.BaseApiTest
import io.restassured.RestAssured.given
import io.restassured.http.ContentType
import io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class HealthNegativeTest : BaseApiTest() {

    @Test
    fun `should return 405 for invalid method POST`() {
        given()
            .body("{ \"status\": \"UP\" }")
            .`when`()
            .post("/health")
            .then()
            .statusCode(405)
    }

    @Test
    fun `should fail for missing headers`() {
        given()
            .header("X-Custom", "")
            .`when`()
            .get("/health")
            .then()
            .statusCode(400)
    }

    @Test
    fun `should fail contract when status field is missing`() {
        // Teste negativo de contrato — sem status
        val invalidResponseJson = "{ \"uptime\": 123 }"

        assertThrows<AssertionError> {
            given()
                .contentType(ContentType.JSON)
                .body(invalidResponseJson)
                .`when`()
                .get("/health") // endpoint qualquer, só para disparar a validação
                .then()
                .body(matchesJsonSchemaInClasspath("contracts/health.schema.json"))
        }
    }
}
