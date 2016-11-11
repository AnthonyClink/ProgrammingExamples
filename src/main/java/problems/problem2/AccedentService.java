package problems.problem2;

import static java.util.Objects.isNull;
import static java.util.Objects.requireNonNull;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccedentService {

	private final RoadService roadService;

	// intentionally package protected
	AccedentService(RoadService roadService) {
		this.roadService = roadService;
	}

	public List<Accedent> getAll() {

		List<Accedent> accedents = new ArrayList<>();

		roadService.getAll().forEach(road -> accedents.addAll(road.getAccedents()));

		return accedents;
	}
	
	public Map<USState, List<Accedent>> getAllFilteredByState(){
		Map<USState, List<Accedent>> filteredResults = new HashMap<>();
		
		for(Road road : roadService.getAll()){
			List<Accedent> accidentsInState = filteredResults.get(road.getUsState());
			
			if(accidentsInState == null){
				accidentsInState = new ArrayList<Accedent>();
				filteredResults.put(road.getUsState(), accidentsInState);
			}
			
			accidentsInState.addAll(road.getAccedents());
			
		}
		
		return filteredResults;
		
	}

	public void reportAccident(String id, String roadId) {
		reportAccident(id, roadId, null);
	}

	public void reportAccident(String id, String roadId, LocalDateTime localDateTime) {

		requireNonNull(id);
		requireNonNull(roadId);

		Road road = null;

		try {
			road = roadService.findById(roadId);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException("Accedent " + id + " reported on road with id " + roadId + " does not exist!",
					e);
		}

		List<Accedent> accedents = road.getAccedents();

		if (isNull(accedents)) {
			accedents = new ArrayList<>();
			road.setAccedents(accedents);
		}

		Accedent accedent = new Accedent();
		accedent.setId(id);
		accedent.setRoadId(roadId);

		accedent.setTimestamp(localDateTime == null ? LocalDateTime.now() : localDateTime);

	}

}
