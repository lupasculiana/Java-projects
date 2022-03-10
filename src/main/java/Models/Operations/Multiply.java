package Models.Operations;
import Models.Monom;
import Models.Polinom;

public class Multiply implements MathOperation{

    public Multiply(){};

    @Override
    public Polinom operate(Polinom polinom1, Polinom polinom2) {
        polinom1.normalize();
        polinom2.normalize();
        Polinom rez = new Polinom();
        for(Monom monom1 : polinom1.getMonoms()) {
            for(Monom monom2 : polinom2.getMonoms()) {
                double coeficient = 0, exponent = 0;
                coeficient = monom1.getCoeficient() * monom2.getCoeficient();
                exponent = monom1.getExponent() + monom2.getExponent();
                Monom monom = new Monom(coeficient,exponent);
                rez.getMonoms().add(monom);
            }
        }
        rez.normalize();
        rez.sort();
        return rez;
    }
}
