/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assessment;

/**
 *
 * @author alexg
 */
public class SummativeSums {
    public static void main(String[] args)
    {
        
        //I added a bit more to the print to make it clear which array we are working on
        System.out.println("The results from the following array { 1, 90, -33, -55, 67, -16, 28, -55, 15 }: ");
        int [] a1 = { 1, 90, -33, -55, 67, -16, 28, -55, 15 };//initilize array
        int result1 = addints(a1);//call and use method
        System.out.println("#1 Array Sum: "+result1);//print result
        
        System.out.println("The results from the following array { 999, -60, -77, 14, 160, 301 }: ");
        int [] a2 = { 999, -60, -77, 14, 160, 301 };//initilize array
        int result2 = addints(a2);//call and use method
        System.out.println("#2 Array Sum: "+result2);//print result
        
        System.out.println("The results from the following array { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130,140, 150, 160, 170, 180, 190, 200, -99 }: ");
        int [] a3 = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130,140, 150, 160, 170, 180, 190, 200, -99 } ;//initilize array
        int result3 = addints(a3);//call and use method
        System.out.println("#3 Array Sum: "+result3);//print result
        
      
        
       
    
    
    
    
    
    
    }        
            
    public static int addints(int[] x)
    {
        
      int sum = 0; 
      for (int i=0; i<x.length;i++)
      {
        sum = sum + x[i];  
          
      }
        
      return sum;  
        
        
    }
            
            
            
            
            
            
            
            
}
