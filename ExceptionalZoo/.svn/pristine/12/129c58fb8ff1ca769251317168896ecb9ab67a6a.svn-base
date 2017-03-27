package z3_ThrowTryCatch;

public class Animal { 
	String status;
	
	//REQUIRES: food to be "red meat"
	public void feed(String food) throws FoodException{
		if (!food.equals("red meat")){
			throw new FoodException();
		}
		Printer.print("Animal: I got fed:"+food);
		this.status="fed";
	}
}
