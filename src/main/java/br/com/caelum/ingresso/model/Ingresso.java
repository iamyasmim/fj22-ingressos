package br.com.caelum.ingresso.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Ingresso {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
	private Sessao sessao;
	
	private BigDecimal preco;

	@ManyToOne
	private Lugar lugar;
	
	@Enumerated(EnumType.STRING)
	private TipoDeIngresso tipoIngresso;

	public Ingresso() {

	}

	public Ingresso(Sessao sessao, TipoDeIngresso tipoIngresso, Lugar lugar) {
		this.sessao = sessao;
		this.tipoIngresso = tipoIngresso;
		this.preco = tipoIngresso.aplicaDesconto(sessao.getPreco());
		this.lugar = lugar;
	}

	public Sessao getSessao() {
		return sessao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public Integer getId() {
		return id;
	}

	public Lugar getLugar() {
		return lugar;
	}

	public TipoDeIngresso getTipoIngresso() {
		return tipoIngresso;
	}

}
