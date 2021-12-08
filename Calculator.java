import java.util.Locale;

public class Calculator {

    public static void main(String[] args) {
        String userContinue = "yes";

        while (userContinue.equalsIgnoreCase("yes")) {
            int result = Calculation.operation4();
            System.out.println("result:" + result + "\nContinue? Yes or No: ");
            userContinue = Calculation.scanner();
        }
    }
}
