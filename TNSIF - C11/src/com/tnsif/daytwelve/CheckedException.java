//Program to use checked Exception
package com.tnsif.daytwelve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckedException {
	static String acceptText() throws IOException {
		BufferedReader br;
		InputStreamReader isr = new InputStreamReader(System.in);
		br = new BufferedReader(isr);
		System.out.println("Enter the string: ");
		String str = br.readLine();
		return str;
	}

}
