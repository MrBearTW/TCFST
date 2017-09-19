
public class Chicken extends Bird {

    String crest;
    void setCrest(String crest){
        this.crest = crest;
    }
    String getCrest(){
        return crest;
    }
    
    String getName(){      //protected public
        return "*"+super.getName()+"*";
    }
    
    void wuwuwu(){
        System.out.println(name+" wuwuwu!!");
    }
}