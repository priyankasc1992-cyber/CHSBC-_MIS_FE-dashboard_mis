package dashboard_mis;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class Conversation_Records_UI_Test_Cases {
	
	static WebDriver driver = new EdgeDriver();
static	private int weekday;
	
	//TC_01 click the conversation 
	//records in menu page
	//Conversation records 
	//page must be displayed 

	@BeforeTest
	public void init() throws InterruptedException
	{
		driver.get("http://visualivrmis.simpragma.com/");
		Thread.sleep(5000);

		//1.login with valid credentials
		driver.findElement(By.id("email")).sendKeys("naveenr@simpragma.com");
		driver.findElement(By.id("password")).sendKeys("Password@123");
		driver.findElement(By.tagName("button")).click();
		Thread.sleep(6000);
		//click on  conversation record btn in menu
		WebElement conversationRecords= driver.findElement(By.xpath("(//li)[2]"));

	conversationRecords.click();
		Thread.sleep(1000);
	
	}
	@Test(priority=1)
	public void tc_1()
	{
		
		
		//VERIFY
		Assert.assertTrue(driver.findElement(By.tagName("h4")).getText().endsWith("Conversation Records"));
		
	}
	//TC_3 check that conversation 
	//Records page contains the 
	//From Date and To date fields 
	//with data table
	
	@Test(priority=3)
	public void tc_3() throws InterruptedException
	{
		
	 Thread.sleep(2000);
		// check if from date field is present or not
		Assert.assertTrue(driver.findElement(By.xpath("(//input)[1]")).isDisplayed());
		
		// check if to date field is present or not
		Assert.assertTrue(driver.findElement(By.xpath("(//input)[2]")).isDisplayed());
	}
		
	//titleBarTop	
	//TC_04 check the size of the 
	///conversation records page 
	//title bar
	
	@Test(priority=7)
	public void tc_7()
	{

		//verify size of title bar
		String titlebarSize=driver.findElement(By.xpath("//div[@class='titleBarTop']")).getSize().toString();
		
		System.out.println(titlebarSize);
	}
	//tc_5 check that distance between header and title bar of thConversation Records page
	@Test(priority=5)
	public void tc_5() throws InterruptedException
	{
		
		
	
		//verifthat distance between header and title bar of thConversation Records page
		String marginTop=driver.findElement(By.cssSelector("div.titleBarWrapper.mt-5")).getCssValue("margin-top");
		System.out.println(marginTop);
		Assert.assertTrue(marginTop.toString().equals("48px"));
 	}
	
	
	//TC_ 08 check  if conversation record icon is present or not
	@Test(priority=8)
	public void tc_8() throws InterruptedException
	{
		WebElement icon=driver.findElement(By.xpath("//div[@class='iconWrap']"));
		Assert.assertTrue(icon.isDisplayed());	
	
	}
	//Tc_09 check the size of the conversation records icon
	@Test(priority=9)
	public void tc_9() throws InterruptedException
	{
		WebElement icon=driver.findElement(By.xpath("//div[@class='iconWrap']"));
		String height=icon.getCssValue("height").toString();
		String width=icon.getCssValue("width").toString();
		System.out.println(height+" "+"X"+" "+width);
		Assert.assertEquals(height, "30px");
		Assert.assertEquals(width, "30px");
		
	}
	//TC_11 check the font size and font type of the conversation records title
	@Test(priority=11)
	public void tc_11() throws InterruptedException
	{
		WebElement icon=driver.findElement(By.tagName("h4"));
		String font_size=icon.getCssValue("font-size").toString();
		String font_family=icon.getCssValue("font-family").toString();
		System.out.println(font_size+" "+font_family);
		Assert.assertEquals(font_size, "24px");
		Assert.assertTrue(font_family.contains("Nunito Sans"));	
		Assert.assertEquals(font_size,"24px" );
	}
	//Tc_12 check that text colour of the conversation records title €
	@Test(priority=12)
	public void tc_12() throws InterruptedException
	{
		WebElement icon=driver.findElement(By.tagName("h4"));
		String color=icon.getCssValue("color").toString();
		System.out.println(color);
		Assert.assertEquals(color,"rgba(52, 52, 52, 1)" );
	}
	//TC_13 check that excel /export icon is present or not in title bar of the conversation records page
	@Test(priority=13)
	public void tc_13() throws InterruptedException
	{
		
		WebElement exporticon=driver.findElement(By.xpath("//body/div[@id='root']/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/a[1]/*[1]"));
		Assert.assertTrue(exporticon.isDisplayed());

	}
	
	//TC_14 check that size of the export icon
	@Test(priority=14)
	public void tc_14() throws InterruptedException
	{
		Thread.sleep(1000);
		WebElement exporticon=driver.findElement(By.tagName("a"));
		String exportIconSize=exporticon.getSize().toString();
		System.out.println(exportIconSize);
		Assert.assertEquals(exportIconSize,"(28, 28)");
	}
	//TC_15 check that colour of the export icon
	@Test(priority=15)
	public void tc_15() throws InterruptedException
	{
		WebElement exporticon=driver.findElement(By.cssSelector("svg.exportIcon"));
		String exportIconColor=exporticon.getAttribute("color").toString();
		System.out.println(exportIconColor);
		Assert.assertEquals(exportIconColor,"green");
	}
	
	//TC_17 check that export icon is clickable or not
	@Test(priority=17)
	public void tc_17() throws InterruptedException
	{
		WebElement exporticon=driver.findElement(By.cssSelector("svg.exportIcon"));
		Assert.assertTrue(exporticon.isEnabled());
	}
	@Test (  priority =23 , description="check that size of the from date and to date fields")
	public void Tc_23()throws InterruptedException
	{
		
		int from= driver.findElement(By.xpath("(//input)[1]")).getSize().getHeight();
		int to=driver.findElement(By.xpath("(//input)[2]")).getSize().getHeight();
		System.out.println(" size of the  from date filter :" +from);
		System.out.println(" size of the  to date filter :" +to);
		Assert.assertEquals(from, 40);
		Assert.assertEquals(to, 40);	
	}
	//TC_24check that font size and font type of the from date and to date
	@Test(priority=24)
	public void tc_24() throws InterruptedException
	{
		WebElement fromDate=driver.findElement(By.xpath("(//input)[1]"));
		String fromfontSize=fromDate.getCssValue("font-size").toString();
		System.out.println("from date "+fromfontSize);
		Assert.assertEquals(fromfontSize,"16px");
		WebElement toDate=driver.findElement(By.xpath("(//input)[2]"));
		String tofontSize=fromDate.getCssValue("font-size").toString();
		System.out.println("to  font size:"+tofontSize);
		Assert.assertEquals(tofontSize,"16px");
		
		String fromfontfamily=fromDate.getCssValue("font-family").toString();
		System.out.println("from date font family : "+fromfontfamily);
		Assert.assertEquals(fromfontfamily,"Nunito");
		String tofontfamily=fromDate.getCssValue("font-family").toString();
		System.out.println("to date font family : "+tofontfamily);
		Assert.assertEquals(tofontfamily,"Nunito");
		
	}
	//TC-25 check that text colour of the from date and to date fields
	@Test(priority=25)
	public void tc_25() throws InterruptedException
	{
		WebElement fromDate=driver.findElement(By.xpath("(//input)[1]"));
		String fromdatecolor=fromDate.getCssValue("color").toString();
		System.out.println("from date color "+fromdatecolor);
		Assert.assertEquals(fromdatecolor,"rgba(42, 48, 57, 1)");
		WebElement toDate=driver.findElement(By.xpath("(//input)[2]"));
		String todatecolor=fromDate.getCssValue("color").toString();
		System.out.println("to  date  color:"+todatecolor);
		Assert.assertEquals(todatecolor,"rgba(42, 48, 57, 1)");	
	}
	//Tc_26 check that From date and To date labels are displayed or not
	@Test(priority=26)
	public void tc_26() throws InterruptedException
	{
		Assert.assertTrue(driver.findElement(By.xpath("(//label)[1]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("(//label)[2]")).isDisplayed());
	}
	//Tc_27 check that font size and font type of the from date and to date lables
	@Test(priority=27)
	public void tc_27() throws InterruptedException
	{
		WebElement fromDate=driver.findElement(By.xpath("(//label)[1]"));
		WebElement todate=driver.findElement(By.xpath("(//label)[2]"));
		String fromfontSize=fromDate.getCssValue("font-size").toString();
		System.out.println("from date "+fromfontSize);
		Assert.assertEquals(fromfontSize,"14px");
		WebElement toDate=driver.findElement(By.xpath("(//input)[2]"));
		String tofontSize=fromDate.getCssValue("font-size").toString();
		System.out.println("to  font size:"+tofontSize);
		Assert.assertEquals(tofontSize,"14px");
		
		String fromfontfamily=fromDate.getCssValue("font-family").toString();
		System.out.println("from date font family : "+fromfontfamily);
		Assert.assertEquals(fromfontfamily,"Nunito");
		String tofontfamily=fromDate.getCssValue("font-family").toString();
		System.out.println("to date font family : "+tofontfamily);
		Assert.assertEquals(tofontfamily,"Nunito");
		
	}
	//TC_28 check that colour of the from date and to date lables
	@Test(priority=28)
	public void tc_28() throws InterruptedException
	{
		WebElement fromDate=driver.findElement(By.xpath("(//label)[1]"));
		WebElement todate=driver.findElement(By.xpath("(//label)[2]"));
		String fromdatecolor=fromDate.getCssValue("color").toString();
		System.out.println("from date color "+fromdatecolor);
		Assert.assertEquals(fromdatecolor,"rgba(63, 73, 84, 1)");
		WebElement toDate=driver.findElement(By.xpath("(//input)[2]"));
		String todatecolor=fromDate.getCssValue("color").toString();
		System.out.println("to  date  color:"+todatecolor);
		Assert.assertEquals(todatecolor,"rgba(63, 73, 84, 1)");	
	}
	//Tc_29 check that alignment of the 	from date and to date fields
	@Test(priority=29)
	public void tc_29() throws InterruptedException
	{
		WebElement fromDate=driver.findElement(By.xpath("(//input)[1]"));
		WebElement todate=driver.findElement(By.xpath("(//input)[2]"));
		
		String fromdatealign=fromDate.getCssValue("align-items").toString();
		System.out.println("from date field alignment  "+fromdatealign);
		Assert.assertEquals(fromdatealign,"center");
		
		String todatealign=todate.getCssValue("align-items").toString();
		System.out.println("to  date field alignment:"+todatealign);
		Assert.assertEquals(todatealign,"center");	
	}
	
	@Test(priority=30,description="when we click on the from date and to date fields check whether the fields are highlighted in blue colour ")
	public void tc_30() throws InterruptedException
	{

		WebElement fromDate=driver.findElement(By.xpath("(//input)[1]"));
		//clcik on from date 
		fromDate.click();
		//get border color of top left right and bottom
		String ftop=fromDate.getCssValue("border-top-color");
		String fleft=fromDate.getCssValue("border-top-color");
		String fright=fromDate.getCssValue("border-top-color");
		String fbottom=fromDate.getCssValue("border-top-color");
		System.out.println(ftop+" "+fleft+" "+fright+" "+fbottom);
		//verify that all border colors are same
		Assert.assertTrue(ftop.equals(fleft));
		Assert.assertTrue(ftop.equals(fright));
		Assert.assertTrue(ftop.equals(fbottom));
		Assert.assertTrue(fleft.equals(fright));
		Assert.assertTrue(fleft.equals(fbottom));
		Assert.assertTrue(fbottom.equals(fright));
		
		//Verify eo and  ao
		Assert.assertEquals(ftop, "rgba(1, 182, 245, 1)");
		
		
		
		

				
	}
	@Test(priority=30,description="when we click on the from date and to date fields check whether the fields are highlighted in blue colour ")
	public void tc_30_1() throws InterruptedException
	{
		WebElement todate=driver.findElement(By.xpath("(//input)[2]"));
		//clcik on to date 
	
				todate.click();
				Thread.sleep(5000);
				//get border color of top left right and bottom
				String top=todate.getCssValue("border-top-color");
				String left=todate.getCssValue("border-top-color");
				String right=todate.getCssValue("border-top-color");
				String bottom=todate.getCssValue("border-top-color");
				System.out.println(top+" "+left+" "+right+" "+bottom);
				//verify that all border colors are same
				Assert.assertTrue(top.equals(left));
				Assert.assertTrue(top.equals(right));
				Assert.assertTrue(top.equals(bottom));
				Assert.assertTrue(left.equals(right));
				Assert.assertTrue(left.equals(bottom));
				
				Assert.assertTrue(bottom.equals(right));
				String eo ="rgba(1, 182, 245, 1)";
				//Verify eo and  ao
				Assert.assertEquals(top,eo );
	}
	@Test(priority=35,description="Check that data table header contains the following items or not :"
	+ "\n\t\tDATE\n"
	+ "\t\tCUSTOMER\n"
	+ "\t\tCLIENT ID\n"
	+ "\t\tSESSION ID\n"
	+ "\t\tMOBILE NUMBER\n"
	+ "\t\tSESSION DURATIO\n"
	+ "\t\tENDED BY\n" 
	+"EO is these  data must be displayed")
	public void tc_35() throws InterruptedException
	{
		String[] eo= {"DATE","CUSTOMER","CLIENT ID","SESSION ID","MOBILE NUMBER","SESSION DURATION","ENDED BY"};
		List<WebElement> thead=driver.findElements(By.xpath("//div [@class='sc-yZwTr bJFNHB']"));
		int i=0;
		for(WebElement e: thead)
		{
			String ao=e.getText();
			System.out.println(ao);
			Assert.assertTrue(ao.equals(eo[i]));
			i++;
		}
	}
	
	@Test(priority=37,description="check that font size and font type of the table header content")
	public void tc_37() throws InterruptedException
	{
		List<WebElement> thead=driver.findElements(By.xpath("//div [@class='sc-yZwTr bJFNHB']"));
		for(WebElement e: thead)
		{
			Assert.assertEquals(e.getCssValue("font-size"), "14px");
			Assert.assertEquals(e.getCssValue("font-family"), "Nunito");
		}
	}
	@Test(priority=38,description="check that text colour of the table content")
	public void tc_38() throws InterruptedException
	{
		//get color of header contents
		List<WebElement> thead=driver.findElements(By.xpath("//div [@class='sc-yZwTr bJFNHB']"));
		String thead_s = null;
		for(WebElement e: thead)
		{
			thead_s=e.getCssValue("color");
			System.out.println(thead_s);
		}
		//get color of body content
		WebElement tbody=driver.findElement(By.xpath("//div[@class='sc-hRmvpr gNmwKQ']"));
		String tbody_s= tbody.getCssValue("color");
		
		//verify if all content in table including haeder and body color are same
		Assert.assertEquals(thead_s,tbody_s );
		
		String eo="rgba(63, 73, 84, 1)";
		
		//verify ao and eo
		Assert.assertEquals(tbody_s, eo);
	}
	@Test(priority=42,description="check the size of the each \r\n" + 
	 		"gridcell in the table")
			public void tc_42() throws InterruptedException
			{

				
					int eoheight=42;
					List<WebElement> td= driver.findElements(By.tagName("td"));
					for(WebElement e:td)
					{
						int height=e.getSize().getHeight();
					
						Assert.assertEquals(eoheight, height);
						
					}
					
			}
	@Test ( priority=52,description="check the size of the Goto page \r\n" + 
	 		"buttons",enabled=false)
				public void TC_52() throws InterruptedException
				{
			
					//click on new policy requests
					driver.findElement(By.xpath("//li[contains(text(),'New Policy Requests')]")).click();
					Thread.sleep(2000);
					//check if goto btns are present or not
					int i=0;
				
						List<WebElement>gotobtns=driver.findElements(By.className("sc-dPNhBE.kqZRAX"));
						for(WebElement e:gotobtns)
						{
							
							int height=gotobtns.get(i).getSize().getHeight();
							int width=gotobtns.get(i).getSize().getWidth();
							System.out.println(" size of goto button  "+i+ " is "+ height+" X "+width);
							Assert.assertEquals(height,32);
							Assert.assertEquals(width,32);
						}
					}

@Test ( priority=53,description="check the size of the Goto page clickable or not",enabled=false)
public void TC_53() throws InterruptedException
{

//click on Callback Requests
driver.findElement(By.xpath("//li[contains(text(),'Callback Requests')]")).click();
Thread.sleep(2000);
//check if goto btns are present or not
int i=0;

List<WebElement>gotobtns=driver.findElements(By.className("sc-dPNhBE.kqZRAX"));
for(WebElement e:gotobtns)
{
String align=e.getCssValue("align-items");
Assert.assertEquals(align,"center");
}
}
	 @Test ( priority=54,description="check the size of the Goto page clickable or not",enabled=false)
					public void TC_54() throws InterruptedException
					{
				
						//click on new policy requests
						driver.findElement(By.xpath("//li[contains(text(),'New Policy Requests')]")).click();
						Thread.sleep(2000);
						//check if goto btns are present or not
						int i=0;
					
							List<WebElement>gotobtns=driver.findElements(By.className("sc-dPNhBE.kqZRAX"));
							for(WebElement e:gotobtns)
							{
								
								Assert.assertTrue(e.isEnabled());
							}
						}
	 @Test ( priority=55,description="check that text colour of Goto page buttons",enabled=false)
		public void TC_55() throws InterruptedException
		{
	
			//click on new policy requests
			driver.findElement(By.xpath("//li[contains(text(),'New Policy Requests')]")).click();
			Thread.sleep(2000);
			//check if goto btns are present or not
			int i=0;
		
				List<WebElement>gotobtns=driver.findElements(By.className("sc-dPNhBE.kqZRAX"));
				for(WebElement e:gotobtns)
				{
					
					Assert.assertTrue(e.getCssValue("color").equals("rgba(63, 73, 84, 1)"));
				}
				
		}
	@Test(priority=43,description="check that data is at left aligned or not in the table")
	public void tc_43() throws InterruptedException
	{

		//get color of header contents
		List<WebElement> thead=driver.findElements(By.xpath("//div [@class='sc-yZwTr bJFNHB']"));
		String thead_s = null;
		for(WebElement e: thead)
		{
			thead_s=e.getCssValue("text-align");
			System.out.println(thead_s);
		}
		//get color of body content
		WebElement tbody=driver.findElement(By.xpath("//div[@class='sc-hRmvpr gNmwKQ']"));
		String tbody_s= tbody.getCssValue("text-align");
		
		//verify if all content in table including haeder and body color are same
		Assert.assertEquals(thead_s,tbody_s );
		
		String eo="left";
		
		//verify ao and eo
		Assert.assertEquals(tbody_s, eo);
	}
	
	@Test(priority=20,description="check that position of the \r\n" + 
			"export icon")
	public void tc_20() throws InterruptedException
	{
		String position=driver.findElement(By.xpath("//body/div[@id='root']/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/a[1]/*[1]")).getLocation().toString();
		System.out.println(position);
	}
	public void tc_21() throws InterruptedException
	{
		String fromDate=driver.findElement(By.xpath("(//input)[1]")).getAttribute("value");
		System.out.println(fromDate);
	
		String toDate=driver.findElement(By.xpath("(//input)[2]")).getAttribute("value");
		System.out.println(toDate);
		
		// get current date
		LocalDate todaysdate=java.time.LocalDate.now();
		String currentDate="";
		currentDate+=todaysdate;
		System.out.println(currentDate);
		
				//retive 1 week post value from todate/currentdate
			
				
				//get day
				String[] a=currentDate.split("-");
				String day=a[2];
				System.out.println(" day= "+day);
				int d=Integer.parseInt(day);
				System.out.println("d= "+d);
				
				//get day
			
				String month=a[1];
				System.out.println("month= "+month);
				int m=Integer.parseInt(month);
				System.out.println("m= "+m);
				//t=t-6;
				
				if(d<=6)
				{
							 weekday=weekDayCalculator(d,m);
					
							System.out.println(weekday);
							
							String tt="", str="";
			
							tt+=weekday;
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
				
				else
				{
					//verify  fromdate  is equal to  postweek
					d=d-6;
					String postweek=currentDate;
					String str=postweek.substring(0,8);
					System.out.println(str+"   str1");

			str+=d;
			System.out.println(str+"   str");
			
			System.out.println(fromDate+" ==From Date");
			//verify  fromdate  is equal to  postweek
			Assert.assertTrue(fromDate.equals(str));
				}
		
	
				
				

					
				
				//Assert.assertTrue(fromDate.equals(str));
	}

	@Test ( priority=45 ,description="In CUSTOMER column check \r\n" + 
			"that customer name is \r\n" + 
			"displayed in uppercase or not")
	public void TC_45()
	{
		int i=0;
	 List<WebElement> customerColumnData=driver.findElements(By.xpath("(//td/div/span)[1]"));
	 for(WebElement e: customerColumnData)
	 {
		
		 String name=e.getText();
		 System.out.println(name);
		 String  UC_name=name.toUpperCase();
		 Assert.assertTrue(name.equals(UC_name));
		
		
		 
	 }
	}
	private int weekDayCalculator(int day, int month)
	{
		
		//Let us make array named year [],
		int [] year={0,-2,1,0,1,0,1,1,0,0,1};
		//In this array  0 is for 30 days , 1is 31 days and -2 is feb either 28 or 29
		int n=42;
		//if current month is of 30 days
		if(month==1|| month==4|| month==9||month==6||month==11)
		{
			
			System.out.println("----inside  month if---");
		
				if(day==6)
				{
					weekday=42-(day*2-1);
					System.out.println(	"if current month is of 30 days weekday will be:" +weekday );
					
				
				}
				if(day==5)
				{
					
					weekday=39-(day*2-1);
					System.out.println(	"if current month is of 30 days weekday will be:" +weekday );
				
				
				}
				if(day==4)
				{
					weekday=36-(day*2-1);
					System.out.println(	"if current month is of 30 days weekday will be:" +weekday );
					
				
				}
				if(day==3)
				{
					
					weekday=33-(day*2-1);
					System.out.println(	"if current month is of 30 days weekday will be:" +weekday );
					
				
				}
				if(day==2)
				{
					;
					weekday=30-(day*2-1);
					System.out.println(	"if current month is of 30 days weekday will be:" +weekday );
					
				
				}
				if(day==1)
				{
					
					weekday=29-(day*2-1);
					System.out.println(	"if current month is of 30 days weekday will be:" +weekday );
					
				
				}
				

		}
		else
		{
			//if current month is of 31 days
			

			if(day==6)
			{
				weekday=42-(day*2);
				System.out.println(	"if current month is of 30 days weekday will be:" +weekday );
				
			
			}
			if(day==5)
			{
				
				weekday=39-day*2;
				System.out.println(	"if current month is of 30 days weekday will be:" +weekday );
			
			
			}
			if(day==4)
			{
				weekday=36-day*2;
				System.out.println(	"if current month is of 30 days weekday will be:" +weekday );
				
			
			}
			if(day==3)
			{
				
				weekday=33-day*2;
				System.out.println(	"if current month is of 30 days weekday will be:" +weekday );
				
			
			}
			if(day==2)
			{
				;
				weekday=30-day*2;
				System.out.println(	"if current month is of 30 days weekday will be:" +weekday );
				
			
			}
			if(day==1)
			{
				
				weekday=29-day*2;
				System.out.println(	"if current month is of 30 days weekday will be:" +weekday );
				
			
			}
			
		}

		//if current  month is feb
		
		if( month ==2)
		{
			if(day==6)
			{
				weekday=42-day;
				System.out.println(	"if current month is of 30 days weekday will be:" +weekday );
				
			
			}
			if(day==5)
			{
				
				weekday=39-day;
				System.out.println(	"if current month is of 30 days weekday will be:" +weekday );
			
			
			}
			if(day==4)
			{
				weekday=36-day;
				System.out.println(	"if current month is of 30 days weekday will be:" +weekday );
				
			
			}
			if(day==3)
			{
				
				weekday=33-day;
				System.out.println(	"if current month is of 30 days weekday will be:" +weekday );
				
			
			}
			if(day==2)
			{
				;
				weekday=30-day;
				System.out.println(	"if current month is of 30 days weekday will be:" +weekday );
				
			
			}
			if(day==1)
			{
				
				weekday=29-day;
				System.out.println(	"if current month is of 30 days weekday will be:" +weekday );
				
			
			}
			

		}
		
		return weekday;
	}
	
//	 @Test ( priority=62,description="check that vertical scroll bar is\r\n" + 
//		"scrollable or not, in New Policy \r\n" + 
//		"Requests page")
//public void TC_62() throws InterruptedException
//{
//
//	//click on Callback Requests
//	driver.findElement(By.xpath("//li[contains(text(),'Callback Requests')]")).click();
//	Thread.sleep(2000);
//	Actions act = new Actions(driver);
// act.sendKeys(Keys.PAGE_DOWN).build().perform(); //Page Down
// System.out.println("Scroll down perfomed");
// Thread.sleep(3000);
// act.sendKeys(Keys.PAGE_UP).build().perform();       //Page Up
// System.out.println("Scroll up perfomed");
// Thread.sleep(3000);
//}
//@Test ( priority=63,description="check that horizhontal scroll bar is\r\n" + 
// 		"scrollable or not, in New Policy \r\n" + 
// 		"Requests page")
//	public void TC_63() throws InterruptedException
//	{
//
//		//click on Callback Requests
//		driver.findElement(By.xpath("//li[contains(text(),'Callback Requests')]")).click();
//		Thread.sleep(2000); 
//		// scroll horizontally in the right direction, use the following JavaScript.
//		((JavascriptExecutor)
//
//				driver).executeScript("window.scrollBy(2000,0)");
//		//scroll horizontally in the left direction, use the following JavaScript.
//		((JavascriptExecutor)
//
//				driver).executeScript("window.scrollBy(-2000,0)");
//	}
//	@AfterTest
//	public void closedriver()
//	{
//		driver.close();
//	}
	
	
}

