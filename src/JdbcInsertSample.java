import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcInsertSample {
	private static final String URL = "jdbc:mysql://localhost:3306/database01?user=user01&" + "password=password01&useSSL=false&allowPublicKeyRetrieval=true";
	
	public static void main(String[] args) throws ClassNotFoundException {
		try (Connection connection = DriverManager.getConnection(URL);
				PreparedStatement statement = connection.prepareStatement("insert into user (email, name) values (?, ?)")) {
			statement.setString(1,  "bbb@bbb.bbb");
			statement.setString(2, "山田三郎");
			int count = statement.executeUpdate();
			System.out.println("userテーブルに、新しく" + count + "件のデータが挿入されました");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
