package ThucHanh;

public class locator {
    //login
    public static String url= "https://crm.anhtester.com/admin/clients";
    public static String userName="admin@example.com";
    public static String pass="123456";
    public static String btnLogin="//button[contains(text(),'Login')]";


    //Customer
    public static String menuCustomer= "//a/span[contains(text(),'Customers')]";
    public static String labelHeader= "//span[contains(text(),'Customers Summary')]";
    public static String btnAddNew= "//a[contains(@class,'btn btn-primary mright5 test pull-left display-block')]";
    public static String txtCompany= "//input[@name='company']";
    public static String txtVat= "//input[@name='vat']";
    public static String txtPhone= "//input[@name='phonenumber']";
    public static String txtWebsite= "//input[@name='website']";
    public static String drpGroup= "//button[@aria-owns='bs-select-1']";
    public static String searchGroup="//button[@aria-owns='bs-select-1']/following-sibling::div//input";
    public static String itemGroup= "//button[@aria-owns='bs-select-1']/following-sibling::div//span[contains(text(),'VIP')]";
    public static String drpCurrency= "//button[@aria-owns='bs-select-2']";
    public static String itemCurrency= "//button[@aria-owns='bs-select-2']/following-sibling::div//span[contains(text(),'USD')]";
    public static String drpLanguage= "//button[@aria-owns='bs-select-3']";
    public static String itemLanguage= "//button[@aria-owns='bs-select-3']/following-sibling::div//span[contains(text(),'English')]";
    public static String ariaAddress= "//textarea[@name='address']";
    public static String txtCity= "//input[@name='city']";
    public static String txtState= "//input[@name='state']";
    public static String txtZip= "//input[@name='zip']";
    public static String drpCountry= "//button[@aria-owns='bs-select-4']";
    public static String itemCountry= "//button[@aria-owns='bs-select-4']/following-sibling::div//span[contains(text(),'Angola')]";
    public static String btnSave= "//button[@group='submit']";
    public static String lalCheck="//a[contains(text(),'Customer Details')]";

}
