import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Test {
	private final static  String driver ="com.mysql.jdbc.Driver"; 
	private final static  String url="jdbc:mysql://localhost:3306/test";
	private final static  String userName ="root";
	private final static  String passWord ="root";
public static void main(String[] args) throws ClassNotFoundException, SQLException {

	Class.forName(driver);
	Connection con = DriverManager.getConnection(url, userName, passWord); // connection
	Statement stat=con.createStatement(); // create statement
	String createTable= "CREATE TABLE abhi " +
            "(id INTEGER not NULL, " +
             " first VARCHAR(255), " + 
            " last VARCHAR(255), " + 
            " age INTEGER, " + 
            " PRIMARY KEY ( id ))";  //write ur query
	//stat.executeUpdate(createTable);
	String retrive = "select * from jdbcdemo";
	
	String insert= "insert into jdbcdemo values(3,'ab','b',24)";
	stat.executeUpdate(insert);
	
	String delete ="delete from jdbcdemo where last='b'";
	
int i =	stat.executeUpdate(delete);
System.out.println(i);
ResultSet s=stat.executeQuery(retrive);

/*while(s.next())
{
	int id = s.getInt(1);
	String fname = s.getString(2);
	String lname = s.getString(3);
	int age = s.getInt(4);
	
	System.out.println(id+" "+fname+" "+lname+" "+age);
}*/

List l = new ArrayList();
while(s.next()){
	
	
	Employee e = new Employee();
	e.setId(s.getInt(1));
	e.setFname(s.getString(2));
	e.setLname(s.getString(3));
	e.setAge(s.getInt(4));
	//System.out.println(e);
	l.add(e);
}
System.out.println(l);
	stat.close();
	con.close();
}
}

