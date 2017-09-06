import java.util.*;
public class TestIf {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Score:");
        String x1 = scan.next();
       
        int x = Integer.parseInt(x1);
        
if (x <=100 && x >=0) {
    

        if (x >100) {
            System.out.println("Erro   "+x+"  could not happen");
                    }
        else if(x >=90) {
            System.out.println("PASS  Level A"+"   Score:"+x);
                    }
        else if(x >=80) {
            System.out.println("PASS  Level B"+"   Score:"+x);
                                }     
                                else if(x >=70) {
                                    System.out.println("PASS  Level C"+"   Score:"+x);
                                                        }              
                                                        else if(x >=0) {
                                                            System.out.println("Fail  Level F"+"   Score:"+x);
                                                                                }                             
        else{
            System.out.println("Erro   "+x+"  could not happen");
        }
    }
    else{
        System.out.println("Erro ,Please enter a number between 0~100.");
    }

    }
}