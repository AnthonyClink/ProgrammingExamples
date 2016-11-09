package problems.problem1;

import java.util.List;

public class DataInputReader {

	public static final char DEFAULT_SEPARATOR = ',';

	private final Settings settings;

	public DataInputReader() {
		this(new Settings());
	}

	public DataInputReader(Settings settings) {
		this.settings = settings;
	}

	public List<String> read(String input) {
		return null;
	}

	public List<String> read(String... input) {
		return null;
	}

	public static class Settings {

		private final char separator;

		public Settings() {
			this(DEFAULT_SEPARATOR);
		}

		public Settings(char separator) {
			this.separator = separator;
		}

		public char getSeparator() {
			return separator;
		}
	}

}
