public class TestArray1{
        public static void main (String args[]) {
/* Ex1
            int[] scores = new int[5];
            scores[0]=97;
            scores[1]=87;
            scores[2]=77;
            scores[3]=67;
            scores[4]=57;
            for (int i=0;i<5;i++) {
                    System.out.println(scores[i]);
                }
*/

/* Ex2
            int [] scores2 ={95,96,95,94,93,92,87,94,87,94,0};
            for (int i=0;i<scores2.length;i++) {
                System.out.println(scores2[i]);
            }
*/
            int[] lottos =new int[6];
            for(int k=0;k<lottos.length;k++){
                lottos[k] =(int) (Math.random()*42+1);
                System.out.print(lottos[k]+" ");
                }
                /*
            int [] scores2 ={ };

            for (int i=0;i<scores2.length;i++) {
                System.out.println(scores2[i]);
            }
*/

        }
}