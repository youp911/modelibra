package model;

import java.io.Serializable;

public interface IEntity<T extends IEntity<T>> extends Serializable {

	public void setOid(Long oid);

	public Long getOid();
	
	public Object getProperty(String propertyCode);

}