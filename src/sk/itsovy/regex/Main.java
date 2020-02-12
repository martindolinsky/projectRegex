package sk.itsovy.regex;

import sk.itsovy.data.DataIP;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
		DataIP dataIP = new DataIP();
		ipAddressRegex(dataIP.get());
    }

    public static void ipAddressRegex(List<String> list) {
		Pattern pattern = Pattern.compile(
				"^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$");
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) != null) {
				Matcher matcher = pattern.matcher(list.get(i));
				if (matcher.find()) {
					System.out.println("VALID IP: " + matcher.group());
				}
			}
		}
	}

	public static void personalIDRegex(List<String> list) {
		Pattern pattern = Pattern.compile(
				"^[0-9]{2}[0156][0-9]{3}\\/?[0-9]{3,4}$");
		for (String s: list) {
			if (s != null) {
				Matcher matcher = pattern.matcher(s);
				if (matcher.find()) {
					System.out.println("VALID IP: " + matcher.group());
				}
			}
		}
	}
}
