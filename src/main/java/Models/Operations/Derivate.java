package Models.Operations;
import Models.Monom;
import Models.Polinom;

public class Derivate implements MathOperation{
    private Polinom result;

    public Derivate() {
        result = new Polinom();
    };

    public Polinom getResult() {
        return this.result;
    }
    @Override
    public Polinom operate(Polinom polinom1, Polinom polinom2) {
        polinom1.normalize();

        for(Monom monom1 : polinom1.getMonoms()) {
            if(monom1.getExponent() != 0) {
                double coeficient = 0, exponent = 0;
                coeficient = monom1.getCoeficient() * monom1.getExponent();
                exponent = monom1.getExponent() - 1;
                Monom monom = new Monom(coeficient,exponent);
                result.getMonoms().add(monom);
            }
        }
        return this.result;
    }
}
