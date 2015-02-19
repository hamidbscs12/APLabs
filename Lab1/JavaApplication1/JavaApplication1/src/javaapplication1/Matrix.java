

package javaapplication1;

import java.util.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
public class Matrix {
	
    
    /////////////////multiplication function///////////////////
	public static int[][] multiply_f(int a[][], int b[][]) {
            int  sum = 0, c, d, k;
            int multiply[][] = new int[3][3];
            for ( c = 0 ; c < 3 ; c++ )
                    {
                        for ( d = 0 ; d < 3 ; d++ )
                        {
                            for ( k = 0 ; k < 3 ; k++ )
                            {
                                sum = sum + a[c][k]*b[k][d];
                            }
                            
                            multiply[c][d] = sum;
                            sum = 0;
                        }
                    }
            
            System.out.println("Product of entered matrices:-");
                    
                    for ( c = 0 ; c < 3 ; c++ )
                    {
                        for ( d = 0 ; d < 3 ; d++ )
                            System.out.print(multiply[c][d]+"\t");
                        
                        System.out.print("\n");
                    }
  
            return multiply;
            }
        //////////////////addition function of two matrix/////////////////////
        public static int[][] add_f(int a[][], int b[][]) {
            System.out.println("Addition of matrix is: ");
            int  sum = 0, c, d, k;
            int add_sum[][] = new int[3][3];
	            for ( c = 0 ; c < 3 ; c++ ){
	                for ( d = 0 ; d < 3 ; d++ ){
	                   add_sum[c][d]= a[c][d]+b[c][d];
	                   System.out.print(add_sum[c][d]+"\t");
	                	}
	                System.out.print("\n");
	            	}
                    return add_sum;
        }
        
        
        ///////////subtract function of two matrix////////////////////
         public static int[][] sub_f(int a[][], int b[][]) {
            System.out.println("Subtraction of  matrix is: ");
            int  sum = 0, c, d, k;
            int sub[][] = new int[3][3];
	            for ( c = 0 ; c < 3 ; c++ ){
	                for ( d = 0 ; d < 3 ; d++ ){
	                   sub[c][d]= a[c][d]-b[c][d];
	                   System.out.print(sub[c][d]+"\t");
	                	}
	                System.out.print("\n");
	            	}
                    return sub;
        }
}
		
	

