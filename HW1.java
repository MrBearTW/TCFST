import java.util.*;
public class HW1{
    public static void main(String args[]){

    int x =(int) (Math.random()*10+1);  //x is answer

        
        Scanner scan = new Scanner(System.in);
        System.out.println("GUESS?");
        int y  = scan.nextInt();
        System.out.println("Your Guess: "+y);


//    System.out.println("Answer: "+x);

//********************************************** 
/*
for (int i=0;i<10;i++) {
    System.out.print(i+" ");
}
        while (j<10) {
            System.out.print(j+" ");
            j++;
        }
*/
//********************************************** 

/*
    for (int z=1;x!=y;z++) {
        System.out.println("Wrong ,"+y+" is your guess,"+z+" Time Guess");
    }
*/
        int z=1;
        for (;x!=y;) {
    //        if (x!=y){

                        System.out.println("Wrong ,"+"this is your "+z+" Time Guess");
                        //System.out.println("Answer: "+x);
                                if (x>y) {
                                System.out.println("Guess Bigger");
                               }else{
                                System.out.println("Guess Smaller");
                               }
                        z++;
                
//                Scanner scan2 = new Scanner(System.in);
                System.out.println("GUESS? Again");
                y  = scan.nextInt();
                System.out.println("Your Guess: "+y);


    //                }
    //            else{
    //              System.out.println("Good Job ,"+"this is your "+z+" Time Guess");
    //              System.out.println("Answer: "+x);
    //                }
                }
                System.out.println("Correct!!! ,"+"this is your "+z+" Time Guess");
                System.out.println("Answer: "+x);

                   
       //     }

         
           
    }
}