package hn.unah.lenguajes1900.creditos.services;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.internal.lang.annotation.ajcDeclareEoW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes1900.creditos.entities.Cliente;
import hn.unah.lenguajes1900.creditos.entities.Cuota;
import hn.unah.lenguajes1900.creditos.entities.Prestamo;
import hn.unah.lenguajes1900.creditos.repositories.ClienteRepository;
import hn.unah.lenguajes1900.creditos.repositories.CuotaRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CuotaRepository cuotaRepository;

    public Cliente crearCliente(Cliente cliente){
        
        if(clienteRepository.existsById(cliente.getDni())){
            return null;
        }else{
            List<Prestamo> prestamos = cliente.getPrestamos();
            
            double i = 0.09/12;
            if (prestamos != null){
                for(Prestamo prestamo:prestamos){
                    prestamo.setCliente(cliente);
                    int plazo = prestamo.getPlazo();
                    double exp = java.lang.Math.pow(1+i,plazo);
                    double cuota = (prestamo.getCuota()*i*exp)/(exp-1);
                    
                    
                   
                   

                    for(int j=0; j<=plazo*12; j++){
                        
                        if(j==0){
                            Cuota cuota0 = new Cuota();
                            cuota0.setCapital(0);
                            cuota0.setInteres(0);
                            cuota0.setMes(j);
                            cuota0.setSaldo(prestamo.getMonto());
                            cuota0.setCodigoPrestamo(prestamo.getCodigoPrestamo());
                            this.cuotaRepository.save(cuota0);
                        }
                        Cuota cuotaActual = new Cuota();
                        this.cuotaRepository.save(cuotaActual)

                        Cuota cuotaAnterior = this.cuotaRepository.findById(cuotaActual.getCodigoCuota()-1).get();
                        
                        cuotaActual.setCapital();
                        cuotaActual.setInteres(cuotaAnterior.getSaldo()*i);
                        cuotaActual.setMes(j);
                        cuotaActual.setSaldo(prestamo.getMonto());
                        cuotaActual.setCodigoPrestamo(prestamo.getCodigoPrestamo());
                        

                        
                    }
                 }
            }


            return this.clienteRepository.save(cliente);
        }
        
    }


    
}
