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
public class ConditionalExpression extends Expression {
    Expression condition;
    Expression left, right;
    private int line;
    private int column;
    

    public ConditionalExpression(Expression condition, Expression left, Expression right, int line, int column) {
        this.condition = condition;
        this.left = left;
        this.right = right;
        this.line = line;
        this.column = column;
    }

    public int getLine(){
        return line;
    }
    public int getColumn(){
        return column;
    }

    public Expression getCondition() {
        return condition;
    }

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }

    @Override
    public void accept(IRVisitor visitor) {
        condition.accept(visitor);
        left.accept(visitor);
        right.accept(visitor);

        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "("+condition.toString()+")?"+left.toString()+":"+right.toString();
    }

}
