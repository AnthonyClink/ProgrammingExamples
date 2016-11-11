package problems.problem2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Stream;

public class CVSFile {

	public static final String DEFAULT_SEPARATOR = ",";

	private final Path filePath;
	private final Map<String, Header> headers;
	private final AtomicBoolean firstLineIsHeader;
	private final List<Row> rows;
	private final AtomicBoolean fileRead;

	public CVSFile(String filePath, String... headers) {
		this(filePath);
		this.firstLineIsHeader.set(false);

		for (int i = 0; i < headers.length; i++) {
			this.headers.put(headers[i], new Header(i, headers[i]));
		}

	}

	public CVSFile(String filePath) {

		Path path = Paths.get(filePath).toAbsolutePath();

		if (path.isAbsolute()) {
			this.filePath = path;
		} else {
			this.filePath = Paths.get(filePath);
		}

		this.headers = new HashMap<>();
		this.firstLineIsHeader = new AtomicBoolean(true);
		this.fileRead = new AtomicBoolean(false);
		this.rows = new ArrayList<>();
	}

	public List<String> getHeaders() {

		if (!fileRead.get()) {
			read();
		}

		List<String> headerNames = new ArrayList<>(headers.size());

		for (Header header : headers.values()) {
			headerNames.add(header.getIndex(), header.getName());
		}

		return headerNames;

	}

	public List<Row> read() {

		if (fileRead.get()) {
			return rows;
		}

		// read file into stream, try-with-resources
		try (Stream<String> stream = Files.lines(filePath)) {
			
			Iterator<String> iterator = stream.iterator();
			
			if (firstLineIsHeader.get() && iterator.hasNext()) {

				List<String> headerNames = readLine(iterator.next());

				for (int i = 0; i < headerNames.size(); i++) {
					String headerName = headerNames.get(i);
					headers.put(headerName, new Header(i, headerNames.get(i)));
				}
			}
			
			while(iterator.hasNext()){
				addRow(iterator.next());
			};

		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}

		fileRead.set(true);

		return rows;
	}

	public List<Row> getRows() {
		return read();
	}

	public void addRow(String line) {
		List<String> data = readLine(line);

		Row row = new Row();

		rows.add(row);

		for (int i = 0; i < data.size(); i++) {
			String cell = data.get(i);

			if (!Objects.isNull(cell) || !cell.isEmpty()) {
				row.setAt(i, cell);
			}
		}
	}

	private List<String> readLine(String line) {

		final StringTokenizer stringTokenizer = new StringTokenizer(line, DEFAULT_SEPARATOR);

		List<String> data = new ArrayList<>();

		while (stringTokenizer.hasMoreTokens()) {
			data.add(stringTokenizer.nextToken().trim());
		}

		return data;
	}

	public final class Header {

		private final int index;
		private final String name;

		private Header(int index, String name) {
			this.index = index;
			this.name = name;
		}

		public int getIndex() {
			return index;
		}

		public String getName() {
			return name;
		}

	}

	public final class Row {

		private List<String> data;

		private Row() {
			data = new ArrayList<String>();
		}

		public List<String> getHeaders() {
			return getHeaders();
		}

		public String get(String headerName) {
			return getAt(headers.get(headerName).getIndex());
		}

		public void set(String headerName, String data) {
			setAt(headers.get(headerName).getIndex(), data);
		}

		public String getAt(int index) {
			return data.get(index);
		}

		public void setAt(int index, String data) {
			if (this.data.size() < index + 1) {

				int elementsToAdd = (index - this.data.size()) * 2;

				for (int i = 0; i <= elementsToAdd; i++) {
					this.data.add(null);
				}
			}

			this.data.set(index, data);
		}

		@Override
		public String toString() {
			return String.join(",", data);
		}

	}

}
