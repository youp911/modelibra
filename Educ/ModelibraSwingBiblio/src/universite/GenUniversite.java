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
package universite;

import org.modelibra.Domain;
import org.modelibra.config.DomainConfig;

/* ======= import models ======= */

import universite.biblio.Biblio;	

/**
 * Universite generated domain. This class should not be changed manually. 
 * Use a subclass to add specific code.
 * 
 * @author Dzenan Ridjanovic
 * @version 2011-09-13
 */
public abstract class GenUniversite extends Domain {

	private static final long serialVersionUID = 1315949418573L;
	
	private Biblio biblio;
		
	/**
	 * Creates the Universite domain.
	 * 
	 * @param domainConfig
	 *            domain configuration
	 */
	public GenUniversite(DomainConfig domainConfig) {
		super(domainConfig);
		biblio = new Biblio(this);		
	}

	public Biblio getBiblio() {
		return biblio;
	}
		
}