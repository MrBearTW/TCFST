public class TestForeach {
    public static void main(String args[]) {
/*
        int[] nums ={1,2,3,4,5};
        for (int n: nums) {
            System.out.println(n);
*/
        int[][] nums2={{1,2,3,4},{5,6,7,8,9,}};
        for(int[] ns:nums2){
            for (int m: ns) {
                System.out.println(nums2+" "+ns+" "+m);
                //System.out.println(ns);
                //System.out.println(nums2);
            }
        }
    }
    
}