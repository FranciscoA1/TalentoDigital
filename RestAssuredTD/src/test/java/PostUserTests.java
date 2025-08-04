import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import utils.BaseTests;

import static org.hamcrest.Matchers.*;

@Feature("API metodos POST")
public class PostUserTests extends BaseTests {

    @Story("Registro exitoso de usuario")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("smoke")
    @Tag("methodPost")
    @Test
    void registroExitoso() {
        String jsonBody = """
        {
          "first_name": "Arturo",
          "job": "QA"
        }
        """;

        request
                .body(jsonBody)
                .post("/users")
                .then()
                .statusCode(201)
                .header("Content-Type", containsString("application/json"))
                .body("first_name", equalTo("Arturo"))
                .body("job", equalTo("QA"));
    }

    @Story("Crear usuario sin body")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("smoke")
    @Tag("methodPost2")
    @Test
    void crearUsuarioSinBody() {
        request
                .post("/users")
                .then()
                .statusCode(201)
                .body("id", notNullValue())
                .body("email", nullValue());
    }
}