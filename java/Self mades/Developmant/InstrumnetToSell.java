public class InstumentToSell extends Instrument
{

    private double price;
    
    private double discountPercent;
    
    private String sellDate;
    
    private boolean isSold;

    public instrumentToSell(String instrumentName,double price){
        super.getInstrumentName(StringinstrumentName);
        this.price="";
        this.discountPercent=0;
        this.sellDate="";
        this.isSold="";
    
    
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

    //setter for variables
    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public void setSellDate(String sellDate) {
        this.sellDate = sellDate;
    }

    //this does two things at once that is to check if the instrument is already sold or if not then assign the value
    public void setSold(boolean isSold) {
        if (isSold == true){
            System.out.println("The instrument is already sold!");
        } else{
        this.isSold = isSold;
        }
    }

    }

}