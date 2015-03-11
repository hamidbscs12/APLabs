/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication1;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.StringTokenizer;


public class WebServer {
	protected void start() {
		ServerSocket s;

		System.out.println("Webserver running on port 8088");
		try {
			s = new ServerSocket(8088);
		} catch (Exception e) {
			System.out.println("Error: " + e);
			return;
		}

		System.out.println("Waiting for response");
		BufferedReader br = null;
		StringBuilder stb=new StringBuilder("");
		BufferedReader in;
		Socket remote=null;
		for (;;) {
			try {
				remote = s.accept();
				System.out.println("Connection,  data has been sent.");
				 in = new BufferedReader(new InputStreamReader(
						remote.getInputStream()));
				PrintWriter out = new PrintWriter(remote.getOutputStream());
				String str = ".";
				while (!str.equals("")){
					str = in.readLine();
					if(str.contains("GET")){        	  
						StringTokenizer stk=new StringTokenizer(str,"/");
						stk.nextToken();
						String filename=stk.nextToken();
						filename=filename.replace("HTTP", "");
						System.out.println(filename);
						String sCurrentLine;
						br = new BufferedReader(new FileReader("C:\\Users\\temperary\\Desktop\\"+filename));
						while ((sCurrentLine = br.readLine()) != null) {
							stb.append(sCurrentLine);
						}
					}

				}
				out.println("HTTP/1.0 200 OK");
				out.println("Content-Type: text/html");
				out.println("");
				out.println("<H1>Welcome to the  WebServer</H2>");
				out.println(stb.toString());
				out.flush();
				
			} catch (Exception e) {
				try {
					PrintWriter out = new PrintWriter(remote.getOutputStream());
					out.println("HTTP/1.0 200 OK");
					out.println("Content-Type: text/html");
					out.println("");
					out.println("<H1>Error:"+e+"</H2>");
					out.println(stb.toString());
					out.flush();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}finally {
				
				try {
					remote.close();
					if (br != null)br.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}
	}
	public static void main(String args[]) {
		WebServer ws = new WebServer();
		ws.start();
	}
}