package problems.problem2;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.Objects.nonNull;

public class RoadData {
	
	private final Map<String, Road> roadData;
	
	public RoadData(Map<String, Road> roadData){
		
		//allow for new entries at runtime without sacrificing speed
		this.roadData = new ConcurrentHashMap<>(roadData.size() * 2);
		
		if(nonNull(roadData)){
			//create a copy to avoid any possible concurrency issues with a passed in hashmap
			synchronized (roadData) {
				this.roadData.putAll(roadData);	
			}
		}
		
	}
	
	public void addRoadUSA(String id, String name, USState usState){
		Road road = new Road();
		roadData.put(id, road);
		road.setId(id);
		road.setName(name);
		road.setUsState(usState);
	}
	
}
