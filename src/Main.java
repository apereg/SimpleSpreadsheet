import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numSheets = readAnInteger(sc);
		SpreadSheet[] sol = readAndSolveSpreadSheet(sc, numSheets);
		printSpreadSheetSolution(sol);
		sc.close();
	}

	private static int[] readTwoIntegers(Scanner scanner) {
		String entry = scanner.nextLine();
		String[] entrySplitted = entry.split(" ");
		if (entrySplitted.length != 2 || !isANum(entrySplitted[0]) || !isANum(entrySplitted[1]) ) 
			wrongEntry(scanner);
		int[] result = {Integer.parseInt(entrySplitted[0]), Integer.parseInt(entrySplitted[1])};
		return result;
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

	private static SpreadSheet[] readAndSolveSpreadSheet(Scanner sc, int numSheets) {
		ArrayList<SpreadSheet> solutions = new ArrayList<SpreadSheet>();
		for (int k = 0; k < numSheets; k++) {
			int[] sheetDim = readTwoIntegers(sc);
			int sheetJ = sheetDim[0];
			int sheetI = sheetDim[1];
			if (sheetI < 0 || sheetI > 999 || sheetJ < 0 || sheetJ > 18278)
				wrongEntry(sc);
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
		System.out.println("Entrada del Inválida.");
		scanner.close();
		System.exit(-1);
	}
}
