package second;

public class App implements IApp {

	private static App app = new App();

	private IModel model;

	private App() {
	}

	public static App getApp() {
		return app;
	}

	public IModel getModel() {
		return model;
	}

	public void setModel(IModel model) {
		this.model = model;
	}
	
	protected Object clone() {
		throw new RuntimeException("Singleton");
	}

}
