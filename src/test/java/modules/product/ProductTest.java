package modules.product;

import dataFactory.ProductDataFactory;
import dataFactory.UserDataFactory;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@DisplayName("Product module API Rest tests")
public class ProductTest {
    private String token;

    @BeforeEach
    public void BeforeEach() {
        // Configurating API Rest's data
        baseURI = "http://165.227.93.41";
        //port 8080;
        basePath = "/lojinha";

        // Get admin user's token
        this.token = given()
                .contentType(ContentType.JSON)
                .body(UserDataFactory.createUser("admin", "admin"))
            .when()
                .post("/v2/login")
            .then()
                .extract()
                    .path("data.token");
    }

    @Test
    @DisplayName("Validate that product value equal to 0 is not allowed")
    public void testValidateZeroProhibitedProductValueLimits() {

        // Try to insert a product with value = 0.00 and validate that error's message was showed
        // and status code returned was 422
        given()
            .contentType(ContentType.JSON)
            .header("token", this.token)
            .body(ProductDataFactory.createCommonProductWithValueEqualTo(0.00))
        .when()
            .post("/v2/produtos")
        .then()
            .assertThat()
                .body("error", equalTo("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00"))
                .statusCode(422);
    }

    @Test
    @DisplayName("Validate that product value equal to 7001 is not allowed")
    public void testValidateGreaterSevenThousandProhibitedProductValueLimits() {

        // Try to insert a product with value = 7000.01 and validate that error's message was showed
        // and status code returned was 422
        given()
            .contentType(ContentType.JSON)
            .header("token", this.token)
            .body(ProductDataFactory.createCommonProductWithValueEqualTo(7000.01))
        .when()
            .post("/v2/produtos")
        .then()
            .assertThat()
                .body("error", equalTo("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00"))
                .statusCode(422);
    }
}
