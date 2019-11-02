import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<SpreadSheet> sheets = new ArrayList<SpreadSheet>();
		String entry;
		String[] entrySplitted;
		int numSheets = readNumSheets(sc);
		int sheetJ = readNumSheets(sc);
		int sheetI = readNumSheets(sc);
		for (int k = 0; k < numSheets; k++) {
			SpreadSheet spreadSheet = getSpreadSheet(sheetI, sheetJ);
			spreadSheet.resolveSpreadSheet();
		}
		
	}

	private static SpreadSheet getSpreadSheet(int sheetI, int sheetJ) {
		// TODO Auto-generated method stub
		return null;
	}

	private static int readNumSheets(Scanner scanner) {
		int tam = scanner.nextInt();
		scanner.nextLine();
		return tam;
	}
}
