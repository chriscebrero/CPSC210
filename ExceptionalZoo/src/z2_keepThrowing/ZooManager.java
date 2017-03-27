package z2_keepThrowing;

import java.util.ArrayList;

public class ZooManager {
	private ArrayList<Animal> animals;
	
	public ZooManager(){
		animals = new ArrayList<Animal>();
	}
	
	public void addAnimal(Animal a){
		animals.add(a);
	}
	
	public void manageZoo(ZooKeeper zk) throws FoodException{
		Printer.print("ZM: Telling Phil to feed the animals");
		zk.feedAnimals(animals);
		Printer.print("ZM: Well that worked out well!");
	}
	
	public static void main(String[] args) throws FoodException{
		ZooManager Gerald = new ZooManager();
		ZooKeeper Phil = new ZooKeeper();
		Gerald.addAnimal(new Animal());
		Gerald.addAnimal(new Animal());	
		Gerald.manageZoo(Phil);
	}

}
