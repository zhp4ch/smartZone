package com.mass.biz.utils;
import java.util.List;
import java.util.Map;
public class StringUtil {
	public static boolean isListEmpty(Object list) {
		if (list instanceof java.util.List) {
			if (list != null && !((List<Object>) list).isEmpty()) {
				return false;
			} else {
				return true;
			}
		} else {
			return true;
		}
	}

	public static boolean isMapEmpty(Object list) {
		if (list instanceof java.util.Map) {
			if (list != null && !((Map<Object, Object>) list).isEmpty()) {
				return false;
			} else {
				return true;
			}
		} else {
			return true;
		}
	}

	public static boolean isMapContainsKey(Map map, Object key) {
		if (isMapEmpty(map)) {
			return false;
		} else {
			if (map.containsKey(key)) {
				return true;
			} else {
				return false;
			}
		}
	}

	public static boolean isEmpty(String str) {
		if (str != null && !"".equals(str)) {
			return false;
		} else {
			return true;
		}
	}

	public static String removeLast(String str) {
		if (!isEmpty(str)) {
			return str.substring(0, str.length() - 1);
		} else {
			return str;
		}
	}
}
