import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;



public class TransactionList extends Object
{
    private Transaction[] Transactions = new Transaction[99];
    int numTrans = 0; // incrementing value to help declare array index for next Transaction added

    public TransactionList() 
    {
        super();
    }
    
    public TransactionList(File file)
    {
        try 
        {
            Scanner in = new Scanner(file);
            
            while(in.hasNextLine())
            {
                int category = in.nextInt();
                String recipient = in.next();
                float amount = in.nextFloat();
                int day = in.nextInt();
                int month = in.nextInt();
                int year = in.nextInt();
                in.nextLine();
                
                Transaction transact1 = new Transaction(category, recipient, amount, day, month, year);
                addTransaction(transact1);
            }
        } catch (FileNotFoundException ex) 
        {
            System.out.println(ex.getMessage());
            System.out.println("in " + System.getProperty("user.dir"));
            System.exit(1);
        }

    }
        
    public void addTransaction(Transaction transact1)
    {
        this.Transactions[numTrans] = transact1;
        numTrans++;
    }
    
    public void addTransaction(int cat, String transrecipient,float transactAmount, int day, int month, int year)
    {
        Transaction transact1 = new Transaction(cat, transrecipient, transactAmount, day, month, year);
        this.Transactions[numTrans] = transact1;
        numTrans++;
        this.writeTransactionstoFile();
    }
    
    public void printMostRecent()
    {
        System.out.println("Transaction number: " + (numTrans-1));
        this.Transactions[numTrans-1].printTransaction();
    }
    
    public void printTransactionNo(int transactionNo)
    {
        System.out.println("Transaction number: " + transactionNo);
        this.Transactions[transactionNo].printTransaction();
    }
    
    public void printAllCategory(int category)
    {
        for(int i=0; i<this.numTrans;i++)
        {
            if(this.Transactions[i].getCategory() ==category)
            {
                this.printTransactionNo(i);
            }
        }
    }
    
   public void printAllTransactions()
   {
       for(int i=0;i<numTrans;i++)
       {
           this.printTransactionNo(i);
       }
   }
    
    public int getLength()
    {
        return this.Transactions.length;
    }
        
    public void swapTransactions(int a, int b)
    {
        Transaction temp = this.Transactions[a];
        this.Transactions[a] = this.Transactions[b];
        this.Transactions[b] = temp;
        writeTransactionstoFile();
    }
            
    private void orderAllTransactionsbyDate()
    {
        int loop = 1;
        while(loop>0)
        {
            loop=0;            
            for(int i = 0; i<numTrans-1; i++)
            {
                if(this.Transactions[i].getDateforOrdering()>this.Transactions[i+1].getDateforOrdering())
                {
                    swapTransactions(i, i+1);
                    loop++;                  
                }       
            }
        }
    }
    
    
    public void printTransactionsBetweenDates(int firstDate, int secondDate)
    {
        float amountSpentBetweenDates =0;
        for(int i=0; i< numTrans ; i++)
        {
            if(this.Transactions[i].getDateforOrdering()>=firstDate && this.Transactions[i].getDateforOrdering()<=secondDate)
            {
                this.printTransactionNo(i);
                amountSpentBetweenDates = amountSpentBetweenDates + this.Transactions[i].getAmount(); 
            }
       }
        
        System.out.println("Total Spent between dates = £" + amountSpentBetweenDates + "\n");
    }
    
    
    public void printTransactionsBetweenDatesToRecipient(int firstDate, int secondDate,String RecipientName)
    {
        float amountSpentBetweenDatesToRecipient = 0;
        for(int i=0; i< numTrans ; i++)
        {
           if(this.Transactions[i].getDateforOrdering()>=firstDate && 
                   this.Transactions[i].getDateforOrdering()<=secondDate && 
                   this.Transactions[i].getRecipient().equals(RecipientName))
           {
               this.printTransactionNo(i);
               amountSpentBetweenDatesToRecipient = amountSpentBetweenDatesToRecipient + this.Transactions[i].getAmount(); 
           }
        
        }
        System.out.println("Total Spent between dates to " + RecipientName + " = £" + amountSpentBetweenDatesToRecipient + "\n");
    }
    
       
    public void writeTransactionstoFile()
    {
        this.orderAllTransactionsbyDate();
        PrintWriter out = null;
        try
        {
            out=new PrintWriter("TransactionDetails.txt");
        } 
        catch(FileNotFoundException ex)
        {
            System.out.println(ex.getMessage());
            System.out.println("in " + System.getProperty("user.dir"));
            System.exit(1);
        } 
        
        int i = 0;
        while(i<numTrans)
        {
            int category = this.Transactions[i].getCategory();
            String recipient = this.Transactions[i].getRecipient();
            float transactAmount = this.Transactions[i].getAmount();
            int day = this.Transactions[i].getDay();
            int month = this.Transactions[i].getMonth();
            int year = this.Transactions[i].getYear();
            
            String record = new String(category +" "+ recipient +" "+ transactAmount +" "+ day +" "+ month +" "+ year);
            out.println(record);
            
            i++;
        }
        
        out.close();
    }
             
}
