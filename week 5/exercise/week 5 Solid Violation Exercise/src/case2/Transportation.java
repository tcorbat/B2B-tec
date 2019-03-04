package case2;

public class Transportation {
	public static void main(String[] args) {
		var distance = 100;

		var tripOnFoot = new Trip(distance, MeansOfTransport.Walk);
		System.out.println("Trip on foot takes: " + tripOnFoot.duration());

		var tripWithBike = new Trip(distance, MeansOfTransport.Bicycle);
		System.out.println("Trip with bike takes: " + tripWithBike.duration());

		var tripByCar = new Trip(distance, MeansOfTransport.Car);
		System.out.println("Trip by car takes: " + tripByCar.duration());

//		var tripByMotorcycle = new Trip(distance, MeansOfTransport.Motorcycle);
//		System.out.println("Trip by motorcycle takes: " + tripByMotorcycle.duration());
	}
}
