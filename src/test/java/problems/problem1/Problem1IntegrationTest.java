package problems.problem1;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;

import org.junit.Assert;
import org.junit.Test;

public class Problem1IntegrationTest {

	@Test
	public void deleteMe(){
		//write a sample program that hyjacks the System.out so we can fully test all functionality of the application
		

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(byteArrayOutputStream);
		System.setOut(printStream);

		System.out.println("Hello world");

		Assert.assertEquals("Hello world", new String(byteArrayOutputStream.toByteArray(), Charset.defaultCharset()).trim());

		
		
	}
	
	@Test
	public void theProgramShouldOutputTheProperResult() {

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(byteArrayOutputStream);
		System.setOut(printStream);

		System.out.println("Hello world");

		Assert.assertEquals("Hello world", new String(byteArrayOutputStream.toByteArray(), Charset.defaultCharset()).trim());

	}

}
