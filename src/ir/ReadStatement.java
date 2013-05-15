/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ir;

import java.util.ArrayList;
import java.util.List;
import utils.IRVisitor;

/**
 *
 * @author beh01
 */
public class ReadStatement extends Statement{
    List<Variable> variables = new ArrayList<Variable>();

    public ReadStatement() {
    }

    public List<Variable> getVariables() {
        return variables;
    }

    @Override
    public void accept(IRVisitor visitor) {
        for(Variable v: variables) {
            v.accept(visitor);
        }
        visitor.visit(this);
    }

    @Override
    public String toString() {
        StringBuilder sb =new StringBuilder("read ");
        for(Variable v : variables) sb.append(v.toString()).append(", ");
        sb.append(";");
        return sb.toString();
    }

    @Override
    public String getCode() {
        return "Reading not implemented yet\n";
    }

}
