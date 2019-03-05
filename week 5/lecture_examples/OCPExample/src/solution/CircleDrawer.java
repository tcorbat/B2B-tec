package solution;

import shapes.Circle;

final class CircleDrawer implements ShapeDrawer<Circle> {
	@Override
	public void draw(Circle shape) {
		System.out.println("Draw Circle");
	}
}