package harveynorman.step_definition;

import base_file.Base_Class1;
import data_file.Test_Data1;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import locators_file.Harveynorman_Locator1;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;

public class Harveynorman_Step_Definition extends Base_Class1 {

	@Given("the user navigates to the e-commerce website homepage")
	public void the_user_navigates_to_the_e_commerce_website_homepage() {
		driver.get(Test_Data1.url);
		maximize();
		implicitlywait();
		log("User navigated to the homepage.");
	}

	@When("the user locates the search bar and inputs the search query {string}")
	public void the_user_locates_the_search_bar_and_inputs_the_search_query(String searchQuery) {
		WebElement searchBar = driver.findElement(Harveynorman_Locator1.search_button);
		explicitWait(searchBar); // Wait for the search bar to be visible
		searchBar.sendKeys(searchQuery); // Input the search query
		searchBar.submit(); // Submit the search
		log("Search query submitted: " + searchQuery);
	}

	@Then("the search results page should load successfully")
	public void the_search_results_page_should_load_successfully() {
		// Check if the search results page has loaded
		String currentUrl = driver.getCurrentUrl();
		assert currentUrl.contains("search"); // Modify the condition based on your URL structure
		log("Search results page loaded successfully.");
	}

	@Then("the search results should contain items relevant to the search query")
	public void the_search_results_should_contain_items_relevant_to_the_search_query() {
		// Accept the cookies if the button is present
		try {
			WebElement acceptCookiesButton = driver.findElement(Harveynorman_Locator1.accept_cookies);
			explicitWait(acceptCookiesButton); // Wait for the cookie consent button to be visible
			acceptCookiesButton.click();
			log("Cookies accepted.");
		} catch (NoSuchElementException e) {
			log("Cookie consent button not found; proceeding without accepting cookies.");
		}

		// Check if search results contain relevant items
		boolean resultsContainRelevantItems = driver.findElements(Harveynorman_Locator1.displayed_product).size() > 0;
		assert resultsContainRelevantItems : "No relevant items found for the search query.";
		log("Search results contain relevant items.");
	}
}
