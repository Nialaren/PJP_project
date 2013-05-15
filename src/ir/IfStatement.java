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
public class IfStatement extends Statement {

    private Expression condition;
    private BlockStatement thenPart, elsePart;
    private int line;
    private int column;

    public IfStatement(Expression condition, BlockStatement thenPart, BlockStatement elsePart, int line, int column) {
        this.condition = condition;
        this.thenPart = thenPart;
        this.elsePart = elsePart;
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

    public BlockStatement getElsePart() {
        return elsePart;
    }

    public BlockStatement getThenPart() {
        return thenPart;
    }

    @Override
    public void accept(IRVisitor visitor) {
        condition.accept(visitor);
        thenPart.accept(visitor);
        elsePart.accept(visitor);

        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "if (" + condition.toString() + ") then " + thenPart.toString() + " else " + elsePart.toString() + " end;";
    }

    @Override
    public String getCode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
