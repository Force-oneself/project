package pers.quan.uitls;

import java.text.SimpleDateFormat;
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

	public static void main(String[] args) {
		// Calendar c = Calendar.getInstance();
		// c.add(Calendar.SECOND, -3600);
		// System.out.println(c.getTime());
		SimpleDateFormat sdf = new SimpleDateFormat();
		/*
		 * Calendar c1 = sdf.getCalendar(); Calendar c2 = sdf.getCalendar(); Date d1 =
		 * c1.getTime(); c1.add(Calendar.SECOND, -3600); Date d2 = c1.getTime();
		 * System.out.println(d1); System.out.println(d2);
		 */

		// System.out.println(c1==c2);

		System.out.println(sdf.format(getDate(null)));
	}
}
