package second;

public abstract class Action implements IAction {

	private String status = "started";

	void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public boolean isExecuted() {
		if (getStatus().equals("executed")) {
			return true;
		}
		return false;
	}

	public boolean isUndone() {
		if (getStatus().equals("undone")) {
			return true;
		}
		return false;
	}

}
