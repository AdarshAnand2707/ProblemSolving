package stack;

import java.util.Stack;

public class PostFixExpressionEvaluator {
	
	public static int evaluate (char[] expression) {
		if (expression == null || expression.length == 0) {
			return 0;
		}
		Stack<Integer> operand = new Stack<Integer>();
		for (char ch : expression) {
			if (ExpressionEvaluatorUtil.isOperand(ch)) {
				operand.push(ch - '0');
			} else if (ExpressionEvaluatorUtil.isOperator(ch)) {
				operand.push(ExpressionEvaluatorUtil.evaluate(operand.pop(), operand.pop(), ch));
			}
		}
		return operand.pop();
	}

	public static void main(String[] args) {
		String expression = "231*+9-";
		char[] charArr = expression.toCharArray();
		System.out.println(evaluate(charArr));
	}

}
