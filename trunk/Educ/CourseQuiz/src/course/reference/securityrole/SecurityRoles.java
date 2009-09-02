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
package course.reference.securityrole;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modelibra.IDomainModel;

/* ======= import internal parent entity class ======= */

/* ======= import external parent entity and entities classes ======= */

/**
 * SecurityRole specific entities.
 * 
 * @author Dzenan Ridjanovic
 * @version 2007-12-25
 */
public class SecurityRoles extends dm.reference.securityrole.SecurityRoles {

	private static final long serialVersionUID = 1176561884336L;

	private static Log log = LogFactory.getLog(SecurityRoles.class);

	/* ======= base constructor ======= */

	/**
	 * Constructs securityRoles within the domain model.
	 * 
	 * @param model
	 *            model
	 */
	public SecurityRoles(IDomainModel model) {
		super(model);
	}

	/* ======= parent argument constructors ======= */

	/* ============================= */
	/* ======= SPECIFIC CODE ======= */
	/* ============================= */

}