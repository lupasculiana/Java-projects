package Models.Operations;
import Models.Monom;
import Models.Polinom;
import java.util.ArrayList;

public class Add implements MathOperation{

    public Add() {};

    @Override
    public Polinom operate(Polinom polinom1, Polinom polinom2) {
        polinom1.normalize();
        polinom2.normalize();
        Polinom rez = new Polinom();
        ArrayList<Monom> toRemove = new ArrayList<>();
        ArrayList<Monom> toRemove2 = new ArrayList<>();
        for(Monom monom1 : polinom1.getMonoms()) {
            for(Monom monom2 : polinom2.getMonoms()) {
                if(monom1.getExponent() == monom2.getExponent()) {
                    double coeficient = 0, exponent = 0;
                    coeficient = monom1.getCoeficient()+ monom2.getCoeficient();
                    exponent = monom1.getExponent();
                    Monom monom = new Monom(coeficient,exponent);
                    rez.getMonoms().add(monom);
                    toRemove.add(monom2);
                    toRemove2.add(monom1);
                }
            }
        }
        polinom1.getMonoms().removeAll(toRemove2);
        polinom2.getMonoms().removeAll(toRemove);
        rez.getMonoms().addAll(polinom2.getMonoms());
        rez.getMonoms().addAll(polinom1.getMonoms());
        rez.normalize();
        rez.sort();
        return rez;
    }
}
