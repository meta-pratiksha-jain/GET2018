package multivariatrePolynomial;

import java.util.*;

/**
 * This class represents a term in a polynomial.
 *
 */
public class PolynomialTerm {
    private int coefficient;
    private List<Variable> listOfVariable;
    
    public PolynomialTerm(int coefficient,List<Variable> listOfVariable)
    {
        this.coefficient=coefficient;
        this.listOfVariable=listOfVariable;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    public List<Variable> getListOfVariable() {
        return listOfVariable;
    }

    public void setListOfVariable(List<Variable> listOfVariable) {
        this.listOfVariable = listOfVariable;
    }

}
