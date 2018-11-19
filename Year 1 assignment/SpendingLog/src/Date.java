
public class Date 
{
    private int day = 1;
    private int month=1;
    private int year=2018;
    
    public Date(int dD, int mM, int yYYY)
    {
        day = dD;
        month = mM;
        year = yYYY;
    }

    public void setDay(int day) 
    {
        this.day = day;
    }

    public int getDay() 
    {
        return day;
    }

    public void setMonth(int month) 
    {
        this.month = month;
    }
    
    public int getMonth() 
    {
        return month;
    }

    public void setYear(int year) 
    {
        this.year = year;
    }
    
    public int getYear() 
    {
        return year;
    }
    
    public int getDate()
    {
        int addDates = (year*10000)+(month*100)+day;
        return addDates;
    }
}
