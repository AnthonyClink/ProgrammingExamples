package problems.problem1;

import java.util.List;
import java.util.function.Function;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class DataInputReaderUnitTest {

	private static final String INPUT_DATA = "12345,Clink,Anthony";
	
	private DataInputReader dataInputReader;
	
	@Before
	public void setup(){
		dataInputReader = new DataInputReader();
	}
	
	@Test
	public void readShouldReturnAListContainingTheData() {
		List<String> data = dataInputReader.read(INPUT_DATA);
		
		Assert.assertEquals("12345", data.get(0));
		Assert.assertEquals("Clink", data.get(1));
		Assert.assertEquals("Anthony", data.get(2));
	}

	@Test
	public void javaArgsArrayMayContainDataPastTheFirstSegmentJoinItIfTheInputWasMistypedInTheConsole() {
		List<String> data = dataInputReader.read("12345,Clink,","Anthony");
		
		Assert.assertEquals("12345", data.get(0));
		Assert.assertEquals("Clink", data.get(1));
		Assert.assertEquals("Anthony", data.get(2));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nullDataIsNotAllowedInAnyField() {
		
		try{
			dataInputReader.read("");
			Assert.fail("We should have thrown an exception");
		}catch(IllegalArgumentException e){
			dataInputReader.read((String)null);
		}
		
	}
	
	
}
