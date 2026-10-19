package dashboard_mis;

import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Dashboard_MIS_UI_testing {

	static WebDriver driver=new EdgeDriver();
	//TC_01 check that if enter correct credetials and click on login button
	//must be load the dashboard page within 3 sec
	
			
		
			@Test(priority=1)
			public void MIS_Dashboard_TC1() throws InterruptedException
			{

				driver.get("http://visualivrmis.simpragma.com/");
		
				driver.manage().window().maximize();
				Thread.sleep(4000);
				//1.login with valid credentials
				driver.findElement(By.id("email")).sendKeys("naveenr@simpragma.com");
				driver.findElement(By.id("password")).sendKeys("Password@123");
				driver.findElement(By.tagName("button")).click();
				Thread.sleep(3000);
				Assert.assertTrue(driver.getCurrentUrl().contains("visualivrmis.simpragma.com/dashboard"));
			}
			
		//TC_2 check that size of the side bar container	menuContainer
			@Test(priority=2)
			public void MIS_Dashboard_TC2() throws InterruptedException 
			{

				driver.get("http://visualivrmis.simpragma.com/");
				
				//driver.manage().window().maximize();
				Thread.sleep(4000);
				//1.login with valid credentials
				driver.findElement(By.id("email")).sendKeys("naveenr@simpragma.com");
				driver.findElement(By.id("password")).sendKeys("Password@123");
				driver.findElement(By.tagName("button")).click();
				Thread.sleep(4000);
				System.out.println(driver.findElement(By.className("sidebarComponent")).getSize().toString());
				Assert.assertTrue(driver.findElement(By.className("sidebarComponent")).getSize().toString().equals("(250, 589)"));
				
				
			}
			//TC_3 check that size of the side bar container	menuContainer
			@Test(priority=3)
			public void MIS_Dashboard_TC3() throws InterruptedException 
			{

				driver.get("http://visualivrmis.simpragma.com/");
				
				//driver.manage().window().maximize();
				Thread.sleep(4000);
				//1.login with valid credentials
				driver.findElement(By.id("email")).sendKeys("naveenr@simpragma.com");
				driver.findElement(By.id("password")).sendKeys("Password@123");
				driver.findElement(By.tagName("button")).click();
				Thread.sleep(4000);
				System.out.println(driver.findElement(By.className("logoContainer")).getLocation().toString());
				Assert.assertTrue(driver.findElement(By.cssSelector("div.logoContainer")).getLocation().toString().equals("(0, 0)"));
				
				
			}
					
			
			//TC_4 check logo is of  dimension  191.2. and width 50.05
				@Test(priority=4)
				public void MIS_Dashboard_TC4() throws InterruptedException 
				{

					driver.get("http://visualivrmis.simpragma.com/");
					
					//driver.manage().window().maximize();
					Thread.sleep(4000);
					//1.login with valid credentials
					driver.findElement(By.id("email")).sendKeys("naveenr@simpragma.com");
					driver.findElement(By.id("password")).sendKeys("Password@123");
					driver.findElement(By.tagName("button")).click();
					Thread.sleep(4000);
					System.out.println(driver.findElement(By.className("logoContainer")).getSize().toString());
					Assert.assertTrue(driver.findElement(By.cssSelector("div.logoContainer")).getSize().toString().equals("(231, 90)"));
					
				}	
				
				
				//TC_5 check if logo position is at center
					@Test(priority=5)
					public void MIS_Dashboard_TC5() throws InterruptedException 
					{

						driver.get("http://visualivrmis.simpragma.com/");
						
						//driver.manage().window().maximize();
						Thread.sleep(4000);
						//1.login with valid credentials
						driver.findElement(By.id("email")).sendKeys("naveenr@simpragma.com");
						driver.findElement(By.id("password")).sendKeys("Password@123");
						driver.findElement(By.tagName("button")).click();
						Thread.sleep(4000);
				
						System.out.println(driver.findElement(By.xpath("(//img)[1]")).getCssValue("vertical-align"));
						Assert.assertTrue(driver.findElement(By.xpath("(//img)[1]")).getCssValue("vertical-align").equals("middle"));
						
					}	
					//TC_6 check if menu bar is at leftside of page
					
					
					//TC_07 check that menu contains following items Dashboard, Conversation Records, Key Reports and Forms
					
					@Test(priority=7)
					public void MIS_Dashboard_TC7() throws InterruptedException 
					{

						driver.get("http://visualivrmis.simpragma.com/");
						
						//driver.manage().window().maximize();
						Thread.sleep(4000);
						//1.login with valid credentials
						driver.findElement(By.id("email")).sendKeys("naveenr@simpragma.com");
						driver.findElement(By.id("password")).sendKeys("Password@123");
						driver.findElement(By.tagName("button")).click();
						Thread.sleep(4000);
						List<WebElement> menuItems=driver.findElements(By.className("menuItem"));
						for(WebElement e:menuItems)
							Assert.assertTrue(e.isDisplayed());
					}
					//TC_9 check if menu bar items text font family is Nunito 
					@Test(priority=9)
					public void MIS_Dashboard_TC9() throws InterruptedException 
					{

						driver.get("http://visualivrmis.simpragma.com/");
						
						//driver.manage().window().maximize();
						Thread.sleep(4000);
						//1.login with valid credentials
						driver.findElement(By.id("email")).sendKeys("naveenr@simpragma.com");
						driver.findElement(By.id("password")).sendKeys("Password@123");
						driver.findElement(By.tagName("button")).click();
						Thread.sleep(4000);
						List<WebElement> menuItems=driver.findElements(By.className("menuItem"));
						for(WebElement e:menuItems)
							Assert.assertTrue(e.getCssValue("font-family").equals("Nunito"));
					}
					//TC_10 check if menu bar items text font size is 13px 
					@Test(priority=10)
					public void MIS_Dashboard_TC10() throws InterruptedException 
					{

						driver.get("http://visualivrmis.simpragma.com/");
						
						//driver.manage().window().maximize();
						Thread.sleep(4000);
						//1.login with valid credentials
						driver.findElement(By.id("email")).sendKeys("naveenr@simpragma.com");
						driver.findElement(By.id("password")).sendKeys("Password@123");
						driver.findElement(By.tagName("button")).click();
						Thread.sleep(4000);
						List<WebElement> menuItems=driver.findElements(By.className("menuItem"));
						for(WebElement e:menuItems)
							Assert.assertTrue(e.getCssValue("font-size").toString().equals("13px"));
					}

					//TC_11 check that menu items are clickable or not
					@Test(priority=11)
					public void MIS_Dashboard_TC11() throws InterruptedException 
					{

						driver.get("http://visualivrmis.simpragma.com/");
						
						//driver.manage().window().maximize();
						Thread.sleep(4000);
						//1.login with valid credentials
						driver.findElement(By.id("email")).sendKeys("naveenr@simpragma.com");
						driver.findElement(By.id("password")).sendKeys("Password@123");
						driver.findElement(By.tagName("button")).click();
						Thread.sleep(4000);
						List<WebElement> menuItems=driver.findElements(By.className("menuItem"));
						for(WebElement e:menuItems)
							Assert.assertTrue(e.isEnabled());
					}
			//TC_12 check that kpi report title and form title in the side bar menu is not clickable
					@Test(priority=12)
					public void MIS_Dashboard_TC12() throws InterruptedException 
					{

						driver.get("http://visualivrmis.simpragma.com/");
						
						//driver.manage().window().maximize();
						Thread.sleep(4000);
						//1.login with valid credentials
						driver.findElement(By.id("email")).sendKeys("naveenr@simpragma.com");
						driver.findElement(By.id("password")).sendKeys("Password@123");
						driver.findElement(By.tagName("button")).click();
						Thread.sleep(4000);
						List<WebElement> menuItems=driver.findElements(By.className("menuItem"));
						for(WebElement e:menuItems)
						{
							if(e.getText().equals("Key Reports")|| e.getText().equals("Forms"))
							{
								System.out.println(e.getText());
								System.out.println(e.isEnabled());
							Assert.assertTrue(e.isEnabled());
							}
						}
					}	
					
			//TC_13 check that menu items are separated by thin line excluding submenu items
					@Test(priority=13)
					public void MIS_Dashboard_TC13() throws InterruptedException 
					{

						driver.get("http://visualivrmis.simpragma.com/");
						
						//driver.manage().window().maximize();
						Thread.sleep(4000);
						//1.login with valid credentials
						driver.findElement(By.id("email")).sendKeys("naveenr@simpragma.com");
						driver.findElement(By.id("password")).sendKeys("Password@123");
						driver.findElement(By.tagName("button")).click();
						Thread.sleep(4000);
						List<WebElement> menuItems=driver.findElements(By.className("menuItem"));
						for(WebElement e:menuItems)
						{
							
								System.out.println(e.getText());
							System.out.println(e.getCssValue("border-top"));
							Assert.assertTrue(e.getCssValue("border-top").contains("1px solid"));
							
						}
						List<WebElement> submenuItems=driver.findElements(By.className("subMenuItem"));
						for(WebElement e:submenuItems)
						{
							
								System.out.println(e.getText());
							System.out.println(e.getCssValue("border-top"));
							Assert.assertTrue(e.getCssValue("border-top").contains("0px none"));
							
						}
					}		
					
					//TC_14 check that size of headercomponent of menu page
					@Test(priority=14)
					public void MIS_Dashboard_TC14() throws InterruptedException 
					{

						driver.get("http://visualivrmis.simpragma.com/");
						
						driver.manage().window().maximize();
						Thread.sleep(4000);
						//1.login with valid credentials
						driver.findElement(By.id("email")).sendKeys("naveenr@simpragma.com");
						driver.findElement(By.id("password")).sendKeys("Password@123");
						driver.findElement(By.tagName("button")).click();
						Thread.sleep(4000);
						
						String headerComponentSize=driver.findElement(By.className("headerComponent")).getSize().toString();
						System.out.println(headerComponentSize);	
						Assert.assertTrue(headerComponentSize.equals("(1052, 60)"));
						
						
					}
					//(//img)[2]
					//TC_16 check that avatar image is displayed top right corner of the menu header
					@Test(priority=16)
					public void MIS_Dashboard_TC16() throws InterruptedException 
					{

						driver.get("http://visualivrmis.simpragma.com/");
						
						driver.manage().window().maximize();
						Thread.sleep(4000);
						//1.login with valid credentials
						driver.findElement(By.id("email")).sendKeys("naveenr@simpragma.com");
						driver.findElement(By.id("password")).sendKeys("Password@123");
						driver.findElement(By.tagName("button")).click();
						Thread.sleep(4000);
						
						Point positionOfAvtar=driver.findElement(By.xpath("(//img)[2]")).getLocation();
						System.out.println(positionOfAvtar);	
						Assert.assertTrue(positionOfAvtar.toString().equals("(1222, 5)"));
						
						
					}
					
					//TC_17 check that size of the avatar menu
					@Test(priority=17)
					public void MIS_Dashboard_TC17() throws InterruptedException 
					{

						driver.get("http://visualivrmis.simpragma.com/");
						
						driver.manage().window().maximize();
						Thread.sleep(4000);
						//1.login with valid credentials
						driver.findElement(By.id("email")).sendKeys("naveenr@simpragma.com");
						driver.findElement(By.id("password")).sendKeys("Password@123");
						driver.findElement(By.tagName("button")).click();
						Thread.sleep(4000);
						
						String colorOfAvtar=driver.findElement(By.xpath("(//img)[2]")).getCssValue("color").toString();
						System.out.println(colorOfAvtar);	
						Assert.assertTrue(colorOfAvtar.equals("rgba(255, 255, 255, 1)"));
						
						
					}
					//tc18 check that avatar menu is clickable or not
					@Test(priority=18)
					public void MIS_Dashboard_TC18() throws InterruptedException 
					{

						driver.get("http://visualivrmis.simpragma.com/");
						
						//driver.manage().window().maximize();
						Thread.sleep(4000);
						//1.login with valid credentials
						driver.findElement(By.id("email")).sendKeys("naveenr@simpragma.com");
						driver.findElement(By.id("password")).sendKeys("Password@123");
						driver.findElement(By.tagName("button")).click();
						Thread.sleep(4000);
						
						Assert.assertTrue(driver.findElement(By.xpath("(//img)[2]")).isEnabled());
					}
					
					//Tc19  when click on  the avatar menu check that expand window is displayed or not
					@Test(priority=19)
					public void MIS_Dashboard_TC19() throws InterruptedException 
					{

						driver.get("http://visualivrmis.simpragma.com/");
						
						//driver.manage().window().maximize();
						Thread.sleep(4000);
						//1.login with valid credentials
						driver.findElement(By.id("email")).sendKeys("naveenr@simpragma.com");
						driver.findElement(By.id("password")).sendKeys("Password@123");
						driver.findElement(By.tagName("button")).click();
						Thread.sleep(4000);
						
						driver.findElement(By.xpath("(//img)[2]")).click();
						Assert.assertTrue(driver.findElement(By.xpath("//ul[@role='menu']")).isDisplayed());	
					}
					
					//Tc_20 check that avatar menu expand window contains name of the person with role who logged in, Edit Profile, Update Password and Logout 
					
					@Test( priority=20)
					
					public void MIS_Dashboard_TC20() throws InterruptedException
					{
						driver.get("http://visualivrmis.simpragma.com/");
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
						
						// 2. get token from cookie
						Cookie c =driver.manage().getCookieNamed("token");
						System.out.println(c.getValue());
						String  encodedToken=c.getValue();
						
						//3. decode the token
						String base64Payload = encodedToken.split("\\.")[1];
						String decodedPayload = new String(Base64.getDecoder().decode(base64Payload));
						System.out.println("Decoded payload: \n" + decodedPayload);
						
						//4.extract firstaname , lastname and role values
						LinkedHashMap<String,String> data =new LinkedHashMap<>();
						String str="";
						str+=decodedPayload;
						String[] keyVal=str.split(",");
						String firstname,role;
						
					
						String ar[]=keyVal[2].split(":");
						role=ar[1].substring(0).replace('"',' ');
						
						System.out.println(role+"..");
							
							String ar1[]=keyVal[3].split(":");
							//System.out.println(ar[1].substring(1)+" ---1");
							firstname=ar1[1].substring(1).replace('"',' ');
							System.out.println(firstname+".");
							firstname=ar1[1].substring(1).replace('"',',');	
							System.out.println(firstname+".");
							String ar2[]=keyVal[4].split(":");
							//System.out.println(ar[1].substring(1)+"---2");
							role=ar2[1].substring(1).replace('"',' ');
							System.out.println(role+".");
							role=ar2[1].substring(1).replace('"',' ');	
							System.out.println(role+".");
							
							//5.click on profile avatar
							driver.findElement(By.xpath("//span[@class='sc-gqjmRU hNubjF']")).click();
							
							
						
							
							System.out.println(driver.findElement(By.cssSelector("span.name")).getText());
							String text=driver.findElement(By.cssSelector("span.name")).getText();
							
							//6.verify name and role
							String a[]=text.split(",");
							Assert.assertTrue(text.contains(a[0]));
							// verify for edit
							System.out.println(driver.findElement(By.xpath("(//span[@class='sc-bGbJRg cVihzA'])[1]")).getText());
							Assert.assertTrue(driver.findElement(By.xpath("(//span[@class='sc-bGbJRg cVihzA'])[1]")).getText().equals("Edit Profile"));
							
							
							// verify update  password
							System.out.println(driver.findElement(By.xpath("(//span[@class='sc-bGbJRg cVihzA'])[2]")).getText());
							Assert.assertTrue(driver.findElement(By.xpath("(//span[@class='sc-bGbJRg cVihzA'])[2]")).getText().equals("Update Password"));
							
							//verify for logout
							Assert.assertTrue(driver.findElement(By.xpath("//span[@class='sc-gqjmRU hNubjF']")).isDisplayed());
							
							
					}
					
					//Tc_24 check the size of the expand window
					@Test( priority=24)
					
					public void MIS_Dashboard_TC24() throws InterruptedException
					{
						driver.get("http://visualivrmis.simpragma.com/");
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
						
						//click on profile  avatar
						driver.findElement(By.xpath("//span[@class='sc-gqjmRU hNubjF']")).click();
						
						// get  size of expanded  window
						String sizeOfExpandedWindow=driver.findElement(By.id("listbox-1")).getSize().toString();
						System.out.println(sizeOfExpandedWindow);
						
						//verify the size of expanded window
						Assert.assertTrue(sizeOfExpandedWindow.equals("(240, 208)"));
					}
					
					//Tc_26  when we click on logout check that navigating back to login page or not
					@Test(priority=26)
					public void MIS_Dashboard_TC26() throws InterruptedException
					{
						driver.get("http://visualivrmis.simpragma.com/");
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
						
						WebDriverWait  wait=new WebDriverWait(driver,20);
								
						//click on profile  avatar
						driver.findElement(By.cssSelector("div.mainLayout:nth-child(2) div.mainContainer div.header div.headerComponent div.sc-kpOJdX.gMzpoU.avatarMenu button.sc-jKJlTe.eSHoy span.sc-gqjmRU.hNubjF > img.sc-gZMcBi.kmEkPW")).click();
						
						//click on logout
						
						By logout=By.xpath("//body/div[2]/div[1]/ul[1]/li[5]");
						wait.until(ExpectedConditions.visibilityOfElementLocated(logout)).click();
						//navigate back
						driver.navigate().back();
						
						
						Thread.sleep(3000);
						String curl=driver.getCurrentUrl();
						System.out.println(curl);
						Assert.assertTrue(curl.contains("http://visualivrmis.simpragma.com/"));
					}
					//TC_27 click on logout and navigate back to login page now click on back button in the browser
					@Test(priority=27)
					public void MIS_Dashboard_TC27() throws InterruptedException
					{
						driver.get("http://visualivrmis.simpragma.com/");
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
						
						
						//click on profile  avatar
						driver.findElement(By.cssSelector("div.mainLayout:nth-child(2) div.mainContainer div.header div.headerComponent div.sc-kpOJdX.gMzpoU.avatarMenu button.sc-jKJlTe.eSHoy span.sc-gqjmRU.hNubjF > img.sc-gZMcBi.kmEkPW")).click();
						
						//click on logout
						WebDriverWait  wait=new WebDriverWait(driver,20);
						By logout=By.xpath("//body/div[2]/div[1]/ul[1]/li[5]");
						wait.until(ExpectedConditions.visibilityOfElementLocated(logout)).click();
						//navigate back
						driver.navigate().back();
						
						
						
						
						//verify that we  are  on login page
						Thread.sleep(3000);
						String curl=driver.getCurrentUrl();
						System.out.println(curl);
						Assert.assertTrue(curl.contains("http://visualivrmis.simpragma.com/"));
					}
				//Tc_28  when we click on edit profile check that edit profile popup is displayed or not 
					@Test(priority=28)
					public void MIS_Dashboard_TC28() throws InterruptedException
					{
						driver.get("http://visualivrmis.simpragma.com/");
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
						
						
						//click on profile  avatar
						driver.findElement(By.xpath("//span[@class='sc-gqjmRU hNubjF']")).click();
					
						//click on edit pofile
						driver.findElement(By.xpath("(//span[@class='sc-bGbJRg cVihzA'])[1]")).click();
						
						Thread.sleep(1000);
						
						//verify if edit profile pop up is dispalyed  or not
						Assert.assertTrue(driver.findElement(By.tagName("section")).isDisplayed());
						
					}
					
			//Tc_29  check that Edit profile popup contains First Name, Last Name, Phone Number textfields with Submit and Cancel buttons
					@Test(priority=29)
					public void MIS_Dashboard_TC29() throws InterruptedException
					{
						driver.get("http://visualivrmis.simpragma.com/");
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
						
						
						//click on profile  avatar
						driver.findElement(By.xpath("//span[@class='sc-gqjmRU hNubjF']")).click();
					
						//click on edit pofile
						driver.findElement(By.xpath("(//span[@class='sc-bGbJRg cVihzA'])[1]")).click();
						Thread.sleep(1000);
						
						driver.getWindowHandle();
						WebElement  form=driver.findElement(By.xpath("//section/div/form"));
						form.click();

						System.out.println(form.getTagName());
						//inspect firstnamefield
						WebElement  firstname =driver.findElement(By.xpath("(//input)[1]"));
					
						
						//inspect  last name
						WebElement  lastname =driver.findElement(By.xpath("(//input)[2]"));
						
						
						//inpsect phonenumber
						WebElement  phonenumber =driver.findElement(By.xpath("(//input)[1]"));
						
						
						// inspect cancel button
						WebElement  cancelbtn =driver.findElement(By.xpath("(//button)[4]"));
						
						// inspect submit button
						WebElement  submitbtn =driver.findElement(By.xpath("(//button)[5]"));
					
						
					
					
						Assert.assertTrue(firstname.isDisplayed());
						
						Assert.assertTrue(lastname.isDisplayed());
						Assert.assertTrue(cancelbtn.isDisplayed());
						Assert.assertTrue(submitbtn.isDisplayed());
						
				
						
					}
					//Tc_30  when we click on Update Password check that Update Password popup is displayed or not
					@Test(priority=30)
					public void MIS_Dashboard_TC30() throws InterruptedException
					{
						driver.get("http://visualivrmis.simpragma.com/");
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
						
						
						//click on profile  avatar
						driver.findElement(By.xpath("//span[@class='sc-gqjmRU hNubjF']")).click();
						
						//click on update password icon
						driver.findElement(By.xpath("//span[contains(text(),'Update Password')]")).click();
						
						System.out.println(driver.findElement(By.xpath("//section")).getText());
						Assert.assertTrue(driver.findElement(By.xpath("//section")).getText().contains("Change Password"));
					}
						
					
					
					//Tc_31 check that Update Password popup contains Old Password and New Password text fields with Cancel and Update buttons
					@Test(priority=31)
					public void MIS_Dashboard_TC31() throws InterruptedException
					{
						driver.get("http://visualivrmis.simpragma.com/");
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
						
						
						//click on profile  avatar
						driver.findElement(By.xpath("//span[@class='sc-gqjmRU hNubjF']")).click();
						
						//click on update password icon
						driver.findElement(By.xpath("//span[contains(text(),'Update Password')]")).click();
						
						//check  if update  password   pop up contain  old password textfield
						Assert.assertTrue(driver.findElement(By.xpath("(//input)[1]")).isDisplayed());
					
						//check  if update  password   pop up contain  new password textfield
						Assert.assertTrue(driver.findElement(By.xpath("(//input)[2]")).isDisplayed());
						

						// inspect cancel button
						WebElement  cancelbtn =driver.findElement(By.xpath("(//button)[6]"));
						
						// inspect submit button
						WebElement  submitbtn =driver.findElement(By.xpath("(//button)[7]"));
						
						Assert.assertTrue(cancelbtn.isDisplayed());
						
						Assert.assertTrue(submitbtn.isDisplayed());
						
						
					}
					//TC_32check that eye icon is presented or not, in Old and New Password text fields
					@Test(priority=32)
					public void MIS_Dashboard_TC32() throws InterruptedException
					{
						driver.get("http://visualivrmis.simpragma.com/");
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

						//click on profile  avatar
						driver.findElement(By.xpath("//span[@class='sc-gqjmRU hNubjF']")).click();
						
						//click on update password icon
						driver.findElement(By.xpath("//span[contains(text(),'Update Password')]")).click();
						
						Assert.assertTrue(driver.findElement(By.xpath("(//button)[4]")).isDisplayed());
						Assert.assertTrue(driver.findElement(By.xpath("(//button)[4]")).isEnabled());
						
						
						Assert.assertTrue(driver.findElement(By.xpath("(//button)[5]")).isDisplayed());
						Assert.assertTrue(driver.findElement(By.xpath("(//button)[5]")).isEnabled());
					}
					
					
					//Tc_33 check that validation for Password text fields
					
						//It should be Minimum 8 characters,1uppercase,1lowercase,1number&1special character
						//Tc_33.1  check if password field less then 8 chars
						//Tc 33.2 check length restiction for password fields---->FAIL----BUG RAISED
						//Tc_33.3  exclude UC
						//Tc_33.4  exclude LC
						//TC_33.5  exclude number
						//TC_33.6 exclude special char	
					@Test(priority=33)
					public void MIS_Dashboard_TC33() throws InterruptedException
					{
						driver.get("http://visualivrmis.simpragma.com/");
						driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
						
						
						//1.login with valid credentials
						driver.findElement(By.id("email")).sendKeys("rohit@simpragma.com");
						driver.findElement(By.id("password")).sendKeys("Password@123");
						driver.findElement(By.tagName("button")).click();
						
						
						try {
							Thread.sleep(4000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						//click on profile  avatar
						driver.findElement(By.xpath("//span[@class='sc-gqjmRU hNubjF']")).click();
						
						//click on update password icon
						driver.findElement(By.xpath("//span[contains(text(),'Update Password')]")).click();
						
						//check if  old  password field less then 8 chars and verify  for  error messsage  
						driver.findElement(By.xpath("(//input)[1]")).sendKeys("123");
						Assert.assertTrue(driver.findElement(By.xpath("/html[1]/body[1]/div[2]/section[1]/div[1]/form[1]/div[1]/div[2]")).getText().equalsIgnoreCase("Incorrect Password!"));
						
						//check for  length restiction for  old password textfield
						//123Aa!jbfjkxjhxjghjhbxjbvhjhbcjhbvbcnvbnbcnvbnvbnbnvbcnbncbvnbncbvnbnbncbvnbcnbv5667777765756765785874654654654657465768787cf54b65c765vdxf4g565b6c454ksfkljkvjfkfjbvjkcbnkcvnbnvnbmnmn mnmn mnbmn mvnmnmn m,vnbnmcvnbmnvmnmnbmbnmnbbnxnbmnxmcbnmvnbnvmbnmcvnbm
						driver.findElement(By.xpath("(//input)[2]")).sendKeys("123Aa!jbfjkxjhxjghjhbxjbvhjhbcjhbvbcnvbnbcnvbnvbnbnvbcnbncbvnbncbvnbnbncbvnbcnbv5667777765756765785874654654654657465768787cf54b65c765vdxf4g565b6c454ksfkljkvjfkfjbvjkcbnkcvnbnvnbmnmnmnmnmnbmnmvnmnmnm,vnbnmcvnbmnvmnmnbmbnmnbbnxnbmnxmcbnmvnbnvmbnmcvnbm");
						Assert.assertTrue(driver.findElement(By.xpath("/html[1]/body[1]/div[2]/section[1]/div[1]/form[1]/div[2]/div[2]")).getText().equalsIgnoreCase("Incorrect Password!"));
						
					}
					
					
					//Tc_34 check that placeholders of Old and New password text fields 
					@Test(priority=34)
					public void MIS_Dashboard_TC34() throws InterruptedException
					{
						driver.get("http://visualivrmis.simpragma.com/");
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

						//click on profile  avatar
						driver.findElement(By.xpath("//span[@class='sc-gqjmRU hNubjF']")).click();
						
						//click on update password icon
						driver.findElement(By.xpath("//span[contains(text(),'Update Password')]")).click();
						
						//verify
						
						Assert.assertTrue(driver.findElement(By.name("password")).getAttribute("placeholder").equalsIgnoreCase("old password"));
						
						Assert.assertTrue(driver.findElement(By.name("newPassword")).getAttribute("placeholder").equalsIgnoreCase("new password"));
						
						
					}
					//Tc_35 check that both password text fields are required fields or not, in Change Password popup
					@Test(priority=35)
					public void MIS_Dashboard_TC35() throws InterruptedException
					{
						driver.get("http://visualivrmis.simpragma.com/");
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

						//click on profile  avatar
						driver.findElement(By.xpath("//span[@class='sc-gqjmRU hNubjF']")).click();
						
						//click on update password icon
						driver.findElement(By.xpath("//span[contains(text(),'Update Password')]")).click();
						
			
						Assert.assertTrue(driver.findElement(By.xpath("(//abbr)[1]")).getAttribute("title").equals("required"));
						
						Assert.assertTrue(driver.findElement(By.xpath("(//abbr)[2]")).getAttribute("title").equals("required"));	
						
					}
					//tc_36 check that Update and Cancel buttons are clickable or not, in Change Password popup
					@Test(priority=36)
					public void MIS_Dashboard_TC36() throws InterruptedException
					{
						driver.get("http://visualivrmis.simpragma.com/");
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

						//click on profile  avatar
						driver.findElement(By.xpath("//span[@class='sc-gqjmRU hNubjF']")).click();
						
						//click on update password icon
						driver.findElement(By.xpath("//span[contains(text(),'Update Password')]")).click();
						
						
						
						Assert.assertTrue(driver.findElement(By.xpath("(//button)[6]")).isEnabled());
						
					}
					
					//tc_37 enter correct credentials and click on Update button in Change Password popup, check that Password is successfully changed message is displayed 
					@Test(priority=37)
					public void MIS_Dashboard_TC37() throws InterruptedException
					{
						driver.get("http://visualivrmis.simpragma.com/");
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

						//click on profile  avatar
						driver.findElement(By.xpath("//span[@class='sc-gqjmRU hNubjF']")).click();
						
						//click on update password icon
						driver.findElement(By.xpath("//span[contains(text(),'Update Password')]")).click();
						
						driver.findElement(By.xpath("(//input)[1]")).sendKeys("Password@123");
						
						driver.findElement(By.xpath("(//input)[2]")).sendKeys("Password@123");
						
						driver.findElement(By.xpath("(//button)[7]")).click();
						
						
					}
					
					//Tc_44  check the tilte of the dashboard page
					@Test(priority=44)
					public void MIS_Dashboard_TC44() throws InterruptedException
					{
						driver.get("http://visualivrmis.simpragma.com/");
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
						
						List<WebElement> menuItems=driver.findElements(By.className("menuItem"));
						
						//verify that  dasboard  titlr bar had text  as 'dashboard'
						Assert.assertTrue(driver.findElement(By.cssSelector("h4.title")).getText().equalsIgnoreCase("dashboard"));
						
						
						
					}
					
					//Tc_45  check the size of the dadhboard title 
					@Test(priority=45)
					public void MIS_Dashboard_TC45() throws InterruptedException
					{
						driver.get("http://visualivrmis.simpragma.com/");
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
						
						List<WebElement> menuItems=driver.findElements(By.className("menuItem"));
						
						//verify that  dasboard  titlr bar had text  as 'dashboard'
						System.out.println(driver.findElement(By.cssSelector("h4.title")).getSize().toString());
						Assert.assertTrue(driver.findElement(By.cssSelector("h4.title")).getSize().toString().equals("(116, 29)"));
						
						
						
					}
					//Tc_50  check the color of the dadhboard text 
					@Test(priority=50)
					public void MIS_Dashboard_TC46() throws InterruptedException
					{
						driver.get("http://visualivrmis.simpragma.com/");
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
						
						List<WebElement> menuItems=driver.findElements(By.className("menuItem"));
						
						//verify that  dasboard  titlr bar had text  as 'dashboard'
						System.out.println(driver.findElement(By.cssSelector("h4.title")).getCssValue("color"));
						Assert.assertTrue(driver.findElement(By.cssSelector("h4.title")).getCssValue("color").toString().equals("rgba(52, 52, 52, 1)"));
						
						
						
					}
					

			//Tc_47  check the size of the dashboard  icon
			@Test(priority=47)
			public void MIS_Dashboard_TC47() throws InterruptedException
			{
				driver.get("http://visualivrmis.simpragma.com/");
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
				
				System.out.println(driver.findElement(By.cssSelector("svg.icon")).getSize().toString());
				Assert.assertTrue(driver.findElement(By.cssSelector("svg.icon")).getSize().toString().contains("(20, 20)"));
					
					
				
			}

			//TC_49 check the font size and font type of the dashboard title
			@Test(priority=49)
			public void MIS_Dashboard_TC49() throws InterruptedException
			{
				driver.get("http://visualivrmis.simpragma.com/");
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
		
				
				//verify that  dasboard  titlr bar had text  as 'dashboard'
				System.out.println(driver.findElement(By.cssSelector("h4.title")).getCssValue("font-size"));
				Assert.assertTrue(driver.findElement(By.cssSelector("h4.title")).getCssValue("font-size").toString().equals("24px"));
				
				System.out.println(driver.findElement(By.cssSelector("h4.title")).getCssValue("font-family"));
				Assert.assertTrue(driver.findElement(By.cssSelector("h4.title")).getCssValue("font-family").toString().contains("Nunito Sans"));
				
				
				
				
			}
		
			//Tc_51 check that menu button is present or not in title bar of the dashboard page
			@Test(priority=51)
			public void MIS_Dashboard_TC51() throws InterruptedException
			{
				driver.get("http://visualivrmis.simpragma.com/");
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
				Assert.assertTrue(driver.findElement(By.xpath("(//button)[2]")).isDisplayed());
			}

			//Tc_52 check that size of the menu button in title bar of the dashboard page
			@Test(priority=52)
			public void MIS_Dashboard_TC52() throws InterruptedException
			{
				driver.get("http://visualivrmis.simpragma.com/");
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
				System.out.println(driver.findElement(By.xpath("(//button)[2]")).getSize().toString());
				Assert.assertTrue(driver.findElement(By.xpath("(//button)[2]")).getSize().toString().equals("(48, 48)"));
			}
			
			
			//Tc_53 check that menu button is clickable or not in title bar of the dashboard page
			@Test(priority=53)
			public void MIS_Dashboard_TC53() throws InterruptedException
			{
				driver.get("http://visualivrmis.simpragma.com/");
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
				Assert.assertTrue(driver.findElement(By.xpath("(//button)[2]")).isEnabled());
			}
			//TC_54  check that when click on menu/filter button   from date and to date with Month and Week buttons must be displayed
			@Test(priority=54)
			public void MIS_Dashboard_TC54() throws InterruptedException
			{
				driver.get("http://visualivrmis.simpragma.com/");
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
				//click on menu/filter button  
				driver.findElement(By.xpath("(//button)[2]")).click();
				
				//check is month button is dispalyed
				Assert.assertTrue(driver.findElement(By.xpath("(//button)[3]")).isDisplayed());
				
				//check is month button is dispalyed				
				Assert.assertTrue(driver.findElement(By.xpath("(//button)[4]")).isDisplayed());
			}
			//TC_55 check that From date and Todate labels are present or not
			@Test(priority=55)
			public void MIS_Dashboard_TC55() throws InterruptedException
			{
				driver.get("http://visualivrmis.simpragma.com/");
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
				//click on menu/filter button  
				driver.findElement(By.xpath("(//button)[2]")).click();
				
				//check that From date and Todate labels are present or not
			Assert.assertTrue(driver.findElement(By.xpath("(//label)[1]")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.xpath("(//label)[2]")).isDisplayed());
			}
			
			@Test (  priority =58 , description="check that size of the from date and to date fields")
			public void Tc_58()throws InterruptedException
			{
				driver.get("http://visualivrmis.simpragma.com/");
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
				
				//click on menu/filter button  
				driver.findElement(By.xpath("(//button)[2]")).click();
				int from= driver.findElement(By.xpath("(//input)[1]")).getSize().getHeight();
				int to=driver.findElement(By.xpath("(//input)[2]")).getSize().getHeight();
				System.out.println(" size of the  from date filter :" +from);
				System.out.println(" size of the  to date filter :" +to);
				Assert.assertEquals(from, 40);
				Assert.assertEquals(to, 40);	
			}
			 @Test( priority =59, description="check that size of the Month and \r\n" + 
				 		"Week buttons together ")
				 public void tc_59() throws InterruptedException
				 {
				 driver.get("http://visualivrmis.simpragma.com/");
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
					
					//click on menu/filter button  
					driver.findElement(By.xpath("(//button)[2]")).click();
					
					WebElement Monthbtn=driver.findElement(By.xpath("//button[contains(text(),'Month')]"));
					String MonthbtnSize=Monthbtn.getSize().toString();
					System.out.println("size of the Month button  : "+MonthbtnSize);
					Assert.assertEquals(MonthbtnSize, "(80, 40)");
					WebElement weekbtn=driver.findElement(By.xpath("//button[contains(text(),'Month')]"));
					String weekbtnSize=Monthbtn.getSize().toString();
					System.out.println("size of the  week button : "+weekbtnSize);
					Assert.assertEquals(weekbtnSize, "(80, 40)");
							
				 }
			
			//TC_60  check that font size and font type of the from date, to date and month, week
			@Test(priority=60)
			public void MIS_Dashboard_TC60() throws InterruptedException
			{
				driver.get("http://visualivrmis.simpragma.com/");
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
				//click on menu/filter button  
				driver.findElement(By.xpath("(//button)[2]")).click();

				
				
				//check is month button
				Assert.assertTrue(driver.findElement(By.xpath("(//button)[3]")).getCssValue("font-size").contains("16px"));
				
				//check is week button				
				Assert.assertTrue(driver.findElement(By.xpath("(//button)[4]")).getCssValue("font-size").contains("16px"));
				
				//from
				Assert.assertTrue(driver.findElement(By.xpath("(//input)[1]")).getCssValue("font-size").contains("16px"));
				
				//to
				Assert.assertTrue(driver.findElement(By.xpath("(//input)[2]")).getCssValue("font-size").contains("16px"));
		
				//check is month button
				Assert.assertTrue(driver.findElement(By.xpath("(//button)[3]")).getCssValue("font-family").contains("Nunito"));
				
				//check is week button				
				Assert.assertTrue(driver.findElement(By.xpath("(//button)[4]")).getCssValue("font-family").contains("Nunito"));
				
				//from
				Assert.assertTrue(driver.findElement(By.xpath("(//input)[1]")).getCssValue("font-family").contains("Nunito"));
				
				//to
				Assert.assertTrue(driver.findElement(By.xpath("(//input)[2]")).getCssValue("font-family").contains("Nunito"));
			}
			@Test(priority=61)
			public void MIS_Dashboard_TC61() throws InterruptedException
			{
				driver.get("http://visualivrmis.simpragma.com/");
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
				//click on menu/filter button  
				driver.findElement(By.xpath("(//button)[2]")).click();

				System.out.println(driver.findElement(By.xpath("(//input)[1]")).getCssValue("color"));
				System.out.println(driver.findElement(By.xpath("(//input)[1]")).getCssValue("color"));
			
				//from
				Assert.assertTrue(driver.findElement(By.xpath("(//input)[1]")).getCssValue("color").toString().contains("rgba(42, 48, 57, 1)"));
				
				//to
				Assert.assertTrue(driver.findElement(By.xpath("(//input)[2]")).getCssValue("color").toString().contains("rgba(42, 48, 57, 1)"));
		
				}
			
			@Test(priority=62)
			public void MIS_Dashboard_TC62() throws InterruptedException
			{
				driver.get("http://visualivrmis.simpragma.com/");
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
				//click on menu/filter button  
				driver.findElement(By.xpath("(//button)[2]")).click();


				String month=driver.findElement(By.xpath("(//button)[3]")).getCssValue("color").toString();
				String week=driver.findElement(By.xpath("(//button)[4]")).getCssValue("color").toString();
				
				System.out.println(month+"  "+week);
				//month
				Assert.assertTrue(month.equals("rgba(1, 182, 245, 1)"));
				
				//week
				Assert.assertTrue(week.equals("rgba(1, 182, 245, 1)"));
		
				}
			//tc_63  check that month and week buttons are clickable or not
			@Test(priority=63)
			public void MIS_Dashboard_TC63() throws InterruptedException
			{
				driver.get("http://visualivrmis.simpragma.com/");
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
				//click on menu/filter button  
				driver.findElement(By.xpath("(//button)[2]")).click();

			
				//month
				Assert.assertTrue(driver.findElement(By.xpath("(//button)[3]")).isEnabled());
				
				//week
				Assert.assertTrue(driver.findElement(By.xpath("(//button)[4]")).isEnabled());
		
				}
			//  tC_69  check the color of the all info cards
			@Test(priority=68)
			public void MIS_Dashboard_TC69() throws InterruptedException
			{
				driver.get("http://visualivrmis.simpragma.com/");
				driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				
				
				//1.login with valid credentials
				driver.findElement(By.id("email")).sendKeys("naveenr@simpragma.com");
				driver.findElement(By.id("password")).sendKeys("Password@123");
				driver.findElement(By.tagName("button")).click();
				
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				
				
				driver.findElement(By.xpath("(//button)[2]")).click();
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//background-color:rgb(0,115, 183)
				String blue=driver.findElement(By.xpath("//div[@class='infoCard blue']")).getCssValue("background-color");
				System.out.println(blue);
//click  on   btn   because sometimes on mouseover on 1 st tile color  change to white  andthen wait forfew secs  to  change color
				
				driver.findElement(By.xpath("(//button)[2]")).click();
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//background-color:rgb(0, 166, 190)
				String  green=driver.findElement(By.xpath("//div[@class='infoCard green']")).getCssValue("background-color");
				System.out.println(green);
				//background-color:rgb(245, 105, 84)
//click  on   btn   because sometimes on mouseover on 1 st tile color  change to white  andthen wait forfew secs  to  change color
				
				driver.findElement(By.xpath("(//button)[2]")).click();
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String  red  =driver.findElement(By.xpath("//div[@class='infoCard red']")).getCssValue("background-color");
				System.out.println(red);
				//background-color:rgb(0, 192, 239)
//click  on   btn   because sometimes on mouseover on 1 st tile color  change to white  andthen wait forfew secs  to  change color
				
				driver.findElement(By.xpath("(//button)[2]")).click();
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String aqua=driver.findElement(By.xpath("//div[@class='infoCard aqua']")).getCssValue("background-color");
				System.out.println(aqua);
				
				Assert.assertTrue(blue.equals("rgba(0, 115, 183, 1)"));
				Assert.assertTrue(green.equals("rgba(0, 166, 90, 1)"));
				Thread.sleep(2000);
				Assert.assertTrue(red.equals("rgba(245, 105, 84, 1)"));
				Assert.assertTrue(aqua.equals("rgba(0, 192, 239, 1)"));
			}
			
			//  tC_68  check the size of the all info cards
			@Test(priority=68)
			public void MIS_Dashboard_TC68() throws InterruptedException
			{
				driver.get("http://visualivrmis.simpragma.com/");
				driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				
				
				//1.login with valid credentials
				driver.findElement(By.id("email")).sendKeys("naveenr@simpragma.com");
				driver.findElement(By.id("password")).sendKeys("Password@123");
				driver.findElement(By.tagName("button")).click();
				
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				
				
				driver.findElement(By.xpath("(//button)[2]")).click();
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//background-color:rgb(0,115, 183)
				String blue=driver.findElement(By.xpath("//div[@class='infoCard blue']")).getSize().toString();
				

				//background-color:rgb(0, 166, 190)
				String  green=driver.findElement(By.xpath("//div[@class='infoCard green']")).getSize().toString();
	
				String  red  =driver.findElement(By.xpath("//div[@class='infoCard red']")).getSize().toString();
	
				String aqua=driver.findElement(By.xpath("//div[@class='infoCard aqua']")).getSize().toString();
				
				String eo="(147, 225)";
				Assert.assertEquals(blue, eo);
				Assert.assertEquals(green, eo);
				Assert.assertEquals(red, eo);
				Assert.assertEquals(aqua, eo);
			}
				
			//tc_77  check that font size and font type of the text in all info cards
			@Test(priority=77)
			public void MIS_Dashboard_TC77() throws InterruptedException
			{
				driver.get("http://visualivrmis.simpragma.com/");
				driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				
				
				//1.login with valid credentials
				driver.findElement(By.id("email")).sendKeys("naveenr@simpragma.com");
				driver.findElement(By.id("password")).sendKeys("Password@123");
				driver.findElement(By.tagName("button")).click();
				
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				
				
				driver.findElement(By.xpath("(//button)[2]")).click();
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				WebElement blue=driver.findElement(By.xpath("//div[@class='infoCard blue']"));
				
				WebElement  green=driver.findElement(By.xpath("//div[@class='infoCard green']"));
	
				WebElement  red  =driver.findElement(By.xpath("//div[@class='infoCard red']"));
	
				WebElement aqua=driver.findElement(By.xpath("//div[@class='infoCard aqua']"));
				
				Assert.assertTrue(blue.getCssValue("font-size").toString().equals("13px"));
				Assert.assertTrue(green.getCssValue("font-size").toString().equals("13px"));
				Assert.assertTrue(red.getCssValue("font-size").toString().equals("13px"));
				Assert.assertTrue(aqua.getCssValue("font-size").toString().equals("13px"));
				
				Assert.assertTrue(blue.getCssValue("font-family").toString().contains("Nunito"));
				Assert.assertTrue(green.getCssValue("font-family").toString().contains("Nunito"));
				Assert.assertTrue(red.getCssValue("font-family").toString().contains("Nunito"));
				Assert.assertTrue(aqua.getCssValue("font-family").toString().contains("Nunito"));
				
			}
				//tc_78 check that count font size in all info cards
			@Test(priority=78)
			public void MIS_Dashboard_TC78() throws InterruptedException
			{
				driver.get("http://visualivrmis.simpragma.com/");
				driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				
			
				//1.login with valid credentials
				driver.findElement(By.id("email")).sendKeys("naveenr@simpragma.com");
				driver.findElement(By.id("password")).sendKeys("Password@123");
				driver.findElement(By.tagName("button")).click();
				
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				
				
				driver.findElement(By.xpath("(//button)[2]")).click();
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				WebElement count=driver.findElement(By.xpath("(//span[@class='infoCardCount'])[1]"));
				String  count_size=count.getCssValue("font-size");
				Assert.assertTrue(count_size.equals("36px"));
				
			}
			 @Test ( priority=90,description="check that vertical scroll bar is\r\n" + 
	 		"scrollable or not, in New Policy \r\n" + 
	 		"Requests page")
		public void TC_90() throws InterruptedException
		{
	
				 driver.get("http://visualivrmis.simpragma.com/");
					driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
					
				
					//1.login with valid credentials
					driver.findElement(By.id("email")).sendKeys("naveenr@simpragma.com");
					driver.findElement(By.id("password")).sendKeys("Password@123");
					driver.findElement(By.tagName("button")).click();
					
					try {
						Thread.sleep(6000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					
					
					driver.findElement(By.xpath("(//button)[2]")).click();
			Actions act = new Actions(driver);
            act.sendKeys(Keys.PAGE_DOWN).build().perform(); //Page Down
            System.out.println("Scroll down perfomed");
            Thread.sleep(3000);
            act.sendKeys(Keys.PAGE_UP).build().perform();       //Page Up
            System.out.println("Scroll up perfomed");
            Thread.sleep(3000);
		}
	 @Test ( priority=91,description="check that horizhontal scroll bar is\r\n" + 
		 		"scrollable or not, in New Policy \r\n" + 
		 		"Requests page")
			public void TC_91() throws InterruptedException
			{
		
		 driver.get("http://visualivrmis.simpragma.com/");
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
		
			//1.login with valid credentials
			driver.findElement(By.id("email")).sendKeys("naveenr@simpragma.com");
			driver.findElement(By.id("password")).sendKeys("Password@123");
			driver.findElement(By.tagName("button")).click();
			
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			
			driver.findElement(By.xpath("(//button)[2]")).click();
			
				//scroll horizontally in the left direction, use the following JavaScript.
				 JavascriptExecutor js = (JavascriptExecutor) driver;
				 
			       js.executeScript("window.scrollBy(6000,0)");
			 
			       try
			       {
			           Thread.sleep(4000);
			       }
			       catch (InterruptedException e)
			       {
			           e.printStackTrace();
			       }
			       js.executeScript("window.scrollBy(-3000,0)");
					// scroll horizontally in the right direction, use the following JavaScript.
			       js = (JavascriptExecutor) driver;
			       js.executeScript("window.scrollBy(6000,0)");
			}
	 @Test ( priority=92,description="when we place cursor on info cards check that background colour of info cardse")
			public void TC_92() throws InterruptedException
			{
		
		 driver.get("http://visualivrmis.simpragma.com/");
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
		
			//1.login with valid credentials
			driver.findElement(By.id("email")).sendKeys("naveenr@simpragma.com");
			driver.findElement(By.id("password")).sendKeys("Password@123");
			driver.findElement(By.tagName("button")).click();
			
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			
			driver.findElement(By.xpath("(//button)[2]")).click();
			Actions a=new Actions(driver);
			String color=driver.findElement(By.className("infoCard")).getCssValue("color");
			Thread.sleep(1000);
			System.out.println(color);
			Assert.assertEquals("rgba(73, 73, 73, 1)", color);
			}
			

}


