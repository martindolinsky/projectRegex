package sk.itsovy.regex;

import sk.itsovy.data.DataIP;
import sk.itsovy.data.Date;
import sk.itsovy.data.MacAddress;
import sk.itsovy.data.PersonalID;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
		DataIP dataIP = new DataIP();
		PersonalID personalID = new PersonalID();
		MacAddress macAddress = new MacAddress();
		Date date = new Date();
		ipAddressRegex(dataIP.get());
		System.out.println();
		personalIDRegex(personalID.get());
		System.out.println();
		macAddressRegex(macAddress.get());
		System.out.println();
		dateRegex(date.get());
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
					System.out.println("VALID ID: " + matcher.group());
				}
			}
		}
	}

	public static void macAddressRegex(List<String> list) {
		Pattern pattern = Pattern.compile(
				"^([0-9A-Fa-f][0-9A-Fa-f][\\:]){5}[0-9A-Fa-f]{2}$");
		for (String s: list) {
			if (s != null) {
				Matcher matcher = pattern.matcher(s);
				if (matcher.find()) {
					System.out.println("VALID MAC: " + matcher.group());
				}
			}
		}
	}

	public static void dateRegex(List<String> list) {
		Pattern pattern = Pattern.compile(
				"^((([1-9]|[12][0-9]|3[0-1])\\.(1|3|5|7|8|10|12))|(([1-9]|[12][0-9]|30)\\.(4|6|9|11))|(([1-9]|[12][0-9])\\.2))\\.(19|20)[0-9]{2}$");
		for (String s: list) {
			if (s != null) {
				Matcher matcher = pattern.matcher(s);
				if (matcher.find()) {
					System.out.println("VALID DATE: " + matcher.group());
				}
			}
		}
	}
}
