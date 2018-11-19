
public class Transaction 
{    
    private int category = 0;
    private String categoryString = new String();
    private String recipient = new String();
    private float amount = 0;
    private int day = 1;
    private int month = 1;
    private int year = 2018;
    private Date transactDate = new Date(day, month, year);   
    private int dateforOrdering = 20180101;
  
            
    public Transaction(int cat, String transrecipient,float transactAmount, int day, int month, int year)
    {
        category = cat;
        recipient = transrecipient;
        amount = transactAmount;
        transactDate.setDay(day);
        transactDate.setMonth(month);
        transactDate.setYear(year); 
        dateforOrdering = (year*10000)+(month*100)+day;
        
        switch(category)
        {
            case 1:
                categoryString = "Rent";
                break;
            case 2:
                categoryString= "Electricity";
                break;
            case 3:
                categoryString= "ISP";
                break;
            case 4:
                categoryString= "Gas";
                break;
            case 5:
                categoryString= "Mobile Phone";
                break;
            case 6:
                categoryString= "Groceries";
                break;
            case 7:
                categoryString= "Entertainment";
                break;
            case 8: 
                categoryString= "Eating Out";
                break;
            case 9:
                categoryString= "Public Transport";
                break;
            case 10:
                categoryString= "Car";
                break;
            default:
                categoryString= "Invalid Category";
                break;
        }  
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
    
    public int getCategory() {
        return category;
    }

    public String getCategoryName() {
        return categoryString;
    }   

    public void setCategory(int category) {
        this.category = category;
        
        switch(category)
        {
            case 1:
                categoryString = "Rent";
                break;
            case 2:
                categoryString= "Electricity";
                break;
            case 3:
                categoryString= "ISP";
                break;
            case 4:
                categoryString= "Gas";
                break;
            case 5:
                categoryString= "Mobile Phone";
                break;
            case 6:
                categoryString= "Groceries";
                break;
            case 7:
                categoryString= "Entertainment";
                break;
            case 8: 
                categoryString= "Eating Out";
                break;
            case 9:
                categoryString= "Public Transport";
                break;
            case 10:
                categoryString= "Car";
                break;
            default:
                categoryString= "Invalid Category";
                break;
        } 
    }
    
    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
    
    public void setDate(int day, int month, int year)
    {
        this.transactDate.setDay(day);
        this.transactDate.setMonth(month);
        this.transactDate.setYear(year);
    }
    
    public int getDay()
    {
        return this.transactDate.getDay();
    }
    
    public int getMonth()
    {
        return this.transactDate.getMonth();
    }
    
    public int getYear()
    {
        return this.transactDate.getYear();
    }

    public String getDate()
    {
        return this.getDay() + "/"+ this.getMonth()+"/"+this.getYear();
    }
    
    public void printTransaction()
    {
        System.out.println("Category: "+ getCategory()+"-"+getCategoryName()+ "\nAmount: £" + getAmount()+ "\nRecipient: " + getRecipient() + "\nDate: " + getDate() +"\n");
    }

    public int getDateforOrdering()
    {
        return dateforOrdering;
    }
    
}
