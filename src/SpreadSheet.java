
public class SpreadSheet {
	
	private String[][] entry;

	private int[][] solution;

	private int numRows;
	
	private int numCols;
	
	public SpreadSheet(int i, int j) {
		this.numRows = i;
		this.numCols = j;
		this.entry = new String[numRows][numCols];
		this.solution = new int[numRows][numCols];
		for (i = 0; i < this.numRows; i++) {
			for (j = 0; j < this.numCols; j++) {
				entry[i][j] = "";
			}
		}
	}
	
	private boolean isANum(String input) {
		try {
			Integer.parseInt(input);
			return true;
		}catch(NumberFormatException e) {
			return false;
		}	
	}

	public void fillLine(String[] input, int row) {
		for (int j = 0; j < this.numCols; j++) {
			if (isANum(input[j]))
				this.solution[row][j] = Integer.parseInt(input[j]);
			else
				this.entry[row][j] = input[j];

		}
	}

	public void resolve() {
		for (int i = 0; i < this.numRows; i++) {
			for (int j = 0; j < this.numCols; j++) {
				if(this.entry[i][j] != "") {
					resolveFormula(this.entry[i][j]);
					this.entry[i][j] = "Solved";
				}
			}
		}
	}
	
	private int resolveCell(int row, int col) {
		if (this.entry[row][col] == "") {
			return resolveFormula(this.entry[row][col]);
		}
		return this.solution[row][col];
	}
	
	
	private int resolveFormula(String formula) {
		formula = formula.substring(1, (formula.length()-1));
		String[] formulaSplitted = formula.split("+");
		int result = 0;
		for (int i = 0; i < formulaSplitted.length; i++) {
			for (int k = 0; k < formulaSplitted[i].length()-1; k++) {
				if(isANum(formulaSplitted[i].substring(k, k))) {
					
				}
			}
		}
		return result;
	}

	@Override
	public String toString() {
		StringBuffer out = new StringBuffer();
		for (int i = 0; i < numRows; i++) {
			out.append("\n");
			for (int j = 0; j < numCols; j++) {
				out.append(solution[i][j]);
				if(j != numCols-1) {
					out.append(" ");
				}
			}
		}
		return out.toString();
		
	}

}
