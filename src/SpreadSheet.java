
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
	
	public void fillSpreadSheet(String[] entry) {
		
		this.actualRow++;
	}

	public void resolveSpreadSheet() {
		// TODO Auto-generated method stub
		
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
