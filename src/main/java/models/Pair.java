package models;

public record Pair(String _from, String _to) {
    @Override
    public boolean equals(Object obj){
        Pair pair = (Pair) obj;
        return _from.equals(pair._from) && _to.equals(pair._to);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
