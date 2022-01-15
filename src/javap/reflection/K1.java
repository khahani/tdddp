package javap.reflection;

public class K1 {
    public int f1;
    protected int f2;

    public K1() {

    }

    public K1(int f1) {
        this.f1 = f1;
    }

    public void m1() {
        System.out.println("K1.m1()");
    }

    public void m1(int i) {
        System.out.println("K1.m1(int)");
    }

    private void m2() {
        System.out.println("K1.m2()");
    }
}
