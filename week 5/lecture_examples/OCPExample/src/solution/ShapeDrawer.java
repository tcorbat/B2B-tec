package solution;

import shapes.Shape;

public interface ShapeDrawer<ShapeType extends Shape> {
	void draw(ShapeType shape);
}
