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
public class PrintStatement extends Statement{
    private List<Expression> expressions=new ArrayList<Expression>();

    public PrintStatement() {
    }

    public List<Expression> getExpressions() {
        return expressions;
    }

    @Override
    public void accept(IRVisitor visitor) {
        for(Expression e : expressions) {
            e.accept(visitor);
        }
        visitor.visit(this);
    }

    @Override
    public String toString() {
        StringBuilder sb =new StringBuilder("print ");
        for(Expression e : expressions) sb.append(e.toString()).append(", ");
        return sb.toString();
    }

}
