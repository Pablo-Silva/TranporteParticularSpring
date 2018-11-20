package br.edu.uniopet.tranporteparticular.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "VIAGEM_ROTA_TABLE")
public class ViagemRota {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_VIAGEM_ROTA")
    @Id
    private Long idViagemRota;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_VIAGEM")
    private Viagem viagem;

    @Column(name = "LATIDUTE")
    private Double latitude;

    @Column(name = "LONGITUDE")
    private Double longitude;

    public ViagemRota() {
    }

    public ViagemRota(Viagem viagem, Double latitude, Double longitude) {
        this.viagem = viagem;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getIdViagemRota() {
        return idViagemRota;
    }

    public void setIdViagemRota(Long idViagemRota) {
        this.idViagemRota = idViagemRota;
    }

    public Viagem getViagem() {
        return viagem;
    }

    public void setViagem(Viagem viagem) {
        this.viagem = viagem;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ViagemRota that = (ViagemRota) o;
        return Objects.equals(idViagemRota, that.idViagemRota) &&
                Objects.equals(viagem, that.viagem) &&
                Objects.equals(latitude, that.latitude) &&
                Objects.equals(longitude, that.longitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idViagemRota, viagem, latitude, longitude);
    }

    @Override
    public String toString() {
        return "ViagemRota{" +
                "idViagemRota=" + idViagemRota +
                ", viagem=" + viagem +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}