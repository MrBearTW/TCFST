import java.util.*;
public class HW1{
    public static void main(String args[]){

        Scanner scan = new Scanner(System.in);
        System.out.println("GUESS?");
        int y  = scan.nextInt();
        System.out.println("Your Guess: "+y);

    int x =(int) (Math.random()*10+1);
//    System.out.println("Answer: "+x);

//********************************************** */
/*
for (int i=0;i<10;i++) {
    System.out.print(i+" ");
}
        while (j<10) {
            System.out.print(j+" ");
            j++;
        }
*/
//********************************************** */

/*
    for (int z=1;x!=y;z++) {
        System.out.println("Wrong ,"+y+" is your guess,"+z+" Time Guess");
    }
*/

        

    if (x!=y){
            System.out.println("Wrong "+"this is your "+" Time Guess");
            System.out.println("Answer: "+x);
        }else{
            System.out.println("Good Job "+"this is your "+" Time Guess");
            System.out.println("Answer: "+x);
        }    
    }
}