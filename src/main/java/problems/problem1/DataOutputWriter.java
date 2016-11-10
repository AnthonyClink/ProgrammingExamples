package problems.problem1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class DataOutputWriter {

	// by default, the input should be reversed before outputting it
	private static final Function<List<String>, List<String>> DEFAULT_TRANSFORMATION_FUNCTION = (data) -> {

		if (data == null) {
			return new ArrayList<>();
		}

		Collections.reverse(data);
		return data;
	};

	private final Settings settings;

	public DataOutputWriter() {
		this(new Settings());
		getSettings().setFieldOutputSeparator(DataInputReader.DEFAULT_SEPARATOR);
	}

	public DataOutputWriter(Settings settings) {
		this.settings = settings;
	}

	public void writeData(List<String> data) {
		// if someone sets it to null
		if (getSettings().getFieldOutputSeparator() == null) {
			getSettings().setFieldOutputSeparator(DataInputReader.DEFAULT_SEPARATOR);
		}

		System.out.println(String.join(getSettings().getFieldOutputSeparator(),
				getSettings().getDataTransformationFunction().apply(data)));
	}

	public Settings getSettings() {
		return settings;
	}

	public static class Settings {

		private volatile String fieldOutputSeparator;

		private volatile Function<List<String>, List<String>> dataTransformationFunction;

		public String getFieldOutputSeparator() {
			return fieldOutputSeparator;
		}

		public void setFieldOutputSeparator(String fieldOutputSeparator) {
			this.fieldOutputSeparator = fieldOutputSeparator;
		}

		public Function<List<String>, List<String>> getDataTransformationFunction() {
			return dataTransformationFunction == null ? DEFAULT_TRANSFORMATION_FUNCTION : dataTransformationFunction;
		}

		public void setDataToOutputFunction(Function<List<String>, List<String>> dataTransformationFunction) {
			this.dataTransformationFunction = dataTransformationFunction;
		}

	}

}
