package lockedme.com;

import java.io.IOException;
import java.util.Scanner;

public class DisplayScreen {
	static FileManager fm = new FileManager();
	final static String ROOT_DIRECTORY_PATH = "C:\\Users\\nikki\\OneDrive\\Desktop\\Locker";

	private static final String WelcomeScreen = "LockedMe.com" + "\nDeveveloped by Ranjith" + "\nVersion 1.0";

	public static void main(String[] args) {
		System.out.println(WelcomeScreen);
		MainMenu();
		try (Scanner es = new Scanner(System.in)) {
			int opt = es.nextInt();
			switch (opt) {
			case 1:
				MainMenu();

			case 2:
				subMenu();
			}
		} catch (Exception e) {
			System.out.println("Please choose 1, 2 or 3");
			MainMenu();
		}
	}

	static void MainMenu() {
		System.out.println("Main Menu");
		System.out.println("1. Display Files");
		System.out.println("2. Add/Remove/Search Files");
		System.out.println("3. Exit Program");
		System.out.println("Enter you choice");
		try  {
			Scanner sc = new Scanner(System.in);
			int opt = sc.nextInt();
			switch (opt) {
			case 1:
				fm.displayFilesInAsc(ROOT_DIRECTORY_PATH);
				MainMenu();
			case 2:
				subMenu();
				break;
			case 3:
				System.out.println("You have been logged off!");
				System.exit(0);
			default:
				System.out.println("Please choose 1, 2, or 3");
				MainMenu();
			}
		} catch (Exception e) {
			System.out.println("Please choose 1, 2, or 3");
			MainMenu();
		}
	}

	static void subMenu() {
		System.out.println("1. Add a file to the directory");
		System.out.println("2. Remove a file from the directory");
		System.out.println("3. Search a file");
		System.out.println("4. Back to Main Menu");
		try {
			Scanner sc = new Scanner(System.in);
			int opt1 = sc.nextInt();
			switch (opt1) {
			case 0:
				System.out.println("Please choose 1, 2, 3, or 4");
				subMenu();
				break;
			case 1:
				String fileName = readFileName(sc);
				try {
					fm.addFile(fileName, ROOT_DIRECTORY_PATH);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				String delFile = readDelFile(sc);
				fm.deleteFile(delFile, ROOT_DIRECTORY_PATH);
				break;
			case 3:
				String fileName2 = readSearchFile(sc);
				fm.searchFile(fileName2, ROOT_DIRECTORY_PATH);
				break;
			case 4:
				MainMenu();
			default:
				System.out.println("Please choose 1, 2, 3, or 4");
			}
			subMenu();
		} catch (Exception e) {
			System.out.println("Please choose 1, 2, 3, or 4");
			subMenu();
		}
	}

	private static String readFileName(Scanner sc) {
		System.out.println("Enter the file name to add");
		sc.nextLine();
		String fileName = sc.nextLine().trim();
		return fileName;
	}

	private static String readDelFile(Scanner sc) {
		System.out.println("Enter the file name to delete");
		sc.nextLine();
		String fileName1 = sc.nextLine().trim();
		return fileName1;
	}

	private static String readSearchFile(Scanner sc) {
		System.out.println("Enter the file name to look for");
		sc.nextLine();
		String fileName2 = sc.nextLine().trim();
		return fileName2;
	}
}