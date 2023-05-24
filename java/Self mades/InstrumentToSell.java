public class InstrumentToSell extends Instrument
{

    private double price;
    
    private double discountPercent;
    
    private String sellDate;
    
    private boolean isSold;

    //constructor
    public InstrumentToSell(String instrumentName,double price){
        super(instrumentName);
        this.price=0;
        this.discountPercent=0;
        this.sellDate="";
        this.isSold=false;
    }
    
    // getter for variables
    public double getPrice() {
        return price;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public String getSellDate() {
        return sellDate;
    }

    public boolean getIsSold(){
        return isSold;
    }

    //setter for variables of price and checks if the instrument is sold out already or not 
    public void setPrice(double price) {
        if (isSold == true){
            System.out.println("The instrument is already sold!");
        } else{
        this.price = price;
        }
    }
    //setter for variables
    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public void setSellDate(String sellDate) {
        this.sellDate = sellDate;
    }

    //this does two things at once that is to check if the instrument is already sold or if not then assign the value
    public void setSold(boolean isSold) {
       this.isSold = isSold;
    }

    // for selling the instrument
    public void instrumentToSell(String customerName, String customerMobileNumber, int customerPAN, String sellDate, double discountPercent){
        if (this.isSold == true){
           System.out.println("The Instrument has been sold!");
           System.out.println("Customer Name : " + super.getCustomerName());
           System.out.println("Customer Phone Number : " + super.getCustomerMobileNumber());
           System.out.println("Customer PAN No. : " + super.getCustomerPAN());
        } else{
            super.setCustomerName(customerName);
            super.setCustomerMobileNumber(customerMobileNumber);
            super.setCustomerPAN(customerPAN);
            this.sellDate = sellDate;
            this.discountPercent = discountPercent;
            this.isSold = true;
            this.price = this.price-((discountPercent/100)*this.price);
        }
    }

    //display method 
    public void display(){
        super.display();
        System.out.println("Instrument Price : Rs." + this.price);
        if (this.isSold == true){
            System.out.println("Sold Date : " + this.sellDate);
        }
    }

}