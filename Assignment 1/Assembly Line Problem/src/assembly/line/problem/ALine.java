

package assembly.line.problem;


import java.util.*;
import java.util.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;



public class ALine {
    
    /**
    * @param args the command line arguments
    */
    int n=5;
        int t1[]={0,0,0,0};
        int t2[]={0,0,10,0};
        int a2[]={1,1,15,1,1};
        int a1[]={2,2,2,2,2};
        int e1=1;
        int e2=1;
        int x1=1;
        int x2=1;
        int l1[]={0,0,0,0,0};;
        int l2[]=new int[n];
        int l=0;
        int f1[]=new int[n];
        int f2[]=new int[n];
        int f=0;
    void Assembly_Line()
    {
         
        f1[0] = e1 + a1[0];
        f2[0] = e2 + a2[0];
        l1[0]=1;
        l2[0]=2;
        int j=1;
        for(j=1;j<n;j++)
        {
            //System.err.println("i="+f1[5]);
            
            if (f1[j-1] + a1[j] <= f2[j-1] + t2[j-1] + a1[j]){
                f1[j] = f1[j-1]+a1[j];
                l1[j] = 1;
            }
            else
            {
                f1[j] = f2[j-1] + t2[j-1] + a1[j];
                l1[j] = 2;
         
            }
            if (f2[j-1] + a2[j] <= f1[j-1] + t1[j-1] + a2[j] )
            {
                f2[j] = f2[j-1]+a2[j];
                l2[j] =2;
            }
            else
            {
                f2[j] = f1[j-1] + t1[j-1] + a2[j] ;
                l2[j] = 1;
             
            }
           
        }
        
        for (int i = 0; i <n; i++) {
           // System.out.println("value of l1 is  "+l1[i]);
        }
        n=n-1;
        if  (f1[n] + x1 <= f2[n] + x2){
            f = f1[n] + x1;
            l = 1;
        }
        else
        {
            f= f2[n] + x2;
            l = 2;
            
        }
        
        
        
        System.out.println("f = "+f+" l = "+l);
    }
 /*   public static void main(String[] args) {
        ALine a=new ALine();
        a.Assembly_Line();
       
        
    }*/
    
    
}

