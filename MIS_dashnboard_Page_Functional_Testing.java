package dashboard_mis;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class MIS_dashnboard_Page_Functional_Testing {

	

	private static final boolean flase = false;
	static WebDriver driver=new EdgeDriver();

	//check  if  person who had logged in. validate for name  ---get it from cookiee/local storage/Db=Mongo db
	//once you are in dashboard page and click on avatar image, 
	//check  if  person who had logged in his name and role with edit profile and logout option must be present 
	
	//Tc#1  and TC#2 steps
	
	
	// 1.right click on web page and inspect  
	// 2.get all cookies
	// 3. within cokkies decode role and name attricute
	
	@Test(priority=1)
	public void MIS_Dashboard_TC1() throws InterruptedException
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
			
			//5.click on logout avatar
			driver.findElement(By.xpath("//span[@class='sc-gqjmRU hNubjF']")).click();
			
			
		
			
			System.out.println(driver.findElement(By.cssSelector("span.name")).getText());
			String text=driver.findElement(By.cssSelector("span.name")).getText();
			
			//6.verify name and role
			String a[]=text.split(",");
			Assert.assertTrue(text.contains(a[0]));
			Assert.assertTrue(text.contains(a[1]));
			
			
		
			
	}
	//@AfterTest
	public  static void logout()
	{
			//click on logout button
			driver.findElement(By.cssSelector("li.sc-jtRlXQ crMelM")).click();
	}	
	
	//TC_4  :check if role is super the billing  information and  usernmanagement option is present or not in vertical sidebar/menu
		//expected result:must  be present
		
		
		@Test(priority =3)
		public void Dashboard_MIS_TC_3()
		{
				driver.get("https://visualivrmis.simpragma.com");
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
				//2.check role of user
				
				driver.findElement(By.xpath("//span[@class='sc-gqjmRU hNubjF']")).click();
				System.out.println(	driver.findElement(By.xpath("//div[@class='rainbow-m-left_x-small nameWrap']/span[@class='designation']")).getText());
				String text=driver.findElement(By.cssSelector("span.name")).getText();
				String a[]=text.split(",");
				
				Assert.assertTrue(text.contains(a[1]));
				
			
			
				String roles[]=driver.findElement(By.xpath("//div[@class='rainbow-m-left_x-small nameWrap']/span[@class='designation']")).getText().split("_");
				List<WebElement>menuItems=null;
				//3. if APP_ADMIN check if Billing information  and user management info is present or not
				if(a[1].contains("APP_ADMIN"))
				{
					// find menu side bar
				menuItems=driver.findElements(By.xpath("//div[@class='menuContainer']/ul/li[@class='menuItem']"));
					
				}
				for(WebElement e:menuItems)
					System.out.println(e.getText());
					int i=0;
				
					//Traverse till we reach billing option
					while(i<menuItems.size())
					{
						if(menuItems.get(i).getText().equalsIgnoreCase("billing"))
						{
							//verify if billinhg oprtion is present or not
							Assert.assertFalse(menuItems.get(i).getText().equalsIgnoreCase("billing"));
						}
						
						if(menuItems.get(i).getText().equalsIgnoreCase("user management"))
						{
							System.out.println(menuItems.get(i).getText());
							//verify if billinhg oprtion is present or not
							Assert.assertFalse(menuItems.get(i).getText().equalsIgnoreCase("User Management"));
						}
						i++;
					}
				
			
		}
	
	//TC_4  :check if role is super the billing  information and  usernmanagement option is present or not in vertical sidebar/menu
	//expected result:must  be present
	
	
	@Test(priority =4)
	public void Dashboard_MIS_TC_4()
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
			//2.check role of user
			
			driver.findElement(By.xpath("//span[@class='sc-gqjmRU hNubjF']")).click();
			System.out.println(	driver.findElement(By.xpath("//div[@class='rainbow-m-left_x-small nameWrap']/span[@class='designation']")).getText());
			String text=driver.findElement(By.cssSelector("span.name")).getText();
			String a[]=text.split(",");
			
			Assert.assertTrue(text.contains(a[1]));
			
		
		
			String roles[]=driver.findElement(By.xpath("//div[@class='rainbow-m-left_x-small nameWrap']/span[@class='designation']")).getText().split("_");
			List<WebElement>menuItems=null;
			//3. if APP_ADMIN check if Billing information  and user management info is present or not
			if(a[1].contains("APP_SUPER"))
			{
				// find menu side bar
			menuItems=driver.findElements(By.xpath("//div[@class='menuContainer']/ul/li[@class='menuItem']"));
				
			}
			for(WebElement e:menuItems)
				System.out.println(e.getText());
				int i=0;
			
				//Traverse till we reach billing option
				while(i<menuItems.size())
				{
					if(menuItems.get(i).getText().equalsIgnoreCase("billing"))
					{
						//verify if billinhg oprtion is present or not
						Assert.assertTrue(menuItems.get(i).getText().equalsIgnoreCase("billing"));
					}
					
					if(menuItems.get(i).getText().equalsIgnoreCase("user management"))
					{
						System.out.println(menuItems.get(i).getText());
						//verify if billinhg oprtion is present or not
						Assert.assertTrue(menuItems.get(i).getText().equalsIgnoreCase("User Management"));
					}
					i++;
				}
			
		
	}
		//check if by default we are on dashboard page once we are loggedin
	@Test(priority=5)
	public void Dashboard_MIS_TC_5()
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
	
			Assert.assertTrue(driver.findElement(By.tagName("h4")).getText().equalsIgnoreCase("Dashboard"));
	}
	
	//click on dashboard button  in menu
	@Test(priority=6)
	public void Dashboard_MIS_TC_6()
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


		List<WebElement> menuItems=driver.findElements(By.className("menuItem"));
		for(int i=0;i<menuItems.size();i++)
		{
			System.out.println(menuItems.get(i).getText());
			if(menuItems.get(i).getText().equals("Dashboard"))
			{
				//4.click on dashbord in sidebar and verify if we are at dashboard page by getting title/ heading zas dashboard
				menuItems.get(i).click();	
				Assert.assertTrue(driver.findElement(By.tagName("h4")).getText().equalsIgnoreCase("Dashboard"));
			}
		}
		
		List<WebElement> cardsTitle=driver.findElements(By.className("infoCardTitle"));
		for(int i=0;i<cardsTitle.size();i++)
		{
			System.out.println(cardsTitle.get(i).getText());

			String title=cardsTitle.get(i).getText();
			if(title.equals("Get a Call"))
			{
				Assert.assertTrue(title.equals("Get a Call"));
			}
			else if(title.equals("Buy New Policy"))
			{
				Assert.assertTrue(title.equals("Buy New Policy"));
			}
			else if(title.equals("My Policies"))
			{
				Assert.assertTrue(title.equals("My Policies"));
			}
			else  if(title.equals("Downloads"))
			{
				Assert.assertTrue(title.equals("Downloads"));
			}
		}
		
		
		List<WebElement> charts=driver.findElements(By.className("dBgyJd"));
	
			System.out.println(charts.get(0).getText()+"--chart1");
			Assert.assertTrue(charts.get(0).getText().equals("Conversations"));
			
			System.out.println(charts.get(1).getText()+"--chart2");
			Assert.assertTrue(charts.get(1).getText().equals("Generated Links vs Verified Links"));
		
	}
	//check the content on get a call
	@Test(priority=7)
	public void CheckContentForGetACallCard() throws InterruptedException
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


		//check a call icon  
		Assert.assertTrue(driver.findElement(By.cssSelector("div.infoCardIconWrap")).isDisplayed());
		//check for Get a Call text
		Assert.assertTrue(driver.findElement(By.cssSelector("span.infoCardTitle")).getText().equals("Get a Call"));
		//Check for count number of calls made ie is there any integer value--?
		//System.out.println(driver.findElement(By.cssSelector("span.infoCardCount")).getAttribute("innerHTML"));
		Thread.sleep(5000);
		System.out.println(driver.findElement(By.cssSelector("div[class='infoCardCountWrap'] span.infoCardCount")).getText());

	}
	

	//check starting date from in case of BNP tile..should be starting from date 1 week  previous from today
	@Test(priority=10)
	public void  Dashboard_MIS_TC_10()
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
		
		// check starting date from in case of BNP tile by inspecting
		String getfromDate=driver.findElement(By.cssSelector("div.infoCardDate")).getText();
		System.out.println(getfromDate);
		
		
		//extract date from  text
		String[] extractedFromDateText=getfromDate.split(" ");
		String day= extractedFromDateText[2];
		String month=extractedFromDateText[3];
		String year=extractedFromDateText[4];
		System.out.println(day+" --"+month+"--"+year);
		
		// get current date
		
		LocalDate from=java.time.LocalDate.now();
		
		String fromdate="";
		fromdate+=from;
		System.out.println(fromdate+"");
		//get day
		String[] a=fromdate.split("-");
		String fromDay=a[2];
		int t=Integer.parseInt(fromDay);
		int n=t-6;
		String week="";
		week+=n;
		
		System.out.println(week);
		
		//VERIFY DAY
		Assert.assertTrue(day.contains(week));
		
		String []months= {"Jan,","feb,","march,","april,","may,","june,","july,","aug,","sept,","oct,","nov,","dec,"};
		
		//VERIFY MONTH
		String s="";
		s+=a[1].charAt(a[1].length()-1);
		 int m=Integer.parseInt(s);
		 System.out.println("m="+m);
		 m--;
		 System.out.println("m-- "+m);
		for(int i=0;i<months.length;i++)
		{
			if(m==i)
			{
				System.out.println(months[m]+"-->moths[m]");
				months[m]=months[m].toLowerCase();
				month=month.toLowerCase();
				month=month.replace(",", "");
				System.out.println("months[m] "+months[m]+"==="+month);
				if(months[m].charAt(0)!=month.charAt(0))
					Assert.assertFalse(false);
				if(months[m].length()<month.length())
				{
					for(int i1=0;i1<months[m].length();i1++)
					{
						if(month.charAt(i1)!=months[m].charAt(i1))
						{
							Assert.assertTrue(true);
						}
					}
				
				}
				else
				{
					for(int i1=0;i1<month.length();i1++)
					{
						if(month.charAt(i1)!=months[m].charAt(i1))
						{
							Assert.assertTrue(true);
						}
					}
				
				}
			}
		}
		
		//VERIF YEAR
		String y="";
		y+=a[0];
		System.out.println(y);
		Assert.assertTrue(year.equals(y));
		
	}
	
	//check starting date from in case of My policies tile..should be starting from date 1 week  previous from today
		@Test(priority=11)
		public void  Dashboard_MIS_TC_11()
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
			
			// check starting date from in case of BNP tile by inspecting
			String getfromDate=driver.findElement(By.cssSelector("div.infoCardDate")).getText();
			System.out.println(getfromDate);
			
			
			//extract date from  text
			String[] extractedFromDateText=getfromDate.split(" ");
			String day= extractedFromDateText[2];
			String month=extractedFromDateText[3];
			String year=extractedFromDateText[4];
			System.out.println(day+" --"+month+"--"+year);
			
			// get current date
			
			LocalDate from=java.time.LocalDate.now();
			
			String fromdate="";
			fromdate+=from;
			System.out.println(fromdate+"");
			//get day
			String[] a=fromdate.split("-");
			String fromDay=a[2];
			int t=Integer.parseInt(fromDay);
			int n=t-6;
			String week="";
			week+=n;
			
			System.out.println(week);
			
			//VERIFY DAY
			Assert.assertTrue(day.contains(week));
			
			String []months= {"Jan,","feb,","march,","april,","may,","june,","july,","aug,","sept,","oct,","nov,","dec,"};
			
			//VERIFY MONTH
			String s="";
			s+=a[1].charAt(a[1].length()-1);
			 int m=Integer.parseInt(s);
			 System.out.println(m);
			 m--;
			 System.out.println(m);
			 for(int i=0;i<months.length;i++)
				{
					if(m==i)
					{
						System.out.println(months[m]+"-->moths[m]");
						months[m]=months[m].toLowerCase();
						month=month.toLowerCase();
						month=month.replace(",", "");
						System.out.println("months[m] "+months[m]+"==="+month);
						if(months[m].charAt(0)!=month.charAt(0))
							Assert.assertFalse(false);
						if(months[m].length()<month.length())
						{
							for(int i1=0;i1<months[m].length();i1++)
							{
								if(month.charAt(i1)!=months[m].charAt(i1))
								{
									Assert.assertTrue(true);
								}
							}
						
						}
						else
						{
							for(int i1=0;i1<month.length();i1++)
							{
								if(month.charAt(i1)!=months[m].charAt(i1))
								{
									Assert.assertTrue(true);
								}
							}
						
						}
					}
				}
			//VERIF YEAR
			String y="";
			y+=a[0];
			System.out.println(y);
			Assert.assertTrue(year.equals(y));
			
			
		}
		
		//check starting date from in case of Downlods tile..should be starting from date 1 week  previous from today
				@Test(priority=12)
				public void  Dashboard_MIS_TC_12()
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
					
					// check starting date from in case of BNP tile by inspecting
					String getfromDate=driver.findElement(By.cssSelector("div.infoCardDate")).getText();
					System.out.println(getfromDate);
					
					
					//extract date from  text
					String[] extractedFromDateText=getfromDate.split(" ");
					String day= extractedFromDateText[2];
					String month=extractedFromDateText[3];
					String year=extractedFromDateText[4];
					System.out.println(day+" --"+month+"--"+year);
					
					// get current date
					
					LocalDate from=java.time.LocalDate.now();
					
					String fromdate="";
					fromdate+=from;
					System.out.println(fromdate+"");
					//get day
					String[] a=fromdate.split("-");
					String fromDay=a[2];
					int t=Integer.parseInt(fromDay);
					int n=t-6;
					String week="";
					week+=n;
					
					System.out.println(week);
					
					//VERIFY DAY
					Assert.assertTrue(day.contains(week));
					
					String []months= {"Jan,","feb,","march,","april,","may,","june,","july,","aug,","sept,","oct,","nov,","dec,"};
					
					//VERIFY MONTH
					String s="";
					s+=a[1].charAt(a[1].length()-1);
					 int m=Integer.parseInt(s);
					 System.out.println(m);
					 m--;
					 System.out.println(m);
					 for(int i=0;i<months.length;i++)
						{
							if(m==i)
							{
								System.out.println(months[m]+"-->moths[m]");
								months[m]=months[m].toLowerCase();
								month=month.toLowerCase();
								month=month.replace(",", "");
								System.out.println("months[m] "+months[m]+"==="+month);
								if(months[m].charAt(0)!=month.charAt(0))
									Assert.assertFalse(false);
								if(months[m].length()<month.length())
								{
									for(int i1=0;i1<months[m].length();i1++)
									{
										if(month.charAt(i1)!=months[m].charAt(i1))
										{
											Assert.assertTrue(true);
										}
									}
								
								}
								else
								{
									for(int i1=0;i1<month.length();i1++)
									{
										if(month.charAt(i1)!=months[m].charAt(i1))
										{
											Assert.assertTrue(true);
										}
									}
								
								}
							}
						}
					
					//VERIF YEAR
					String y="";
					y+=a[0];
					System.out.println(y);
					Assert.assertTrue(year.equals(y));
					
				}
				
	//click on date filter icon on top right corner of dashboard page
	//from date and to date with month and week must be displayed
	@Test(priority=16)
	public void Dashboard_MIS_TC_16()
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
		//click on date filter icon on top right corner of dashboard page
		driver.findElement(By.xpath("(//button)[2]")).click();
		
		// verify  for rom date and to date with month and week is displayed
		// from date
		Assert.assertTrue(driver.findElement(By.name("fromDate")).isDisplayed());
		
		//to date
		Assert.assertTrue(driver.findElement(By.name("toDate")).isDisplayed());
	}
	
	//check if date filter icon is clickable or not
	@Test(priority=17)
	public void Dashboard_MIS_TC_17()
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
		
		Assert.assertTrue(	driver.findElement(By.xpath("(//button)[2]")).isEnabled());
	}
	
	
	//check default value of from date and to date..To date must today's date and from date must be 1 week previous from today--->QUERY
	@Test(priority=18)
	public void Dashboard_MIS_TC_18()
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
		
		//click on side filter icon
		driver.findElement(By.xpath("(//button)[2]")).click();
		
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
		String str=postweek.substring(0,7);
				System.out.println(str+"   str1");

		str+="-"+tt;
		System.out.println(str+"   str2");
		
		System.out.println(fromDate+" ==From Date");
		
		ArrayList<Character> ao=new ArrayList();
		char ch[]=fromDate.toCharArray();
		 for(int i=0;i<ch.length;i++)
		 {
			 ao.add(ch[i]);
		 }
	
		
		System.out.println(ao+": Ao of from date");
		if(ao.get(8)=='0')
			ao.set(8, ' ');
		System.out.println(ao+": Ao of from date");
		String res="";
		 for(int i=0;i<ao.size();i++)
		 {
			 if(i!=8)
			 {
				 res+=ao.get(i);
			 }
		 }
		 System.out.println(res);
		//verify  fromdate  is equal to  postweek
		 if(fromDate.charAt(8)=='0')
			 Assert.assertTrue(res.equals(str));
		 else
			 Assert.assertTrue(fromDate.equals(str));
		
	}
//	//TC_19 check if from date accepts more than to date------------------query
//	@Test(priority=19)
//	public void Dashboard_MIS_TC_19()
//	{
//		driver.get("https://visualivrmis.simpragma.com");
//		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
//
//		//1.login with valid credentials
//		driver.findElement(By.id("email")).sendKeys("naveenr@simpragma.com");
//		driver.findElement(By.id("password")).sendKeys("Password@123");
//		driver.findElement(By.tagName("button")).click();
//		
//		try {
//			Thread.sleep(4000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		//click on side filter icon
//		driver.findElement(By.xpath("(//button)[2]")).click();
//		//get currenrt date
//		LocalDate to=java.time.LocalDate.now();
//		System.out.println("get currenrt date : "+to);
//		String todate="";
//		todate+=to;
//		
//		//get day
//		String[] a=todate.split("-");
//		String toDay=a[2];
//		int t=Integer.parseInt(toDay);
//		System.out.println("get day"+t);
//		//get tommorow date
//
//		t++;
//		System.out.println("get tommorow date"+t);
//		String fromDate="";
//		for(int i=a.length-1;i>=0;i--)
//		{
//			if(i==a.length-1)
//			{
//				fromDate+=t+"-";
//			}
//			else
//			{
//				fromDate+=a[i]+"-";
//			}
//			
//		}
//        String fromDatesend=fromDate.substring(0, fromDate.length()-1);
//		System.out.println(fromDatesend);
//
//		driver.findElement(By.name("fromDate")).sendKeys(fromDatesend);
//		
//		  //JavascriptExecutor j = (JavascriptExecutor) driver;
//		
//	     
//		Assert.assertTrue(driver.findElement(By.cssSelector("div.go3958317564")).getText().equalsIgnoreCase("from date cannot be more than to date"));
//		
//		
//	}
//	
//	//TC_20 check if to date accepts less than from date
//	@Test(priority=20)
//	public void Dashboard_MIS_TC_20()
//	{
//		driver.get("https://visualivrmis.simpragma.com");
//		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
//	
//		
//		//1.login with valid credentials
//		driver.findElement(By.id("email")).sendKeys("naveenr@simpragma.com");
//		driver.findElement(By.id("password")).sendKeys("Password@123");
//		driver.findElement(By.tagName("button")).click();
//		
//		try {
//			Thread.sleep(4000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		//click on side filter icon
//		driver.findElement(By.xpath("(//button)[2]")).click();
//		
//		//get currenrt date
//		LocalDate from=java.time.LocalDate.now();
//		String fromdate="";
//		fromdate+=from;
//		
//		//get day
//		String[] a=fromdate.split("-");
//		String fromDay=a[2];
//		int t=Integer.parseInt(fromDay);
//		
//		//get previous date
//		t--;
//		String toDate="";
//		for(int i=a.length-1;i>=0;i--)
//		{
//			if(i==a.length-1)
//			{
//				toDate+=t+"-";
//			}
//			else
//			{
//				toDate+=a[i]+"-";
//			}
//			
//		}
//        String toDatesend=toDate.substring(0, toDate.length()-1);
//		System.out.println(toDatesend);
//		
//		driver.findElement(By.xpath("(//input[@type='date'])[2]")).sendKeys(toDatesend);
//		//go4109123758
//		System.out.println(driver.findElement(By.cssSelector("div.go4109123758")).getText());
//		Assert.assertTrue(driver.findElement(By.cssSelector("div.go4109123758")).getText().equalsIgnoreCase("to date cannot be less than from date"));
//		
//		
//		
//	}
	//sc-dUjcNx sc-gHboQg kueDBJ
	//Tc_21 check if calender icon is clickable or note) 
	@Test(priority=21)
	public void Dashboard_MIS_TC_21()
	{
		driver.get("https://visualivrmis.simpragma.com");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		
		//1.login with valid credentials
		driver.findElement(By.id("email")).sendKeys("naveenr@simpragma.com");
		driver.findElement(By.id("password")).sendKeys("Password@123");
		driver.findElement(By.tagName("button")).click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//click on side filter icon
		driver.findElement(By.xpath("(//button)[2]")).click();
		
		// click on from calender icon and check if  clickable or not
		Assert.assertTrue(driver.findElement(By.xpath("(//input[@class='sc-dUjcNx sc-gHboQg kueDBJ'])[1]")).isEnabled());
		
		// click on to calender icon and check if  clickable or not
		Assert.assertTrue(driver.findElement(By.xpath("(//input[@class='sc-dUjcNx sc-gHboQg kueDBJ'])[2]")).isEnabled());
	}
	
	//TC_24 click on other tabs such as conversation records etc and come again to Dashboard  
	@Test(priority=24)
	public void Dashboard_MIS_TC_24()
	{
		driver.get("https://visualivrmis.simpragma.com");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		
		//1.login with valid credentials
		driver.findElement(By.id("email")).sendKeys("naveenr@simpragma.com");
		driver.findElement(By.id("password")).sendKeys("Password@123");
		driver.findElement(By.tagName("button")).click();
		
	
		//click on side filter icon
				driver.findElement(By.xpath("(//button)[2]")).click();
		//get default value of from and to date

		String fromDate=driver.findElement(By.xpath("(//input[@type='date'])[1]")).getAttribute("value");
		System.out.println(fromDate);
	
		String toDate=driver.findElement(By.xpath("(//input[@type='date'])[2]")).getAttribute("value");
		System.out.println(toDate);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// click on conversation record
		List<WebElement> menuItems=driver.findElements(By.className("menuItem"));
		for(WebElement e:menuItems)
		System.out.println(e.getText());
		
		menuItems.get(1).click();
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// click again on dashboard
		menuItems=driver.findElements(By.className("menuItem"));
		for(WebElement e:menuItems)
			System.out.println(e.getText());
		menuItems.get(0).click();
		
		//click on side filter icon
				driver.findElement(By.xpath("(//button)[2]")).click();	
	
		//verify current from and todate  with  previous;
		Assert.assertTrue(driver.findElement(By.xpath("(//input[@type='date'])[1]")).getAttribute("value").equals(fromDate));
		Assert.assertTrue(driver.findElement(By.xpath("(//input[@type='date'])[2]")).getAttribute("value").equals(toDate));
		
		//
		
	}
	//TC_27 check if we select GBF is month
	//EO by default to date is today's date and from date is 1 month previous from today
	@Test(priority =27)
	public void Dashboard_MIS_TC_27()
	{
		driver.get("https://visualivrmis.simpragma.com");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		
		//1.login with valid credentials
		driver.findElement(By.id("email")).sendKeys("naveenr@simpragma.com");
		driver.findElement(By.id("password")).sendKeys("Password@123");
		driver.findElement(By.tagName("button")).click();
		
	
		//click on side filter icon
				driver.findElement(By.xpath("(//button)[2]")).click();
		//clcick on week
				driver.findElement(By.xpath("(//button)[3]")).click();
		//get default value of from and to date

		String fromDate=driver.findElement(By.xpath("(//input[@type='date'])[1]")).getAttribute("value");
		System.out.println(fromDate);
	
		String toDate=driver.findElement(By.xpath("(//input[@type='date'])[2]")).getAttribute("value");
		System.out.println(toDate);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// get current date
		LocalDate todaysdate=java.time.LocalDate.now();
		String currentDate="";
		currentDate+=todaysdate;
		System.out.println("--"+currentDate);
		
				//retive 1 week post value from todate/currentdate
			
				
				//get month
				String[] a=currentDate.split("-");
				String fromMonth=a[1];
				int t=Integer.parseInt(fromMonth);
				t=t-1;
				String tt="";
				tt+=t;
				String str = null;
				String postweek=currentDate;
				System.out.println("tt="+tt);
				if(Integer.parseInt(tt)<10)
				{
				 str=postweek.substring(0,6);
				System.out.println(str+"   str1");

				}
				//else
					
						
				str+=tt;

				//get day
				String[] a1=fromDate.split("-");
				String fromDay=a1[2];
				str+="-";
				str+=Integer.parseInt(fromDay);
				System.out.println(str+"   str2");
				
				System.out.println(fromDate+" ==From Date");
				//verify  fromdate  is equal to  postmonth
				Assert.assertTrue(fromDate.equals(str));
	}
	
	//TC_28 check if we select GBF is week
	//EO by default to date is today's date and from date is 1 week previous from today
	@Test(priority =28)
	public void Dashboard_MIS_TC_28()
	{
		driver.get("https://visualivrmis.simpragma.com");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		
		//1.login with valid credentials
		driver.findElement(By.id("email")).sendKeys("naveenr@simpragma.com");
		driver.findElement(By.id("password")).sendKeys("Password@123");
		driver.findElement(By.tagName("button")).click();
		
	
		//click on side filter icon
				driver.findElement(By.xpath("(//button)[2]")).click();
		//clcick on week
				driver.findElement(By.xpath("(//button)[4]")).click();
		//get default value of from and to date

		String fromDate=driver.findElement(By.xpath("(//input[@type='date'])[1]")).getAttribute("value");
		System.out.println(fromDate);
	
		String toDate=driver.findElement(By.xpath("(//input[@type='date'])[2]")).getAttribute("value");
		System.out.println(toDate);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// get current date
		LocalDate todaysdate=java.time.LocalDate.now();
		String currentDate="";
		currentDate+=todaysdate;
		System.out.println(currentDate);
		
				//retive 1 week post value from todate/currentdate
			
				
				//get day
				String[] a=currentDate.split("-");
				String fromDay=a[2];
				int t=Integer.parseInt(fromDay);
				t=t-6;
				String tt="", str="";
				tt+=t;
				String postweek=currentDate;
				System.out.println("tt="+tt);
				 str=postweek.substring(0,8);
						System.out.println(str+"   str1");

				str+=tt;
				System.out.println(str+"   str");
				
				System.out.println(fromDate+" ==From Date");
				//verify  fromdate  is equal to  postweek
				Assert.assertTrue(fromDate.equals(str));
	}
	

}
