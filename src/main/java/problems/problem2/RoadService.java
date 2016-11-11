package problems.problem2;

import static java.util.Objects.isNull;

import java.util.List;

public class RoadService {

	private RoadData roadData;
	
	//intentionally package protected
	RoadService(RoadData roadData) {
		this.roadData = roadData;
	}
	
	public List<Road> getAll(){
		return roadData.getAll();
	}
	
	public Road findById(String id) {
		
		Road road = roadData.get(id);
		
		if (isNull(road)) {
			throw new IllegalArgumentException(
					"Road " + id + " does not exist! This may be an input error");
		}
		
		return road;
	}
	
	
}
