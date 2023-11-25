import java.io.*;   // Import the FileWriter class

import java.util.Scanner;

public class WriteToFile {
  public static void main(String[] args) {
    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    int number_nodes = myObj.nextInt();  // Record number of nodes
    int number_of_input = number_nodes + 4;
    int x = 0;
    
    while (x <= number_of_input){
         String userName = myObj.nextLine();  // Read user input
         System.out.println(x);
         x ++;
    } 

  }
}