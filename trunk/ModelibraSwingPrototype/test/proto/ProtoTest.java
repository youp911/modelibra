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
package proto;

import org.modelibra.config.DomainConfig;
import org.modelibra.config.ModelConfig;

/**
 * Domain tests. In general, there may be more than one domain model.
 * 
 * @author Dzenan Ridjanovic
 * @version 2011-09-20
 */
public class ProtoTest {
	
	private static ProtoTest protoTest;

	private Proto proto;

	private PersistentProto persistentProto;
	
	private ProtoTest() {
		super();
		open();
	}
	
	public static ProtoTest getSingleton() {
		if (protoTest == null) {
			protoTest = new ProtoTest();
		}
		return protoTest;
	}
	
	private void open() {
		ProtoConfig protoConfig = new ProtoConfig();
		DomainConfig domainConfig = protoConfig.getDomainConfig();
		for (ModelConfig modelConfig : domainConfig.getModelsConfig()) {
			modelConfig.setPersistenceRelativePath(modelConfig
					.getPersistenceRelativePath()
					+ ProtoConfig.SEPARATOR
					+ protoConfig.getModelibraProperties().getTestDirectoryName());
		}
		proto = new Proto(domainConfig);
		persistentProto = new PersistentProto(proto);
	}

	public Proto getProto() {
		return proto;
	}
	
	public void close() {
		if (persistentProto != null) {
			persistentProto.close();
		}
	}
	
}