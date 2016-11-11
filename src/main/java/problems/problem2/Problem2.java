package problems.problem2;

import java.util.List;
import java.util.Map;

public class Problem2 {

	
	public static void main(String[] args){
		
		RoadData roadData = new RoadData("src/main/resources/roads.csv", "src/main/resources/accidents.csv");
		
		RoadService roadService = new RoadService(roadData);
		
		AccedentService accedentService = new AccedentService(roadService);
		
		int mostAccidents = -1;
		USState mostAccidentsState = null;
		
		for(Map.Entry<USState, List<Accedent>> stateAccidents : accedentService.getAllFilteredByState().entrySet()){
			if(stateAccidents.getValue().size() > mostAccidents){
				mostAccidentsState = stateAccidents.getKey();
			}
		}
		
		System.out.println("State with most accidents: " + mostAccidentsState.getStateName());
		
	}
	
	
}
