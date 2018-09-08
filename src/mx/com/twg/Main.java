package mx.com.twg;

import java.util.List;
import java.util.Scanner;

import mx.com.twg.dao.PersonaDao;
import mx.com.twg.entity.Persona;

public class Main {

	private static PersonaDao pd = new PersonaDao();
	private static Scanner ent = new Scanner(System.in);
	private static boolean x;
	
	public static void main(String[] args) {
		int id =0;
		String nombre =null;
		String apellido =null;
		
		do {
		System.out.println("SELECT=1\nUPDATE=2\nDELETE=3\nINSERT=4\nEXIT=0");
		switch(ent.nextLine()) {
			case "1":
				select(pd.select());
				x=true;
				break;
			case "2":
					System.out.println("Id de la persona:");
				id = Integer.parseInt(ent.nextLine());
					System.out.println("Nuevo nombre:");
				nombre = ent.nextLine();
					System.out.println("Nuevo apellido:");
				apellido = ent.nextLine();
				pd.update(id, nombre, apellido);
				x=true;
			break;
			case "3":
					System.out.println("Id de la persona:");
				id = Integer.parseInt(ent.nextLine());
				pd.delete(id);
				x=true;
			break;
			case "4":
					System.out.println("Nombre:");
				nombre = ent.nextLine();
					System.out.println("Apellido:");
				apellido = ent.nextLine();
				pd.insert(nombre, apellido);
				x=true;
			break;
			default:
				x=false;
			break;
				
		}
			System.out.println("");
		}while(x);

	}
	
	private static void select(List<Persona> listaPersonas) {
		for(Persona p:listaPersonas) {
			System.out.println(p);
		}
	}
	

}
