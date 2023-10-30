package cl.crowdar.prueba.Page;


import java.util.List;
import java.util.Map;

import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import cl.crowdar.prueba.Context.Context;
import cl.crowdar.prueba.Context.ScenarioContext;
import io.cucumber.datatable.DataTable;

public class ToolsQaPage extends Base {

	private ScenarioContext scenarioContext;

	public ToolsQaPage() {
		super(driver);
	}
	@FindBy(xpath = "//div[@class='login_logo']")
	public WebElement title;
	@FindBy(xpath = "//input[@id='user-name']")
	public WebElement inputUserName;
	@FindBy(xpath = "//input[@id='password']")
	public WebElement inputPassword;
	@FindBy(xpath = "//*[@id='login-button']")
	public WebElement btnLogin;
	@FindBy(xpath = "//h3[@data-test='error']")
	public WebElement msnError;
	@FindBy(xpath = "//*[@class='inventory_list']")
	public WebElement inventoryList;
	@FindBy(xpath = "//a[@id='item_4_title_link']/div")
	public WebElement btnItemBag;
	@FindBy(xpath = "//*[@id='item_0_title_link']")
	public WebElement btnItemLight;
	@FindBy(xpath = "//*[@id='item_1_title_link']")
	public WebElement btnItemShirt;
	@FindBy(xpath = "//*[@id='item_5_title_link']")
	public WebElement btnItemJacket;
	@FindBy(xpath = "//button[contains(text(),'Add to cart')]")
	public WebElement AddToCart;
	
	//shopping cart
	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	public WebElement btnCart;
	@FindBy(xpath = "//*[@class='cart_item']")
	public WebElement cartItem;
	@FindBy(xpath = "//button[@id='checkout']")
	public WebElement btnCheckout;
	
	//form
	@FindBy(xpath = "//input[@id='first-name']")
	public WebElement inputName;
	@FindBy(xpath = "//input[@id='last-name']")
	public WebElement inputLastName;
	@FindBy(xpath = "//input[@id='postal-code']")
	public WebElement inputPostalCode;
	
	@FindBy(xpath = "//input[@id='continue']")
	public WebElement btnContinue;
	@FindBy(xpath = "//button[@id='finish']")
	public WebElement btnFinish;
	
	
		
	
	public boolean IsVisibleTitle() {
		waitUntilElementIsVisible(title);
		return isVisible(title);
	}
	
	public void sendKeysUserName(String userName) {
		waitUntilElementIsVisible(inputUserName);
		inputUserName.clear();
		inputUserName.sendKeys(userName);
	}
	
	public void sendKeysPassword(String password) {
		waitUntilElementIsVisible(inputPassword);
		inputPassword.clear();
		inputPassword.sendKeys(password);
	}
	
	public void clickBtnlogin() {
		waitUntilElementIsElementClickable(btnLogin);
		btnLogin.click();
	}

	public boolean IsVisibleInventoryList() {
		waitUntilElementIsVisible(inventoryList);
		return isVisible(inventoryList);
	}
	
	public boolean IsVisibleMsnError(String mensajeError) {
		waitUntilElementIsVisible(msnError);
		String textoError = msnError.getText();

		return textoError.equals(mensajeError);
	}
	
	public void clickBtnAddBag() {
		waitUntilElementIsElementClickable(btnItemBag);
		btnItemBag.click();
	}
	

	public void clickBtnAddLight() {
		waitUntilElementIsVisible(btnItemLight);
		btnItemLight.click();
	}
	

	public void clickBtnAddShirt() {
		waitUntilElementIsVisible(btnItemShirt);
		btnItemShirt.click();
	}
	
	public void clickBtnAddToCart() {
		waitUntilElementIsElementClickable(AddToCart);
		AddToCart.click();
	}
	

	public void clickBtnCart() {
		waitUntilElementIsVisible(btnCart);
		btnCart.click();
	}
	
	public boolean IsVisibleitemInCart() {
		waitUntilElementIsVisible(cartItem);
		return isVisible(cartItem);
	}
	
	public void clickBtnContinue() {
		waitUntilElementIsElementClickable(btnContinue);
		btnContinue.click();
	}
	
	public void clickBtnFinish() {
		waitUntilElementIsVisible(btnFinish);
		btnFinish.click();
	}
	
	public void clickBtnCheckout() {
		waitUntilElementIsVisible(btnCheckout);
		btnCheckout.click();
	}
	
	public void selectItemForCart(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		
	}
	
	public void completeForm(DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> row : data) {
			String userName = row.get("First Name");
			String lastName = row.get("Last Name");
			String Zip = row.get("Zip/Postal Code");
			inputName.sendKeys(userName);
			inputLastName.sendKeys(lastName);
			inputPostalCode.sendKeys(Zip);
			
		}
	}
	
	public boolean IsVisibleSatisfactoryPurchase(String nombre) {
		WebElement selector = getDriver()
				.findElement(By.xpath("//h2[contains(text(),'" + nombre + "')]"));
		waitUntilElementIsVisible(selector);
		return isVisible(selector);
	}

	
//// parte numero dos 
	

	public void clickEditForName(String nombre) {
		WebElement selector = getDriver()
				.findElement(By.xpath("//div[contains(text(),'" + nombre + "')]/..//span[@title='Edit']"));
		waitUntilElementIsVisible(selector);
		waitUntilElementIsElementClickable(selector);
		selector.click();
	}

	public boolean IsVisibleNameChange(String nombre) {
		WebElement selector = getDriver().findElement(By.xpath("//div[contains(text(),'" + nombre + "')]/.."));
		waitUntilElementIsVisible(selector);
		return isVisible(selector);
	}

	public void deleteLastUser() {

		WebElement selector = getDriver()
				.findElement(By.xpath("(//span[contains(@id,'delete')])[last()]/../../..//div[@role='gridcell'][1]"));
		String UserDelete = selector.getText();
		scenarioContext = new ScenarioContext();
		scenarioContext.setContext(Context.USER, UserDelete);
		By deleteSelector = By.xpath(String.format("(//span[contains(@id,'delete')])[last()]"));
		waitUntilElementIsVisible(deleteSelector);
		WebElement delete = getDriver().findElement(deleteSelector);
		delete.click();

	}

	public boolean IsVisibleLastName() {
		String nameRemove = (String) scenarioContext.getContext(Context.USER);
		By deleteTable = By.xpath(String.format("//div[contains(text(),'" + nameRemove + "')]/.."));
		return isVisible(deleteTable);
	}

}
