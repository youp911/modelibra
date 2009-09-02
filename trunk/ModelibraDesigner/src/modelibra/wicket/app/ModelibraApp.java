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
package modelibra.wicket.app;

import modelibra.Modelibra;
import modelibra.ModelibraConfig;
import modelibra.PersistentModelibra;

import org.modelibra.wicket.app.DomainApp;

/**
 * Modelibra domain web application.
 * 
 * @author Dzenan Ridjanovic
 * @version 2008-05-28
 */
public class ModelibraApp extends DomainApp {

	/**
	 * Constructs the domain web application.
	 */
	public ModelibraApp() {
		super(new PersistentModelibra(new Modelibra(new ModelibraConfig().getDomainConfig())));
	}

	/**
	 * Gets the Modelibra domain.
	 * 
	 * @return Modelibra domain
	 */
	public Modelibra getModelibra() {
		return (Modelibra) super.getDomain();
	}
	
	/* ============================= */
	/* ======= SPECIFIC CODE ======= */
	/* ============================= */

}
