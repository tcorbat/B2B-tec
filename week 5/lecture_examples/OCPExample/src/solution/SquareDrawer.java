package solution;

import shapes.Square;

final class SquareDrawer implements ShapeDrawer<Square> {
	@Override
	public void draw(Square shape) {
		System.out.println("Draw Square");
	}
}