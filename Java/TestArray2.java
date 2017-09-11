public class TestArray2 {
    public static void main(String args[]) {

/*  EX1.
        int[][] array=new int[2][3];
        
        array[0][0]= 99;
        array[0][1]= 88;
        array[0][2]= 77;

        array[1][0]= 66;
        array[1][1]= 55;
        array[1][2]= 44;

        for(int i=0;i<array.length;i++){
            
            for(int j=0;j<array[i].length;j++){
                System.out.print(array[i][j]+" ");
            }
            System.out.println("i="+i);
*/

/*  EX2  */
            int[][] array2 = {{11,22,33,44,55,66},{99,88,77}};
            for(int i=0;i<array2.length;i++){
                
                for(int j=0;j<array2[i].length;j++){
                        System.out.print(array2[i][j]+" ");
                    }
                    System.out.println("i="+i);            
                }
                System.out.println("array2="+array2);
                System.out.println("array[0]="+array2[0]);
                System.out.println("array[1]="+array2[1]);  
    }
    
}