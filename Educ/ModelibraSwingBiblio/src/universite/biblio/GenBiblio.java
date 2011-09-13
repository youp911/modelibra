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
package universite.biblio;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modelibra.IDomain;
import org.modelibra.DomainModel;

/* ======= import entry concept entities ======= */

import universite.biblio.livre.Livres;	

/* ======= import non entry external child/parent required concept entities ======= */


/**
 * Biblio generated model. This class should not be changed manually. 
 * Use a subclass to add specific code.
 * 
 * @author Dzenan Ridjanovic
 * @version 2011-09-13
 */
public abstract class GenBiblio extends DomainModel {

	private static final long serialVersionUID = 1315949476395L;
	
	private static Log log = LogFactory.getLog(GenBiblio.class);
	
	private Livres livres;
		
	/**
	 * Constructs a domain model within the domain.
	 * 
	 * @param domain
	 *            domain
	 */
	public GenBiblio(IDomain domain) {
		super(domain);
		livres = new Livres(this);
	}

	/**
	 * Gets Livre entities.
	 * 
	 * @return Livre entities
	 */
	public Livres getLivres() {
		return livres;
	}
	

}
