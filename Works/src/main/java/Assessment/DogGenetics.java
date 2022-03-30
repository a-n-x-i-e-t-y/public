package Assessment;
import java.util.Random;
import java.util.Scanner;



/**
 *
 * @author alexg
 */
public class DogGenetics {
    public static void main(String[] args)
    {
        Random rng = new Random();
        Scanner scan = new Scanner(System.in);
        
        System.out.println("What is your dog's name?: ");
        String name = scan.nextLine();
        //String name = "Reiley"; hardcoded for faster testing
        System.out.println("Well, I have this highly reliable report on "+ name+"'s prestigious background right here.");
        System.out.println("");
        System.out.println(name+" is:");
        System.out.println("");
        
        int[] breed= new int[5];
        
        breed [0] = rng.nextInt(100)+1;
        int percentage = 0;
        
        
        for(int x=0;x<5;x++)
       {
        //the last one's value  
        if (x==4)
        {
          breed[4]=100-percentage;
          break;
        }
           
        percentage = percentage + breed[x];
        
        //if we get to 100% we break    
        if(percentage==100)
        {
          break;  
        }
      
        
        
        breed[x+1] = rng.nextInt(100-percentage)+1;//find the rng of the next breed
        
                
      }
      
     String [] dogname = { "Rottweiler", "Saint Bernard", "German Shepard", "Labrador", "Bloodhound" } ;  
     int ishundred =0;   
     for (int i=0; i<5; i++) 
    {
        ishundred = ishundred + breed[i];
    
         
         System.out.println(breed[i]+"% "+dogname[i]);

     
    } 
     
    //to test if we got to 100 
    /*
    if (ishundred==100)
    {
        System.out.println("Success everything worked properly");
    }
    */
    System.out.println("");
    System.out.println("Wow, that's quite a dog!");
        
        
        
        
        
    }
    
}
