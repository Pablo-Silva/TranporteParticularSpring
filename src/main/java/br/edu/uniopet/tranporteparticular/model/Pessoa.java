package br.edu.uniopet.tranporteparticular.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "PESSOA_TABLE")
public class Pessoa {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PESSOA")
    @Id
    private Long idPessoa;

    @Column(name = "PRIMEIRO_NOME")
    private String primeiroNome;

    @Column(name = "SOBRENOME")
    private String sobrenome;

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

    public Pessoa() {
    }

    public Pessoa(String primeiroNome, String sobrenome, Date dataNascimento, Character sexo, String cpf, String numeroCelular, String email, String senha, Date dataCadastro) {
        this.primeiroNome = primeiroNome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.cpf = cpf;
        this.numeroCelular = numeroCelular;
        this.email = email;
        this.senha = senha;
        this.dataCadastro = dataCadastro;

    }

    public Long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
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
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(idPessoa, pessoa.idPessoa) &&
                Objects.equals(primeiroNome, pessoa.primeiroNome) &&
                Objects.equals(sobrenome, pessoa.sobrenome) &&
                Objects.equals(dataNascimento, pessoa.dataNascimento) &&
                Objects.equals(sexo, pessoa.sexo) &&
                Objects.equals(cpf, pessoa.cpf) &&
                Objects.equals(numeroCelular, pessoa.numeroCelular) &&
                Objects.equals(email, pessoa.email) &&
                Objects.equals(senha, pessoa.senha) &&
                Objects.equals(dataCadastro, pessoa.dataCadastro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPessoa, primeiroNome, sobrenome, dataNascimento, sexo, cpf, numeroCelular, email, senha, dataCadastro);
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "idPessoa=" + idPessoa +
                ", primeiroNome='" + primeiroNome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", sexo=" + sexo +
                ", cpf='" + cpf + '\'' +
                ", numeroCelular='" + numeroCelular + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", dataCadastro=" + dataCadastro +
                '}';
    }
}
