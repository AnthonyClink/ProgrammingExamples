package problems.problem1;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DataInputReaderUnitTest {

	private static final String INPUT_DATA = "1234,Clink,Anthony";
	
	private DataInputReader dataInputReader;
	
	@Before
	public void setup(){
		dataInputReader = new DataInputReader();
	}
	
	@Test
	public void readShouldReturnAListContainingTheData() {
		List<String> data = dataInputReader.read(INPUT_DATA);
		
		Assert.assertEquals("1234", data.get(0));
		Assert.assertEquals("Clink", data.get(1));
		Assert.assertEquals("Anthony", data.get(2));
	}

	@Test
	public void javaArgsArrayMayContainDataPastTheFirstSegmentJoinItIfTheInputWasMistypedInTheConsole() {
		List<String> data = dataInputReader.read("1234,Clink,","Anthony");
		
		Assert.assertEquals("1234", data.get(0));
		Assert.assertEquals("Clink", data.get(1));
		Assert.assertEquals("Anthony", data.get(2));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nullDataIsNotAllowedInAnyField() {

	}
	
	public void ifNullOrBlankDataIsPresentThrowAnIllegalArgumentException() {
		
	}
	
}
