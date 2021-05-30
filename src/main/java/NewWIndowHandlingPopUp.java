import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*Scenario :
Open a page(parent window)
Click on a button
get a new child window
switch to child window
perform some action on child window 
close child window
Again switch back to parent window

Solution:
need window ID by Window Handler API*/

public class NewWIndowHandlingPopUp {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C://Users/sanka/Documents/ChromeDriverEXE/new/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://giving dummy url");
		driver.findElement(By.xpath("//input[@type='submit' and @name='proceed']")).click();
		
		//get window id of parent and child window
		
		Set<String> handler=driver.getWindowHandles(); //handler object has 2 window Id's in it 
		Iterator<String> it=handler.iterator();      //to fetch values from set we use iterator just like we use for loop in list(no index values in set)
		
		String parentWindowId=it.next();
		System.out.println("ParentWindow is :" + parentWindowId);         //earlier iterator was not pointing to any value out of 2 but now woth this it will point to first one and will give first value of parent window
	
		String childtWindowId=it.next();    //again iterate to pint to 2nd element
		System.out.println("ChildWindow is :" + childtWindowId);
		
		//switch from parent to child window
		
		driver.switchTo().window(childtWindowId);  //Now control is on child window popup
		System.out.println("Child Window Title is :" + driver.getTitle());
		
		//to close child window
		
		driver.close();    
		
		//Now driver control is lost so we need to switch back to parent window again
		
		driver.switchTo().window(parentWindowId);  
		System.out.println("Parent Window Title is :" + driver.getTitle());
		
		driver.quit();
		
	}

}
