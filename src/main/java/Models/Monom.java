package Models;

public class Monom {
    private double coeficient;
    private double exponent;

    public Monom(double coeficient, double exponent) {
        this.coeficient = coeficient;
        this.exponent = exponent;
    }

    public double getCoeficient() {
        return this.coeficient;
    }

    public void setCoeficient(double coeficient) {
        this.coeficient = coeficient;
    }

    public double getExponent() {
        return this.exponent;
    }

    public void setExponent(double exponent) {
        this.exponent = exponent;
    }

    public void inmultireScalar(double scalar){
        this.setCoeficient(getCoeficient() * scalar);
    }
}
