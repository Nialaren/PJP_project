/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ir;

import utils.IRVisitor;

/**
 *
 * @author Fisa
 */
public class DeclarationStatement extends Statement {

    Variable var;
    
    public DeclarationStatement(Variable v)
    {
        var = v;
    }
    
    @Override
    public void accept(IRVisitor visitor) {
        var.accept(visitor);
    }

    @Override
    public String toString() {
        return var.getType() + " " + var.toString() + ";";
    }
    
}
