/*
 * Modelibra
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package sales.cheesestore.address;

import java.util.Comparator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modelibra.Entities;
import org.modelibra.IDomainModel;
import org.modelibra.ISelector;
import org.modelibra.Oid;
import org.modelibra.PropertySelector;

/* ======= import essential property classes ======= */

/* ======= import internal parent entity class ======= */

/* ======= import external parent entity and entities classes ======= */

/* ======= for each internal (part of) many-to-many child: import many-to-many entities class and its external parent entity class ======= */

/**
 * Address generated entities. This class should not be changed manually. Use a
 * subclass to add specific code.
 * 
 * @author Dzenan Ridjanovic
 * @version 2009-01-05
 */
public abstract class GenAddresss extends Entities<Address> {

	private static final long serialVersionUID = 1231169511159L;

	private static Log log = LogFactory.getLog(GenAddresss.class);

	/* ======= internal parent neighbors ======= */

	/* ======= external parent neighbors ======= */

	/* ======= base constructor ======= */

	/**
	 * Constructs addresss within the domain model.
	 * 
	 * @param model
	 *            model
	 */
	public GenAddresss(IDomainModel model) {
		super(model);
	}

	/* ======= parent argument constructors ======= */

	/* ======= get entity methods based on a property ======= */

	/**
	 * Retrieves the address with a given oid. Null if not found.
	 * 
	 * @param oid
	 *            oid
	 * @return address
	 */
	public Address getAddress(Oid oid) {
		return retrieveByOid(oid);
	}

	/**
	 * Retrieves the address with a given oid unique number. Null if not found.
	 * 
	 * @param oidUniqueNumber
	 *            oid unique number
	 * @return address
	 */
	public Address getAddress(Long oidUniqueNumber) {
		return getAddress(new Oid(oidUniqueNumber));
	}

	/**
	 * Retrieves the first address whose property with a property code is equal
	 * to a property object. Null if not found.
	 * 
	 * @param propertyCode
	 *            property code
	 * @param property
	 *            property
	 * @return address
	 */
	public Address getAddress(String propertyCode, Object property) {
		return retrieveByProperty(propertyCode, property);
	}

	/**
	 * Selects addresss whose property with a property code is equal to a
	 * property object. Returns empty entities if no selection.
	 * 
	 * @param propertyCode
	 *            property code
	 * @param property
	 *            property
	 * @return addresss
	 */
	public Addresss getAddresss(String propertyCode, Object property) {
		return (Addresss) selectByProperty(propertyCode, property);
	}

	/**
	 * Gets addresss ordered by a property.
	 * 
	 * @param propertyCode
	 *            property code
	 * @param ascending
	 *            <code>true</code> if the order is ascending
	 * @return ordered addresss
	 */
	public Addresss getAddresss(String propertyCode, boolean ascending) {
		return (Addresss) orderByProperty(propertyCode, ascending);
	}

	/* ======= selector and order methods ======= */

	/**
	 * Gets addresss selected by a selector. Returns empty addresss if there are
	 * no addresss that satisfy the selector.
	 * 
	 * @param selector
	 *            selector
	 * @return selected addresss
	 */
	public Addresss getAddresss(ISelector selector) {
		return (Addresss) selectBySelector(selector);
	}

	/**
	 * Gets addresss ordered by a composite comparator.
	 * 
	 * @param comparator
	 *            comparator
	 * @param ascending
	 *            <code>true</code> if the order is ascending
	 * @return ordered addresss
	 */
	public Addresss getAddresss(Comparator comparator, boolean ascending) {
		return (Addresss) orderByComparator(comparator, ascending);
	}

	/*
	 * ======= property selector methods for not unique essential properties
	 * without email (org.modelibra.type.Email) and url (java.net.URL) =======
	 */

	/* ======= property selector methods for unique properties ======= */

	/**
	 * Gets name address.
	 * 
	 * @param name
	 *            name
	 * @return name address
	 */
	public Address getNameAddress(String name) {
		PropertySelector propertySelector = new PropertySelector("name");
		propertySelector.defineEqual(name);
		List<Address> list = getAddresss(propertySelector).getList();

		if (list.size() > 0)
			return list.iterator().next();
		else
			return null;
	}

	/*
	 * ======= reference property selector methods for a non many-to-many
	 * concept that has at least one external parent =======
	 */

	/* ======= order methods for essential properties ======= */

	/**
	 * Gets addresss ordered by name.
	 * 
	 * @param ascending
	 *            <code>true</code> if ascending
	 * @return ordered addresss
	 */
	public Addresss getAddresssOrderedByName(boolean ascending) {
		return getAddresss("name", ascending);
	}

	/*
	 * ======= for a many-to-many concept: get entity method based on all
	 * many-to-many parents =======
	 */

	/*
	 * ======= for each internal (part of) many-to-many child: get entities
	 * method based on the many-to-many external parent =======
	 */

	/* ======= internal parent set and get methods ======= */

	/* ======= external parent set and get methods ======= */

	/* ======= for a many-to-many concept: post add propagation ======= */

	/* ======= for a many-to-many concept: post remove propagation ======= */

	/* ======= for a many-to-many concept: post update propagation ======= */

	/*
	 * ======= for a non many-to-many concept that has at least one external
	 * parent: post add propagation =======
	 */

	/*
	 * ======= for a non many-to-many concept that has at least one external
	 * parent: post remove propagation =======
	 */

	/*
	 * ======= for a non many-to-many concept that has at least one external
	 * parent: post update propagation =======
	 */

	/* ======= create entity method ======= */

	/**
	 * Creates address.
	 * 
	 * @param name
	 *            name
	 * @return address
	 */
	public Address createAddress(String name) {
		Address address = new Address(getModel());
		address.setName(name);
		if (!add(address)) {
			address = null;
		}
		return address;
	}

}