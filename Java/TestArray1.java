public class TestArray1{
        public static void main (String args[]) {
/* Ex1      //Second [] should have number   
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
/* Ex3      //Second [] should not have number
            int [] scores3 =new int [] {95,96,95,94,93,92,87,94,87,94,0};
            for (int i=0;i<scores2.length;i++) {
                System.out.println(scores2[i]);
            }
            //Second [] should not have number
*/

                int[] lottos =new int[6];
                b_label:{            
                //int[] lottos =new int[6];
                for(int k=0;k<lottos.length;k++){
                    lottos[k] =(int) (Math.random()*42+1);
                };
 /*
                    int x=0; 
                    int y=1;
                    for(;lottos[x]==lottos[y];y++)
*/
                   
/*
                    int x=1;
                    int y=2;		
                    for(;x<7;x++){
                        
                                for(;y<7;y++){
                                    int z=x*y;
                                    System.out.print(x+" ");
                                    System.out.print(y+" ");
                                    System.out.println(z);
                                    }
                                y=2;
                            }
*/                  
                            int x=0;
                            int y=0;
                            //y=x+1;		
                            for(;x<6;x++){
                                y=x+1;
                                        for(;y<6;y++){
                                            //int z=x*y;
                                            
                                            System.out.print("X"+x+"="+lottos[x]+" ");
                                            System.out.println("Y"+y+"="+lottos[y]);
                                            //System.out.println(z);
                                            
                                            if(lottos[x]==lottos[y]){
                                                x=0;
                                                y=0;
                                                System.out.println("XXXXXXXXX");
                                                break b_label;};
                                            }
                                        //y=x+1;
                                    }

                    
                        }//b_label



                        for(int m=0;m<6;m++){
                            System.out.print(lottos[m]+" ");
                        };
                    
                    
                

/*x=1 y=x+1   x<7,y<7  
12 13 14 15 16
   23 24 25 26
      34 35 36
         45 46
            56
*/



/*            
                    System.out.println(" ");  
                    System.out.println("1."+lottos[0]);   
                    System.out.println("2."+lottos[1]);
                    System.out.println("3."+lottos[2]);
                    System.out.println("4."+lottos[3]);                    
                    System.out.println("5."+lottos[4]);
                    System.out.println("6."+lottos[5]);
*/


/*                  
            int [] scores2 ={ };

            for (int i=0;i<scores2.length;i++) {
                System.out.println(scores2[i]);
            }
*/

        }
}