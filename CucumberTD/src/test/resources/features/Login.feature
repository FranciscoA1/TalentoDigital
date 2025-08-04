Feature: Ejercicio Login TD

  @regression
  Scenario: Login credenciales correctas
    Given estoy en la página de inicio de sesión
    When  ingreso el nombre de usuario "student" y la contraseña "Password123"
    And   hago clic en el botón de inicio de sesión
    Then  debería ver el mensaje de exito "Logged In Successfully"


  @regression
  Scenario Outline: Login credenciales invalidas
    Given estoy en la página de inicio de sesión
    When  ingreso el nombre de usuario "<usuario>" y la contraseña "<password>"
    And   hago clic en el botón de inicio de sesión
    Then  debería ver el mensaje de error "<mensaje>"

    Examples:
      | usuario         | password          | mensaje                     |
      | incorrectUser   | Password123       | Your username is invalid!   |
      | student         | incorrectPassword | Your password is invalid!   |