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
package proto.weblink.url;

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
 * Url generated entities. This class should not be changed manually. 
 * Use a subclass to add specific code.
 * 
 * @author Dzenan Ridjanovic
 * @version 2011-09-20
 */
public abstract class GenUrls extends Entities<Url> {
	
	private static final long serialVersionUID = 1316545294495L;

	private static Log log = LogFactory.getLog(GenUrls.class);
	
	/* ======= internal parent neighbors ======= */
	
	    
/* ======= external parent neighbors ======= */
	

	/* ======= base constructor ======= */
	
	/**
	 * Constructs urls within the domain model.
	 * 
	 * @param model
	 *            model
	 */
	public GenUrls(IDomainModel model) {
		super(model);
	}
	
	/* ======= parent argument constructors ======= */
	
	 
	/* ======= get entity methods based on a property ======= */
    
/**
 * Retrieves the url with a given oid. 
 * Null if not found. 
	 * 
	 * @param oid
	 *            oid
	 * @return url
	 */
public Url getUrl(Oid oid) {
		return retrieveByOid(oid);
	}

	/**
 * Retrieves the url with a given oid unique number. 
 * Null if not found. 
	 * 
	 * @param oidUniqueNumber
	 *            oid unique number
	 * @return url
	 */
	public Url getUrl(Long oidUniqueNumber) {
		return getUrl(new Oid(oidUniqueNumber));
	}
    
/**
 * Retrieves the first url whose property with a  
 * property code is equal to a property object. Null if not found. 
	 * 
	 * @param propertyCode
	 *            property code
	 * @param property
	 *            property
	 * @return url
	 */
	public Url getUrl(String propertyCode, Object property) {
		return retrieveByProperty(propertyCode, property);
	}
	
			
		/**
	 * Selects urls whose property with a property code is equal to a property
	 * object. Returns empty entities if no selection.
	 * 
	 * @param propertyCode
	 *            property code
	 * @param property
	 *            property
	 * @return urls
	 */
	public Urls getUrls(String propertyCode, Object property) {
		return (Urls) selectByProperty(propertyCode, property);
	}
	
	/**
	 * Gets urls ordered by a property.
	 * 
	 * @param propertyCode
	 *            property code
	 * @param ascending
	 *            <code>true</code> if the order is ascending
	 * @return ordered urls
	 */
	public Urls getUrls(String propertyCode, boolean ascending) {
		return (Urls) orderByProperty(propertyCode, ascending);
	}
	
	/* ======= selector and order methods ======= */
	
	/**
	 * Gets urls selected by a selector. Returns empty urls if there are no
	 * urls that satisfy the selector.
	 * 
	 * @param selector
	 *            selector
	 * @return selected urls
	 */
	public Urls getUrls(ISelector selector) {
		return (Urls) selectBySelector(selector);
	}
	
	/**
	 * Gets urls ordered by a composite comparator.
	 * 
	 * @param comparator
	 *            comparator
	 * @param ascending
	 *            <code>true</code> if the order is ascending
	 * @return ordered urls
	 */
	public Urls getUrls(Comparator comparator, boolean ascending) {
		return (Urls) orderByComparator(comparator, ascending);
	}
	
	/* ======= property selector methods for not unique essential properties without email (org.modelibra.type.Email) and url (java.net.URL) ======= */
	
	/**
		 * Gets link urls.
		 * 
		 * @param link 
		 *            link
		 * @return link urls
		 */
		public Urls getLinkUrls(String link) {
			PropertySelector propertySelector = new PropertySelector("link");
			propertySelector.defineEqual(link);
			return getUrls(propertySelector);
		}
		
		
	/* ======= property selector methods for unique properties ======= */
	
		
	/* ======= reference property selector methods for a non many-to-many concept that has at least one external parent ======= */
	
					
	/* ======= order methods for essential properties ======= */
	
	/**
		 * Gets urls ordered by link.
		 * 
		 * @param ascending
		 *            <code>true</code> if ascending
		 * @return ordered urls
		 */
		public Urls getUrlsOrderedByLink(boolean ascending) {			
			return getUrls("link", ascending);
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
	 * Creates url.
	 *
		 * @param link link 
		 * @return url
	 */
	public Url createUrl(
											String link 
				) {
		Url url = new Url(getModel());
						url.setLink(link);
				if (!add(url)) {
			url = null;
		}
		return url;
	}

}