import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numSheets = readAnInteger(sc);
		int sheetJ = readAnInteger(sc);
		int sheetI = readAnInteger(sc);
		if (sheetI < 0 || sheetI > 999 || sheetJ < 0 || sheetJ > 18278)
			wrongEntry(sc);
		SpreadSheet[] sol = readAndSolveSpreadSheet(sc, numSheets, sheetI, sheetJ);
		printSpreadSheetSolution(sol);
		sc.close();
	}

	private static void printSpreadSheetSolution(SpreadSheet[] sol) {
		for (int i = 0; i < sol.length; i++)
			System.out.println(sol[i].toString());
	}

	private static int readAnInteger(Scanner scanner) {
		String entry = scanner.nextLine();
		if( !isANum(entry)) 
			wrongEntry(scanner);
		return Integer.parseInt(entry);
	}

	private static String[] getALine(Scanner scanner, int numCols) {
		String entry = scanner.nextLine();
		String[] entrySplitted = entry.split(" ");
		if(entrySplitted.length != numCols)
			wrongEntry(scanner);
		return entrySplitted;
	}

	private static SpreadSheet[] readAndSolveSpreadSheet(Scanner sc, int numSheets, int sheetI, int sheetJ) {
		ArrayList<SpreadSheet> solutions = new ArrayList<SpreadSheet>();
		for (int k = 0; k < numSheets; k++) {
			SpreadSheet spreadSheet = new SpreadSheet(sheetI, sheetJ);
			for (int i = 0; i < sheetI; i++) {
				spreadSheet.fillLine(getALine(sc, sheetJ), i);
			}
			spreadSheet.resolve();
			solutions.add(spreadSheet);
		}
		return solutions.toArray(new SpreadSheet[solutions.size()]);
	}

	public static boolean isANum(String input) {
		try {
			Integer.parseInt(input);
			return true;
		}catch(NumberFormatException e) {
			return false;
		}	
	}
	
	public static boolean isAFormula(String input) {
		if(input.charAt(0) == '=') return true;
		return false;
	}
	
	public static void wrongEntry() {
		System.out.println("Entrada Inválida.");
		System.exit(-1);
	}

	public static void wrongEntry(Scanner scanner) {
		System.out.println("Entrada Inválida.");
		scanner.close();
		System.exit(-1);
	}
}
