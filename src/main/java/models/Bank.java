package models;

import java.util.Hashtable;

public class Bank {
    private final Hashtable rates = new Hashtable();

    public Money reduce(IExpression source, String to){
        return source.reduce(this, to);
    }

    public int rate(String from, String to){
        if (from.equals(to)) return 1;

        int rate = (int)rates.get(new Pair(from, to));
        return rate;
    }

    public void addRate(String from, String to, int value){
        Pair pair = new Pair(from, to);
        rates.put(pair, value);
    }
}
