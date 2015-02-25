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
public class JavaLab2 {

    //HashMap<String,Integer> ;
    
    public static void main(String[] args) {
        // TODO code application logic here
        JavaLab2 ob=new JavaLab2();
        ob.readFile();
    }
    
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
				 System.out.println(line);
				String cheack[]=line.split(" ");
                               if( cheack[0].compareToIgnoreCase("let") ==0)
                               {
                                   String cheack2[]=line.split("=");
                                   if(cheack2.length==1)
                                   {
                                       System.out.println(" = sign does not exist ");
                                   }
                                   else
                                       try
                                   {
                                       //System.out.println("str " + cheack[3]);
                                        x=Integer.parseInt(cheack[3]);
                                      // System.out.println("parse int = " + x);
                                               
                                   }
                                   catch(Exception e){}
                                   
                                   
                               }
                               if( cheack[0].compareToIgnoreCase("x") ==0){
				  String s1[]=line.split("=");
                                   System.out.println("2nd line "+cheack[3]);
                                   if("+"==cheack[3]){
                                       System.out.println("asd");
                                       x=x+Integer.parseInt(cheack[4]);
                                   }
                                   if("-"==cheack[3]){}
                                   if("*"==cheack[3]){}
                                   if("/"==cheack[3]){}
                               }
                               
                               if( cheack[0].compareToIgnoreCase("print") ==0){
				  String s1[]=line.split("=");
                                   System.out.println("2nd line "+cheack[3]);
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
