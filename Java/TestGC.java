public class TestGC{

    String name =" ";
    static int count= 0;
//Constructor
    public TestGC(String name){
        this.name=name;
        System.out.println(name+"is on");
    }
//method
    protected void finalize(){
        System.out.println(name+"is off");
    }
//method
    public static void main(String args[]){

        while(true){
            TestGC g =new TestGC("g"+ count++);
            g=null;
        }


    }


}