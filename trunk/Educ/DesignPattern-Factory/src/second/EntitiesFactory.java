package second;

public class EntitiesFactory implements IEntitiesFactory {

	public IEntities<?> createEntities(String name) {
		IEntities<?> entities = null;
		if (name.equals("Clients")) {
			entities = new Clients();
		} else if (name.equals("Products")) {
			entities = new Products();
		}
		return entities;
	}

}
