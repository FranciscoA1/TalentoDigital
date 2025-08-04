import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import utils.BaseTests;

import static org.hamcrest.Matchers.lessThan;

@Feature("API metodos DELETE")
public class DeleteUserTests extends BaseTests {

    @Story("Eliminar usuario")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("smoke")
    @Tag("methodDelete")
    @Test
    void eliminarUsuario() {
        request
                .delete("/users/2")
                .then()
                .statusCode(204)
                .time(lessThan(2000L));
    }
}
