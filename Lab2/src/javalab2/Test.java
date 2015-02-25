/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javalab2;
import java.util.*;
import java.io.*;

/**
 *
 * @author test1
 */
public class Test {

    //HashMap<String,Integer> ;
    
    
  static  public void readFile()
    {
       System.out.println("Reading File from Java code");
		//Name of the file
		String fileName="Hamid.txt";
		try{
			//Create object of FileReader
			FileReader inputFile = new FileReader(fileName);
			
			//Instantiate the BufferedReader Class
			BufferedReader bufferReader = new BufferedReader(inputFile);
			
			//Variable to hold the one line data
			String line;
			int x=0;
			// Read file line by line and print on the console
			while ((line = bufferReader.readLine()) != null)   {
				// System.out.println(line);
				String cheack[]=line.split(" ");
                                
                                /* if( cheack[0].compareToIgnoreCase("let") !=0){   //erroe handling 
                                     System.out.println(" 'Let' is missing .....Invalid syntax");
                                     return;
                                 }*/
                                    /////1st line cheack 
                               if( cheack[0].compareToIgnoreCase("let") ==0)
                               {
                                   String cheack2[]=line.split("=");
                                   
                                   if(cheack2.length == 1)
                                   {
                                       System.out.println(" = sign does not exist "); //erroe handling
                                       return ;
                                   }
                                   else
                                       try
                                       {
                                        x=Integer.parseInt(cheack[3]);
                                      // System.out.println("parse int = " + x);
                                               
                                   }
                                   catch(Exception e){}
                                   
                                   
                               }
                               
                               
                               ////2nd  line cheack
                               if( cheack[0].compareToIgnoreCase("x") ==0){
				  String s1[]=line.split("=");
                                  if(s1.length==1){         //erroe handling
                                      System.out.println("= does not exist in assignment");
                                      return;
                                  }
                                  //erroe handling
                                 // System.out.println("gdg"+cheack[3].compareToIgnoreCase("*"));
                                  if(0!=cheack[3].compareToIgnoreCase("-") && 0!=cheack[3].compareToIgnoreCase("+") && 0!=cheack[3].compareToIgnoreCase("*") && 0!=cheack[3].compareToIgnoreCase("/")){
                                      System.out.println("Arthemetic operater does not exist in assignment");
                                      return;
                                  }
                                  
                                  
                                   //System.out.println("2nd line "+cheack[3]);
                                   
                                   if(0!=cheack[3].compareToIgnoreCase("+") ){
                                      // System.out.println("asd");
                                       x=x+Integer.parseInt(cheack[4]);
                                   }
                                   if(0==cheack[3].compareToIgnoreCase("-")){
                                       x=x-Integer.parseInt(cheack[4]);
                                   }
                                   if(0==cheack[3].compareToIgnoreCase("*")){
                                       x=x*Integer.parseInt(cheack[4]);
                                   
                                   }
                                   if(0==cheack[3].compareToIgnoreCase("/")){
                                       x=x/Integer.parseInt(cheack[4]);
                                   }
                                   
                               }
                               
                               ///// 3rd line cheack
                               if( cheack[0].compareToIgnoreCase("print") ==0){
				 // String s1[]=line.split("=");
                                 //  System.out.println("2nd line "+cheack.length);
                                   if(cheack.length!=2){
                                       System.out.println("Invalid Syntax");
                                       return;
                                   }
                                      Interpreter.tem=x;
                                   System.out.println("Value of x "+ x);
                               }
			}
			//Close the buffer reader
			bufferReader.close();
		}catch(Exception e){
			 System.out.println("Error while reading file line by line:" + e.getMessage());
		} 
    }
    
    
}
