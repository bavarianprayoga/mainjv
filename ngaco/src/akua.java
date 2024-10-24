import java.util.*;  
public class akua {  
  public static void main(String args[]) {  

    //Create an empty Vector        
    Vector<Integer> vec = new Vector<>(); 
    
    //Add elements in the vector  
    vec.add(100);  
    vec.add(200);  
    vec.add(300);  
    vec.add(200);  
    vec.add(400);  
    vec.add(500);  
    vec.add(600);  
    vec.add(700);  

    //Display the vector elements  
    System.out.println("Values in vector: " +vec);  

    //use remove() method to delete the first occurence of an element  
    System.out.println("Remove first occurence of element 200: "+vec.remove((Integer)200));  
    
    //Display the vector elements after remove() method  
    System.out.println("Values in vector: " +vec);  
    
    //Remove the element at index 4  
    System.out.println("Remove element at index 4: " +vec.remove(4));  
    System.out.println("New Value list in vector: " +vec);  
    
    //Remove an element  
    vec.removeElementAt(5);        
    
    //Checking vector and displays the element  
    System.out.println("Vector element after removal: " +vec);  
    
    //Get the hashcode for this vector  
    System.out.println("Hash code of this vector: "+vec.hashCode());  
    
    //Get the element at specified index  
    System.out.println("Element at index 1 is: "+vec.get(1));  
      }  
}  