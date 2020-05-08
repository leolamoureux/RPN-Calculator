package rpncalculate;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RPNEnter {

    RPNEngine rpnEngine = new RPNEngine();
    
    // Method wish is interact with user
    protected void interaction() {
        System.out.println("Hi welcome to RPN Calculator");
        System.out.println("You can choose number or operation like +, -, *, /");
        System.out.println("After your choice, press enter key");
        System.out.println("If you want to calcul, press enter key");

        Scanner sc = new Scanner(System.in);

        String[] tab_operator = {"+", "-", "*", "/"};
        List<String> listOperator = Arrays.asList(tab_operator);
        String operand;

        boolean notOperand = true;
        boolean isContinue = true;

        do {
            System.out.print("Please enter a number, an operation or enter key : ");
            operand = sc.nextLine();

            if (operand.isEmpty()) {
                rpnEngine.operation();
                isContinue = false;
            } else if (listOperator.contains(operand) || rpnEngine.isNumber(operand)) {
                rpnEngine.save(operand);
                System.out.println("Operand: " + operand);
            } else {
                System.out.println("Enter a valid integer value");
                notOperand = false;
            }

        } while (isContinue || !notOperand);
    }
}
