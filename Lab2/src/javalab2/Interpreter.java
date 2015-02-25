/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javalab2;

/**
 *
 * @author temperary
 */
public class Interpreter {
    
    static int tem=0; 
    public static void main(String[] args) {
        // TODO code application logic here
        Test ob=new Test();
        Variable v=new Variable();
        ob.readFile();
        v.set(tem);
    }
    
}
