
package javaapplication1;

import java.io.*;
import java.util.*;
//import Matrix;
/*
*
* IN MY CASE HAMID IS MY TEXT FILE WHICH I WANT TO DISPLAY YOU CHANGE WITH YOUR   OWN
*/

public class Tesunit
{
	public static void main(String[] args)   ///////////main start
	{
		int a2d[][]  = new int[3][3]; ///  matrix for test unit
		int[][] b2d = new int[3][3];
		int[][] c2d = new int[3][3];
		int[][] d2d = new int[3][3];
		int[][] e2d = new int[3][3];
		
		
		/////////////////////////////////////////////////////////////
		
		System.out.println("Reading File from Java code");
		//Name of the file
		String fileName="HAMID.txt";
		try{
			//Create object of FileReader
			FileReader inputFile = new FileReader(fileName);
			
			//Instantiate the BufferedReader Class
			BufferedReader bufferReader = new BufferedReader(inputFile);
			
			//Variable to hold the one line data
			String line;
			
			// Read file line by line and print on the console
			int j1=0,j2=0;
			while ((line = bufferReader.readLine()) != null)   {
				// System.out.println(line);
				
				StringTokenizer st = new StringTokenizer(line);
				int i1=0;
				while (st.hasMoreTokens()) {
					int y = Integer.parseInt(st.nextToken());
					// System.out.println(st.nextToken());
					//System.out.println(y);
					if(j1==3)
					j1=0;
					////  intiallization of ist matrix
					if(j2>=0 && j2<9){
						a2d[j1][i1]=y;
					}
					
					////  intiallization of 2nd matrix
					if(j2>=9 && j2<18){
						//  System.out.println("asd");
						b2d[j1][i1]=y;
					}
					
					////  intiallization of 3rd matrix
					if(j2>=18 && j2<27){
						c2d[j1][i1]=y;
					}
					
					////  intiallization of 4rth matrix
					if(j2>=27 && j2<36){
						d2d[j1][i1]=y;
					}
					
					////  intiallization of 5th matrix
					if(j2>=36 && j2<45){
						e2d[j1][i1]=y;
					}
					i1++;
					j2++;
				}
				// System.out.println("Value of outer loop is");
				j1++;
			}
			//Close the buffer reader
			bufferReader.close();
		}catch(Exception e){
			// System.out.println("Error while reading file line by line:" + e.getMessage());
		}
		////    loop for matrix printing
		/*for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 3; j++) {
		System.out.println("hellow" + c2d[i][j]);  ;
		// b2d[i][j]=j;
		}
		
		}*/
		System.out.println("Multipliction of two matrixs which was required");
		a2d=Matrix.multiply_f(a2d , b2d);
		c2d=Matrix.add_f(c2d, d2d);
		System.out.println("Addition of 3 matrixs which was required");
		c2d=Matrix.add_f(c2d, e2d);
		System.out.println("Multiply 2 matrices and then add a 3rd one to the result of addition of 3 matrixs");
		Matrix.add_f(c2d, a2d);
	}  ////main end
} //class end
