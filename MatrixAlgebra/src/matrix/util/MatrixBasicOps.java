package matrix.util;

import java.util.ArrayList;

/**
 * Matrix basic operations defines the elementary operations of a matrix class,
 * such as addition, subtraction, multiplication, and division.
 * 
 * @author Marcus
 *
 */
public class MatrixBasicOps {
	/**
	 * Working set provides the arrays of matricies to be used for the
	 * operations.
	 *
	 */
	private ArrayList<Matrix> workingSet;
	/**
	 * The max capacity for operations is 10. This can be adjusted later.
	 */
	private static final int MAX_CAPACITY = 10;
	/**
	 * The front is a constant used for the zero element of some list.
	 */
	private static final int FRONT = 0;

	/**
	 * Instantiate with null constructor.
	 */
	public MatrixBasicOps() {
		workingSet = new ArrayList<Matrix>();
	}

	/**
	 * The addition method adds specified matricies. If the client wants to add
	 * matricies 1, 3, and 5, of the working set, it supplies those arguments to
	 * this method.
	 * 
	 * @param matricies
	 *            an integer array of matricies to add, based on the index of
	 *            the matricies in the working set.
	 */
	public Matrix addition(int[] matricies) {
		try {
			verifyAddition(matricies);
			// At this point both matricies should have the same dimensions

			// Assuming no errors, create a new matrix with the
			// dimensions of the first element of the set of matricies
			// to add. The selection of the first element is arbitrary
			// since addition should be defined for all selected members
			// of the working set.
			Matrix sum = new Matrix(workingSet.get(matricies[FRONT]).getRows(),
					workingSet.get(matricies[FRONT]).getColumns());
			double value = 0;
			for (int i = FRONT; i < sum.getRows(); i++) {
				for (int j = FRONT; j < sum.getColumns(); j++) {
					for (int k = 0; k < matricies.length; k++) {
						value = value + workingSet.get(k).getValue(i, j) + workingSet.get(k).getValue(i, j);
					}					
					sum.modify(i, j, value);
				}
			}
			return sum;
		} catch (IllegalArgumentException e) {
			// Matrix addition not defined.
			// Handle.
		}
		// Shouldn't get here
		return null;

	}

	/**
	 * The private method verifies the possibility of addition.
	 * 
	 * @param matricies
	 *            the list of matricies in the working set to verify before
	 *            addition
	 */
	private void verifyAddition(int[] matricies) {
		// Cannot perform addition if there are no matricies
		if (workingSet.isEmpty()) {
			throw new IllegalArgumentException();
		}

		// Cannot perform addition if there are too many matricies
		if (matricies.length > workingSet.size()) {
			throw new IllegalArgumentException();
		}

		// Check that addition is possible
		for (int i = 0; i < matricies.length; i++) {
			if (workingSet.get(matricies[i]).getRows() != workingSet.get(
					matricies[i]).getColumns()) {
				throw new IllegalArgumentException();
			}

		}
	}

	/**
	 * The multiplication method multiplies the private matrix by one passed as
	 * a parameter.
	 * 
	 * @param matrix
	 *            a matrix to multiply by the private one
	 */
	public Matrix multiply(Matrix matrix) {
		if (matrix.getRows() != this.columns) {
			throw new IllegalArgumentException(
					"Multiplcation not defined for arguments.");
		}
		Matrix product = new Matrix(this.rows, this.columns);
		// Create an array of the rows
		double subProduct = 0; // Varible for result of cell by cell
								// multiplication
		double secondSubProduct = 0;
		int i = 0;
		int j = 0;
		while (i < this.rows) {
			while (j < this.columns) {
				subProduct = getValue(i, j) * matrix.getValue(i, j);
				i++;
			}
			secondSubProduct = getValue(i, j) * matrix.getValue(i, j);
			product.modify(i, j, subProduct + secondSubProduct);
			j++;
		}
		return product;

	}

}
