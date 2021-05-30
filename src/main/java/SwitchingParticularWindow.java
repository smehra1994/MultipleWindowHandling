
/*Scenario:
on a page
click on something
multiple windows open
want to woek in specific windows only
fetch as per user input
*/
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchingParticularWindow {

		public static void main(String[] args) throws InterruptedException {
			System.setProperty("webdriver.chrome.driver", "C://Users/sanka/Documents/ChromeDriverEXE/new/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("https://seleniumpractise.blogspot.com/2017/07/multiple-window-examples.html");
			
			String parent=driver.getWindowHandle();
			System.out.println("ParentWindow is :" + parent);
			
			Set<String> AllChildWindows=driver.getWindowHandles(); 
			
			//convert set into a arraylist for fetching user defined window/tab bcz we dont have any index in set so cant fetch from it
			ArrayList<String> arr=new ArrayList(AllChildWindows);
			
			driver.switchTo().window(arr.get(0));       //fetch parent window
			
			System.out.println("Title of parent :" + driver.getTitle());
			
			driver.close();
			
			driver.switchTo().window(arr.get(3));        //fetch 3rd child window
			
			driver.close();
			
			driver.switchTo().window(arr.get(1)); 
			
	}

}
