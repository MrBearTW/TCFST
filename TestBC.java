public class TestBC {
    public static void main(String args[]) {
        b_label:{
        c_label:
        int y = 0;
            for ( y<5;y++) {  
                //c_label:                        
                    for (int i=0;i<10;i++) {
                        if(i==7){
                        // break;
                        //continue;
                        //break b_label;
                        continue c_label;
                        }
                    System.out.print(i);
                }   
                System.out.println("  y="+y);
            }
        System.out.println("c_label , y="+y);
        } 
    }
    
}