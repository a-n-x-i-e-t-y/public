package Assessment;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author alexg
 */
public class RockPaperScissors {
    public static void main(String[] args)
    {   
        //useful objects we will use throughout 
        Random rng = new Random();
        Scanner scan = new Scanner(System.in);      
        
        boolean playagain = true;//to see if person wants to play again
        
      while(playagain) 
      {    
          
        System.out.println("How many times would you like to play?");
        int play = Integer.parseInt(scan.nextLine());
        
        while (play>10 || play<1)//I know the instructions said to quite but this seems more elegant
           {
            System.out.println("Sorry you can only play between 1 and 10 times please try again: ");
            play = Integer.parseInt(scan.nextLine());
           }
        
        
        
               int compwins=0;//variables we'll use later
               int playerwins=0;
               int ties=0;
        //games beging
        for(int x =0; x<play; x++)
        {
            System.out.println("Please insert your battle option. ");
            System.out.println("1=Rock, 2=Paper 3=Scissors: ");
            int choice = Integer.parseInt(scan.nextLine());//player choice
            
            if(choice != 1 && choice != 2 && choice != 3)//player management
            {
                System.out.println("You have not chosen one of the options, this round is a dud. ");
                continue;
            }
            
            int compchoice = (rng.nextInt(3)+1);//computer choice
            
            
            if(choice==compchoice)//if it's a tie
            {
             System.out.println("Looks like this one is a tie");
             System.out.println("You both chose: "+choice);
             ties++;
             System.out.println("--------------------------------"); 
             continue;
            }
            
            
            
            
            if (choice==1)//dealing with all cases
            {
                if(compchoice==2)
                {
                  System.out.println("Looks like the computer won here");
                  compwins++;
                }
                else
                {
                  System.out.println("Looks like you won here");
                  playerwins++;
                }
            }    
                
                
                
                
            if (choice==2)//dealing with all cases
            {
                if(compchoice==3)
                {
                  System.out.println("Looks like the computer won here");
                  compwins++;
                }
                else
                {
                  System.out.println("Looks like you won here");
                  playerwins++;
                }
            }
                
            
            if (choice==3)//dealing with all cases
            {
                if(compchoice==1)
                {
                  System.out.println("Looks like the computer won here");
                  compwins++;
                }
                else
                {
                  System.out.println("Looks like you won here");
                  playerwins++;
                }     
            }    
            
            //summary of the round
            System.out.println("You chose "+choice+" and the computer chose "+compchoice);   
            System.out.println("--------------------------------"); 
                
        
        }
        //shows winnings
        System.out.println("----------------");
        System.out.println("You won "+playerwins+" times");
        System.out.println("The computer won "+compwins+" times");
        System.out.println("You tied "+ties+" times");
        
        //shows winner
        if(playerwins==compwins)
        {
           System.out.println("There are no winners, it's a tie"); 
        }
        
        if(playerwins>compwins)
        {
           System.out.println("Congratulations you won"); 
        }
        if(playerwins<compwins)
        {
          System.out.println("Unfortunately the computer won");   
        }
        
        System.out.println("---------------");
        System.out.println("Would you like to play again?");
        System.out.println("If yes press 1, if no press 2:");
        int nrchoice = Integer.parseInt(scan.nextLine());
        
        if(nrchoice==1)
        {
           playagain= true;  
        }
        
        else
        {
          playagain=false;  
            
        }    
                    
      }   
      
      
        System.out.println("Thanks for playing!");
        System.exit(0);
       
        
        
        
        
        
        
        
    }
    
}
