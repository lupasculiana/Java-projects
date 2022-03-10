import View.CalculatorView;
import Controller.CalculatorController;

public class Main {
    public static void main(String[] args) {
        CalculatorView calculatorView = new CalculatorView();
        CalculatorController calculatorController = new CalculatorController(calculatorView);
    }
}