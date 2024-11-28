package it.unibo.mvc;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    private List<String> printHistory = new LinkedList<>(); 
    private String nextString;

    @Override
    public void setString(String s) {
        this.nextString = s;
    }

    @Override
    public String getString() {
        return this.nextString;
    }

    @Override
    public void printString() {
        if (nextString != null) {
        printHistory.add(this.nextString);
        System.out.println(this.nextString.toString());
        } else {
            throw new IllegalStateException("next string is null!");
        }
    }

    @Override
    public List<String> getPrintHistory() {
        return this.printHistory;
    }

}
