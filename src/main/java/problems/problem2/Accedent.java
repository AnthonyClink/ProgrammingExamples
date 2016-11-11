package problems.problem2;

import java.time.LocalDateTime;

public class Accedent {

	private String id;
	private String roadId;
	private LocalDateTime localDateTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoadId() {
		return roadId;
	}

	public void setRoadId(String roadId) {
		this.roadId = roadId;
	}

	public LocalDateTime getZonedDateTime() {
		return localDateTime;
	}

	public void setTimestamp(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

}
