package abc.def;
import static java.lang.System.out;

public class Package {

	public static void main(String args[] ){
        Package s = new Package();
        s.sayHi();

    }
    void sayHi(){
        out.println("Hello Java");
    }


}

// javac -d . Package.java
// java abc.def.Package