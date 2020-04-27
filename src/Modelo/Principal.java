package Modelo;

import Modelo.Conexion;

public class Principal {

	public static void main( String args[] ) {
		String sentencia;

		Conexion bbdd = new Conexion("pruebas.db");
		sentencia = "DROP TABLE COMPANY;";
		bbdd.sentenciaSQL(sentencia);
		
		sentencia = "CREATE TABLE IF NOT EXISTS COMPANY (" +
						" ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
						" NAME           TEXT    NOT NULL, " + 
						" AGE            INT     NOT NULL, " + 
						" ADDRESS        CHAR(50), " + 
						" SALARY         REAL, " +
						" TIME1          TEXT DEFAULT CURRENT_TIMESTAMP, " +
						" TIME2          TEXT DEFAULT(strftime('%Y-%m-%d %H:%M:%f', 'now', 'localtime')) " + 
						")"; 
		
		bbdd.sentenciaSQL(sentencia);

		sentencia = "INSERT INTO COMPANY (NAME,AGE,ADDRESS,SALARY) VALUES ('Paul', 32, 'California', 20000.00 );";
		bbdd.sentenciaSQL(sentencia); 

		sentencia = "INSERT INTO COMPANY (NAME,AGE,ADDRESS,SALARY) " +
								 "VALUES ('Allen', 25, 'Texas', 15000.00 ), " + 
									    "('Teddy', 23, 'Norway', 20000.00 ), " +
									    "('Mark', 25, 'Rich-Mond ', 65000.00 );";
		bbdd.sentenciaSQL(sentencia);

		bbdd.consulta();	   
	}

}