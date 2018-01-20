package edu.princeton.cs.algs4.clients;

import edu.princeton.cs.algs4.Stack;
import java.util.Scanner;

// Evaluate a fully parenthesized arithmetical expression, like for example:
//         ( ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) ) + ( sqrt 25 ) )
// Result: 106.0
public class Evaluate {

    public static void main(String[] args) {
        Stack<String> operators = new Stack<String>();
        Stack<Double> values = new Stack<Double>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.next();
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("sqrt"))
                operators.push(s);
            else if (s.equals("("));
            else if (s.equals(")")) {
                switch (operators.pop()) {
                    case "+": values.push(values.pop() + values.pop()); break;
                    case "-": values.push(values.pop() - values.pop()); break;
                    case "*": values.push(values.pop() * values.pop()); break;
                    case "/": values.push(values.pop() / values.pop()); break;
                    case "sqrt": values.push(Math.sqrt(values.pop())); break;
                }
            }
            else values.push(Double.parseDouble(s));
        }
        if (!operators.isEmpty() || values.size() != 1)
            edu.princeton.cs.algs4.StdOut.println("Invalid expression");
        else
            edu.princeton.cs.algs4.StdOut.println("Result: " + values.pop());
    }
}

