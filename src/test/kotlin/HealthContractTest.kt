import api.BaseApiTest
import io.restassured.RestAssured.given
import io.restassured.http.ContentType
import io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath
import org.junit.jupiter.api.Test

class HealthContractTest : BaseApiTest() {

    @Test
    fun `should validate health endpoint contract`() {
        given()
            .`when`()
            .get("/health")
            .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body(matchesJsonSchemaInClasspath("contracts/health.schema.json"))
    }

    @Test
    fun `should return 404 for invalid endpoint`() {
        given()
            .`when`()
            .get("/health/invalid")
            .then()
            .statusCode(404)
    }

    @Test
    fun `should return 405 for invalid method POST`() {
        given()
            .contentType(ContentType.JSON)
            .body("{}")
            .`when`()
            .post("/health")
            .then()
            .statusCode(405)
    }


    @Test
    fun `should return 400 for unexpected body`() {
        given()
            .contentType(ContentType.JSON)
            .body("{ \"unexpected\": \"field\" }")
            .`when`()
            .get("/health")
            .then()
            .statusCode(400)
    }
}

