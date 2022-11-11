package railwaytimetable;

public class LiveBoard extends ReadFile {
	public void FindDes(String d) {
		d = Check(d);
		if (d.equals("")) {
			System.out.println("Not found");
		} else {
			int d_index = -1;
			for (int i = 0; i < lines.size(); i++) {
				if (lines.get(i).substring(0, 24).trim().equals(d)) {
					d_index = i;
					break;
				}
			}
			if (d_index != -1) {
				WriteDetails(d_index);
			} else {
				System.out.println("Wrong value");
			}
		}
	}

	public void WriteDetails(int d) {
		System.out.println("\t Dep      status      platform");
		for (int j = 34; j < lines.get(d).indexOf(';'); j += 6) {
			if (lines.get(d).substring(j, j + 5).trim().equals("-")) {
				continue;
			} else {
				System.out.print("\t " + lines.get(d).substring(j, j + 5).trim());
				// random status
				if (j % 5 == 1) {
					System.out.print("      OnTime ");
				} else if (j % 5 == 2) {
					System.out.print("     Delayed " + "      1");
				} else {
					System.out.print("     Canceled");
				}
			}
			System.out.println("");
		}
	}
}
