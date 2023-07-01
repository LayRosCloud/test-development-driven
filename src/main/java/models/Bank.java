package models;

public class Bank {
    public Money reduce(IExpression source, String to){
        return new Money(10, to);
    }
}
