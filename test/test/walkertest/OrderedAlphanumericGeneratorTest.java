package test.walkertest;
import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.ReflectionUtils;

import com.walkertest.helpers.OrderedAlphanumericGenerator;



class OrderedAlphanumericGeneratorTest {

	@Test
	void testIncrementString() throws NoSuchMethodException, SecurityException {
		String input = "ZA";
		String expected = "ZB";
		
		Method method = OrderedAlphanumericGenerator.class.getDeclaredMethod("incrementString", String.class, int.class);
		String actual = (String)ReflectionUtils.invokeMethod(method, null, input, 3);
		
		Assert.assertEquals(expected, actual);
	}

	@Test
	void testGenerateAlphabets() {
		int generatedArrayLength = 5;
		String[] expecteds = {"A", "B", "C", "D", "E"};
		
		String[] actuals = OrderedAlphanumericGenerator.generateAlphabets(generatedArrayLength);
		
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
}
