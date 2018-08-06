package com.suren;

/**
 * @author surendar
 */
public class Range {

    private int lowerZipCode;
    private int upperZipCode;

    public Range(int lowerZipCode, int upperZipCode) {
        this.lowerZipCode = lowerZipCode;
        this.upperZipCode = upperZipCode;
    }

    public int getLowerZipCode() {
        return lowerZipCode;
    }

    public void setLowerZipCode(int lowerZipCode) {
        this.lowerZipCode = lowerZipCode;
    }

    public int getUpperZipCode() {
        return upperZipCode;
    }

    public void setUpperZipCode(int upperZipCode) {
        this.upperZipCode = upperZipCode;
    }

    @Override
    public String toString() {
        return "[" + lowerZipCode +
                ", " + upperZipCode +
                ']';
    }

    @Override
    public boolean equals(Object zipCodeObj) {
        boolean result = false;
        if (zipCodeObj instanceof ZipRange) {
            Range that = (Range) zipCodeObj;
            result = (this.getLowerZipCode() == that.getLowerZipCode() && this.getUpperZipCode() == that.getUpperZipCode());
        }
        return result;
    }

}
