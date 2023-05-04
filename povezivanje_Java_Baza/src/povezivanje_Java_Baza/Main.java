package povezivanje_Java_Baza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/sistem_biblioteka";
		String username = "root";
		String password = "";

		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			System.out.println("Uspesna konekcija ka bazi");

			CRUD.create(conn);
			CRUD.read(conn);
			CRUD.update(conn);
			CRUD.read(conn);
			CRUD.delete(conn);
			CRUD.read(conn);

		}

		catch (SQLException e) {
			e.printStackTrace();
		}

	}

}