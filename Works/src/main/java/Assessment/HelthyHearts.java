package Assessment;
import java.util.Random;
import java.util.Scanner;


/**
 *
 * @author alexg
 */
public class HelthyHearts {
    
    public static void main(String[] args)
{
    
    Random rng = new Random();
    Scanner scan = new Scanner(System.in);
    //double play = Integer.parseInt(scan.nextLine());
    System.out.println("Please insert your age?");
    //double age = Double.parseDouble (scan.nextLine());
    int age = Integer.parseInt(scan.nextLine());
    int maximum = 220 - age;//calcualte maximum heartrate
    
    double low = maximum*0.5;//calcualte target low and high
    double high = maximum*0.85;
    
    int lowint = (int)low;//change to int to look pretty
    int highint = (int)high;//yes you do lose some decimals but oh well
    
    System.out.println("Your maximum heartrate should be "+maximum+" beats per minute");
    System.out.println("Your target HR zone is "+lowint+" - "+highint+" beats per minute");
    
    
    
    
    
    
    

}
    
    
    
    
    
    
    
    
    
    
    
    
}
