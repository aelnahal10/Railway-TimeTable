package railwaytimetable;

import java.util.Scanner;

public class Rail {
	public static void main(String[] args) {
		System.out.println("Welcome to railway application");
		Scanner input = new Scanner(System.in);
		System.out.println("Enter full name or CRS code:");
		String f = input.nextLine();
		TimeTable t = new TimeTable();
		if (t.loadfile(f.trim()) == true) {
			t.writetable();
			while (!f.equals("Quit")) {
				/*
				 * if(f.equals("filter") || f.equals("LiveBoard")) {
				 * System.out.println("choose an option: table: back to time table"); f =
				 * input.next(); if(f.equals("table")) {t.writetable();} else
				 * {System.out.println("Wrong option");} } else {
				 */
				System.out.println("choose an option:");
				System.out.println("1-down-up-forward-backward");
				System.out.println("2-Facility");
				System.out.println("3-Filter");
				System.out.println("4-LiveBoard");
				System.out.println("5-Quit");
				f = input.next();
				features(f);
				// }
			}
		}
	}

	public static void features(String f) {
		if (f.equals("down")) {
			TimeTable t = new TimeTable();
			if (t.statnum >= (double) t.lines.size() / 10) {
				System.out.println("Wrong option");
			} else {
				t.statnum++;
				t.writetable();
			}
		} else if (f.equals("up")) {
			TimeTable t = new TimeTable();
			if (t.statnum != 1) {
				t.statnum--;
				t.writetable();
			} else {
				System.out.println("Wrong option");
			}
		} else if (f.equals("forward")) {
			TimeTable t = new TimeTable();
			t.timnum++;
			if (12 * 6 * (t.timnum - 1) + 27 >= (t.lines.get(0).indexOf(';'))) {
				t.timnum--;
				System.out.println("Wrong option");
			} else {
				t.writetable();
			}
		} else if (f.equals("backward") || f.contentEquals("back")) {
			TimeTable t = new TimeTable();
			if (t.timnum != 1) {
				t.timnum--;
				t.writetable();
			} else {
				System.out.println("Wrong option");
			}
		} else if (f.equals("filter") || f.contentEquals("Filter")) {
			Scanner input = new Scanner(System.in);
			System.out.println("Enter origin:");
			String ori = input.nextLine().trim();
			System.out.println("Enter destination:");
			String des = input.nextLine().trim();
			Filter s = new Filter();
			s.find(ori, des);
		} else if (f.equals("facility") || f.contentEquals("Facility")) {
			Scanner input = new Scanner(System.in);
			System.out.println("Enter facility P or B or D:");
			String facilty = input.nextLine().trim();
			Facility fa = new Facility();
			fa.WriteTable(facilty);
		} else if (f.equals("LiveBoard")) {
			Scanner input = new Scanner(System.in);
			System.out.println("Enter destination:");
			String des = input.nextLine().trim();
			LiveBoard lb = new LiveBoard();
			lb.FindDes(des);
		} else if (f.equals("Quit") || f.contentEquals("q") || f.contentEquals("Q")) {
			System.out.println("Thank You");
		} else {
			System.out.println("Wrong option");
		}
	}
}
