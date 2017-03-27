package z8_unchecked_and_catch;

import org.junit.Test;

public class AnimalTest {

	@Test (expected= ProtestException.class)
	public void test() throws ProtestException {
		Animal a = new Animal();
		a.feed("spam");
	}

}
