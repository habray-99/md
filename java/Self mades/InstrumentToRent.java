public class InstrumentToRent extends Instrument {
    
    private int chargePerDay;    
    
    private String dateOfRent;
    
    private String dateOfReturn;
    
    private int noOfDays;
    
    private boolean isRented;

    //constructor
    public  InstrumentToRent(String instrumentName,int chargePerDay) {
        super(instrumentName);
        this.chargePerDay=0;
        this.dateOfRent="";
        this.dateOfReturn="";
        this.noOfDays=0;
        this.isRented = false;
    }

    // setter for the variables{
    public void setChargePerDay(){
        this.chargePerDay = chargePerDay;
    }

    public void setDateOfRent() {
        this.dateOfRent = dateOfRent;
    }

    public void setDateOfReturn(){
        this.dateOfReturn = dateOfReturn;
    }

    public void setNoOfDays(){
        this.noOfDays = noOfDays;
    }

    public void SetIsRented(){
    this.isRented = isRented;
    }

    // getter methods
    public double getChargePerDay(){
        return chargePerDay;
    }
    
    public String getDateOfReturn(){
        return dateOfReturn;
    }
    
    public String getDateOfRent(){
        return dateOfRent;
    }
    
    public int getNoOfDays(){
        return noOfDays;
    }
    
    public boolean getIsRented(){
        return isRented;
    }
    
    
    public void rentedInstrument(String customerName,String customerMobileNumber,int customerPAN,String dateOfRent,String dateOfReturn,int noOfDays){
        if (isRented == true){
            System.out.println("The instrument is currently being rented");
            System.out.println("Customer Name : "+super.getCustomerName());
            System.out.println("Mobile Number of : : " + super.getCustomerPAN());
            System.out.println("Date of Return : " + getDateOfReturn());
        } else {
            super.setCustomerName(customerName);
            super.setCustomerMobileNumber(customerMobileNumber);
            super.setCustomerPAN(customerPAN);
            this.dateOfRent = dateOfRent;
            this.dateOfReturn = dateOfReturn;
            this.noOfDays = noOfDays;
            this.isRented = true;
            System.out.println("The Customer info has been recorded and changed the value of rented to true");
            System.out.println("Customer Name : " + super.getCustomerName());
            System.out.println("Customer Moblie Number : " + super.getCustomerMobileNumber());
            System.out.println("Customer PAN No. : " + super.getCustomerPAN());
            System.out.println("Date of Rent : "+ getDateOfRent());
            System.out.println("Date of Retuen : " + getDateOfReturn());
            System.out.println("Total Charge : Rs." + (this.chargePerDay*getNoOfDays()));
        }
    }
    
    // display method
    public void display(){
        System.out.println("The Instrument is Rented");
        super.display();
        if (this.isRented == true){
            System.out.println("Date Of Rent : " + this.dateOfRent);
            System.out.println("Date Of Return : " + this.dateOfReturn);
        }
    }
}
