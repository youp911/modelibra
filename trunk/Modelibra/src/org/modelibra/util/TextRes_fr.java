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
package org.modelibra.util;

import java.io.IOException;
import java.util.PropertyResourceBundle;

/**
 * @author Dzenan Ridjanovic
 * @version 2005-05-27
 */
public class TextRes_fr extends PropertyResourceBundle {

	TextRes_fr() throws IOException {
		super(TextRes_fr.class.getResourceAsStream("TextRes_fr.properties"));
	}

}
