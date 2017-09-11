
import java.util.*;
public class TestSwitch{
    public static void main(String args[]){

        Scanner scan = new Scanner(System.in);
        System.out.print("Witch:");
        char food = scan.next().charAt(0);  //get the first character
//       char food = 'A';
        switch (food) {
                case 'A':
                System.out.println("1");
                //System.out.println("2");
                //System.out.println("3");             
                //break;                    //No break could use in manage Authority control
                case 'B':
                System.out.println("2");
                //System.out.println("3");
                //break;
                case 'C':
                System.out.println("3");
                break;
        
            default:
            System.out.println("Please enter A or B or C");
                break;
        }
    }
}