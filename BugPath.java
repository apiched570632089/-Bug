////////////////////////////////////////////////////////////////////////////////
///////////////////////////apiched audomphon////////////////////////////////////
////////////////////////////// 570632089///////////////////////////////////////
package bugpath;

import java.util.Scanner;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showInputDialog;

public class BugPath {
    public String path[][] = new String[1000][1000];
    public String bug[][] = new String[1000][1000];
    public String pro[][] = new String[1000][1000];
    public int cost[]= new int [5] ;
    
    
    public void path(int pa ){
    
        for(int i=0; i<pa;i++){
            for(int j=0; j<pa;j++){
            path [i][j]= "o"; 
           // System.out.print(""+num[i][j]);
            if(i==(pa-2) & j==pa-1)   {
                path [i][j]= "-";
             //  System.out.print(""+num[i][j]); 
            } 
            if(i==(pa-1) & j==pa-1)   {
                path [i][j]= "-";
              }
            if(i==(pa-1) & j==pa-2)   {
                path [i][j]= "-";
              }
             }}}
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
    
    public void debug(int pa){
        for(int i=0; i<pa;i++){
            for(int j=0; j<pa;j++){
            bug [i][j]= "o"; 
           // System.out.print(""+num[i][j]);
            
/////////////////////////////1////////////////////            
            if(i==(pa-3) & j==pa-1)   {
                bug [i][j]= "-";
              }
/////////////////////////////2/////////////////////////
             if(i==(pa-2) & j==pa-1)   {
                bug [i][j]= "+";
              }
            if(i==(pa-2) & j==pa-2)   {
                bug [i][j]= "-";
            }
/////////////////////////////3/////////////////////////            
             if(i==(pa-1) & j==pa-3)   {
                bug [i][j]= "-";
              }
            if(i==(pa-1) & j==pa-1)   {
                bug [i][j]= "+";
              }
            if(i==(pa-1) & j==pa-2)   {
                bug [i][j]= "+";
              }
        }
    }
}
    
   public void printBug(int pa){
         
     BugPath s = new BugPath();
          s.path(pa);
          s.debug(pa);
           System.out.print("|||||||||||||||bug||||||||||||||||||\n");   
          for(int i=0; i<pa;i++){
             for(int j=0; j<pa;j++){
                System.out.print(s.path[i][j]+" ");      
                if(j==pa-1){
                System.out.print("\n");   
                }
            }  
        }
    }
   
   
     public void printPath(int pa){
         
     BugPath s = new BugPath();
          s.path(pa);
          s.debug(pa);
           System.out.print("|||||||||||||||path||||||||||||||||||\n");   
          for(int i=0; i<pa;i++){
             for(int j=0; j<pa;j++){
                System.out.print(s.bug[i][j]+" ");      
                if(j==pa-1){
                System.out.print("\n");   
                }
            }  
        }
    }
     
  public void  process1(int pa){  
      BugPath s = new BugPath();
///////////////////////////////P1/////////////////////////////////      
           for(int i=0, j=0; j<pa; j++){
                if(bug[i][j]== path[i][j]){
                     pro[i][j]= "o"; 
                }
                     if(bug[i][j]!=path[i][j]){   
                         pro[i][j]= "-";
                     }
                        cost [0]= 1;
                       System.out.print(" "+pro[i][j]);
            }
  }
     
  public void  process2(int pa){  
      BugPath s = new BugPath();
///////////////////////////////P1/////////////////////////////////      
           for(int i=0,k=1,j=0; j<pa; j++){
                if(pro[i][j]== bug[k][j]){
                     path[i][j]= "o"; 
                }
                     if(pro[i][j]!=bug[k][j]){   
                         path[i][j]= "-";
                }  
                     if(i==pa-1){
                 path[i][pa-1]= "o";
                }
                     System.out.print(" "+path[i][j]); 
                     cost [0]+= 1;             
            }
}
  
public void  process3(int pa){  
      BugPath s = new BugPath();
///////////////////////////////P1/////////////////////////////////      
           for(int i=0,k=2,j=0; j<pa; j++){    
                     if(path[i][j]!=bug[k][j]){   
                         pro[i][j]= "-";
                     }               
           }
           for(int i=0,k=2,j=1; j<pa; j++){
                         pro[i][j]= "o";
           }
           for(int i=0,j=0; j<pa; j++){
                     System.out.print(" "+pro[i][j]); 
           }
           cost[0]+=  2;
  }
/////////////////////////////////main program//////////////////////////////////   
    public static void main(String[] args) {
        System.out.print("input path: ");
        Scanner path= new Scanner(System.in);
        Scanner bug = new Scanner(System.in);
        String p  = path.nextLine();
         String[] b = p.split("\\s");
            int bu = Integer.parseInt(b[0]);
            int pa = Integer.parseInt(b[1]);
        BugPath s = new BugPath();
          s.path(pa);
          s.debug(pa);
          s.printBug(pa);
          s.printPath(pa);
          System.out.print("||||||||||||||process|||||||||||||||||\n"); 
            s.process1(pa);
               System.out.print("\n"); 
             s.process2(pa);
             System.out.print("\n");
             s.process3(pa);
             System.out.print("\n"); 
              s.process1(pa);
             System.out.print("\n"); 
             s.process2(pa);
             System.out.print("\n"); 
             s.process3(pa);
             System.out.print("\n"); 
             s.process2(pa);
       System.out.print(" \n cost = "+s.cost[0]); 
             
     } 
}

        
