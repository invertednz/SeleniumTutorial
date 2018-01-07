package elements.advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by jfarrier on 17/10/2016.
 */
public class Table {
    public static void main(String[] args) {
        /*
        An HTML table is defined with the <table> tag.

        Each table row is defined with the <tr> tag. A table header is defined with the <th> tag. By default, table headings are bold and centered. A table data/cell is defined with the <td> tag.

        For more information check - http://www.w3schools.com/html/html_tables.asp
         */


        //FirefoxDriver webdriver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver webdriver = new ChromeDriver();

        webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webdriver.navigate().to("http://www.w3schools.com/html/tryit.asp?filename=tryhtml_tables2");

        webdriver.switchTo().frame("iframeResult");

        //individual elements in the tables behave similarly to div or other inactive html elements.

        //Get a specific cell.  We could iterate through the table or use a specific xpath.
        WebElement specificCell = webdriver.findElement(By.xpath("//table/tbody/tr[2]/td"));
        System.out.println(specificCell.getText());

        //Get all elements from a table
        //note this will not get the lowest level just the captions and tr's
        System.out.println("all high level table elements");
        List<WebElement> tableElements = webdriver.findElements(By.xpath("//table/*"));
        printElements(tableElements);

        //all table elements
        System.out.println("all table elements");
        List<WebElement> allTableElements = webdriver.findElements(By.xpath("//table//*"));
        printElements(allTableElements);

        //Get all td elements from a table
        System.out.println("all td elements");
        List<WebElement> tdElements = webdriver.findElements(By.xpath("//table//td"));
        //alternatively could use
        tdElements = webdriver.findElements(By.tagName("td"));
        printElements(tdElements);

        //iterate through each cell in the table
        //exercise, change this to include th elements
        WebElement table = webdriver.findElement(By.xpath("//table"));
        //To locate rows of table.
        List<WebElement> tableRows = table.findElements(By.tagName("tr"));
        //To calculate no of rows In table.
        int rowCount = tableRows.size();

        //Loop will execute till the last row of table.
        for (WebElement row:tableRows){
            //To locate columns(cells) of that specific row.
            List<WebElement> columns = row.findElements(By.tagName("td"));
            //To calculate no of columns(cells) In that specific row.
            int columnCount = columns.size();
            System.out.println("Number of cells In Row "+row+" are "+columnCount);

            //Loop will execute till the last cell of that specific row.
            for (WebElement cell:columns){
                //To retrieve text from that specific cell.
                System.out.println(cell.getText());
            }
        }

        //exercise, check to see if a table has a matching element/value in the table
        //print the row where month is january.

        webdriver.quit();
    }


    public static void printElements(List<WebElement> elements){
        for(WebElement element: elements){
            System.out.println(element.getTagName() + " " + element.getText());
        }
    }

    //data that matches criteria
    //is data sorted

}
