
public class Finance
{
  int balance;
  Date deadline;
  Student account;
  Tutor tutor;
  String deliquency;
  
  Date setDeadline(Date d)  //returns the due date for payment
  {
   int tempM = d.month;
   int tempD = d.day;
   tempD = tempD + 30;
   int tempY = d.year;
   switch(tempM) //calculates due date based on month
   {
     case 1: //Jan
     if(tempD > 31)
     {
       tempD = tempD - 31;
       tempM++;
     }
     break;
     
     case 2: //Feb
     if(tempY%4 == 0) //Leap Year
     {
     if(tempD > 29)
     {
       tempD = tempD - 29;
       tempM++;
     }
     }
     else //No Leap year
     {
     if(tempD > 28)
     {
       tempD = tempD - 28;
       tempM++;
     }
     }
     break;
     
     case 3: //Mar
     if(tempD > 31)
     {
       tempD = tempD - 31;
       tempM++;
     }
     break;
     
     case 4: //Apr
     if(tempD > 30)
     {
       tempD = tempD - 30;
       tempM++;
     }
     break;
     
     case 5: //May
     if(tempD > 31)
     {
       tempD = tempD - 31;
       tempM++;
     }
     break;
     
     case 6: //Jun
     if(tempD > 30)
     {
       tempD = tempD - 30;
       tempM++;
     }
     break;
     
     case 7: //Jul
     if(tempD > 31)
     {
       tempD = tempD - 31;
       tempM++;
     }
     break;
     
     case 8: //Aug
     if(tempD > 31)
     {
       tempD = tempD - 31;
       tempM++;
     }
     break;
     
     case 9: //Se[
     if(tempD > 30)
     {
       tempD = tempD - 30;
       tempM++;
     }
     break;
     
     case 10: //Oct
     if(tempD > 31)
     {
       tempD = tempD - 31;
       tempM++;
     }
     break;
     
     case 11: //Nov
     if(tempD > 30)
     {
       tempD = tempD - 30;
       tempM++;
     }
     break;
     
     default: //Dec
     if(tempD > 31)
     {
       tempD = tempD - 31;
       tempM = 1;
       tempY ++;
     }
     break;
   }
   deadline.year = tempY;
   deadline.month = tempM;
   deadline.day = tempD;
   return deadline;
  }
  
  void chargeAccount(int b, Student a) //adds balance to students due balance
  {
    a.balance = a.balance + b;
  }
  
  String checkDeliquent(Student a)  //returns the deliquent status of an account
  {
    return a.deliquentStatus;
  }
  
  void setPaymentReciever(Tutor t) //sets tutor
  {
    tutor = t;
  }
  
  void setBalance(int b, Student a)  //sets balance and account
  {
    balance = b;
    account = a;
  }
}