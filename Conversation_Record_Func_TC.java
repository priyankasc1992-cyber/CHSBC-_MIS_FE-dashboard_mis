package dashboard_mis;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Conversation_Record_Func_TC {
	
	static WebDriver driver=new EdgeDriver();

	//TC_01 Check default value of from date and todate
	//To date must be todays date and from date must be 1 week previous from today 
	
	@Test(priority =1)
	public void tc_1()
	{
		driver.get("https://visualivrmis.simpragma.com");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		
		//1.login with valid credentials
		driver.findElement(By.id("email")).sendKeys("naveenr@simpragma.com");
		driver.findElement(By.id("password")).sendKeys("Password@123");
		driver.findElement(By.tagName("button")).click();
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//click on  conversation record btn in menu
		List<WebElement> menuItems=driver.findElements(By.className("menuItem"));
		menuItems.get(1).click();
		
		// get from date field value
		String fromDate=driver.findElement(By.xpath("(//input[@type='date'])[1]")).getAttribute("value");
		System.out.println(fromDate);
		
		// get to date field value
		String toDate=driver.findElement(By.xpath("(//input[@type='date'])[2]")).getAttribute("value");
		System.out.println(toDate);
		
		// get current date
		LocalDate todaysdate=java.time.LocalDate.now();
		String currentDate="";
		currentDate+=todaysdate;
		System.out.println(currentDate);
		
		//verify  todate  is equal to current date
		Assert.assertTrue(toDate.equals(currentDate));
		
		//retive 1 week post value from todate/currentdate
	
		
		//get day
		String[] a=currentDate.split("-");
		String fromDay=a[2];
		int t=Integer.parseInt(fromDay);
		t=t-6;
		String tt="";
		tt+=t;
		String postweek=currentDate;
		System.out.println("tt="+tt);
		String str=postweek.substring(0,8);
				System.out.println(str+"   str1");

		str+=tt;
		System.out.println(str+"   str2");
		
		System.out.println(fromDate+" ==From Date");
		//verify  fromdate  is equal to  postweek
		Assert.assertTrue(fromDate.equals(str));
	}

	//TC_02 click on other tabs such as dashboard etc and come again to converstion record  
	@Test(priority =2)
	public void tc_2()
	{
		driver.get("https://visualivrmis.simpragma.com");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		//1.login with valid credentials
		driver.findElement(By.id("email")).sendKeys("naveenr@simpragma.com");
		driver.findElement(By.id("password")).sendKeys("Password@123");
		driver.findElement(By.tagName("button")).click();
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//click on  conversation record btn in menu
		List<WebElement> menuItems=driver.findElements(By.className("menuItem"));
		for(WebElement s:menuItems)
		System.out.println(s.getText());
		menuItems.get(1).click();
		//get  from date and to date value for vaifiction at later


		String previousfromDate=driver.findElement(By.xpath("(//input[@type='date'])[1]")).getAttribute("value");
		System.out.println(previousfromDate);
	
		String previoustoDate=driver.findElement(By.xpath("(//input[@type='date'])[2]")).getAttribute("value");
		System.out.println(previoustoDate);
		
		// click  on user mnagement
		menuItems=driver.findElements(By.className("menuItem"));
		menuItems.get(5).click();
		
		driver.navigate().back();
		
		//get  from date and to date value
		
		String postfromDate=driver.findElement(By.xpath("(//input[@type='date'])[1]")).getAttribute("value");
		System.out.println(postfromDate);
	
		String posttoDate=driver.findElement(By.xpath("(//input[@type='date'])[2]")).getAttribute("value");
		System.out.println(posttoDate);
		
		
		// verify
		Assert.assertTrue(previousfromDate.equals(postfromDate ));
		Assert.assertTrue(previoustoDate.equals(posttoDate));
		
		
	}
	
	
		
		

}
