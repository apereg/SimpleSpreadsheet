
public class SpreadSheet {
	
	private int numRows;
	
	private int numCols;
	
	private int actualRow;
	
	private String[][] entry;
	
	private int[][] solution;
	
	public SpreadSheet(int i, int j) {
		this.numRows = i;
		this.numCols = j;
		this.entry = new String[numRows][numCols];
		this.solution = new int[numRows][numCols];
		this.actualRow = 0;
	}
	
	public void fillLine(String[] entry) {
		for (int i = 0; i < entry.length; i++) {
			try {
				solution[this.actualRow][i] = Integer.parseInt(entry[i]);
				this.entry[this.actualRow][i] = null;
			}catch(NumberFormatException e) {
				this.entry[this.actualRow][i] = entry[i];
			}
		}
		this.actualRow++;
	}

	public void resolve() {
		System.out.println("jaja");
		
	}
	
	private int getCell(String position) {
		return 0;
	}
	
	private void resolveCell(int i, int j) {
		
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
