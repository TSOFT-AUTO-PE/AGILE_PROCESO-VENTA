@MovistarFija
Feature: Movistar Fija

  Scenario Outline: Registrar Movistar Fija
    Given Ir a la pagina de Movistar Fija
    And Ingresar codigo ATIS / Usuario "<caso_prueba>"
    And Click en el boton Continuar
    When Validar si el codigo ATIS y ingresar contraseña "<caso_prueba>"
    And Click en el boton Iniciar Sesion
    And Seleccionar en el menu Altas Nuevas
    And Click en el boton Obviar y continuar
    When Ingresar datos del cliente "<caso_prueba>"
    When Validar servicio reniec, consultar nuevamente "<caso_prueba>"
    And Ingresar datos de validacion del cliente "<caso_prueba>"
    And Ingresar lugar de ubicacion "<caso_prueba>"
    And Click en el boton Continuar, Lugar Ubicacion
    When Seleccionar tipo de producto y nombre de producto "<caso_prueba>"
    And Seleccionar SVAS
    And Aceptar condiciones y ingresar email
    And Confirmar el resumen de la venta y aceptar el speech de grabacion
#    And Ingresar la respuesta de Reniec
#    Then ingresar nombre, numero y finalizar venta
    Then  Realizar agendamiento, seleccionar horario e ingresar nombre, numero y finalizar venta
    Examples:
      | caso_prueba |
      |           1 |





