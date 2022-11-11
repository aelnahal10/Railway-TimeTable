package railwaytimetable;

public class Filter extends ReadFile { // find origin and destination index(if names are correct)
	public void find(String o, String d) {
		o = Check(o);
		d = Check(d);
		if (o.equals("") || d.equals("")) {
			System.out.println("Not found");
		} else {
			int o_index = -1, d_index = -1;

			for (int i = 0; i < lines.size(); i++) {
				if (o_index != -1) {
					if (lines.get(i).substring(0, 24).trim().equals(d)) {
						d_index = i;
						break;
					}
				} else if (lines.get(i).substring(0, 24).trim().equals(o)) {
					o_index = i;
					continue;
				}
			}
			if (o_index != -1 && d_index != -1) {
				WriteFilteredTable(o_index, d_index);
			} else {
				System.out.println("Wrong Values");
			}
		}
	}

	public void WriteFilteredTable(int o, int d) { // print table
		for (int i = o; i <= d; i++) {
			System.out.print("\t\t| " + lines.get(i).substring(0, 24) + " | ");
			for (int j = 34; j < lines.get(o).indexOf(';'); j += 6) {
				if (lines.get(o).substring(j, j + 5).trim().equals("-")
						|| lines.get(d).substring(j, j + 5).trim().equals("-")) {
					continue;
				} else {
					System.out.print(lines.get(i).substring(j, j + 5) + " | ");
				}
			}
			System.out.println("");
			if (i == o) {
				i = d - 1;
			}
		}
		// calculate time
		System.out.print("\t\t| " + "JourneyTime             " + " | ");
		for (int j = 34; j < lines.get(o).indexOf(';'); j += 6) {
			if (!(lines.get(o).substring(j, j + 5).trim().equals("-")
					|| lines.get(d).substring(j, j + 5).trim().equals("-"))) {
				int start = Integer.parseInt(lines.get(o).substring(j, j + 5).replace("x", "").trim());
				int sm = start % 100;
				start = start / 100;

				int end = Integer.parseInt(lines.get(d).substring(j, j + 5).replace("x", "").trim());
				int em = end % 100;
				end = end / 100;

				if (sm < em) {
					System.out.print((end - start) + "h," + (em - sm) + "m" + " | ");
				} else if (sm > em) {
					System.out.print((end - start - 1) + "h," + (em - sm + 60) + "m" + " | ");
				}
			}
		}
		System.out.println("");
	}
}
