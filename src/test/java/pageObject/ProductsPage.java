package pageObject;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends basePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    // ---------- SEARCH ----------
    @FindBy(xpath = "//input[@id='search_product']")
    private WebElement searchBar;

    @FindBy(xpath = "//i[@class='fa fa-search']")
    private WebElement searchIcon;


    // ---------- WOMEN SECTION ----------
    @FindBy(xpath = "//a[normalize-space()='Women']//i[@class='fa fa-plus']")
    private WebElement womenExpand;

    @FindBy(xpath = "//div[@id='Women']//a[contains(text(),'Dress')]")
    private WebElement womenDress;

    @FindBy(xpath = "//a[normalize-space()='Tops']")
    private WebElement womenTops;

    @FindBy(xpath = "//a[normalize-space()='Saree']")
    private WebElement womenSaree;


    // ---------- MEN SECTION ----------
    @FindBy(xpath = "//a[normalize-space()='Men']//i[@class='fa fa-plus']")
    private WebElement menExpand;

    @FindBy(xpath = "//a[normalize-space()='Tshirts']")
    private WebElement menTshirts;

    @FindBy(xpath = "//a[normalize-space()='Jeans']")
    private WebElement menJeans;


    // ---------- KIDS SECTION ----------
    @FindBy(xpath = "//a[normalize-space()='Kids']//i[@class='fa fa-plus']")
    private WebElement kidsExpand;

    @FindBy(xpath = "//div[@id='Kids']//a[contains(text(),'Dress')]")
    private WebElement kidsDress;

    @FindBy(xpath = "//a[normalize-space()='Tops & Shirts']")
    private WebElement kidsTopsShirts;


    // ---------- BRAND FILTER ----------
    @FindBy(xpath = "//a[@href='/brand_products/Polo']")
    private WebElement brandPolo;

    @FindBy(xpath = "//a[@href='/brand_products/H&M']")
    private WebElement brandHM;

    @FindBy(xpath = "//a[@href='/brand_products/Madame']")
    private WebElement brandMadame;

    @FindBy(xpath = "//a[@href='/brand_products/Mast & Harbour']")
    private WebElement brandMastHarbour;

    @FindBy(xpath = "//a[@href='/brand_products/Babyhug']")
    private WebElement brandBabyhug;

    @FindBy(xpath = "//a[@href='/brand_products/Kookie Kids']")
    private WebElement brandKookieKids;

    @FindBy(xpath = "//a[@href='/brand_products/Biba']")
    private WebElement brandBiba;


    // ---------- RESULT TITLE ----------
    @FindBy(xpath = "//h2[@class='title text-center']")
    private WebElement filterTitle;


    // ---------- PRODUCT CARD ----------
    @FindBy(xpath = "//div[@class='productinfo text-center']//img[@alt='ecommerce website products']")
    private WebElement productImage;

    @FindBy(xpath = "//div[@class='overlay-content']//a[@class='btn btn-default add-to-cart']")
    private WebElement addToCartBtn;

    @FindBy(xpath = "//a[@style='color: brown;']")
    private WebElement viewCartBtn;



    // =========================================================
    //                    ACTION METHODS
    // =========================================================

    // SEARCH
    public void searchProduct(String productName) {
        searchBar.clear();
        searchBar.sendKeys(productName);
        searchIcon.click();
    }


    // WOMEN
    public void openWomenSection() {
        womenExpand.click();
    }

    public void selectWomenDress() {
        womenDress.click();
    }

    public void selectWomenTops() {
        womenTops.click();
    }

    public void selectWomenSaree() {
        womenSaree.click();
    }


    // MEN
    public void openMenSection() {
        menExpand.click();
    }

    public void selectMenTshirts() {
        menTshirts.click();
    }

    public void selectMenJeans() {
        menJeans.click();
    }


    // KIDS
    public void openKidsSection() {
        kidsExpand.click();
    }

    public void selectKidsDress() {
        kidsDress.click();
    }

    public void selectKidsTopsShirts() {
        kidsTopsShirts.click();
    }


    // BRANDS
    public void filterPolo() { brandPolo.click(); }
    public void filterHM() { brandHM.click(); }
    public void filterMadame() { brandMadame.click(); }
    public void filterMastHarbour() { brandMastHarbour.click(); }
    public void filterBabyhug() { brandBabyhug.click(); }
    public void filterKookieKids() { brandKookieKids.click(); }
    public void filterBiba() { brandBiba.click(); }


    // RESULT TITLE
    public String getFilterTitle() {
        return filterTitle.getText();
    }


    // PRODUCT ACTIONS
    public void hoverOnProduct() {
       Actions act = new Actions(driver);
        act.moveToElement(productImage).perform();
    }

    public void addProductToCart() {
        addToCartBtn.click();
    }

    public void viewCart() {
        viewCartBtn.click();
    }
}