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
	
	public void fillLine(String[] input, int row) {
		for (int j = 0; j < this.numCols; j++) {
			if (Main.isANum(input[j]))
				this.solution[row][j] = Integer.parseInt(input[j]);
			else
				this.entry[row][j] = input[j];

		}
	}

	public void resolve() {
		
		for (int i = 0; i < this.numRows; i++) {
			for (int j = 0; j < this.numCols; j++) {
				if(!(this.entry[i][j].isEmpty())) {
					int result = resolveFormula(this.entry[i][j]);
					this.solution[i][j] = result;
					this.entry[i][j] = "";
				}
			}
		}
	}
	
	private int resolveCell(int row, int col) {
		if (row > this.numRows || row < 0 || col > this.numCols || col < 0)
			Main.wrongEntry();
		if (!(this.entry[row][col].isEmpty())) 
			return resolveFormula(this.entry[row][col]);
		return this.solution[row][col];
	}
	
	private int getAsciiNum(char c) {
		return(((int)c)-64);
	}
	
	private int getFormulaCol(String s) {
		int suma = 0;
		for (int i = 0; i < s.length(); i++)
			suma += Math.pow(26, i) * getAsciiNum(s.charAt(i));
		return suma;
	}
	
	private int resolveFormula(String formula) {
		int result = 0;
		formula = formula.substring(1, formula.length());
		formula = formula.replaceAll("\\+", ",");
		String[] formulaSplitted = formula.split(",");
		for (int i = 0; i < formulaSplitted.length; i++) {
			StringBuffer Num = new StringBuffer();
			StringBuffer Letter = new StringBuffer();	
			for (int k = 0; k < formulaSplitted[i].length(); k++) {
				if(Main.isANum(formulaSplitted[i].substring(k, k+1)))
					Num.append(formulaSplitted[i].charAt(k));
				else
					Letter.append(formulaSplitted[i].charAt(k));
			
			}
			if(Num.toString().isEmpty() || Letter.toString().isEmpty())
				Main.wrongEntry();
			int num = Integer.parseInt(Num.toString())-1;
			int letra = getFormulaCol(Letter.toString())-1;
			result += resolveCell(num, letra);
		}
		return result;
	}

	@Override
	public String toString() {
		StringBuffer out = new StringBuffer();
		for (int i = 0; i < numRows; i++) {
			if(i!=0)
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

