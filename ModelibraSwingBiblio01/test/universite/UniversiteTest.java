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

import org.modelibra.config.DomainConfig;
import org.modelibra.config.ModelConfig;

/**
 * Domain tests. In general, there may be more than one domain model.
 * 
 * @author Dzenan Ridjanovic
 * @version 2011-09-13
 */
public class UniversiteTest {
	
	private static UniversiteTest universiteTest;

	private Universite universite;

	private PersistentUniversite persistentUniversite;
	
	private UniversiteTest() {
		super();
		open();
	}
	
	public static UniversiteTest getSingleton() {
		if (universiteTest == null) {
			universiteTest = new UniversiteTest();
		}
		return universiteTest;
	}
	
	private void open() {
		UniversiteConfig universiteConfig = new UniversiteConfig();
		DomainConfig domainConfig = universiteConfig.getDomainConfig();
		for (ModelConfig modelConfig : domainConfig.getModelsConfig()) {
			modelConfig.setPersistenceRelativePath(modelConfig
					.getPersistenceRelativePath()
					+ UniversiteConfig.SEPARATOR
					+ universiteConfig.getModelibraProperties().getTestDirectoryName());
		}
		universite = new Universite(domainConfig);
		persistentUniversite = new PersistentUniversite(universite);
	}

	public Universite getUniversite() {
		return universite;
	}
	
	public void close() {
		if (persistentUniversite != null) {
			persistentUniversite.close();
		}
	}
	
}