package problems.problem2;

public enum USState {

	OR("1", "OR", "Oregon");
	
	private final String id;
	private final String stateCode;
	private final String stateName;
	
	private USState(String id, String stateCode, String stateName){
		this.id = id;
		this.stateCode = stateCode;
		this.stateName = stateName;
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
