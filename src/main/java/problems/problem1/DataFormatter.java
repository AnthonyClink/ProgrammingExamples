package problems.problem1;

import java.util.function.Function;

public class DataFormatter {
	
	/**
	 * By default, if a string has an even number of characters
	 */
	public static final Function<String, String> DEFAULT_FIELD_READER = (fieldData) -> {
		
		if(fieldData == null || fieldData.isEmpty()){
			throw new IllegalArgumentException("No field can be blank. Please correct your list");
		}
		
		String data = fieldData.trim();
		
		return data.length() % 2 == 0 ? new StringBuilder(data).reverse().toString() : data;
	};
	
	public static class Settings {
		
		private Function<String, String> fieldReader;
		
		public void setFieldReader(Function<String,String> fieldReader){
			this.fieldReader = fieldReader;
		}
		
		public Function<String, String> getFieldReader(){
			return fieldReader;
		}
	}
	
}
