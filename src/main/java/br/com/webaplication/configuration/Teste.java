package br.com.webaplication.configuration;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class Teste {
	public static void main(String[] args) {

		Calendar calendar = Calendar.getInstance();

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd : HH:mm");
		String format = simpleDateFormat.format(calendar.getTime());
		
		System.out.println(format);
		
		

	}

}
