package problems.problem1;

import java.util.function.Function;

public class DataFormatter {

	/**
	 * By default, if a string has an even number of characters reverse those characters
	 */
	public static final Function<String, String> DEFAULT_FIELD_FORMATTER = (fieldData) -> {

		if (fieldData == null || fieldData.isEmpty()) {
			throw new IllegalArgumentException("No field can be blank. Please correct your list");
		}

		String data = fieldData.trim();

		return data.length() % 2 == 0 ? new StringBuilder(data).reverse().toString() : data;
	};
	
	private final Settings settings;
	
	public DataFormatter(){
		this.settings = new Settings(DEFAULT_FIELD_FORMATTER);
	}

	public String formatField(String data){
		
		Function<String, String> fieldFormatter = getSettings().getfieldFormatter();
		
		if(fieldFormatter == null){
			return data;
		}
		
		return fieldFormatter.apply(data);
	}

	public Settings getSettings() {
		return settings;
	}

	public static class Settings {

		private volatile Function<String, String> fieldFormatter;
		
		public Settings(Function<String, String> fieldFormatter) {
			this.fieldFormatter = fieldFormatter;
		}

		public void setFieldReader(Function<String, String> fieldFormatter) {
			this.fieldFormatter = fieldFormatter;
		}

		public Function<String, String> getfieldFormatter() {
			return fieldFormatter;
		}

	}

}
