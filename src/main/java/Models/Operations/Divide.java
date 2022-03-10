package Models.Operations;
import Models.Monom;
import Models.Polinom;
import java.util.ArrayList;

public class Divide implements MathOperation{
    private Polinom rest;

    public Divide() {
        rest = new Polinom();
    };

    public Polinom getRest() {
        return this.rest;
    }

    public void setRest(Polinom rest) {
        this.rest = rest;
    }
    @Override
    public Polinom operate(Polinom polinom1, Polinom polinom2) {
        polinom1.normalize();
        polinom2.normalize();
        Polinom intermediate = new Polinom(), rez = new Polinom(), deimpartit = polinom1, catP;
        Multiply multiply = new Multiply();
        Add add = new Add();
        int i = 0;
        double grad = polinom2.getMonoms().get(0).getExponent(); //0; seteaza gradul
        while(grad <= deimpartit.getMonoms().get(0).getExponent()) {
            ArrayList<Monom> toRemove = new ArrayList<>();
            double coeficient = 0,exponent =0;
            coeficient = (deimpartit.getMonoms().get(0).getCoeficient())/(polinom2.getMonoms().get(0).getCoeficient());
            exponent = (deimpartit.getMonoms().get(0).getExponent())-(polinom2.getMonoms().get(0).getExponent());
            Monom monom = new Monom(coeficient,exponent);
            rez.getMonoms().add(monom);
            intermediate.getMonoms().clear();
            intermediate.getMonoms().add(0,monom);
            intermediate.getMonoms().get(0).inmultireScalar(-1); //1; calculeaza urmatorul monom al rezultatului ; intermediate se va folosi pt calcularea catului partial
            catP = multiply.operate(polinom2,intermediate); //2 ; inmulteste intermediate cu impartitorul si -1, pt a calcula noul cat partial
            Polinom rezultatAdd = add.operate(deimpartit,catP); //3 ; aduna deimparitul cu catul partial, resultatul va deveni noul deimpartit
            deimpartit=rezultatAdd;
            i++;
            for(Monom monomz : deimpartit.getMonoms()) {
                if(monomz.getCoeficient() == 0) {
                    toRemove.add(monomz);
                }
            }
            deimpartit.getMonoms().removeAll(toRemove);
            for(Monom monoms: rez.getMonoms()) {
                monoms.inmultireScalar(-1);}
        }
        setRest(deimpartit);
        return rez;}
}
