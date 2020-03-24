package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
	private Integer numeroDoQuarto;
	private Date dataDeCheckin;
	private Date dataDeCheckout;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva() {
		
	}

	public Reserva(Integer numeroDoQuarto, Date dataDeCheckin, Date dataDeCheckout) {
		this.numeroDoQuarto = numeroDoQuarto;
		this.dataDeCheckin = dataDeCheckin;
		this.dataDeCheckout = dataDeCheckout;
	}

	public Integer getNumeroDoQuarto() {
		return numeroDoQuarto;
	}

	public void setNumeroDoQuarto(Integer numeroDoQuarto) {
		this.numeroDoQuarto = numeroDoQuarto;
	}

	public Date getDataDeCheckin() {
		return dataDeCheckin;
	}

	public Date getDataDeCheckout() {
		return dataDeCheckout;
	}
	
	public long duracaoDaReserva() {
		long duracao = this.dataDeCheckout.getTime() - this.dataDeCheckin.getTime();
		return TimeUnit.DAYS.convert(duracao,TimeUnit.MILLISECONDS);
	}
	
	public void atualizaDatas(Date checkin, Date checkout) {
		this.dataDeCheckin = checkin;
		this.dataDeCheckout = checkout;
	}
	
	@Override
	public String toString() {
		return "Número do quarto:"
				+this.numeroDoQuarto
				+", checkin:"+sdf.format(dataDeCheckin)
				+", checkout:"+sdf.format(dataDeCheckout)
				+", dias: "+duracaoDaReserva();
	}
}
