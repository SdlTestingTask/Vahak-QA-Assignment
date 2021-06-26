package StepDefinition;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestTask {
	
	
	WebDriver driver;
	
	@Given("^Login with the newly created \"(.*)\" and \"(.*)\" credentials$")
	public void Login_with_the_newly_created_credentials(String username, String password) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Anand\\Desktop\\Basic\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.imdb.com/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.imdb."
				+ "com%2Fregistration%2Fap-signin-handler%2Fimdb_us&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2."
				+ "0%2Fidentifier_select&openid.assoc_handle=imdb_us&openid.mode=checkid_setup&siteState=eyJvcGVuaWQuYXNzb2NfaGFuZGxlIjoiaW1kYl91cyIsInJlZGlyZWN0VG8iOiJodHRwczovL3d3dy5pbWRiLmNvbS9yZWdpc3RyYXRpb24vc2lnbmluP3JlZl89bG9naW4ifQ&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&tag=imdbtag_reg-20");
	    
		driver.findElement(By.id("ap_email")).sendKeys(username);	
		
		driver.findElement(By.id("ap_password")).sendKeys(password);
		
		driver.findElement(By.id("signInSubmit")).click();
	
	
	}
	
	@When("^Go to the Menu$")
	public void Go_to_the_Menu() {
		
		driver.findElement(By.id("imdbHeader-navDrawerOpen--desktop")).click();
		
	}
	
	@Then("^click on Top Rated Movies$")
	public void click_on_Top_Rated_Movies() {
		
		driver.findElement(By.xpath("//div[@class='_3wpok4xkiX-9E61ruFL_RA NavLinkCategoryList__StyledContainer-sc-13vymju-0 diDBNJ']/div[1]/span/div/div/ul/a[3]")).click();
		
	}
	
	@Then("^sort movies by Release Date$")
	public void sort_movies_by_Release_Date() {
		
		WebElement sort = driver.findElement(By.id("lister-sort-by-options"));
		
		Select sct = new Select(sort);
		
		sct.selectByVisibleText("Release Date");
	}
	
	@And("^Click on last movie and get the month and date$")
	public void Click_on_last_movie_and_get_the_month_and_date() {
		
		List<WebElement> list = driver.findElements(By.xpath("//table[@class='chart full-width']/tbody/tr"));
		
		int total_size = list.size();
		
		driver.findElement(By.xpath("//table[@class='chart full-width']/tbody/tr["+total_size+"]/td[2]/a")).click();
		
		String str = driver.findElement(By.xpath("//div[@data-testid='title-details-section']/ul/li[1]/div/ul/li/a")).getText();
		
		System.out.println("month and year of the release for that movie: "+str);
		
	}
	
	
}
