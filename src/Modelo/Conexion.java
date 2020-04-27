package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;


public class Conexion {

	String BBDDName;
	Connection c = null;
	Statement stmt = null;

	public Conexion(String path) {
		BBDDName = path;
	}

	public boolean sentenciaSQL(String sql) {
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:"+BBDDName);
			stmt = c.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
			c.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			return false;
		}
		return true;
	}

	public void consulta() {
		ArrayList <Persona> company = new ArrayList <Persona>();
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:"+BBDDName);
			c.setAutoCommit(false);

			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery( "SELECT * FROM COMPANY;" );

			while ( rs.next() ) {
				int id = rs.getInt("id");
				String  name = rs.getString("name");
				int age  = rs.getInt("age");
				String  address = rs.getString("address");
				float salary = rs.getFloat("salary");
				String hora1 = rs.getString("TIME1");
				String hora2 = rs.getString("TIME2");
				
				company.add(new Persona(id, name, age, address, salary, hora1, hora2));
				System.out.print( "ID = " + id );
				System.out.print( ", NAME = " + name );
				System.out.print( ", AGE = " + age );
				System.out.print( ", ADDRESS = " + address );
				System.out.print( ", SALARY = " + salary );
				System.out.print( ", HORA1 = " + hora1);
				System.out.println( ", HORA2 = " + hora2);
			}

			rs.close();
			stmt.close();
			c.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		}
		System.out.println("Consulta terminada");
	}

}
