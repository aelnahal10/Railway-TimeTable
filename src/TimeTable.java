package railwaytimetable;

public class TimeTable extends ReadFile {
	public static int statnum = 1;
	public static int timnum = 1;

	public void writetable() { // StationName:25 d-a:1 times:5 (spaces between them)

		System.out.println("\t " + route + "\n");
		System.out.println("\t " + time);

		for (int i = 10 * (statnum - 1); i < lines.size(); i++) {
			if (i >= 10 * statnum) {
				break;
			}

			// Check for arrival / dep
			if (lines.get(i).substring(24, 27).trim().equals("a")) {
				if (i == lines.size() - 1) {
					CalculateTime();
				}
				continue;
			}

			System.out.print("\t| " + lines.get(i).substring(0, 24) + " ");// StationName
			System.out.print(lines.get(i).substring(27, 34) + " | ");// facility display

			for (int j = 12 * 6 * (timnum - 1) + 34; j < lines.get(i).indexOf(';'); j = j + 6) {
				if (j >= 12 * 6 * timnum + 34) {
					break;
				}
				System.out.print(lines.get(i).substring(j, j + 5) + " |  ");
			}
			System.out.println("");
		}
	}

	public void CalculateTime() {
		System.out.print("\t| " + "JourneyTime                    " + " | ");

		for (int j = 12 * 6 * (timnum - 1) + 34; j < lines.get(0).indexOf(';'); j = j + 6) {
			if (j >= 12 * 6 * timnum + 34) {
				break;
			}

			int start = 0, sm = 0, end = 0, em = 0;
			for (int i = 0; i < lines.size(); i++) {
				if (start != 0) {
					if (!lines.get(i).substring(j, j + 5).trim().equals("-")) {
						end = Integer.parseInt(lines.get(i).substring(j, j + 5).replace("x", "").trim());
						em = end % 100;
						end = end / 100;
					}
				} else if (!lines.get(i).substring(j, j + 5).trim().equals("-")) {
					start = Integer.parseInt(lines.get(i).substring(j, j + 5).replace("x", "").trim());
					sm = start % 100;
					start = start / 100;
				}
			}
			if (sm <= em) {
				System.out.print((end - start) + "h," + (em - sm) + "m" + " | ");
			} else if (sm > em) {
				System.out.print((end - start - 1) + "h," + (em - sm + 60) + "m" + " | ");
			}
		}
		System.out.println("");
	}
}
