package me.lifetime;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

	public static void main(String[] args) {
		
		Date current = new Date();

		String name = new SimpleDateFormat("yyyyMMddHHmmss").format(current);
		
		System.out.println(name);
	}
}
