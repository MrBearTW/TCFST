public class TestArgs {
    public static void main(String args[]) {
        /*
        System.out.println(args[0]);
        System.out.println();
        */
        
        /*
        for(int i = 0; i < args.length; i++)
        System.out.print(args[i] + " ");
        */
        
        /*
        for (String s : args) {
            System.out.println(s);
        */
        String Answer="a,a,b,c,c,b,d,d,c,c,a,";
        String[] Ans =Answer.split(",");
        for(int i = 0; i < Ans.length; i++){
        System.out.print("No."+(i+1)+"="+Ans[i]+" ");
        }
    }  
}