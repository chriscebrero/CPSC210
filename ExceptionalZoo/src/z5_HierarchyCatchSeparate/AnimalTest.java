package z5_HierarchyCatchSeparate;

import org.junit.Test;

public class AnimalTest {

	@Test (expected=VeggiesException.class)
	public void test() throws FeedingException {
		Animal a = new Animal();
		a.feed("veggies");
	}

}
