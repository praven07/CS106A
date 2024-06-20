/*
 * File: Mondrian.java
 * -------------------
 * This program draws the Mondrian pattern used in the text.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

public class Mondrian extends GraphicsProgram {

/* Standard entry point */
	public static void main(String[] args) {
		new Mondrian().start(args);
	}

/* Program entry point */
	public void run() {
		pen = new GPen();
		add(pen);
		pen.setSpeed(0.8);
		subdivideCanvas(0, 0, getWidth(), getHeight());
	}

/* Private method: subdivideCanvas(x, y, width, height) */
/**
 * Draws a Mondrian style picture by recursively subdividing a canvas
 * into progressively smaller subcanvas units whose dimensions are
 * conveyed by the parameters.  At each level of call, the function
 * first checks for the simple case, which is obtained when the size
 * of the rectangular canvas is too small to subdivide (i.e., when the
 * area is less than <code>MINIMUM_AREA</code>).  In the simple case,
 * the function does nothing.  If the area is larger than the minimum,
 * the function first decides whether to split the canvas horizontally
 * or vertically, choosing the larger dimension.  The function then
 * chooses a random dividing line, making sure to leave at least
 * <code>MINIMUM_EDGE<code> on each side.  The program then uses a
 * divide-and-conquer strategy to subdivide the two new rectangles.
 *
 * @usage subdivideCanvas(x, y, width, height);
 * @param <code>x</code> the x-coordinate of the subcanvas
 * @param <code>y</code> the y-coordinate of the subcanvas
 * @param <code>width</code> the width of the subcanvas
 * @param <code>height</code> the height of the subcanvas
 */

	private void subdivideCanvas(double x, double y, double width, double height) {
		if (width * height >= MINIMUM_AREA) {
			double divider = rgen.nextDouble(MINIMUM_EDGE, Math.max(width, height) - MINIMUM_EDGE);
			if (width > height) {
				pen.setLocation(x + divider, y);
				pen.drawLine(0, height);
				subdivideCanvas(x, y, divider, height);
				subdivideCanvas(x + divider, y, width - divider, height);
			} else {
				pen.setLocation(x, y + divider);
				pen.drawLine(width, 0);
				subdivideCanvas(x, y, width, divider);
				subdivideCanvas(x, y + divider, width, height - divider);
			}
		}
	}

/* Private constants */
	private static final double MINIMUM_AREA = 4000;
	private static final double MINIMUM_EDGE = 10;

/* Private instance variabls */
	private GPen pen;
	private RandomGenerator rgen = RandomGenerator.getInstance();

}
