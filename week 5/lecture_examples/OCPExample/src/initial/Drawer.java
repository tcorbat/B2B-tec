package initial;
import java.util.List;

import shapes.Circle;
import shapes.Shape;
import shapes.Square;

public class Drawer {
	public void drawAll(List<Shape> shapes) {
		for (Shape shape : shapes) {
			if (shape instanceof Circle) {
				drawCircle((Circle) shape);
			}
			if (shape instanceof Square) {
				drawSquare((Square) shape);
			}
		}
	}

	// ...
	private void drawSquare(Square shape) {
	}

	private void drawCircle(Circle shape) {
	}
}