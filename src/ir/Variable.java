/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ir;

import utils.IRVisitor;
import utils.VariableCounter;

/**
 *
 * @author beh01
 */
public class Variable extends Expression {

    private String name;
    private int id = -1;

    public Variable(String name) {
        this.name = name;
        this.id = VariableCounter.get();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public String getCode() {
        //return "Variable " + this.name + " ("+this.id+") not implemented yet\n";
        return "";
    }
}
