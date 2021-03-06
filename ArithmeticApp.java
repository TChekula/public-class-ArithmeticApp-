
import java.lang.*;




public class ArithmeticApp {
	
	public static double calc (double a, char o, double b) {
	double result=0;
	switch (o) {
		case '+':
			result = a+b;
			break;
		case '-':
			result = a-b;
			break;
		case '*':
			result = a*b;
			break;
		case '/':
			result = a/b;
			break;
	}
	return result;
	}
	
	public static double recur (String exp) {
		String left;
		String right;
		char op;
		double lres;
		double rres;
		double res = 0;
		for(int i=0; i<exp.length(); i++) {
			if(exp.charAt(i)=='(' && i>0) {
				left = exp.substring(0,i-1);
				right = exp.substring(i+1,exp.length());
				op=exp.charAt(i-1);
				lres=recur(left);
				rres = recur(right);
				res = calc(lres, op, rres);
				
			}
			else if(exp.charAt(i)==')' && i<exp.length()) {
				left = exp.substring(0,i-2);
				right = exp.substring(i+1,exp.length());
				op=exp.charAt(i-1);
				lres=recur(left);
				rres = recur(right);
				res = calc(lres, op, rres);
				
			}
			else if (exp.charAt(i) == ')' && i == exp.length()-1) {
				exp = exp.replace(exp.substring(exp.length()-1), "");
				
			}
			else if (exp.charAt(i)=='+' || (exp.charAt(i)=='-' && exp.charAt(i-1) !='-' && exp.charAt(i-1) !='+' && exp.charAt(i-1) !='*' && exp.charAt(i-1) !='/')) {
				left = exp.substring(0,i);
				right = exp.substring(i+1,exp.length());
				op=exp.charAt(i);
				lres=recur(left);
				rres = recur(right);
				res = calc(lres, op, rres);
			}
			else if (exp.charAt(i)=='*' || exp.charAt(i)=='/') {
				op=exp.charAt(i);
				left = exp.substring(0,i);
				right = exp.substring(i+1,exp.length());
				
				lres = Double.parseDouble(left);
				rres = recur(right);
				res = calc(lres, op, rres);
			}
		
		}
		if(!(exp.contains("-") || exp.contains("+") || exp.contains("*") || exp.contains("/"))) {
			res = Double.parseDouble(exp);
		}
		return res;
	}
	
	


}
