package pers.quan.uitls;

/**
 *
 * @Discription 时间工具
 * @author John丶Woo
 * @date 2019年11月9日 下午5:45:43
 *
 */
public class DateUtils {

	public static boolean isLeapYear(String year) {
		return isLeapYear(Integer.valueOf(year));
	}

	public static boolean isLeapYear(int year) {
		return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}
}
