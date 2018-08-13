package multivariatrePolynomial;

import java.util.*;

/**
 * This class represents Multivariate polynomial using nested list.
 *
 */
public class MultiVariatePolynomial {
    private List<PolynomialTerm> polynomial;
    
    public MultiVariatePolynomial()
    {
        polynomial=new ArrayList<PolynomialTerm>();
    }
    
    /**
     * add a polynomial term to the polynomial
     * @param coefficient
     * @param listOfVariable
     */
    public void addPolynomialTerm(int coefficient, List<Variable> listOfVariable)
    {
        PolynomialTerm term=new PolynomialTerm(coefficient, listOfVariable);
        polynomial.add(term);
    }

    public List<PolynomialTerm> getPolynomial() {
        return polynomial;
    }

    public void setPolynomial(List<PolynomialTerm> polynomial) {
        this.polynomial = polynomial;
    }

}
