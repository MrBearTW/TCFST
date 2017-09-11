public class TestArray1_lottos{
    public static void main (String args[]) {
            int[] lottos =new int[6];
            int k=0;
            

            for(;k<lottos.length;k++){
                lottos[k] =(int) (Math.random()*42+1);
                };
            int x=0;
            int y=0;

            c_label:    		
            for(;x<lottos.length;x++){                           
                for(y=x+1;y<lottos.length;y++){                                     
                    System.out.print("X"+x+"="+lottos[x]+" ");
                    System.out.println("Y"+y+"="+lottos[y]);
                    if(lottos[x]==lottos[y]){
                                            x=0;
                                            y=0;
                                            k=0;
                                            System.out.println("XXXXXXXXX");
                                            continue c_label;
                                            }
                    }               
                }
           for(int m=0;m<6;m++){
               System.out.print(lottos[m]+" ");
                 }
        }
    }