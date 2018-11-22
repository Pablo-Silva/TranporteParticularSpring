package br.edu.uniopet.tranporteparticular.payload;

public class BuscarViagem {

    private String enderecoChegada;

    private String enderecoSaida;

    public String getEnderecoChegada() {
        return enderecoChegada;
    }

    public void setEnderecoChegada(String enderecoChegada) {
        this.enderecoChegada = enderecoChegada;
    }

    public String getEnderecoSaida() {
        return enderecoSaida;
    }

    public void setEnderecoSaida(String enderecoSaida) {
        this.enderecoSaida = enderecoSaida;
    }
}
