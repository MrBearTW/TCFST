class D {
    D() {
        System.out.println("father class is called..."); 
    }

    D(int i) {
        System.out.println("father class int's constructor is called...");
    }
}

public class C extends D {
    C() {
        super(0);
        System.out.println("son class is called..."); 
    }

    public static void main(String args[]) {
        C c = new C();
    }
}