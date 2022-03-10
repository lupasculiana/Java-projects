package Models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Polinom {
    private ArrayList<Monom> monoms;

    public Polinom(){ this.monoms = new ArrayList<>();}

    public ArrayList<Monom> getMonoms() {
        return monoms;
    }

    public void setMonoms(ArrayList<Monom> monoms) {
        this.monoms = monoms;
    }

    public void normalize(){
        Polinom rez = new Polinom();
        Polinom result = new Polinom();
        rez.setMonoms(this.getMonoms());
        ArrayList<Monom> toRemove = new ArrayList<>();
        int i = 0;
        for(Monom monom : rez.getMonoms()) {
            i++;
            result.getMonoms().add(monom);
            int times = 0; //checks how many times there was a monomial with the same exponent
            for(Monom monomRes : rez.getMonoms()) {
                if(monomRes.getExponent() == monom.getExponent()) {
                    times++;
                    if(times>1) {
                        result.getMonoms().get(i-1).setCoeficient(result.getMonoms().get(i-1).getCoeficient()+monomRes.getCoeficient());
                        toRemove.add(monomRes);
                    }
                }
            }
            rez.getMonoms().removeAll(toRemove);
        }
        rez.setMonoms(result.getMonoms());
    }

    public void sort(){
        monoms.sort(Comparator.comparing(Monom::getExponent));
        Collections.reverse(monoms);
    }

    @Override
    public String toString() {
        String output = "Polinom{ ";
        for (Monom monomRes : getMonoms()) {
            if (monomRes.getCoeficient() >= 0) {
                output += " +" + monomRes.getCoeficient() + " X^" + monomRes.getExponent();
            } else {
                output += " -" + monomRes.getCoeficient() + " X^" + monomRes.getExponent();
            }
        }
        output += "}";
        return output;
    }
}
