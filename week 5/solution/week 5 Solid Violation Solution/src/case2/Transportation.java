package case2;

import case2.transport.Bicycle;
import case2.transport.Car;
import case2.transport.Walk;

public class Transportation {
	public static void main(String[] args) {
		var distance = 100;

		var tripOnFoot = new Trip(distance, new Walk());
		System.out.println("Trip on foot takes: " + tripOnFoot.duration());

		var tripWithBike = new Trip(distance, new Bicycle());
		System.out.println("Trip with bike takes: " + tripWithBike.duration());

		var tripByCar = new Trip(distance, new Car());
		System.out.println("Trip by car takes: " + tripByCar.duration());

//		var tripByMotorcycle = new Trip(distance, new Motorcycle());
//		System.out.println("Trip by motorcycle takes: " + tripByMotorcycle.duration());
	}
}
