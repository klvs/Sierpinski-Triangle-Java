import java.awt.*;

import javax.swing.*;
/*  
SierpinskiTriangle.java
Alex Roman
May. 16, 2014

Sierpinski triangle

1. Do usual GUI/JFrame stuff (no need to explain at this point)
2. draw triangle draws a triangle give the provided points
3. subpinski recursively draws line between mid-point 
4. paint draws the initial triangle from instance vars
etc.


*/
public class Triangle extends JFrame {
	int x0 = 250, y0 =0,
	x1 = 0, y1 = 500,
	x2 = 500, y2 = 500;
	
	
	//sets up window 
	public Triangle(){
		super("Sierpinksi Triangle");
		setSize(500,500);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	//overriding paint method
	public void paint(Graphics g){
		

		g.drawLine(x0, y0, x1, y1);
		g.drawLine(x0, y0, x2, y2);
		g.drawLine(x1, y1, x2, y2);
		//g.drawOval(x1, y1, 5, 5);
		subpinski(g, 5, x0, y0, x1, y1, x2, y2);
		
	}
	
	public void subpinski(Graphics g, int number, int x0, int y0, int x1, int y1, int x2, int y2){
		//base case
		if(number == 0){
			drawTri(g, x0, y0, x1, y1, x2, y2);
		}
		//recursive case
		else{
			//first triangle
			int x3 = (x0 + x1)/2, y3 = (y0 + y1)/2;
			int x4 = (x1 + x2)/2, y4 = (y1 + y2)/2;
			int x5 = (x0 + x2)/2, y5 = (y0 + y2)/2;
			
			//g.drawOval(x3, y3, 5, 5);
			subpinski(g, number-1, x0, y0, x3, y3, x5, y5);
			subpinski(g, number-1, x3, y3, x1, y1, x4, y4);
			subpinski(g, number-1, x5, y5, x4, y4, x2, y2);


			//drawTri(g, x3, y3, x4, y4, x5, y5);
			
		}
	}
	
	public void drawTri(Graphics g, int x0, int y0, int x1, int y1, int x2, int y2){
		g.drawLine(x1, y1, x0, y0);
		g.drawLine(x0, y0, x2, y2);
		g.drawLine(x2, y2, x1, y1);
	}

	//main - Triangle is instantiated
	public static void main(String[] args){
		
		new Triangle();

	}
	
	
}
