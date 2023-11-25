import java.io.*;
import java.util.*;

public class SimulatorOne{
    static Graph g = new Graph( );
    static int Creach = 0;// is for the shop to the destination
    static int number_nodes = 0;
    static int number_shops = 0;
    static int number_clients = 0;
    static int nuber_of_edges = 0;
     
    static String temp_minimum = "";
    static String temp_Cost = "";
    static String temp_path = "";
    static String temp_shop = "";
    static ArrayList<String> shopNodePosition = new ArrayList<String>();
    static ArrayList<String> clientNodePosition = new ArrayList<String>();
    static ArrayList<String> costs_taxi_to_client = new ArrayList<String>();
    static ArrayList<String> costs_client_to_shop = new ArrayList<String>();
    static ArrayList<String> costs_client_to_shop2 = new ArrayList<String>();
    public static void main( String [ ] args ) 
    {
     
     
     int number_of_input = 0;
     int line_type = 0;
     
       	
            //FileReader fin = new FileReader(args[0]);
        	   
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            int number_nodes = myObj.nextInt();  // Record number of nodes
            number_of_input = number_nodes + 4;
            line_type++;
            int counter = 0;
            

            // Read the edges and insert
            String line;
            while( counter <= number_of_input)
            {
                line = myObj.nextLine();
                String tempArr[] = line.split(" ");
                
                // records the number of nodes in the graph
                /*if (line_type == 0){
                 
                 try{
                       number_nodes  = Integer.parseInt(tempArr[0]);
                       line_type++;
                       //System.out.println(number_nodes); 
                       
                         }
                    catch (NumberFormatException ex){
                       ex.printStackTrace();
                         }
                }*/
                // end of if
                
                
               // Adds the all the edges into a the graph
               if (line_type > 1  && line_type < number_nodes + 2  )
               {
                     int y = 1;// dest node of an edge
                     int z = 2;// is the cost of an edge
                     int skip = 0;
                   if (tempArr.length >= 3){
                     for ( int x = 0 ; x < tempArr.length ; x++){
                           if ( z < tempArr.length  ){
                              String source  = tempArr[0];
                              String dest    = tempArr[y];
                              int    cost    = Integer.parseInt( tempArr[z] );
                              g.addEdge( source, dest, cost );
                              nuber_of_edges++;
                              

                           
                           
                           /*System.out.print(tempArr[0]+ " ");
                           System.out.print(tempArr[y] + " ");
                           System.out.print(tempArr[z] + " ");
                           System.out.println();*/
                           
                           
                              y = z + 1;
                              z = z + 2;
                           
                           
                           }
                           
                          
               
                     }
                  }
                  else{
                        
                        g.addEdge( tempArr[0], tempArr[0], 1 );
                  }
                     
                     
               
               } 
               
               // gets and stores number of shops
               if (line_type == number_nodes + 2){
                  number_shops = Integer.parseInt( line);
                  //System.out.println(number_shops);
               
               }
               // adds and records the position of shops
               if (line_type == number_nodes + 3){
                     for(int k = 0 ; k < number_shops; k++){
                        shopNodePosition.add( tempArr[k]);
                        
                        
                     }
               }
               
               
               // gets and stores number of clients
               
               if (line_type == number_nodes + 4 ){
                  number_clients = Integer.parseInt( line);
                  //System.out.println(number_clients);
               
               }
               
               
               // adds and records the position of clients
               if (line_type == number_nodes + 5){
                     for(int w = 0 ; w < number_clients; w++){
                        
                        clientNodePosition.add( tempArr[w]);
                         
                        
                     }
               }
               
               if (line_type == number_nodes + 5){
                     // for every clients stored
                       for (int f = 0; f < clientNodePosition.size() ; f++){
                        
                         client_to_shop_path(clientNodePosition.get(f));
                        
                          taxi_to_client_path(clientNodePosition.get(f));
                        //Collections.sort(costs_client_to_shop);
                        //System.out.println(costs_taxi_to_client);
                          print_to_client(clientNodePosition.get(f));
                          print_to_shop(clientNodePosition.get(f));
                        //System.out.println(costs_client_to_shop);
                        //System.out.println(costs_client_to_shop2);
                        
                       }
                     
               }
                                    
               line_type ++;
               counter++;
                
            }
  }
    
   
   //adds path details from taxi to client
  public static void taxi_to_client_path(String client){
     costs_taxi_to_client.clear();
     for (int r = 0; r < number_shops; r++){
           g.reachable = 0;
           g.dijkstra(shopNodePosition.get( r));                   
           g.printPath(client);
           // if there is a path to node then we store the path in format of cost,node,path
           if (g.reachable == 0 ){
               Add_to_arraylist(costs_taxi_to_client,r);
           } 
           g.cst = "";
           g.paths = "";  
     }    

  }
  
  // adds  path details from client to shop
  public static void client_to_shop_path(String client){
            costs_client_to_shop.clear();
            costs_client_to_shop2.clear();
            for (int r = 0; r < number_shops; r++){
                  g.reachable = 0;
                  g.dijkstra(client);
                  g.printPath(shopNodePosition.get( r));
                  // if there is a path to node then we store the path in format of cost,node,path
                  if (g.reachable == 0 ){
                      Add_to_arraylist(costs_client_to_shop,r);
                  }
                  g.cst = "";
                  g.paths = ""; 
                  
                  // you do it again for multiple paths
                  g.reachable = 0;
                  g.dijkstra1(client);
                  g.printPath(shopNodePosition.get( r));
                  // if there is a path to node then we store the path in format of cost,node,path
                  if (g.reachable == 0 ){
                      Add_to_arraylist(costs_client_to_shop2,r);
                  }
                  g.cst = "";
                  g.paths = "";
            }
            
  }
  // prints details for path from taxi to the client
  public static void print_to_shop(String client){
      
      if (costs_client_to_shop.isEmpty() || costs_taxi_to_client.isEmpty() ){// this means there is no route
         int g = 0; 
      }
      else{
             String resultArrC[] = costs_client_to_shop.get(0).split(",");// all the details of path form test 1
             String resultArrC_2[] = costs_client_to_shop2.get(0).split(",");// all the details of path form test 2
             
             
             
             if ( resultArrC_2[0].equals(resultArrC[0]) && !(resultArrC_2[2].equals(resultArrC[2])) ){
                 System.out.println("shop " + resultArrC[1]);
                 String output = "multiple solutions cost " + resultArrC[0];
                 int output_length = output.length();
                 output = output.substring(0,output_length -2);
                 System.out.println(output);
                                 
             }
             else {
                 System.out.println("shop " + resultArrC[1]);
                 System.out.println(resultArrC[2]);
             }
             

            }
            costs_client_to_shop.clear();
            costs_client_to_shop2.clear();

         
      
      
      

      
  }
  // prints details for path from taxi to the client
  public static void print_to_client(String client){
      System.out.println("client " + client);
      
      if (costs_client_to_shop.isEmpty() || costs_taxi_to_client.isEmpty() ){// this means there is no route
         System.out.println("cannot be helped"); 
      }
      else{
         // prints out the shortest path from shop to client
         int fixer = 0;
         for (int i = 0; i < costs_taxi_to_client.size(); i++) {
               String resultArr[] = costs_taxi_to_client.get(i).split(",");// all the details of path
               if ( i == 0 ){// first item
                   temp_minimum = resultArr[0];                                
                   System.out.println("taxi " + resultArr[1]);
                   System.out.println(resultArr[2]);                             
               }
               if ( temp_minimum.equals(resultArr[0]) && fixer > 0){
                   System.out.println("taxi " + resultArr[1]);
                   System.out.println(resultArr[2]);
                                    
               }
               fixer++; 
         }
      }
      //for (int y = 0; y < costs_client_to_shop.size(); y++) {
      
  
  }
  // sorts all the cost to the shop
  public static void To_shop_sort(){
      //Collections.sort(costs_client_to_shop);
      int xl  = 8;
  }
  // sorts all the cost to the client
  public static void To_client(){
      int xw = 8;                         
  }
  
  // adds to the array list in ascending order order of the cost
  public static void Add_to_arraylist( ArrayList<String> details_list , int position_pointer){
      if ( details_list.isEmpty()){
             details_list.add(g.cst + "," +shopNodePosition.get( position_pointer)  + "," + g.paths );
      }
      else{
             
             int track = 0;
             double currentcost = Double.parseDouble(g.cst);          
             for ( int op = details_list.size() - 1 ; op >= 0 ; op --){
                        String AddArrt[] = details_list.get(op).split(",");
                        double testcost = Double.parseDouble(AddArrt[0]);// cost of the last path in the arraylist
                        //System.out.println(duplicate);
                        if (currentcost >= testcost && track == 0  ){
                           details_list.add(op + 1,g.cst + "," +shopNodePosition.get( position_pointer)  + "," + g.paths );// if it is bigger
                           track++;                        
                        }      
              }
              
              if ( track == 0){
                        details_list.add(0,g.cst + "," +shopNodePosition.get( position_pointer)  + "," + g.paths );
                        track = 0;    
              }
             
      
      
      }


  
  } 
  
  
  
  
  





}