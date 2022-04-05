package Assessment;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
/**
 *
 * @author alexg
 */
public class StateCapitals2 {
    
    public static void main(String[] args) throws Exception
{
    Random rng = new Random();//random number generator
    HashMap<String,String> States = new HashMap<>();//make the hashmap
    
    Scanner scan = new Scanner(System.in);//to read from user        
    Scanner sc = new Scanner(new BufferedReader(new FileReader("StateCapitals.txt")));//to read from file
     

    
    // go through the file line by line and add states/capitals to hashmap
    while (sc.hasNextLine()) 
    {
    //System.out.println("--------------------");    these are just to see how things work to test the code
    String currentLine = sc.nextLine();
    String [] storestate = currentLine.split("::");//split around the :: symbols
    //System.out.println(storestate[0]);
    //System.out.println(storestate[1]);
    
    States.put(storestate[0], storestate[1]);
    
    //System.out.println(currentLine);
    
    }
    
    System.out.println("The "+States.size()+" States and Capitals are loaded");//tell the user things are done
    System.out.println("------------------------------------------------------");
    System.out.println("The states are:");
    
    ArrayList<String> stategame = new ArrayList<String>();
    Set<String> keys = States.keySet();//go through the keys
    for (String s : keys )
    {
    stategame.add(s);
    System.out.println(s);
    }
    
    int choice = rng.nextInt(49);//random capital between 0 and 49
    System.out.println("alright user, what's the capital of "+stategame.get(choice));//play the game by asking a random state capital
    String imput = scan.nextLine();
    
    if (imput.equalsIgnoreCase(States.get(stategame.get(choice))))
            
            {
               System.out.println("Congratulations, you got it right!");//win 
            }
           
    else {System.out.println("Nope, you failed!");}//lose
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
    
    
    
    
}
