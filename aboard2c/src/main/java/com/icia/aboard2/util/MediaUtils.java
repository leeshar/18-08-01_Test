package com.icia.aboard2.util;

import java.util.*;

import org.springframework.http.*;

public class MediaUtils {
	private static Map<String, MediaType> mediaMap;
	static{
		mediaMap = new HashMap<String, MediaType>();		
		mediaMap.put("JPG", MediaType.IMAGE_JPEG);
		mediaMap.put("GIF", MediaType.IMAGE_GIF);
		mediaMap.put("PNG", MediaType.IMAGE_PNG);
	}
	public static MediaType getMediaType(String type){
		return mediaMap.get(type.toUpperCase());
	}
}
