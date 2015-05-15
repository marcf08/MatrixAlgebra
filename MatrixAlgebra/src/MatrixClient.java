/**
 * The matrix class defines a matrix object and its methods.
 */
public class MatrixClient {
	public static void main(String[] args) {
		Matrix one = new Matrix(3,2);
		Matrix two = new Matrix(2,2);
		one.modify(0,0,4);
		one.modify(1,0,8);
		one.modify(1,0,0);
		one.modify(1,1,2);
		one.modify(2,0,1);
		one.modify(2,1,6);
		two.modify(0,0,5);
		two.modify(0,1,2);
		two.modify(1,0,9);
		two.modify(1,1,4);
		Matrix answer = one.multiply(two);
		System.out.print(answer.toString());
		
		
	}
}
