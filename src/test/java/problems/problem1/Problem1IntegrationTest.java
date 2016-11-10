package problems.problem1;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;

import org.junit.Assert;
import org.junit.Test;

public class Problem1IntegrationTest {

	private static final String INPUT_DATA = "1234,Clink,Anthony";
	private static final String EXPECTED_OUTPUT_DATA = "Anthony,Clink,4321";
	
	@Test
	public void theProgramShouldOutputTheProperResult() {

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(byteArrayOutputStream);
		System.setOut(printStream);

		Problem1.main(new String[]{INPUT_DATA});
		
		Assert.assertEquals(EXPECTED_OUTPUT_DATA, new String(byteArrayOutputStream.toByteArray(), Charset.defaultCharset()).trim());

	}

}
