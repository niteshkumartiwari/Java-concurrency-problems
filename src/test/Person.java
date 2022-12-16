package test;

public class Person {
    public String fn;
    public String ln;

    public Person(String fn, String ln) {
        this.fn = fn;
        this.ln = ln;
    }

    public String getFn() {
        return fn;
    }

    public String getLn() {
        return ln;
    }
}
