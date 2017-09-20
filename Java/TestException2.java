public class TestException{
    public static void main(String[] args) {
        try {
            int num =Integer.parseInt(args[0]);
            System.out.println(5566/num);
            System.out.println("1.try block");                        
        } catch (ArrayIndexOutOfBoundsException aie) {
            System.out.println("You need to input a number");
            System.out.println("2.aie block");
            aie.printStackTrace();           //you can see javaline...
        }
        catch (NumberFormatException nf) {
            System.out.println("You should not input string");
            System.out.println("3.nf block");
            nf.printStackTrace();
        }
        catch (ArithmeticException ae) {
            System.out.println("You should not input 0");
            ae.printStackTrace();
        }        
        finally{
            System.out.println("4.finally block");

        }
        System.out.println("5.standard block");
    }
}


/*
java TestException 17              >>> 1 4 5

java TestException                 >>> 2 4 5
ArrayIndexOutOfBoundsException

java TestException abc             >>> 3 4 5
NumberFormatException

java TestException 0               >>>   4
ArithmeticException
*/