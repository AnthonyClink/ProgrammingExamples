package problems.problem1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class DataInputReader {

	public static final String DEFAULT_SEPARATOR = ",";
	
	private final Settings settings;

	public DataInputReader() {
		this(new Settings());
		this.settings.setSeparator(DEFAULT_SEPARATOR);
	}

	public DataInputReader(Settings settings) {
		this.settings = settings;
	}

	public List<String> read(String input) {
		
		//we are not doing this with split, just in case someone sets a separator with like a .(dot) or some other regexy thing;
		final StringTokenizer stringTokenizer = new StringTokenizer(input, settings.getSeparator());
		
		List<String> data = new ArrayList<>();
		
		while(stringTokenizer.hasMoreTokens()){
			data.add(stringTokenizer.nextToken().trim());
		}
		
		return data;
	}

	public List<String> read(String... input) {
		return read(String.join("", input));
	}
	
	public final static class Settings{
		
		private volatile String separator;
		
		public String getSeparator() {
			return separator;
		}
		
		public void setSeparator(String separator){
			this.separator = separator;
		}
		
	}
	


}
