package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;

public class Programa {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.print("Numero do quanto:");
		Integer numeroDoQuarto = sc.nextInt();
		sc.nextLine();
		System.out.print("Data de checkin (DD/MM/YYYY):");
		Date checkin = sdf.parse(sc.nextLine());
		System.out.print("Data de checkout (DD/MM/YYYY):");
		Date checkout = sdf.parse(sc.nextLine());
		if(!checkout.after(checkin)) {
			System.out.println("Erro na reserva: data de checkout deve ser maior que a data de checkin!");
		}
		else {
			Reserva reserva = new Reserva(numeroDoQuarto, checkin, checkout);
			System.out.println(reserva.toString());
			System.out.println();
			System.out.println("Atualização da reserva:");
			System.out.print("Data de checkin (DD/MM/YYYY):");
			checkin = sdf.parse(sc.nextLine());
			System.out.print("Data de checkout (DD/MM/YYYY):");
			checkout = sdf.parse(sc.nextLine());
			Date diaAtual = new Date();
			if(diaAtual.after(checkin)||diaAtual.after(checkout)) {
				System.out.println("Datas para reserva devem ser maior que as anteriores");
			}
			else {
				if(!checkout.after(checkin)) {
					System.out.println("Erro na reserva: data de checkout deve ser maior que a data de checkin!");
				}
				else {
					reserva.atualizaDatas(checkin, checkout);
					System.out.println(reserva.toString());
				}
			}
			
		}
		sc.close();
	}

}
