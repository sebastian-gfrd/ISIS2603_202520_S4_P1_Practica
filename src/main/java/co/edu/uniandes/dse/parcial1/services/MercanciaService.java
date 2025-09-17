package co.edu.uniandes.dse.parcial1.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniandes.dse.parcial1.entities.MercanciaEntity;
import co.edu.uniandes.dse.parcial1.repositories.MercanciaRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MercanciaService {
    @Autowired 
    MercanciaRepository mercanciaRepository;

    @Transactional
    public MercanciaEntity crearMercancia(MercanciaEntity mercanciaEntity){
        LocalDateTime hoy = LocalDateTime.now();
        Boolean condition1 = mercanciaRepository.findById(mercanciaEntity.getId()) != null;
        Boolean condition2 = mercanciaEntity.getNombre() != null;
        Boolean condition3 = mercanciaEntity.getFecha_de_recepcion().isBefore(hoy);
        if (condition1 && condition2 && condition3){
            return mercanciaRepository.save(mercanciaEntity);
        }
        else
        {
            return null;
        }

    }


    
}
