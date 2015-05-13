/**
 * The matrix class defines a matrix object and its methods.
 */
public class MatrixClient {
	public static void main(String[] args) {
		Matrix one = new Matrix(2,2);
		Matrix two = new Matrix(2,2);
		one.modify(0,0,0);
		one.modify(0,1,1);
		one.modify(1,0,2);
		one.modify(1,1,3);
		two.modify(0,0,0);
		two.modify(0,1,1);
		two.modify(1,0,2);
		two.modify(1,1,3);
		Matrix answer = one.addition(two);
		System.out.print(answer.toString());
		
		
	}
}
