package povezivanje_Java_Baza;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class CRUD {

	public static void create(Connection conn) throws SQLException {

		String insert1 = "INSERT INTO biblioteke(NazivBiblioteke, Grad, Adresa, adresaBroj) VALUES (?, ?, ?, ?)";
		PreparedStatement p = conn.prepareStatement(insert1);
		String insert2 = "INSERT INTO biblioteke(NazivBiblioteke, Grad, Adresa, adresaBroj, Telefon) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement s = conn.prepareStatement(insert2);

		p.setString(1, "Biblioteka 1");
		p.setString(2, "Vranje");
		p.setString(3, "Glavna ulica");
		p.setString(4, "9");

		s.setString(1, "Biblioteka 2");
		s.setString(2, "Beograd");
		s.setString(3, "Južna ulica");
		s.setString(4, "95");
		s.setString(5, "069/79-35-997");

		int unet1 = p.executeUpdate();

		int unet2 = s.executeUpdate();

		if (unet1 > 0 && unet2 > 0) {
			System.out.println("Upisana su oba podatka!");

		}
	}

	public static void read(Connection conn) throws SQLException {

		String select = "SELECT * FROM biblioteke";
		Statement stmt = conn.createStatement();
		ResultSet result = stmt.executeQuery(select);

		System.out.println("\nPodaci iz tabele Biblioteke:");

		while (result.next()) {
			String naziv = result.getString(2);
			String grad = result.getString(3);
			String ulica = result.getString(4);
			String broj = result.getString(5);
			String telefon = result.getString(6);

			StringBuilder builder = new StringBuilder();
			builder.append("\nNaziv biblioteke: ");
			builder.append(naziv);
			builder.append("\nGrad: ");
			builder.append(grad);
			builder.append("\nAdresa: ");
			builder.append(ulica + " " + broj);
			builder.append("\nTelefon: ");
			builder.append(telefon);

			System.out.println(builder.toString());
		}
	}

	public static void update(Connection conn) throws SQLException {

		String update = "UPDATE biblioteke SET NazivBiblioteke = ?, Grad = ? WHERE bibliotekaID = ?";
		PreparedStatement ps = conn.prepareStatement(update);

		ps.setString(1, "Biblioteka 2.2");
		ps.setString(2, "Užice");

		ps.setString(3, "2");

		int promenjenPodatak = ps.executeUpdate();

		if (promenjenPodatak > 0) {
			System.out.println("\nIzmena naziva i grada je izvršena za ID 2!");
		}
	}

	public static void delete(Connection conn) throws SQLException {

		String delete = "DELETE FROM biblioteke WHERE BibliotekaID = ?";
		PreparedStatement ps = conn.prepareStatement(delete);

		ps.setString(1, "1");

		int obrisano = ps.executeUpdate();
		if (obrisano > 0) {
			System.out.println("\nObrisan je podatak za ID 1!");

		}
	}
}
