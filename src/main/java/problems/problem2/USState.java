package problems.problem2;

import java.util.Objects;

public enum USState {

	OR("1", "OR", "Oregon"),
	WA("2", "WA", "Washington");
	
	private final String id;
	private final String stateCode;
	private final String stateName;
	
	private USState(String id, String stateCode, String stateName){
		this.id = id;
		this.stateCode = stateCode;
		this.stateName = stateName;
	}

	public static USState getState(String identifier){
		
		Objects.requireNonNull(identifier);
		
		String id = identifier.toUpperCase().trim();
		
		for(USState state : USState.values()){
			
			if(state.name().equals(id)){
				return state;
			}
			
			if(state.stateName.toUpperCase().equals(id)){
				return state;
			}
			
			if(state.id.equals(id)){
				return state;
			}
			
		}
		
		return null;
	}
	
	public String getId() {
		return id;
	}

	public String getStateCode() {
		return stateCode;
	}

	public String getStateName() {
		return stateName;
	}
	
}
