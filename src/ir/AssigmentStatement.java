/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ir;

import utils.IRVisitor;

/**
 *
 * @author beh01
 */
public class AssigmentStatement extends Statement{

    private Variable variable;
    private Expression expression;
    private int line;
    private int column;

    public AssigmentStatement(Variable variable, Expression expression, int line, int column) {
        this.variable = variable;
        this.expression = expression;
        this.line = line;
        this.column = column;
    }

    public int getLine(){
        return line;
    }
    public int getColumn(){
        return column;
    }
    
    public Expression getExpression() {
        return expression;
    }

    public Variable getVariable() {
        return variable;
    }

    @Override
    public void accept(IRVisitor visitor) {
        variable.accept(visitor);
        expression.accept(visitor);

        visitor.visit(this);
    }

    @Override
    public String toString() {
        return variable.getName()+" = "+expression.toString()+";";
    }

    @Override
    public String getCode() {
         return "save " + variable.getCode() + "\n";
    }
}
