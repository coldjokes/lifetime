package me.lifetime.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {

	public static String getCurrent(){
		return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	}
}
