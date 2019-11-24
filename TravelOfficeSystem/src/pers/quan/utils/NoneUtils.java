package pers.quan.utils;

import java.util.Collection;
import java.util.Date;

/**
 *
 * @Discription 空白和为空判断工具
 * @author John丶Woo
 * @date 2019年11月9日 下午5:25:24
 *
 */
public class NoneUtils {

	public static Date getDate(Date date) {
		if (date == null) {
			date = new Date(0);
		}
		return date;
	}

	public static boolean isBlank(String str) {
		return str == null || str.trim().equals("");
	}

	public static boolean isNonBlank(String str) {
		return !isBlank(str);
	}

	public static String getValue(String val, String defaultVal) {
		return NoneUtils.isBlank(val) ? defaultVal : val;
	}

	public static <T> boolean isEmpty(Collection<T> collection) {
		return collection == null || collection.isEmpty();
	}

	public static <T> boolean isNonEmpty(Collection<T> collection) {
		return !isEmpty(collection);
	}

	public static boolean isEmpty(Object[] array) {
		return array == null || array.length == 0;
	}

	public static boolean isNonEmpty(Object[] array) {
		return !isEmpty(array);
	}

	public static void removeNull(String... str) {
		for (int i = 0; i < str.length; i++) {
			if (str[i] == null) {
				str[i] = "";
			}
		}
	}
}
