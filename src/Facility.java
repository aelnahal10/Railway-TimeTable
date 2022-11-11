package railwaytimetable;

public class Facility extends ReadFile {
	public int timnumFac = 1;

	public boolean Chara(String c) {
		if (c.equals("P")) {
			return true;
		} else if (c.equals("B")) {
			return true;
		} else if (c.equals("D")) {
			return true;
		} else {
			System.out.println("Wrong Option");
			return false;
		}
	}

	public void WriteTable(String c) {
		if (Chara(c) == true) {
			for (int i = 0; i < lines.size(); i++) {
				if (lines.get(i).substring(27, 34).contains(c)) {
					// Check for arrival / dep
					if (lines.get(i).substring(24, 27).trim().equals("a")) {
						continue;
					}
					System.out.print("\t| " + lines.get(i).substring(0, 24) + " ");// StationName
					System.out.print(lines.get(i).substring(27, 34) + " | ");// facility display

					for (int j = 12 * 6 * (timnumFac - 1) + 34; j < lines.get(i).indexOf(';'); j = j + 6) {
						if (j >= 12 * 6 * timnumFac + 34) {
							break;
						}
						System.out.print(lines.get(i).substring(j, j + 5) + " |  ");
					}
					System.out.println("");
				}
			}
		}
	}
}
