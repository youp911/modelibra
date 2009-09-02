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
package education.wicket.app;

import org.modelibra.wicket.app.DomainApp;

import education.Education;
import education.EducationConfig;
import education.PersistentEducation;

/**
 * Education domain web application.
 * 
 * @author Dzenan Ridjanovic
 * @version 2009-03-04
 */
public class EducationApp extends DomainApp {

	/**
	 * Constructs the domain web application.
	 */
	public EducationApp() {
		super(new PersistentEducation(new Education(new EducationConfig().getDomainConfig())));
	}

	/**
	 * Gets the Education domain.
	 * 
	 * @return Education domain
	 */
	public Education getEducation() {
		return (Education) super.getDomain();
	}
	
	/* ============================= */
	/* ======= SPECIFIC CODE ======= */
	/* ============================= */

}
