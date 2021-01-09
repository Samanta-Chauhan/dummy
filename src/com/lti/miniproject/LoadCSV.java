package com.lti.miniproject;

import java.io.*;

public class LoadCSV {

	public BufferedReader LoadFile() {
		String line = "";
		try {
			// parsing a CSV file into BufferedReader class constructor

			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\HP\\Desktop\\Mini\\complaints.csv"));

			return br;

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}



