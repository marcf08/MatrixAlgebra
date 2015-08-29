package matrix.util;

import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;

public class BasicOpTest {

	public static void main(String[] args) {

		Evaluator firstTry = new Evaluator();
		try {
			System.out.println(firstTry.evaluate("5+5"));
		} catch (EvaluationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
