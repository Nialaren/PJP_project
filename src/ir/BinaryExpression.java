/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ir;

import utils.IRVisitor;
import utils.TypeChecking;
import utils.VariableCounter;

/**
 *
 * @author beh01
 */
public class BinaryExpression extends Expression {

    private String operator;
    private Expression left, right;
    private int line;
    private int column;
    private int id;

    public BinaryExpression(String operator, Expression left, Expression right, int line, int column) {
        super();
        this.operator = operator;
        this.left = left;
        this.right = right;
        this.line = line;
        this.column = column;

        this.id = VariableCounter.get();
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    public Expression getLeft() {
        return left;
    }

    public String getOperator() {
        return operator;
    }

    public Expression getRight() {
        return right;
    }

    @Override
    public void accept(IRVisitor visitor) {
        left.accept(visitor);
        right.accept(visitor);
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return left.toString() + operator + right.toString();
    }

    @Override
    public String getCode() {
        StringBuilder output = new StringBuilder();

        output.append(right.getCode());
        output.append("SAVE ").append(this.id).append("\n");
        output.append(left.getCode());
        output.append(TypeChecking.FindOperator(operator)).append(" ").append(this.id).append("\n");

        return output.toString();
    }
}
