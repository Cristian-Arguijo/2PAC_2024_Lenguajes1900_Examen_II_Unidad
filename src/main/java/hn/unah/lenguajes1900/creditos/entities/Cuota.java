package hn.unah.lenguajes1900.creditos.entities;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="cuotas")
public class Cuota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codigocuota")
    private int codigoCuota;

    private int mes;

    private double interes;

    private double capital;

    private double saldo;

    private int codigoPrestamo;

   /*@JsonIgnore
    @ManyToOne()
    @JoinColumn(name="codigoprestamo", referencedColumnName = "codigoprestamo")
    private Prestamo prestamo;*/
}
