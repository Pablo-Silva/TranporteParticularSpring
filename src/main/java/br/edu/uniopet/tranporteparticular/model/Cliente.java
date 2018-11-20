package br.edu.uniopet.tranporteparticular.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "CLIENTE_TABLE")
public class Cliente {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLIENTE")
    @Id
    private Long idCliente;

    @Column(name = "NOME_CLIENTE")
    private String nomeCliente;

    @Column(name = "DATA_NASCIMENTO")
    private Date dataNascimento;

    @Column(name = "SEXO")
    private Character sexo;

    @Column(name = "CPF")
    private String cpf;

    @Column(name = "NUMERO_CELULAR")
    private String numeroCelular;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "SENHA")
    private String senha;

    @Column(name = "DATA_CADASTRO")
    private Date dataCadastro;

    @Column(name = "TIPO_DEFICIENCIA")
    private String tipoDeficiencia;

    @OneToMany(mappedBy = "cliente")
    private List<Viagem> viagens = new ArrayList<>();

    @OneToMany(mappedBy = "cliente")
    private List<Cartoes> cartoesList = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(String nomeCliente, Date dataNascimento, Character sexo, String cpf, String numeroCelular, String email, String senha, Date dataCadastro, String tipoDeficiencia, List<Viagem> viagens, List<Cartoes> cartoesList) {
        this.nomeCliente = nomeCliente;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.cpf = cpf;
        this.numeroCelular = numeroCelular;
        this.email = email;
        this.senha = senha;
        this.dataCadastro = dataCadastro;
        this.tipoDeficiencia = tipoDeficiencia;
        this.viagens = viagens;
        this.cartoesList = cartoesList;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getTipoDeficiencia() {
        return tipoDeficiencia;
    }

    public void setTipoDeficiencia(String tipoDeficiencia) {
        this.tipoDeficiencia = tipoDeficiencia;
    }

    public List<Viagem> getViagens() {
        return viagens;
    }

    public void setViagens(List<Viagem> viagens) {
        this.viagens = viagens;
    }

    public List<Cartoes> getCartoesList() {
        return cartoesList;
    }

    public void setCartoesList(List<Cartoes> cartoesList) {
        this.cartoesList = cartoesList;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(idCliente, cliente.idCliente) &&
                Objects.equals(nomeCliente, cliente.nomeCliente) &&
                Objects.equals(dataNascimento, cliente.dataNascimento) &&
                Objects.equals(sexo, cliente.sexo) &&
                Objects.equals(cpf, cliente.cpf) &&
                Objects.equals(numeroCelular, cliente.numeroCelular) &&
                Objects.equals(email, cliente.email) &&
                Objects.equals(senha, cliente.senha) &&
                Objects.equals(dataCadastro, cliente.dataCadastro) &&
                Objects.equals(tipoDeficiencia, cliente.tipoDeficiencia) &&
                Objects.equals(viagens, cliente.viagens) &&
                Objects.equals(cartoesList, cliente.cartoesList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCliente, nomeCliente,dataNascimento, sexo, cpf, numeroCelular, email, senha, dataCadastro, tipoDeficiencia, viagens, cartoesList);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", nomeCliente='" + nomeCliente + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", sexo=" + sexo +
                ", cpf='" + cpf + '\'' +
                ", numeroCelular='" + numeroCelular + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", dataCadastro=" + dataCadastro +
                ", tipoDeficiencia='" + tipoDeficiencia + '\'' +
                ", viagens=" + viagens +
                ", cartoesList=" + cartoesList +
                '}';
    }
}
