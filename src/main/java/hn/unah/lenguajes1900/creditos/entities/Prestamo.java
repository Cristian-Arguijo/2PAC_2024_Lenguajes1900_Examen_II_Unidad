package hn.unah.lenguajes1900.creditos.entities;

import java.sql.Date;
import java.util.List;

import org.hibernate.annotations.ManyToAny;
import org.springframework.cache.annotation.CachePut;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data 
@Table(name="prestamos")
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigoprestamo")
    private int codigoPrestamo;

    @Column(name="fechaapertura")
    private Date fechaApertura;

    private double cuota;

    private double monto;

    private int plazo;

    private double interes;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="dni", referencedColumnName = "dni")
    private Cliente cliente;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name="codigoprestamo", referencedColumnName = "codigoprestamo")
    private List<Cuota> cuotas;
   /*@OneToMany(mappedBy = "prestamo", cascade = CascadeType.ALL)
    private List<Cuota> cuotas;*/
}
