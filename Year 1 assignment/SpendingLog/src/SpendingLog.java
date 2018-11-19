import java.util.Scanner;
import java.io.File;


public class SpendingLog 
{

    public static void main(String[] args) 
    {
        //Initializing program with saved details from the text file.
        File TransactionDetails = new File("TransactionDetails.txt");
        
        TransactionList Transactions = new TransactionList(TransactionDetails);

        //Display text for console interfacing
        Scanner userIn = new Scanner(System.in);
        boolean isLooping = true;  //A loop to return user to console interface when action completes
        while(isLooping == true)
        {
            //User selects action from list using number.
            System.out.println("Please enter number of the option you would like: \n"
                    + "1 - Add a Transaction.\n"
                    + "2 - View Last Transaction.\n"
                    + "3 - View All Transactions.\n"
                    + "4 - View All Transactions of a Category.\n"
                    + "5 - View Transactions and amount spent between two dates.\n"
                    + "6 - View Transactions to specified recipient between two dates.\n"
                    + "0 - Exit the Program");
            int userInput1 = userIn.nextInt();
            
            //switch statement used to identify number input and perform action
            switch(userInput1)
            {
                case 1:                    
                    
                    //Entering a new Transaction.
                    System.out.println("\nTo enter a New Transaction, please choose a category.\n"
                            + "1 – Rent\n"
                            + "2 – Electricity\n"
                            + "3 – ISP\n"
                            + "4 – GAS\n"
                            + "5 – Mobile Phone\n"
                            + "6 – Groceries\n"
                            + "7 – Entertainment\n"
                            + "8 – Eating Out\n"
                            + "9 – Public Transport\n"
                            + "10 – Car");
                    int category = userIn.nextInt();
                    System.out.println("Now enter the Recipient.");
                    String recipient = userIn.next();
                    System.out.println("Now enter the amount");
                    float amount = userIn.nextFloat();
                    System.out.println("Now enter the date using the format DD MM YYYY");
                    int day = userIn.nextInt();
                    int month = userIn.nextInt();
                    int year = userIn.nextInt(); 
                    System.out.println("Category: " + category + 
                            "\nRecipient: " + recipient + 
                            "\nAmount: " + amount + 
                            "\nDate: " + day +"/"+month+"/"+year + 
                            "\nIs this Correct?"
                            + "\n1 - Yes"
                            + "\n2 - No");
                    
                    //User sees details entered and can verify or cancel.
                    int userInputVerifyTransactAdd = userIn.nextInt();
                    switch(userInputVerifyTransactAdd)
                    {
                        case 1: 
                            Transactions.addTransaction(category, recipient, amount, day, month, year);
                            System.out.println("Transaction Added");
                            break;
                        case 2:
                        default:                            
                            System.out.println("Please try again.");
                            break;
                    }
                    break;
                    
                case 2:
                    
                    //Runs and prints the transaction with the latest
                    System.out.println();
                    Transactions.printMostRecent();
                    break;
                    
                case 3:
                    
                    //Prints all transactions stored
                    System.out.println();
                    Transactions.printAllTransactions();
                    break;
                    
                case 4:
                    
                    //User can input a category to see all transactions stored with that category.
                    System.out.println("\nPlease enter the Category you would like to view\n"
                            + "1 – Rent\n"
                            + "2 – Electricity\n"
                            + "3 – ISP\n"
                            + "4 – GAS\n"
                            + "5 – Mobile Phone\n"
                            + "6 – Groceries\n"
                            + "7 – Entertainment\n"
                            + "8 – Eating Out\n"
                            + "9 – Public Transport\n"
                            + "10 – Car");
                    int userinput2 = userIn.nextInt();
                    System.out.println();
                    Transactions.printAllCategory(userinput2);
                    break;
                    
                case 5:
                    
                    //User inputs two dates to view all transactions on or between those dates
                    System.out.println("\nPlease enter the first date in DD MM YYYY format.");
                    int day1 = userIn.nextInt();
                    int month1 = userIn.nextInt();
                    int year1 = userIn.nextInt(); 
                    int date1 = (year1*10000)+(month1*100)+day1;
                    
                    System.out.println("Please enter the second date in DD MM YYYY format.");
                    int day2 = userIn.nextInt();
                    int month2 = userIn.nextInt();
                    int year2 = userIn.nextInt(); 
                    int date2 = (year2*10000)+(month2*100)+day2;
                    if(date2>=date1)
                    {
                        System.out.println();
                        Transactions.printTransactionsBetweenDates(date1, date2);
                    }
                    else if(date1>date2)
                    {
                        System.out.println();
                        Transactions.printTransactionsBetweenDates(date2, date1);
                    }
                    else
                    {
                        System.out.println("incorrect format. Try again.)");
                    }
                    break;
                    
                case 6:
                    
                    //User inputs Recipient and two dates to view all Transactions to that recipient between two dates.
                    System.out.println("\nEnter Recipient's name accurately");
                    String recipientName = userIn.next();
                    System.out.println("Please enter the first date in DD MM YYYY format.");
                    int cday1 = userIn.nextInt();
                    int cmonth1 = userIn.nextInt();
                    int cyear1 = userIn.nextInt(); 
                    int cdate1 = (cyear1*10000)+(cmonth1*100)+cday1;
                    
                    System.out.println("Please enter the second date in DD MM YYYY format.");
                    int cday2 = userIn.nextInt();
                    int cmonth2 = userIn.nextInt();
                    int cyear2 = userIn.nextInt(); 
                    int cdate2 = (cyear2*10000)+(cmonth2*100)+cday2;
                    if(cdate2>=cdate1)
                    {
                        System.out.println();
                        Transactions.printTransactionsBetweenDatesToRecipient(cdate1, cdate2,recipientName);
                    }
                    else if(cdate1>cdate2)
                    {
                        System.out.println();
                        Transactions.printTransactionsBetweenDatesToRecipient(cdate2, cdate1, recipientName);
                    }
                    else
                    {
                        System.out.println("incorrect format. Try again.)");
                    }
                    break;
                    
                case 0:
                    
                    //Sets loop value to false, ending the Console interface loop and allowing the program to finish execution.
                    isLooping = false;
                    break;
                    
                default:
                    
                    //if wrong details are entered, program loops back to start of Console Interface.
                    System.out.println("\nInvalid Option");
                    break;                    
            }
            
        }


    }
    
}
