import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.http.Method;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import utils.BaseTests;

import static org.hamcrest.Matchers.*;

@Feature("API metodos GET")
public class GetUserTests extends BaseTests {

    @Story("Obtener usuario por ID")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("smoke")
    @Tag("methodGet")
    @Test
    void usuarioExistente() {
        request
                .get("/users/2")
                .then()
                .statusCode(200)
                .time(lessThan(2000L))
                .header("Content-Type", containsString("application/json"))
                .body("data.id", equalTo(2))
                .body("data.email", containsString("@reqres.in"));
    }

    @Story("Buscar usuario inexistente")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("smoke")
    @Tag("methodGet")
    @Test
    void usuarioNoExistente() {
        request
                .get("/users/-2")
                .then()
                .statusCode(404)
                .time(lessThan(2000L));
    }
}
