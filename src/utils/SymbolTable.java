/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

import ir.Variable;
import java.util.HashMap;
import java.util.*;

/**
 *
 * @author beh01
 */
public class SymbolTable {
            
    
    private HashMap<String,Variable> variables = new HashMap<String, Variable>();

    public void declareVariable(int line, int column,String name, String type) {
        if (variables.containsKey(name)) {
            MyError.addError(new MyError(line, column, "Variable: "+name+" already defined."));
        }else {
            Variable v = new Variable(name);
            v.setType(type.toUpperCase());
            variables.put(name, v);
        }
    }
    public Variable getVariable(int line, int column, String name) {
       if (!variables.containsKey(name)) {
            MyError.addError(new MyError(line, column, "Can not find variable: "+name+"."));
            Variable v = new Variable(name);
            v.setType("ERROR");
            return v;
        }else {
           return variables.get(name);
        }
    }
}
