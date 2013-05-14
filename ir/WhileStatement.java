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
public class WhileStatement extends Statement{

    private BlockStatement statement;
    private Expression condition;
    private int line;
    private int column;

    public WhileStatement(BlockStatement statement, Expression condition, int line, int column) {
        this.statement = statement;
        this.condition = condition;
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

    public BlockStatement getStatement() {
        return statement;
    }

    @Override
    public void accept(IRVisitor visitor) {
        condition.accept(visitor);
        statement.accept(visitor);
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "while ("+condition.toString()+") do "+statement.toString()+" end;";
    }
}
