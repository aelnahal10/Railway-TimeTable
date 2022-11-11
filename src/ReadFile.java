package railwaytimetable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
	public static List<String> lines = new ArrayList<String>();
	public static String route;
	public static String time;

	public boolean loadfile(String f) {
		f = Check(f);
		if (f.equals("")) {
			System.out.println("Not found");
			return false;
		}
		try { // useDelimiter
			BufferedReader abc = new BufferedReader(
					new FileReader("C:\\Users\\abdal\\eclipse-workspace\\Railway Timetable\\" + f + ".txt"));
			while (true) {
				String line = abc.readLine();
				if (line == null) {
					break;
				} else if (line.contains("#")) {
					route = line;
				} else if (line.contains(":")) {
					time = line;
				} else {
					lines.add(line);
				}
			}
			abc.close();
			return true;
		} catch (Exception e) {
			System.out.println("file not found");
			return false;
		}
	}

	// .csv file values
	public String Check(String f) {
		String c = "";
		try {
			BufferedReader abc = new BufferedReader(
					new FileReader("C:\\Users\\abdal\\eclipse-workspace\\Railway Timetable\\stations.csv"));
			while (true) {
				String line = abc.readLine();
				if (line == null) {
					break;
				}
				String data[] = line.split(",");
				for (int i = 0; i < data.length; i++) {
					if (data[i].equals(f)) {
						if (f.length() == 3) {
							System.out.println(data[i - 1] + "," + data[i]);
							c = data[i - 1];
							break;
						} else {
							System.out.println(data[i + 1] + "," + data[i]);
							c = f;
							break;
						}
					}
				}
				if (!c.equals("")) {
					break;
				}
			}
			return c;
		} catch (Exception e) {
			System.out.println("Stationfile not found");
			return c;
		}
	}
}
