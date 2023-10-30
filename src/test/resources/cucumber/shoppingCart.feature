@crowdar
Feature: Compra en tienda en linea

  Background:
      Given valido title de la pagina
      When el usuario ingresa credenciales
    	|username     |password    |
    	|standard_user|secret_sauce|
    	And el usuario hace clic en el boton de inicio de sesion
    	Then usuario iniciara sesion
    
      
  @flujos_crowdar   
  Scenario: Agregar articulo al carrito de compras
    Given que estoy en la pagina de inicio de la tienda en linea
    When selecciono un articulo para comprar y agrego al carro de compras
    And veo que el articulo se ha agregado correctamente al carrito
    And procedo a hacer el checkout y completar con mis datos
    |First Name|Last Name|Zip/Postal Code|
    |Oliver		 |Burgos   |8500000        |
    Then se muesta mensaje de compra correcta "Thank you for your order"

   @flujos_crowdar   
  Scenario: CASO CON ERROR para screenshot Agregar articulo
    Given que estoy en la pagina de inicio de la tienda en linea
    When selecciono un articulo para comprar y agrego al carro de compras
    And veo que el articulo se ha agregado correctamente al carrito
    And procedo a hacer el checkout y completar con mis datos
    |First Name|Last Name|Zip/Postal Code|
    |Oliver		 |Burgos   |8500000        |
    Then se muesta mensaje de compra correcta "Hola mundo"
    
    