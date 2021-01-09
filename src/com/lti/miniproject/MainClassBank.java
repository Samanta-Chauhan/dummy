package com.lti.miniproject;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

public class MainClassBank {

	public void getIssueBasedonBankName(BufferedReader br) throws Exception {

		ArrayList<String> al1 = new ArrayList<>();

		try {
			String line;
			Scanner sc1 = new Scanner(System.in);

			System.out.println("Enter Company Name :");
			String name11 = sc1.next();
			while ((line = br.readLine()) != null) {

				String[] cols = line.split(",");

				if (cols[5].equals(name11)) {
					String QWE = "Issues : " + cols[3] + " || Sub Issues :" + cols[4];

					al1.add(QWE);

				} else
					continue;

			}

		} catch (IOException e) {

			System.out.println("Bank Name not found in DataBase");
		}

		for (String al2 : al1) {
			System.out.println(al2);
		}

	}

	public void getIssueBasedonComplaintID(BufferedReader br) throws Exception {

		ArrayList<String> cid = new ArrayList<>();

		try {
			String line1;
			Scanner sc11 = new Scanner(System.in);
			System.out.println("Enter Complaint ID :");
			String complaint_id = sc11.next();
			while ((line1 = br.readLine()) != null) {

				String[] cols1 = line1.split(",");

				if (cols1[13].equals(complaint_id)) {
					String QWE1 = "Issues : " + cols1[3] + " || Sub Issues :" + cols1[4];

					cid.add(QWE1);

				} else
					continue;

			}

		} catch (IOException e) {

			System.out.println("Complaint ID not found in database");
		}

		for (String cid2 : cid) {
			System.out.println(cid2);
		}

	}

	public void getIssueBasedonYear(BufferedReader br) throws Exception {

		ArrayList<String> year1 = new ArrayList<>();

		try {
			String line;
			Scanner sc2 = new Scanner(System.in);

			System.out.println("Enter Year :");
			String year00 = sc2.next();
			while ((line = br.readLine()) != null) {

				String[] cols2 = line.split(",");
				String input11 = cols2[0];
				String year11 = "";

				if (input11.length() > 4) {
					year11 = input11.substring(input11.length() - 4);

				} else
					year11 = input11;

				if (year11.equals(year00)) {
					String QWE2 = "Year : " + cols2[0] + " || Issue :" + cols2[3] + " || Sub-Issue :" + cols2[4];
					year1.add(QWE2);
				}

			}

		} catch (IOException e) {

			System.out.println("Entered Year Complaints not found in DataBase");
		}

		for (String year2 : year1) {
			System.out.println(year2);
		}

	}

	public void getComplaintsWithTimelyResponse(BufferedReader br) throws Exception {

		ArrayList<String> timely = new ArrayList<>();

		try {
			String line;

			while ((line = br.readLine()) != null) {

				String[] cols4 = line.split(",");

				String name12 = "Yes";

				if (cols4[11].equals(name12)) {
					String QWE4 = "Issues : " + cols4[3] + " || Sub Issues :" + cols4[4] + " || Timely Response :"
							+ cols4[11];

					timely.add(QWE4);

				} else
					continue;

			}

		} catch (IOException e) {

			System.out.println("Complaints not found in DataBase");
		}

		for (String timely2 : timely) {
			System.out.println(timely);
		}

	}

	public void getComplaintsClosedWithExplanation(BufferedReader br) throws Exception {

		ArrayList<String> closed = new ArrayList<>();

		try {
			String line;

			while ((line = br.readLine()) != null) {

				String[] cols5 = line.split(",");

				String name13 = "Closed with explanation";

				if (cols5[10].equals(name13)) {
					String QWE5 = "Issues : " + cols5[3] + " || Sub Issues :" + cols5[4]
							+ " || Company Response to Consumer :" + cols5[10];

					closed.add(QWE5);

				} else
					continue;

			}

		} catch (IOException e) {

			System.out.println("Complaints not found in DataBase");
		}

		for (String closed2 : closed) {
			System.out.println(closed2);
		}

	}

	public void getNoOfDays(BufferedReader br) throws Exception {

		ArrayList<String> days = new ArrayList<>();

		try {
			String line;
			SimpleDateFormat myFormat = new SimpleDateFormat("dd/mm/yyyy");

			while ((line = br.readLine()) != null) {
				String[] cols6 = line.split(",");
				for (int i = 0; i < line.length(); i++) {

					String datestart = cols6[0];
					String dateend = cols6[9];
					Date dateBefore = myFormat.parse(datestart);
					Date dateAfter = myFormat.parse(dateend);
					long difference = dateAfter.getTime() - dateBefore.getTime();
					float daysBetween = (difference / (1000 * 60 * 60 * 24));
					String QWE6 = "Bank Name : " + cols6[5] + " || Days Taken :" + difference;
					days.add(QWE6);
				}

			}

		} catch (IOException e) {

			System.out.println("Bank Name not found in DataBase");
		}

		for (String days2 : days) {
			System.out.println(days2);
		}

	}

	public static void main(String[] args) throws Exception {

		LoadCSV obj = new LoadCSV();
		BufferedReader br = obj.LoadFile();

		MainClassBank c1 = new MainClassBank();

		Scanner ab = new Scanner(System.in);
		System.out.println("Enter the following CASE to perform Operations : " + "\n"
				+ "1.Display all the complaints based on the year provided by the user" + "\n"
				+ "2.Display all the complaints based on the name of the bank provided by the user" + "\n"
				+ "3.Display complaints based on the complaint id provided by the user" + "\n"
				+ "4.Display all the complaints closed/closed with explanation " + "\n"
				+ "5.Display all the complaints which received a timely response ");

		int number1 = ab.nextInt();
		switch (number1) {
		case 1:
			c1.getIssueBasedonYear(br);
			break;

		case 2:
			c1.getIssueBasedonBankName(br);
			break;

		case 3:
			c1.getIssueBasedonComplaintID(br);
			break;

		case 4:
			c1.getComplaintsClosedWithExplanation(br);
			break;

		case 5:
			c1.getComplaintsWithTimelyResponse(br);
			break;

		}
	}

}


