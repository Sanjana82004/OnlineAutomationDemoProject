package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartItemComponent {

    WebDriver driver;
    WebElement row;

    public CartItemComponent(WebDriver driver, WebElement row){
        this.driver = driver;
        this.row = row;
    }

    // product name
    public String getName(){
        return row.findElement(By.xpath(".//td[@class='cart_description']//h4/a")).getText();
    }

    // category text
    public String getCategory(){
        return row.findElement(By.xpath(".//td[@class='cart_description']//p")).getText();
    }

    // price
    public String getPrice(){
        return row.findElement(By.xpath(".//td[@class='cart_price']")).getText();
    }

    // quantity
    public String getQuantity(){
        return row.findElement(By.xpath(".//td[@class='cart_quantity']//button")).getText();
    }

    // total
    public String getTotal(){
        return row.findElement(By.xpath(".//td[@class='cart_total']")).getText();
    }

    // delete product
    public void removeItem(){
        row.findElement(By.xpath(".//td[@class='cart_delete']//a")).click();
    }
}