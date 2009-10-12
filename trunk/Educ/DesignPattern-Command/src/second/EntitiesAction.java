package second;

public abstract class EntitiesAction extends Action {

	private IEntities entities;

	private IEntity entity;

	public EntitiesAction(IEntities entities, IEntity entity) {
		this.entities = entities;
		this.entity = entity;
	}

	public IEntities getEntities() {
		return entities;
	}

	public IEntity getEntity() {
		return entity;
	}

}
