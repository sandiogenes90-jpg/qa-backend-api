
package api

import io.restassured.RestAssured
import io.restassured.http.ContentType
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.Test

class HealthApiTest : BaseApiTest() {

    @Test
    fun `deve retornar status UP no health`() {
        RestAssured
            .given()
            .accept(ContentType.JSON)
            .`when`()
            .get("/health")
            .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("status", equalTo("UP"))
    }
}
