package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcCommitSample {
	private static final String URL = "jdbc:mysql://localhost:3306/database01?user=user01&"
			+ "password=password01&useSSL=false&allowPublicKeyRetrieval=true";
	
	public static void main(String[] args) throws ClassNotFoundException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL);
			connection.setAutoCommit(false);
			
			PreparedStatement statement = connection.prepareStatement("update user2 set money = money - ? where id = ?");
			statement.setInt(1, 10000);
			statement.setLong(2, 2);
			
			statement.executeUpdate();
			connection.commit();
			System.out.println("正常にコミットが実行されました");
		} catch (Exception e) {
			try {
				connection.rollback();
				System.out.println("コミットに失敗しロールバックが実行されました");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
	}
	
	
}
