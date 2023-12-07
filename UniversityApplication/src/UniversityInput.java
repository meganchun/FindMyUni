import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UniversityInput {

	// This method will fill the object array

	UniversityInput() {
		try {
			// Create a Scanner object to get the data from the txt file
			Scanner inputFile = new Scanner(new File("data/UniversityList.txt"));
			// Use the delimiter to split the data when there is a comma
			inputFile.useDelimiter(",|\r\n");
			// Use a for loop to assign each property in the file to
			// a variable, then make a University object and put the object into
			// the object array

			for (int i = 0; i < Map.universityArray.length; i++) {
				String name = inputFile.next();
				String address = inputFile.next();
				String phoneNumber = inputFile.next();
				String link = inputFile.nextLine().substring(1);

				Map.universityArray[i] = new University(name, address, phoneNumber, link);
			}
			// close the file
			inputFile.close();
		}
		// if the file is not found, display an error message
		catch (FileNotFoundException e) {
			System.out.println("File error.");
		}
	}
}
