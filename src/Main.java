import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numSheets = readAnInteger(sc);
		int sheetJ = readAnInteger(sc);
		int sheetI = readAnInteger(sc);
		resolveSpreadsheet(sc, numSheets, sheetI, sheetJ);
		sc.close();
	}

	private static int readAnInteger(Scanner scanner) {
		int tam = scanner.nextInt();
		scanner.nextLine();
		return tam;
	}

	private static String[] getALine(Scanner scanner) {
		return scanner.nextLine().split("");
	}

	private static void resolveSpreadsheet(Scanner sc, int numSheets, int sheetI, int sheetJ) {
		for (int k = 0; k < numSheets; k++) {
			SpreadSheet spreadSheet = new SpreadSheet(sheetI, sheetJ);
			for (int i = 0; i < sheetI; i++) {
				spreadSheet.fillLine(getALine(sc), i);
			}
			spreadSheet.resolve();
			System.out.println(spreadSheet.toString());
		}
	}
}
