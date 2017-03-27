package z7_unchecked_not_caught;

public class Animal {
	String status;
	
	//REQUIRES: food to be "red meat"
	public void feed(String food) {
		if (!food.equals("red meat")){
			throw new ProtestException();
		}
		Printer.print("Animal: I got fed:" + food);
		this.status="fed";
	}
}
