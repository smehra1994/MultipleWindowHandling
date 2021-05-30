/*Scenario :
We are on a page
click on one link
1 or more child windows open like in naukri site we get 2 or more advertising pop up windows
get count of child windows
switch to them one by one and get title
switch back to parent
exit
*/

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleChildWIndowHandling {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://Users/sanka/Documents/ChromeDriverEXE/new/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://seleniumpractise.blogspot.com/2017/07/multiple-window-examples.html");
		
		String parent=driver.getWindowHandle();
		System.out.println("ParentWindow is :" + parent);
		
		Set<String> AllChildWindows=driver.getWindowHandles(); 
	     
		int count= AllChildWindows.size();
		System.out.println("Total Windows are : " + count);
		
		for(String child : AllChildWindows)     
		{
			if(!parent.equalsIgnoreCase(child))
			{
				driver.switchTo().window(child);
				System.out.println("Chils Window Title is :" + driver.getTitle());
				Thread.sleep(5000);
				driver.close();
			}
		}
		
		driver.switchTo().window(parent);
		System.out.println("Parent window title is :" + driver.getTitle());
		
		driver.quit();
	}

}
