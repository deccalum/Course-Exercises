package se.lexicon.Exceptions;

public class OutOfRange extends Exception {
    private int rangeInput;

    public OutOfRange(int rangeInput, String message) {
        super(message);
        this.rangeInput = rangeInput;
    }
    
    public OutOfRange(String message) {
        super(message);
    }
    
    public int getRangeInput() {
        return rangeInput;
    }
    
    @Override
    public String toString() {
        return "OutOfRange Exception: " + getMessage() + " (Input: " + rangeInput + ")";
    }

}