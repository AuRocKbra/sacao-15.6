package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DominioDeExcecao;

public class Reserva {
	private Integer numeroDoQuarto;
	private Date dataDeCheckin;
	private Date dataDeCheckout;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva() {
		
	}

	public Reserva(Integer numeroDoQuarto, Date dataDeCheckin, Date dataDeCheckout) throws DominioDeExcecao{
		if(!dataDeCheckout.after(dataDeCheckin)) {
			throw new DominioDeExcecao("Erro na reserva: data de checkout deve ser maior que a data de checkin!");
		}
		else {
			this.numeroDoQuarto = numeroDoQuarto;
			this.dataDeCheckin = dataDeCheckin;
			this.dataDeCheckout = dataDeCheckout;
		}
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
	
	public void atualizaDatas(Date checkin, Date checkout) throws DominioDeExcecao{
		Date diaAtual = new Date();
		if(diaAtual.after(checkin)||diaAtual.after(checkout)) {
			throw new DominioDeExcecao("Datas para reserva devem ser maior que as anteriores");
		}
		else {
			if(!checkout.after(checkin)) {
				throw new DominioDeExcecao("Erro na reserva: data de checkout deve ser maior que a data de checkin!");
			}
			else {
				this.dataDeCheckin = checkin;
				this.dataDeCheckout = checkout;
			}
		}
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
