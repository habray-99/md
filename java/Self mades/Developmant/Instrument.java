public class Instrument
{

    private static int instrumentID;

    private String instrumentName;

    private String customerName;

    private String customerMobileNumber;

    private int customerPAN;   

    //setter for the variables
    public static void setInstrumentID(int instrumentID) {
        Instrument.instrumentID = instrumentID;
    }

    public void setInstrumentName(String instrumentName) {
        this.instrumentName = instrumentName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerMobileNumber(String customerMobileNumber) {
        this.customerMobileNumber = customerMobileNumber;
    }

    public void setCustomerPAN(int customerPAN) {
        this.customerPAN = customerPAN;
    }

    // getter for variables
    public static int getInstrumentID() {
        return instrumentID;
    }
    
    public String getInstrumentName() {
        return instrumentName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerMobileNumber() {
        return customerMobileNumber;
    }

    public int getCustomerPAN() {
        return customerPAN;
    }

    // for auto-incrementing
    public void autoIncremant() {
        instrumentID++;
    }
    
    //this is for printing the instrument id and name then display name, mobileNumber and customer PAN
    public void display() {
        System.out.println("Instrument ID : " + instrumentID);
        System.out.println("Instrument Name : "+ instrumentName);
        if ((!this.customerName.equals(""))&&(!this.customerMobileNumber.equals(""))&&(this.customerPAN!=0)){
            System.out.println("Customer Name : " + customerName);
            System.out.println("Customer Mobile Number : " + customerMobileNumber);
            System.out.println("Customer PAN : " + customerPAN);
        } else {}
    }
}