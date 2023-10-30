package cl.crowdar.prueba.Step;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import cl.crowdar.prueba.Page.ToolsQaPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ToolsQaDefinition {

	ToolsQaPage toolsQaPage = new ToolsQaPage();

	@Given("valido title de la pagina")
	public void valido_title_de_la_pagina() {
		toolsQaPage.IsVisibleTitle();

	}

	@When("el usuario ingresa credenciales")
	public void el_usuario_ingresa_credenciales(DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> row : data) {
			String username = row.get("username");
			String password = row.get("password");
			toolsQaPage.sendKeysUserName(username);
			toolsQaPage.sendKeysPassword(password);
		}

	}

	@When("el usuario hace clic en el boton de inicio de sesion")
	public void el_usuario_hace_clic_en_el_boton_de_inicio_de_sesion() {
		toolsQaPage.clickBtnlogin();

	}

	@Then("usuario iniciara sesion")
	public void usuario_iniciara_sesion() {
		assertTrue("No se Encontro El inventario por lo tanto no logro inicar seccion",
				toolsQaPage.IsVisibleInventoryList());

	}

	@Then("el mensaje de error {string} se visualiza")
	public void el_mensaje_de_error_se_visualiza(String string) {
		assertTrue("El mensaje de error no se visualiza", toolsQaPage.IsVisibleMsnError(string));

	}

	@When("el usuario ingresa el nombre de usuario {string}")
	public void el_usuario_ingresa_el_nombre_de_usuario(String string) {
		toolsQaPage.sendKeysUserName(string);

	}

	@When("el usuario ingresa la clave {string}")
	public void el_usuario_ingresa_la_clave(String string) {
		toolsQaPage.sendKeysPassword(string);

	}

	@Given("que estoy en la pagina de inicio de la tienda en linea")
	public void que_estoy_en_la_pagina_de_inicio_de_la_tienda_en_linea() {
		assertTrue("No se Encontro El inventario por lo tanto no logre inicar seccion & no estoy en la parte correcta",
				toolsQaPage.IsVisibleInventoryList());

	}

	@Given("selecciono un articulo para comprar y agrego al carro de compras")
	public void selecciono_un_articulo_para_comprar_y_agrego_al_carro_de_compras() {
		toolsQaPage.selectItemForCart(toolsQaPage.btnItemBag);
		toolsQaPage.clickBtnAddBag();
		toolsQaPage.selectItemForCart(toolsQaPage.AddToCart);
		toolsQaPage.clickBtnAddToCart();

	}

	@Given("veo que el articulo se ha agregado correctamente al carrito")
	public void veo_que_el_articulo_se_ha_agregado_correctamente_al_carrito() {
		toolsQaPage.clickBtnCart();
		assertTrue("No se encontro item dentro del carro de compras", toolsQaPage.IsVisibleitemInCart());

	}
	
	@Given("procedo a hacer el checkout y completar con mis datos")
	public void procedo_a_hacer_el_checkout_y_completar_con_mis_datos(DataTable dataTable) {
		toolsQaPage.clickBtnCheckout();
		toolsQaPage.completeForm(dataTable);
		toolsQaPage.clickBtnContinue();
		toolsQaPage.clickBtnFinish();

	}
	
	@Given("se muesta mensaje de compra correcta {string}")
	public void se_muesta_mensaje_de_compra_correcta(String name) {
		assertTrue("La compra No ha sido Completada",toolsQaPage.IsVisibleSatisfactoryPurchase(name));
	
	}
	
	

	

}
