public class AmbiguityExample {
    public static void main(String[] args) {
        foo(5, 7);
    }

    static void foo(int a, double b) {
        System.out.println("int-double method");
    }

    static void foo(double a, int b) {
        System.out.println("double-int method");
    }
}
