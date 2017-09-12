public class TestOL {
    public static void main (String args[]){
        System.out.println(sum(100,200));
		System.out.println(sum(48,654,5146,654,84));
		System.out.println(sum(94,87,9487,5566,55,66,1));
        System.out.println(sum(9,12,2017,1988,2000,1999));
    }
        /*
        static int sum(int a,int b){
            return a+b;
        }
        static int sum(int a,int b, int c){
            return a+b+c;
        }
        static int sum(int a,int b, int c, int d){
            return a+b+c+d;
        }
    */
        static int sum(int... nums){
            int result=0;
            for(int n:nums){
                result += n;
            }
            return result;
        }
        
    }
    
