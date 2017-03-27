package z2_keepThrowing;

import java.util.ArrayList;

public class ZooKeeper {
	
	public void feedAnimals(ArrayList<Animal> animals) throws FoodException{
		Printer.print("ZK: I've been told to feed the animals");
		for (Animal a : animals){
			a.feed("veggies");
		}
		Printer.print("ZK: Done feeding the animals");
	}
	
}
