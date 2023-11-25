import java.io.*;
import java.util.*;
import java.io.*;
import java.util.*;
public class Testsimulator{
    static GraphTest g = new GraphTest( );
    public static void main( String [ ] args )
    {
          ArrayList<String> test = new ArrayList<String>();
          test.add("1" );
          test.add("3" );
          test.add("7");
          test.add("12");
          test.add("25");
          test.add("100");
          test.add("100" );
          test.add("100");
          test.add("1002");
          test.add("1002" );
          
          if ( test.get(0) == null){
             test.add(0,"90");
          }
          else{
               //test.add(test.size(),"leronkhete");// if it is bigger
               //test.add(test.size() -2  ,"pipi");// if it is smaller
          }
          /*if (currentcost >= testcost  ){
                details_list.add(g.cst + "," +shopNodePosition.get( position_pointer)  + "," + g.paths );// if it is bigger
                //System.out.println("in");
             }*/

          double duplicate = 0;
          double duplicate2 = -86;
          int track = 0;
          for ( int op = test.size() - 1 ; op >= 0 ; op --){
                    
                        duplicate = Double.parseDouble(test.get(op ));
                        System.out.println(duplicate);
                        if (duplicate2 >= duplicate && track == 0  ){
                           test.add(op + 1,"maretao");
                           track++;                        
                        }      
           }
           if ( track == 0){
              test.add(0,"maretao");
              track = 0;    
           }

          
          //System.out.println(test.get(test.size() -2));
          System.out.println(test);
          
         /*g.addEdge("0","0", 0);
         g.addEdge("1", "0", 24 );
         g.addEdge("2","1", 12);
         g.addEdge("1","1", 12);
         g.addEdge("2", "0", 7 );
         g.addEdge("3", "1", 23);
         g.addEdge("3","4", 16);
         g.addEdge("4", "2", 15);
         g.addEdge("4",  "3", 9);
         g.dijkstra("1");
         g.printPath("0");
         
         g.dijkstra("2");
         g.printPath("1");
         g.dijkstra("0");
         g.printPath("1");*/

         
         //System.out.println("14.0".equals("23.0"));
    
    }
}