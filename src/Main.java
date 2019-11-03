import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String entry;
		int numSheets = readNumSheets(sc);
		int sheetJ = readNumSheets(sc);
		int sheetI = readNumSheets(sc);
		for (int k = 0; k < numSheets; k++) {
			SpreadSheet spreadSheet = new SpreadSheet(sheetI, sheetJ);
			for (int i = 0; i < sheetI; i++) {
				entry = sc.nextLine();
				spreadSheet.fillLine(entry.split(" "));
			}
			spreadSheet.resolve();
			spreadSheet.toString();
		}
		
	}

	private static int readNumSheets(Scanner scanner) {
		int tam = scanner.nextInt();
		scanner.nextLine();
		return tam;
	}
}
