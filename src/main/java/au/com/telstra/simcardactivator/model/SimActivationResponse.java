package au.com.telstra.simcardactivator.model;

public class SimActivationResponse {
	private boolean success;

	public SimActivationResponse(boolean success) {
		this.success = success;
	}

	public boolean getSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
}
