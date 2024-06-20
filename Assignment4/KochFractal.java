/*
 * File: KochFractal.java
 * ----------------------
 * This program draws the Koch fractal snowflake from Chapter 9.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class KochFractal extends GraphicsProgram {

/* Standard entry point */
	public static void main(String[] args) {
		new KochFractal().start(args);
	}

/* Program entry point */
	public void run() {
		double cx = getWidth() / 2;
		double cy = getHeight() / 2;
		pen = new GPen();
		pen.setColor(Color.magenta);
		pen.setSpeed(0.5);
		pen.showPen();
		add(pen);
		drawFractal(cx, cy, EDGE, ORDER);
		pen.hidePen();
	}

/**
 * Draws a Koch fractal line centered at (x, y) with the specified
 * edge length and fractal order.
 * @param x The x-coordinate of the center
 * @param y The y-coordinate of the center
 * @param edge The edge length of the order-0 fractal
 * @param order The order of this fractal
 */
	private void drawFractal(double x, double y, double edge, int order) {
		pen.setLocation(x - edge / 2, y - edge / (2 * Math.sqrt(3)));
		drawFractalLine(edge, 0, order);
		drawFractalLine(edge, -120, order);
		drawFractalLine(edge, +120, order);
	}

/**
 * Draws a fractal line using the specified parameters.
 * @param len The length of the line
 * @param theta The direction in which to draw the line (in degrees)
 * @param order The order of this fractal
 */
	private void drawFractalLine(double len, int theta, int order) {
		if (order == 0) {
			pen.drawPolarLine(len, theta);
		} else {
			drawFractalLine(len / 3, theta, order - 1);
			drawFractalLine(len / 3, theta + 60, order - 1);
			drawFractalLine(len / 3, theta - 60, order - 1);
			drawFractalLine(len / 3, theta, order - 1);
		}
	}

/* Private constants */
	private static final double EDGE = 200;
	private static final int ORDER = 3;

/* Private instance variables */
	private GPen pen;

}
