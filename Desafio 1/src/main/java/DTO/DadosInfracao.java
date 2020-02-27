package DTO;

import java.util.List;

public class DadosInfracao {
	
	private List<String> dadosPlaca;
	private String numeroAIT;
	private String orgaoAutuador;
	private String codigoinfracao;
	private String infracao;
	private String uf;
	private String municipio;
	private String endereco;
	private String dataVencida;
	private String DataAVencer;
	private String bancoFinanceiro;
	private String bancoDespachante;
	private String codigoBarras;
	private String numeroAITOriginal;
	private String chaveSAP;
	private String nomeDespachante;
	
	public List<String> getDadosPlaca() {
		return dadosPlaca;
	}

	public void setDadosPlaca(List<String> dadosPlaca) {
		this.dadosPlaca = dadosPlaca;
	}

	public String getNumeroAIT() {
		return numeroAIT;
	}
	
	public void setNumeroAIT(String numeroAIT) {
		this.numeroAIT = numeroAIT;
	}
	
	public String getOrgaoAutuador() {
		return orgaoAutuador;
	}
	
	public void setOrgaoAutuador(String orgaoAutuador) {
		this.orgaoAutuador = orgaoAutuador;
	}
	
	public String getCodigoinfracao() {
		return codigoinfracao;
	}
	
	public void setCodigoinfracao(String codigoinfracao) {
		this.codigoinfracao = codigoinfracao;
	}
	
	public String getInfracao() {
		return infracao;
	}
	
	public void setInfracao(String infracao) {
		this.infracao = infracao;
	}
	
	public String getUf() {
		return uf;
	}
	
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	public String getMunicipio() {
		return municipio;
	}
	
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getDataVencida() {
		return dataVencida;
	}

	public void setDataVencida(String dataVencida) {
		this.dataVencida = dataVencida;
	}
	
	public String getDataAVencer() {
		return DataAVencer;
	}

	public void setDataAVencer(String DataAVencer) {
		this.DataAVencer = DataAVencer;
	}

	public String getBancoFinanceiro() {
		return bancoFinanceiro;
	}
	
	public void setBancoFinanceiro(String bancoFinanceiro) {
		this.bancoFinanceiro = bancoFinanceiro;
	}
	
	public String getBancoDespachante() {
		return bancoDespachante;
	}

	public void setBancoDespachante(String bancoDespachante) {
		this.bancoDespachante = bancoDespachante;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}
	
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getNumeroAITOriginal() {
		return numeroAITOriginal;
	}

	public void setNumeroAITOriginal(String numeroAITOriginal) {
		this.numeroAITOriginal = numeroAITOriginal;
	}

	public String getChaveSAP() {
		return chaveSAP;
	}

	public void setChaveSAP(String chaveSAP) {
		this.chaveSAP = chaveSAP;
	}

	public String getNomeDespachante() {
		return nomeDespachante;
	}

	public void setNomeDespachante(String nomeDespachante) {
		this.nomeDespachante = nomeDespachante;
	}
	
}