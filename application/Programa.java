package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;
import model.exceptions.DominioDeExcecao;

public class Programa {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			System.out.print("Numero do quanto:");
			Integer numeroDoQuarto = sc.nextInt();
			sc.nextLine();
			System.out.print("Data de checkin (DD/MM/YYYY):");
			Date checkin = sdf.parse(sc.nextLine());
			System.out.print("Data de checkout (DD/MM/YYYY):");
			Date checkout = sdf.parse(sc.nextLine());
			Reserva reserva = new Reserva(numeroDoQuarto, checkin, checkout);
			System.out.println(reserva.toString());
			System.out.println();
			System.out.println("Atualização da reserva:");
			System.out.print("Data de checkin (DD/MM/YYYY):");
			checkin = sdf.parse(sc.nextLine());
			System.out.print("Data de checkout (DD/MM/YYYY):");
			checkout = sdf.parse(sc.nextLine());
			reserva.atualizaDatas(checkin, checkout);
			System.out.println(reserva);
		}catch (ParseException e) {
			System.out.println("Formato de data inválida!");
		}catch (DominioDeExcecao e) {
			System.out.println(e.getMessage());
		}catch (RuntimeException e) {
			System.out.println("Erro inesperado!");
		}
		finally {
			sc.close();
		}
	}

}
