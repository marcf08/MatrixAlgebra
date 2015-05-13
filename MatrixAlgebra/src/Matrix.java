import java.util.*;
/**
 * The matrix class defines a matrix object and its methods.
 */
public class Matrix {
	/**Number of rows**/
	private int rows;
	/**Number of columns**/
	private int columns;
	/**The matrix object**/
	private double [][] matrix;
	/**The values obtained from the user to store in the matrix**/
	private double [] values;
	/**This is the total number of cells in the matrix.**/
	private int totalCells;
	/**This represents a row of the matrix. It will change
	 * if the client should access a row directly.**/
	private double [] row;
	/**This represents a column of the matrix. It will change
	 * if the client should access a row directly.**/
	private double [] column;
		
	/**The default constructor creates a 1 by 1 matrix.*/
	public Matrix() {
		this.rows = 1;
		this.columns = 1;
		this.matrix = new double[this.rows][this.columns];
		this.totalCells = this.rows * this.columns;
		values = new double[totalCells];
	}
	/**This constructor allows for construction with rows and columns.*/
	public Matrix(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		this.matrix = new double[this.rows][this.columns];
		this.totalCells = this.rows * this.columns;
		values = new double[totalCells];
	}
	/**The setValues method sets the values of the matrix object.
	 * It takes a one dimensional matrix as a list of values and converts
	 * that list into a proper two-dimensional matrix using the row and 
	 * column information. If called, it will automatically override all values
	 * currently in the matrix.*/
	public void setValues() {
		//This gets its own coding so we can check user input in the while-loop instead of
		//doing it inside the nested for-loops where we actually populate the matrix.
		int i = 0; //Variable for while loop
		System.out.print("First value?: ");
		Scanner console = new Scanner(System.in);
		while (!console.hasNextDouble()) {
			console.next(); //Discard invalid input
		}
		double input = console.nextDouble();
		values[i] = input;
		i++; //Increment i or else the first value will simply get replaced
		while (i < values.length) {
			System.out.print("Next value?: ");
			while (!console.hasNextDouble()) {
				console.next(); //Discard invalid input
				System.out.println("Invalid value. Must be real number. Try again.");
			}
			input = console.nextInt();
			values[i] = input;
			i++;
		}
		console.close();
		int k = 0; //Counter for values matrix
		//This is used because we have nested for-loops controlling
		//the population of the matrix.
		for (int l = 0; l < matrix.length; l++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[l][j] = values[k];
				k++;
			}
			
		}

	}
	
	/**Simple accessor method for number of rows.*/
	public int getRows() {
		return this.rows;
	}
	
	/**Simple accessor method for number of columns.*/
	public int getColumns() {
		return this.columns;
	}
	
	/**The toString method overrides the default toString method.
	 * @return output the String representation of the matrix
	 * @override the default String*/
	public String toString() {
		String output = "";
		for (int l = 0; l < matrix.length; l++) {
			for (int j = 0; j < matrix[0].length; j++) {
				output = output + " " + matrix[l][j];
			}
			output = output + "\n";
		}
		return output;
	}
	
	/**The equals method compares two matricies for equality.
	 * @return true if the matricies are equal, and false otherwise
	 * @override the default equals method*/
	public boolean equals(Object o) {
		if (o instanceof Matrix) {
			if (Arrays.deepEquals(matrix, (Object[]) o)) {
				return true;
			}
			else {
				return false;
			}
		}
		return false;
		
	}
	/**The getMatrixArray method returns the matrix as an array.
	 * @return array an array representation of the matrix.*/
	public double[][] getMatrixArray() {
		double [][] array = new double[this.rows][this.columns];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j <matrix[0].length; j++) {
				array[i][j] = matrix[i][j];
			}
		}
		return array;
	}
	
	/**The modify method allows for the editing of a matrix as
	 * if it were an array.
	 * @param row a row of the matrix to modify
	 * @param column a column of the matrix modify
	 * @param value the individual value to modify
	 */
	public void modify(int row, int column, double value) {
		if (row < 0 || row > this.rows) {
			throw new IllegalArgumentException("Invalid rows.");
		} if (column < 0 || column > this.columns) {
			throw new IllegalArgumentException("Invalid columns.");
		}
		//Proper input is expected at this point
		this.matrix[row][column] = value;
	}
	/**The getValue method returns the value of a given cell in 
	 * a matrix object.
	 * @param row a row of the matrix
	 * @param column a column of the matrix
	 */
	public double getValue(int row, int column) {
		if (row < 0 || row > this.rows) {
			throw new IllegalArgumentException("Invalid rows.");
		} if (column < 0 || column > this.columns) {
			throw new IllegalArgumentException("Invalid columns.");
		}
		return this.matrix[row][column];
	}
	/**The fetchRow method returns a row in the form an array.
	 * @param rowNumber the row to return
	 * @return row an array representation of a specified row
	 */
	public double[] fetchRow(int rowNumber) {
		if (rowNumber < 0 || rowNumber > this.rows) {
			throw new IllegalArgumentException("Invalid rows.");
		}
		//A row will contain a number of elements equal to the number of columns
		double[] row = new double[this.columns];
		for (int i = 0; i < this.columns; i++) {
			row[i] = getValue(rowNumber, i);
		}
		return row;
	}
	/**The fetchColumn method returns a column in the form an array.
	 * @param columnNumber the column to return
	 * @return column an array representation of a specified column
	 */
	public double[] fetchColumn(int columnNumber) {
		if (columnNumber < 0 || columnNumber > this.columns) {
			throw new IllegalArgumentException("Invalid columns.");
		}
		//A row will contain a number of elements equal to the number of rows
		double[] column = new double[this.rows];
		for (int i = 0; i < this.rows; i++) {
			column[i] = getValue(i, columnNumber);
		}
		return column;
	}
	
	
	
	/**The addition method adds a matrix to the other. 
	 * @param matrix a matrix to add to the private one
	 */
	public Matrix addition(Matrix matrix) {
		if (matrix.getRows() != this.rows || matrix.getColumns() != this.columns) {
			//Addition is undefined for matricies of different sizes
			throw new IllegalArgumentException("Unequal dimensions.");
		}
		//At this point both matricies must have the same dimensions
		Matrix sum = new Matrix(this.rows, this.columns);
		double value = 0;
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.columns; j++) {
				value = getValue(i,j) + matrix.getValue(i,j);
				sum.modify(i,j,value); 
			}
		}
		return sum;
	}
	
	/**The multiplication method multiplies the private matrix by 
	 * one passed as a parameter. 
	 * @param matrix a matrix to multiply by the private one
	 */
	public Matrix multiply(Matrix matrix){
		if (matrix.getRows() != this.columns) {
			throw new IllegalArgumentException("Multiplcation not defined.");
		}
		Matrix product = new Matrix(this.rows, this.columns);
		double[]
		
	}
	
	
	
	
	
}
