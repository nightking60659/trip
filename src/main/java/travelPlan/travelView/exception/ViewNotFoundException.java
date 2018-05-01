package travelPlan.travelView.exception;

public class ViewNotFoundException extends RuntimeException {

	private  int viewId;

	public ViewNotFoundException(int viewId) {
		super();
		this.viewId = viewId;
	}

	public int getViewId() {
		return viewId;
	}

	public void setViewId(int viewId) {
		this.viewId = viewId;
	}
	
	

}
