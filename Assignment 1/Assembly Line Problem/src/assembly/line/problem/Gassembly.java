

package assembly.line.problem;

import java.awt.*;
import java.util.Formatter;
import javax.swing.*;
import java.util.*;
import java.util.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 *
 * @author Hafiz Muhammad Hamid
 * Reg #342
 * BSCS 2 A
 */
// Extends JPanel, so as to override the paintComponent() for custom rendering codes. 
public class Gassembly extends JPanel {
   // Container box's width and height
   private static final int BOX_WIDTH = 640;
   private static final int BOX_HEIGHT = 480;
   private static  int xc =BOX_WIDTH/2;
    private static  int yc=20;
   
   
  
   private static final int UPDATE_RATE = 1; // Number of refresh per second
  
  static int k=50;
  ALine obj=new ALine();
  static int n=5;
   /** Constructor to create the UI components and init game objects. */
   public Gassembly() {
       //
       n=obj.n;
       obj.Assembly_Line();
       
       
      this.setPreferredSize(new Dimension(BOX_WIDTH, BOX_HEIGHT+n*100));
  
  
       
      // Start the ball bouncing (in its own thread)
      Thread gameThread = new Thread() {
          
         public void run() {
             
             int temp[]=new int[n];
        if(obj.l==1)
             {
               temp=obj.l1;  
             }
       else
            temp=obj.l2;
             
             try {
                  Thread.sleep(2000 / UPDATE_RATE);  // milliseconds
               } catch (InterruptedException ex) { }
            
            for(int i=0;i<n+2;i++) { // Execute one update step
               // Calculate the ball's new position
                k=k+50;
                if(i<n){
               if(temp[i]==1)
              {
                   xc=2*BOX_WIDTH/6;
               yc=120+i*100;
              }
               else
              {
                  xc=4*BOX_WIDTH/6;
               yc=120+i*100;
              }
                }
                
                if(i==n){
                    xc=3*BOX_WIDTH/6;
               yc=120+n*100-20;
                }
                
               
               // Refresh the display
               repaint(); // Callback paintComponent()
               // Delay for timing control and give other threads a chance
               try {
                  Thread.sleep(1000 / UPDATE_RATE);  // milliseconds
               } catch (InterruptedException ex) { }
            }
         }
      };
      gameThread.start();  // Callback run()
   }
  
   /** Custom rendering codes for drawing the JPanel */
   @Override
   public void paintComponent(Graphics g) {
      super.paintComponent(g);    // Paint background
  //int n=;
      // Draw the box
      g.setColor(Color.LIGHT_GRAY);
      g.fillRect(0, 0, BOX_WIDTH, BOX_HEIGHT + n*100);
  //g.
      
      // Display the ball's information
      g.setColor(Color.WHITE);
     
      g.setFont(new Font("Courier New", Font.PLAIN, 12));
      StringBuilder sb = new StringBuilder();
      Formatter formatter = new Formatter(sb);
      //formatter.format("Final cost is =%d, ", obj.f);
     // g.drawString(sb.toString(), 20, 30);
      
      
      
     // formatter.format("Station value");
     // g.drawString(sb.toString(), 50, 30);
      g.setColor(Color.BLUE);
           g.fillRect(BOX_WIDTH/2, 30, 100, 60);
             
           
           // my car
           g.setColor(Color.black);
           g.fillRect(xc, yc, 30, 50);
           
       for (int i = 0; i < n; i++) {
           g.setColor(Color.BLUE);
           g.fillRect(BOX_WIDTH/6, 120+i*100, 40, 60);
           
          // formatter.format("Station value");
    //  g.drawString(sb.toString(), BOX_WIDTH/6, 120+i*100 -15);
     
           
           //2nd line stations
           g.setColor(Color.BLUE);
           g.fillRect(5*BOX_WIDTH/6, 120+i*100, 40, 60);
      
           
       }
      formatter.format("Final cost is =%d ", obj.f);
      g.drawString(sb.toString(), BOX_WIDTH/5, 120+n*100);
      g.setColor(Color.GREEN);
           g.fillRect(BOX_WIDTH/2, 120+n*100, 100, 60);
    //  g.setColor(Color.BLUE);
     // g.fillOval((int) (ballX - ballRadius), (int) (ballY - ballRadius),
       //     (int)(2 * ballRadius), (int)(2 * ballRadius));
      
      
   }
  
   /** main program (entry point) */
   public static void main(String[] args) {
      // Run GUI in the Event Dispatcher Thread (EDT) instead of main thread.
      javax.swing.SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            // Set up main window (using Swing's Jframe)
            JFrame frame = new JFrame("Assembly Line Problem");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(new Gassembly());
            frame.pack();
            frame.setBounds(0, 0, 1000, 2000);
            
            frame.setVisible(true);
         }
      });
   }
}