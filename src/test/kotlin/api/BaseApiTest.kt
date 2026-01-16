package api

import io.restassured.RestAssured
import org.junit.jupiter.api.BeforeAll

abstract class BaseApiTest {

    companion object {
        @JvmStatic
        @BeforeAll
        fun setup() {
            RestAssured.baseURI = "http://localhost"
            RestAssured.port = 3000
        }
    }
}
