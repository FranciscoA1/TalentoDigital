import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import utils.BaseTests;

import static org.hamcrest.Matchers.*;

@Feature("API metodos PUT")
public class PutUserTests extends BaseTests {

    @Story("Actualizar usuario con exito")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("smoke")
    @Tag("methodPut")
    @Test
    void actualizarUsuario() {
        String jsonBody = """
        {
          "first_name": "Francisco",
          "job": "QA Automation Engineer"
        }
        """;

        request
                .body(jsonBody)
                .put("/users/2")
                .then()
                .statusCode(200)
                .time(lessThan(2000L))
                .header("Content-Type", containsString("application/json"))
                .body("first_name", equalTo("Francisco"))
                .body("job", equalTo("QA Automation Engineer"));
    }
}
