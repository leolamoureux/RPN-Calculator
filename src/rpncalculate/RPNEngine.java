package rpncalculate;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public class RPNEngine {

    private List<String> allData = new ArrayList<String>();
    private Stack<Integer> values = new Stack<>();
    
    // Check if item is a number 
    protected boolean isNumber(String operand) {
        try {
            Integer.parseInt(operand);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    
    // Sava data in list of string and return it
    protected List save(String operand) {
        allData.add(operand);
        return allData;
    }
    
    // Calcule operand which is in stack
    protected void operation() {
        int result = 0;
        int secondVal = 0;
        int allDataSize = allData.size();
        int numberDataSize = 0;

        String errorMsg = "It's not RPN Notation";
        for (String data : allData) {
            if (isNumber(data)) {
                ++numberDataSize;
                values.push(Integer.parseInt(data));
                continue;
            }

            switch (data) {
                case "+":
                    try {
                        result = Operation.PLUS.eval(values.pop(), values.pop());
                        values.push(result);
                    } catch (EmptyStackException e) {
                        throw new IllegalArgumentException(errorMsg);
                    }
                    break;
                case "-":
                    try {
                        secondVal = values.pop();
                        result = Operation.MINUS.eval(values.pop(), secondVal);
                        values.push(result);
                    } catch (EmptyStackException e) {
                        throw new IllegalArgumentException(errorMsg);
                    }
                    break;
                case "*":
                    try {
                        result = Operation.MULTIPLIED.eval(values.pop(), values.pop());
                        values.push(result);
                    } catch (EmptyStackException e) {
                        throw new IllegalArgumentException(errorMsg);
                    }
                    break;
                case "/":
                    try {
                        secondVal = values.pop();
                        result = Operation.DIVIDED.eval(values.pop(), secondVal);
                        values.push(result);
                    } catch (EmptyStackException e) {
                        throw new IllegalArgumentException(errorMsg);
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Operation is not valid, you should choose one of this operator : +,-,*,/");
            }
        }

        int symboleDataSize = allDataSize - numberDataSize;
        if (numberDataSize != (symboleDataSize + 1)) {
            throw new IllegalArgumentException("Not invalid arguments number");
        }

        System.out.println("Calcul result = " + values.peek());
    }
}
