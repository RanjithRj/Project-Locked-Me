package lockedme.com;

import java.io.File;
import java.util.Arrays;
import java.io.IOException;

public class FileManager {
	public void displayFilesInAsc(String directoryPath) {
		try {
			File f = new File(directoryPath);
			File[] files = f.listFiles();
			Arrays.sort(files);
			for (File fileEntry : files)
				System.out.println(fileEntry.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addFile(String fileName, String directoryPath) throws IOException {
		try {
			File directory = new File(directoryPath);
			if (directory.isDirectory()) {
				File f = new File(directoryPath + "/" + fileName);
				if (!f.exists()) {
					f.createNewFile();
					System.out.println(fileName + " " + "has been added successfully");
				} else {
					System.out.println("File already exists");
				}
			}
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("Please enter a file name");
		}

	}

	public void deleteFile(String fileName1, String directoryPath) {
		boolean isDeleted = false;
		boolean isExisted = false;
		try {
			File f = new File(directoryPath);
			File[] files = f.listFiles();
			for (File fileEntry : files) {
				if (fileEntry.getName().equals(fileName1)) {
					isExisted = true;
					if (fileEntry.delete())
						isDeleted = true;
				}
			}
			if (isExisted && isDeleted)
				System.out.println(fileName1 + " " + "has been delted successfully");
			else
				System.out.println("File Not Found");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void searchFile(String fileName2, String directoryPath) {
		boolean isExisted = false;
		try {
			File f = new File(directoryPath);
			File[] files = f.listFiles();
			for (File fileEntry : files) {
				if (fileEntry.isFile()) {
					if (fileEntry.getName().equals(fileName2))
						isExisted = true;
				}
			}
			if (isExisted)
				System.out.println(fileName2 + " " + "has been found");
			else
				System.out.println("File Not Found");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
