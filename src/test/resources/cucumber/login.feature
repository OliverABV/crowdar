#utf8
@crowdar
Feature: Pagina de inicio de sesion
  Background:
      Given valido title de la pagina
      
  @flujos_crowdar   
  Scenario: Inicio de sesion exitoso
    When el usuario ingresa credenciales
    |username     |password    |
    |standard_user|secret_sauce|
    And el usuario hace clic en el boton de inicio de sesion
    Then usuario iniciara sesion
    
	@flujos_crowdar
  Scenario: Inicio de sesion con usuario inexistente
    When el usuario ingresa credenciales
    |username     |password  |
    |oliver_malo  |clave_mala|
    And el usuario hace clic en el boton de inicio de sesion
    Then el mensaje de error "Epic sadface: Username and password do not match any user in this service" se visualiza
    
	@flujos_crowdar
  Scenario: Validar campos obligatorios
    When el usuario hace clic en el boton de inicio de sesion
    And el mensaje de error "Epic sadface: Username is required" se visualiza
    And el usuario ingresa el nombre de usuario "standard_user"
    And el usuario hace clic en el boton de inicio de sesion
    And el mensaje de error "Epic sadface: Password is required" se visualiza
    And el usuario ingresa la clave "secret_sauce"
    And el usuario hace clic en el boton de inicio de sesion
    Then usuario iniciara sesion
    
