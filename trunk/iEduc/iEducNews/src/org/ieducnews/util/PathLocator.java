package org.ieducnews.util;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;

public class PathLocator {

	public String getClassBasedPath(Class<?> claz, String localPath) {
		URL fileUrl = claz.getResource(localPath);
		return getPath(fileUrl);
	}

	public String getPath(URL url) {
		String filePath = null;
		try {
			if (url != null) {
				filePath = URLDecoder.decode(url.getFile(), "UTF-8");
			}
		} catch (UnsupportedEncodingException e) {
			System.out.println(e.getMessage());
		}
		return filePath;
	}

}
