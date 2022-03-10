package Controller;

import Models.Operations.*;
import View.CalculatorView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Models.Monom;
import Models.Polinom;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorController {
    private CalculatorView view;

    public CalculatorController(CalculatorView view) {
        this.view = view;
        this.view.addCreateListener(new CreateListener());
    }

    class CreateListener implements ActionListener {

        public Polinom regexPolinom(String s){
            ArrayList<Monom> monoms = new ArrayList<Monom>();
            Polinom polinom = new Polinom();
            Double exponents[] = new Double[10], coeficients[] = new Double[10];
            String text = s;
            Pattern pattern = Pattern.compile("[+-]?[^-+]+");
            Matcher matcher = pattern.matcher(text);
            int i =0,j = 0; //ia monoamele din polinom
            while (matcher.find()) {
                String text2 = matcher.group(),patternString2 = "(?<=\\^)+(\\d+(\\.\\d+)?)"; //ia exponentul din monom
                Pattern pattern2 = Pattern.compile(patternString2);
                Matcher matcher2 = pattern2.matcher(text2);
                while (matcher2.find()) {
                    exponents[i] = Double.parseDouble(matcher2.group());
                    i++;} //vede daca e minus sau plus
                String text3 = matcher.group(),patternString3 = "^.";
                Pattern pattern3 = Pattern.compile(patternString3);
                Matcher matcher3 = pattern3.matcher(text3);
                while (matcher3.find()) { //ia coeficientul din monom
                    String text4 = matcher.group(), patternString4 = "(?<!\\^)+(\\d+(\\.\\d+)?)";
                    Pattern pattern4 = Pattern.compile(patternString4);
                    Matcher matcher4 = pattern4.matcher(text4);
                    if(matcher3.group().equals("-")) {
                        while(matcher4.find()) {
                            coeficients[j] = Double.parseDouble(matcher4.group()) * (-1);
                            Monom monom1 = new Monom(coeficients[j],exponents[j]);
                            monoms.add(monom1);
                            j++;}
                    } else {
                        while(matcher4.find()) {
                            coeficients[j] = Double.parseDouble(matcher4.group());
                            Monom monom2 = new Monom(coeficients[j],exponents[j]);
                            monoms.add(monom2);
                            j++;}
                    }
                }
            }polinom.setMonoms(monoms);
            return polinom;}

        public void actionPerformed(ActionEvent e) {
            try {
                Polinom polinom1 = regexPolinom(view.getFirstValueField()), polinom2 = regexPolinom(view.getSecondValueField()), result;
                String operation=view.getOperationField();
                if(operation.equals("Add")){
                    Add resultVal = new Add();
                    result = resultVal.operate(polinom1,polinom2);
                    view.setTotalValueField(result.toString());
                } else if(operation.equals("Substract")) {
                    Substract resultVal = new Substract();
                    result = resultVal.operate(polinom1, polinom2);
                    view.setTotalValueField(result.toString());
                }else if(operation.equals("Multiplication")){
                    Multiply resultVal = new Multiply();
                    result = resultVal.operate(polinom1,polinom2);
                    view.setTotalValueField(result.toString());
                }else if(operation.equals("Division")){
                    Divide resultVal = new Divide();
                    result = resultVal.operate(polinom1,polinom2);
                    view.setTotalValueField(result.toString()+", rest: "+resultVal.getRest());
                }else if(operation.equals("Derivative")){
                    Derivate resultVal = new Derivate();
                    result = resultVal.operate(polinom1,polinom2);
                    view.setTotalValueField(result.toString());
                }else if(operation.equals("Integration")){
                    Integrate resultVal = new Integrate();
                    result = resultVal.operate(polinom1,polinom2);
                    view.setTotalValueField(result.toString());
                }
            } catch (Exception var) {
                view.showMessage("Bad Input X_X");}
        }
    }
}