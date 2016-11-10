package problems.problem1;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DataInputReader {

	public static final String DEFAULT_SEPARATOR = ",";
	
	private final Settings settings;

	public DataInputReader() {
		this(new Settings());
		this.getSettings().setSeparator(DEFAULT_SEPARATOR);
	}

	public DataInputReader(Settings settings) {
		this.settings = settings;
	}

	public List<String> read(String... input) {
		return read(String.join("", input));
	}
	
	public List<String> read(String input) {
		
		if(input == null || input.trim().equals("")){
			throw new IllegalArgumentException("Null input is now allowed... theres nothing to do with it man!!!");
		}
		
		//we are not doing this with split, just in case someone sets a separator with like a .(dot) or some other regexy thing;
		final StringTokenizer stringTokenizer = new StringTokenizer(input, getSettings().getSeparator());
		
		List<String> data = new ArrayList<>();
		
		while(stringTokenizer.hasMoreTokens()){
			data.add(getSettings().getDataFormatter().formatField(stringTokenizer.nextToken()));
		}
		
		return data;
	}
	
	public Settings getSettings() {
		return settings;
	}

	public final static class Settings{
		
		private volatile String separator;
		private volatile DataFormatter dataFormatter;
		
		public String getSeparator() {
			return separator;
		}
		
		public void setSeparator(String separator){
			this.separator = separator;
		}

		public DataFormatter getDataFormatter() {
			return dataFormatter;
		}

		public void setDataFormatter(DataFormatter dataFormatter) {
			this.dataFormatter = dataFormatter;
		}
	
	}
	
}
