package z8_unchecked_and_catch;

import java.util.ArrayList;

import z1_basic.Printer;

public class ZooKeeper {
	
	public void feedAnimals(ArrayList<Animal> animals) {
		Printer.print("ZK: I've been told to feed the animals");
		for (Animal a : animals){
			try{
				a.feed("veggies");
			}
			catch (ProtestException food){
				food.printStackTrace();
				Printer.print("ZK: food was thrown at me, I caught it");
				Printer.print("ZK: I'm going to keep working");
			}
			finally{
				Printer.print("ZK: FINALLY: Done feeding one animal");
			}
		}
		Printer.print("ZK: Done feeding the animals");
	}
	
}
