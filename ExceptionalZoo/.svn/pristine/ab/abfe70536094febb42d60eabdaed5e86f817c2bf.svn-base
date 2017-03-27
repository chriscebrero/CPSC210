package z8_unchecked_and_catch;

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
