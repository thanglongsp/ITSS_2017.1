import java.sql.*;
class Model {
	protected Connection conn;

	public Model(){
		conn = DriverManager.getConnection(myUrl, "username", "password");
	}
}