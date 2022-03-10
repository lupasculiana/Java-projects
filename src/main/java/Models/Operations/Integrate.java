package Models.Operations;
import Models.Monom;
import Models.Polinom;

public class Integrate implements MathOperation{
    private Polinom result;

    public Integrate() {
        result = new Polinom();
    };

    public Polinom getResult() {
        return this.result;
    }

    public void setResult(Polinom result) {
        this.result = result;
    }

    @Override
    public Polinom operate(Polinom polinom1, Polinom polinom2) {
        polinom1.normalize();

        for(Monom monom1 : polinom1.getMonoms()) {
            double coeficient = 0, exponent = 0;
            coeficient = monom1.getCoeficient() / (monom1.getExponent() + 1);
            exponent = monom1.getExponent() + 1;
            Monom monom = new Monom(coeficient,exponent);
            result.getMonoms().add(monom);
        }
        return this.result;
    }
}
