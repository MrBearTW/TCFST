public class TestJDBC1 {
    public static void main(String args[]){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Loading JDBC driver");
        }
        catch(ClassNotFoundException cnfe){
            System.out.println("Cant not loading JDBC driver");        }
    }       
}


//  java -classpath .;C:\JavaSpace\Java\mysql-connector-java-5.1.44\mysql-connector-java-5.1.44-bin.jar TestJDBC1