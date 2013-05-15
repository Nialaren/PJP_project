package ir;

import utils.IRVisitor;

/**
 *
 * @author beh01
 */
public class Literal extends Expression {

    private Object value;

    public Literal(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public String getCode() {
        return "push " + value.toString();
    }
}
