public class Bird{
    protected String name;

    void setName(String name){
        this.name = name;
    }
    String getName(){
        return "[[[[["+name+"]]]]]";
    }
    void walk(){
        System.out.println(getName()+" can walk!");
    }
}