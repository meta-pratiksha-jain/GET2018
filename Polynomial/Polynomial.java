/**
 * Immutable class Polynomial represents single variable polynomial.Assumes all coefficients are integers.
 */
public final class Polynomial {
    /*
     * 0th column is to store exponent 1st column for coefficients
     */
    private final int[][] polynomial;

    public Polynomial(int[][] polynomial) {
        if(polynomial.length==0)
        {
            throw new AssertionError("polynomial array can't be empty");
        }
        for (int i = 0; i < polynomial.length; i++) {
            // check for zero coefficients
            if (polynomial[i][1] == 0) {
                throw new AssertionError( "Only non zero coefficients must entered");
            }
        }
        this.polynomial = polynomial;
    }
    
    public int[][] getPolynomial()
    {
        return polynomial;
    }

    /**
     * Private helper method to convert 1D array into 2D Array for storing
     * polynomial
     * 
     * @param polynomial contains 1D array representation of polynomial
     * 
     * @return twoDArray contains 2D array representation of polynomial
     */
    private int[][] convertToTwoDArray(int[] OneDArray ){
        int nonZeroCoefficient = 0;
        for (int i = 0; i < OneDArray.length; i++) {
            if (OneDArray[i] != 0)
            {
                nonZeroCoefficient++;
            }
        }
        int[][] twoDArray = new int[nonZeroCoefficient][2];
        int index = 0;
        for (int i = 0; i < OneDArray.length; i++) {
            if (OneDArray[i] != 0) {
                twoDArray[index][0] = i;
                twoDArray[index][1] = OneDArray[i];
                index++;
            }
        }
        return twoDArray;
    }

    /**
     * private helper method to get coefficient of exponent
     * 
     * @param exponent contains exponent
     * 
     * @return coefficient returns the coefficient corresponding to exponent
     */
    private int getCoefficient(int exponent) {
        int coefficient = 0;
        for (int i = 0; i < polynomial.length; i++) {
            if (polynomial[i][0] == exponent) {
                coefficient = polynomial[i][1];
                return coefficient;
            }
        }
        return coefficient;
    }

    /**
     * evaluates the value of polynomial for the input value
     * 
     * @param valueOfVariable contains value of variable
     * 
     * @return valueOfPolynomial returns value of polynomial
     */
    public double evaluatePolynomial(float valueOfVariable) {
        float valueOfPolynomial = 0;
        for (int i = 0; i < polynomial.length; i++) {
            int exponent = polynomial[i][0];
            int coefficient = polynomial[i][1];
            valueOfPolynomial = valueOfPolynomial + coefficient * (float) Math.pow(valueOfVariable, exponent);
        }
        return valueOfPolynomial;
    }

    /**
     * calculate the degree of polynomial
     * 
     * @return degree returns degree of polynomial
     */

    public int getDegree() {
        int degree = 0;
        for (int i = 0; i < polynomial.length; i++) {
            if (degree < polynomial[i][0]) {
                degree = polynomial[i][0];
            }
        }
        return degree;
    }

    /**
     * add two polynomials
     * @param firstPolynomial
     * @param secondPolynomial
     * @return resultPolynomial is the result of addition 
     */
    public Polynomial addPolynomial(Polynomial polynomial) {
        int maxDegree = this.getDegree();
        if (maxDegree < polynomial.getDegree()) {
            maxDegree = polynomial.getDegree();
        }
        int[] result = new int[maxDegree+1];
        for (int i = 0; i < result.length; i++) {
            int firstCoefficient = this.getCoefficient(i);
            int secondCoefficient = polynomial.getCoefficient(i);
            result[i] = firstCoefficient + secondCoefficient;
        }
        int[][] twoDArray = convertToTwoDArray(result);
        Polynomial resultPolynomial = new Polynomial(twoDArray);
        return resultPolynomial;
    }
    
    /**
     * Multiply two polynomials
     * @param firstPolynomial
     * @param secondPolynomial
     * @return resultPolynomial is the result of multiplication
     */
    public Polynomial multiplyPolynomial(Polynomial polynomialInstance) {
        int resultDegree = this.getDegree() + polynomialInstance.getDegree();
        int[] result = new int[resultDegree+1];
        for (int i = 0; i < this.polynomial.length; i++) {
            for (int j = 0; j < polynomialInstance.polynomial.length; j++) {
                int exponent = this.polynomial[i][0]+polynomialInstance.polynomial[j][0];
                result[exponent] += this.polynomial[i][1] * polynomialInstance.polynomial[j][1];
            }
        }
        int[][] twoDArray = convertToTwoDArray(result);
        Polynomial resultPolynomial = new Polynomial(twoDArray);
        return resultPolynomial;
    }
}
