package save;

import java.io.File;
import java.util.Scanner;

import javax.swing.JOptionPane;

import interfaz.Pantallas;




public class cargasmasivas {
	public static int validez=0;
	//Para Alumnos
	public static  String APPS[][];
	public static int rowsAPPS ;
	public static int columnsAPPS;
	
	public void CARGAaplicaciones() {
		
		Pantallas p = new Pantallas();
		try {
			
			System.out.println("Hola soy el cargasr");
			//File txt = new File("Prueba.csv");
			//Prueba.csv
			File txt = new File(Pantallas.ruta.getText());
			Scanner reader = new Scanner(txt);
			String data="";
			while(reader.hasNextLine()) {
				data += reader.nextLine()+"\n";
			}
			
			String rows [] = data.split("\n");
			rowsAPPS =rows.length;
		
			
			String columns[]=rows[0].split(",");
			columnsAPPS=columns.length;
			
			
			if(rowsAPPS<=250) {
				
				APPS = new String[rows.length][6];
			System.out.println("Fueron ingresdaos: "+rowsAPPS+" aplicaciones" ); 
			
			
			for(int i =0; i<rows.length;i++) {
				columns=rows[i].split(",");
				for(int j=0;j<columns.length;j++) {
					APPS[i][j]=(columns[j]);
					
				}
			}
			
	
			
			validez=1;
			
	
			JOptionPane.showMessageDialog(null, "Lista de aplicaciones cargada!");
			}else {
				JOptionPane.showMessageDialog(null, "El sistema solo acepta 150 aplicaciones: y esta ingresando: " +rowsAPPS+ " aplicaciones");
				System.out.println( );
			}
			
			p.aplicaciones();
			reader.close();
			
		}catch(Exception e) {
			System.out.println("Hubo un error en cargar apps error: " + e);
		}
	
}
	}