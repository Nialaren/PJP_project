/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author beh01
 */
public class MyError {
    private int line, column;
    private String message;

    public MyError(int line, int column, String message) {
        this.line = line;
        this.column = column;
        this.message = message;
    }

    @Override
    public String toString() {
        return "Error: "+line+", "+column+" - "+message;
    }
    private static List<MyError> errors = new ArrayList<MyError>();
    public static void clearErrors() {
        errors.clear();
    }
    public static void addError(MyError e) {
        errors.add(e);
    }
    public static boolean noErrors() {
        return errors.isEmpty();
    }
    public static void printErrors() {
        for(MyError e : errors) {
            System.err.println(e);
        }
    }
}
