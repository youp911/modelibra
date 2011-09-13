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
package universite.biblio.livre;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modelibra.Entities;
import org.modelibra.IDomainModel;
import org.modelibra.ISelector;
import org.modelibra.DomainModel;
import org.modelibra.Oid;
import org.modelibra.PropertySelector;

/* ======= import essential property classes ======= */


/* ======= import internal parent entity class ======= */


/* ======= import external parent entity and entities classes ======= */


/* ======= for each internal (part of) many-to-many child: import many-to-many entities class and its external parent entity class ======= */
    

/**
 * Livre generated entities. This class should not be changed manually. 
 * Use a subclass to add specific code.
 * 
 * @author Dzenan Ridjanovic
 * @version 2011-09-13
 */
public abstract class GenLivres extends Entities<Livre> {
	
	private static final long serialVersionUID = 1315949489426L;

	private static Log log = LogFactory.getLog(GenLivres.class);
	
	/* ======= internal parent neighbors ======= */
	
	    
/* ======= external parent neighbors ======= */
	

	/* ======= base constructor ======= */
	
	/**
	 * Constructs livres within the domain model.
	 * 
	 * @param model
	 *            model
	 */
	public GenLivres(IDomainModel model) {
		super(model);
	}
	
	/* ======= parent argument constructors ======= */
	
	 
	/* ======= get entity methods based on a property ======= */
    
/**
 * Retrieves the livre with a given oid. 
 * Null if not found. 
	 * 
	 * @param oid
	 *            oid
	 * @return livre
	 */
public Livre getLivre(Oid oid) {
		return retrieveByOid(oid);
	}

	/**
 * Retrieves the livre with a given oid unique number. 
 * Null if not found. 
	 * 
	 * @param oidUniqueNumber
	 *            oid unique number
	 * @return livre
	 */
	public Livre getLivre(Long oidUniqueNumber) {
		return getLivre(new Oid(oidUniqueNumber));
	}
    
/**
 * Retrieves the first livre whose property with a  
 * property code is equal to a property object. Null if not found. 
	 * 
	 * @param propertyCode
	 *            property code
	 * @param property
	 *            property
	 * @return livre
	 */
	public Livre getLivre(String propertyCode, Object property) {
		return retrieveByProperty(propertyCode, property);
	}
	
			
		/**
	 * Selects livres whose property with a property code is equal to a property
	 * object. Returns empty entities if no selection.
	 * 
	 * @param propertyCode
	 *            property code
	 * @param property
	 *            property
	 * @return livres
	 */
	public Livres getLivres(String propertyCode, Object property) {
		return (Livres) selectByProperty(propertyCode, property);
	}
	
	/**
	 * Gets livres ordered by a property.
	 * 
	 * @param propertyCode
	 *            property code
	 * @param ascending
	 *            <code>true</code> if the order is ascending
	 * @return ordered livres
	 */
	public Livres getLivres(String propertyCode, boolean ascending) {
		return (Livres) orderByProperty(propertyCode, ascending);
	}
	
	/* ======= selector and order methods ======= */
	
	/**
	 * Gets livres selected by a selector. Returns empty livres if there are no
	 * livres that satisfy the selector.
	 * 
	 * @param selector
	 *            selector
	 * @return selected livres
	 */
	public Livres getLivres(ISelector selector) {
		return (Livres) selectBySelector(selector);
	}
	
	/**
	 * Gets livres ordered by a composite comparator.
	 * 
	 * @param comparator
	 *            comparator
	 * @param ascending
	 *            <code>true</code> if the order is ascending
	 * @return ordered livres
	 */
	public Livres getLivres(Comparator comparator, boolean ascending) {
		return (Livres) orderByComparator(comparator, ascending);
	}
	
	/* ======= property selector methods for not unique essential properties without email (org.modelibra.type.Email) and url (java.net.URL) ======= */
	
		
	/* ======= property selector methods for unique properties ======= */
	
	/**
		 * Gets titre livre.
		 * 
		 * @param titre 
		 *            titre
		 * @return titre livre
		 */
		public Livre getTitreLivre(String titre) {
			PropertySelector propertySelector = new PropertySelector("titre");
						propertySelector.defineEqual(titre);
			List<Livre> list = getLivres(propertySelector).getList();
			
			if (list.size() > 0)
				return list.iterator().next();
			else
				return null;
		}
		
		
	/* ======= reference property selector methods for a non many-to-many concept that has at least one external parent ======= */
	
					
	/* ======= order methods for essential properties ======= */
	
	/**
		 * Gets livres ordered by titre.
		 * 
		 * @param ascending
		 *            <code>true</code> if ascending
		 * @return ordered livres
		 */
		public Livres getLivresOrderedByTitre(boolean ascending) {			
			return getLivres("titre", ascending);
		}
	
		
	/* ======= for a many-to-many concept: get entity method based on all many-to-many parents ======= */
	
			
	/* ======= for each internal (part of) many-to-many child: get entities method based on the many-to-many external parent ======= */
    
	
	/* ======= internal parent set and get methods ======= */
    
	
	/* ======= external parent set and get methods ======= */
    
	
	/* ======= for a many-to-many concept: post add propagation ======= */
	
			
	/* ======= for a many-to-many concept: post remove propagation ======= */
	
			
	/* ======= for a many-to-many concept: post update propagation ======= */
	
			
	/* ======= for a non many-to-many concept that has at least one external parent: post add propagation ======= */
	
		
	/* ======= for a non many-to-many concept that has at least one external parent: post remove propagation ======= */
	
		
	/* ======= for a non many-to-many concept that has at least one external parent: post update propagation ======= */
	
		
	/* ======= create entity method ======= */
	
		/**
	 * Creates livre.
	 *
		 * @param titre titre 
		 * @return livre
	 */
	public Livre createLivre(
											String titre 
				) {
		Livre livre = new Livre(getModel());
						livre.setTitre(titre);
				if (!add(livre)) {
			livre = null;
		}
		return livre;
	}

}