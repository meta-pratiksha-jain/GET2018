package multivariatrePolynomial;

/**
 * This class represents variable of the polynomial.
 *
 */
public class Variable {
    private String name;
    private int power;
    
    public Variable(String name,int power)
    {
        this.name=name;
        this.power=power;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

}
