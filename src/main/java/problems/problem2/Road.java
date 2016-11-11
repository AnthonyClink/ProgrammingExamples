package problems.problem2;

import java.util.List;

public class Road {

	private String id;
	private String name;
	private USState usState;
	private List<Accedent> accedents;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public USState getUsState() {
		return usState;
	}

	public void setUsState(USState usState) {
		this.usState = usState;
	}

	public List<Accedent> getAccedents() {
		return accedents;
	}

	public void setAccedents(List<Accedent> accedents) {
		this.accedents = accedents;
	}

}
