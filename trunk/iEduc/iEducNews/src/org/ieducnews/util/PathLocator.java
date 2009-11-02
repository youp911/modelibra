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
package org.ieducnews.util;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;

public class PathLocator {

	public URL getClassBasedUrl(Class<?> claz, String localPath) {
		return claz.getResource(localPath);
	}

	/**
	 * Gets the file path given a local path anchored to the class base.
	 * 
	 * @param claz
	 *            class that is an anchor point
	 * @param localPath
	 *            local path
	 * @return file path
	 */
	public String getClassBasedPath(Class<?> claz, String localPath) {
		URL fileUrl = getClassBasedUrl(claz, localPath);
		return getPath(fileUrl);
	}

	/**
	 * Gets the file path given a url.
	 * 
	 * @param url
	 *            url
	 * @return file path
	 */
	public String getPath(URL url) {
		String filePath = null;
		try {
			if (url != null) {
				filePath = URLDecoder.decode(url.getFile(), "UTF-8");
			}
		} catch (UnsupportedEncodingException e) {
			System.out.println(e.getMessage() + " // problem with UTF-8");
		}
		return filePath;
	}

}
