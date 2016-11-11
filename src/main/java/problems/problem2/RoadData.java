package problems.problem2;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import problems.problem2.CVSFile.Row;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RoadData {

	private final CVSFile roadFile;
	private final CVSFile accidentFile;

	private final Map<String, Road> roadData;

	public RoadData(String roadFileName, String accidentFileName) {
		this.roadData = new ConcurrentHashMap<>();
		this.roadFile = new CVSFile(roadFileName, new String[] { "id", "name", "state" });
		this.accidentFile = new CVSFile(accidentFileName);
		loadRoadData();
	}

	public List<Road> getAll() {
		return new ArrayList<>(roadData.values());
	}

	public Road get(String roadId) {
		return roadData.get(roadId);
	}

	void addRoadUSA(String id, String name, String usState) {
		Road road = new Road();
		roadData.put(id, road);
		road.setId(id);
		road.setName(name);
		road.setUsState(USState.getState(usState));
		road.setAccedents(new ArrayList<>());
	}

	void addAccident(String id, String roadId, String timestamp) {
		Accedent accedent = new Accedent();
		accedent.setId(id);
		accedent.setRoadId(roadId);
		accedent.setTimestamp(LocalDateTime.parse(timestamp));

		Road road = roadData.get(id);

		if (road == null) {
			throw new IllegalArgumentException("No road " + roadId + " exists for accident " + id);
		}

		road.getAccedents().add(accedent);

	}

	private void loadRoadData() {

		for (Row row : roadFile.getRows()) {
			addRoadUSA(row.get("id"), row.get("name"), row.get("state"));
		}

		for (Row row : accidentFile.getRows()) {
			addAccident((String) row.get("accident_id"), (String) row.get("road_id"), (String) row.get("date"));
		}

	}
}
