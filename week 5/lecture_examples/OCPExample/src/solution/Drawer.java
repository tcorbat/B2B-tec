package solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import shapes.Circle;
import shapes.Shape;
import shapes.Square;

public class Drawer {

	private final Map<Class<? extends Shape>, Consumer<Shape>> drawers = new HashMap<>();

	public <T extends Shape> void register(Class<T> clazz, ShapeDrawer<T> drawer) {
		drawers.put(clazz, (shape) -> {
			if (clazz.isInstance(shape)) {
				drawer.draw(clazz.cast(shape));
			}
		});
	}
	
	public void drawAll(List<Shape> shapes) {
		shapes.stream().filter(shape -> drawers.containsKey(shape.getClass())).forEach(shape -> {
			var drawer = drawers.get(shape.getClass());
			drawer.accept(shape);
		});
	}

	public static void main(String[] args) {
		var square = new Square();
		var circle = new Circle();
		var drawer = new Drawer();
		drawer.register(Square.class, new SquareDrawer());
		drawer.register(Circle.class, new CircleDrawer());
		drawer.drawAll(Arrays.asList(square, circle, square));

	}
}
