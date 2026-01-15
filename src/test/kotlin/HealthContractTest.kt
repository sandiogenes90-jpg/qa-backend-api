import io.restassured.RestAssured.given
import io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath
import org.junit.jupiter.api.Test

class HealthContractTest {

    @Test
    fun `should validate health endpoint contract`() {
        given()
            .`when`()
            .get("/health")
            .then()
            .statusCode(200)
            .body(matchesJsonSchemaInClasspath("contracts/health.schema.json"))
    }
}
