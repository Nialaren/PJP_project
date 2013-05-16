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
public class UnaryExpression extends Expression {

    private String operator;
    private Expression expression;
    private int line;
    private int column;

    public UnaryExpression(String operator, Expression expression, int line, int column) {
        super();
        this.operator = operator;
        this.expression = expression;
        this.line = line;
        this.column = column;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    public Expression getExpression() {
        return expression;
    }

    public String getOperator() {
        return operator;
    }

    @Override
    public void accept(IRVisitor visitor) {
        expression.accept(visitor);
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return operator + expression.toString();
    }

    @Override
    public String getCode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
