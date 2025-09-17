package co.edu.uniandes.dse.parcial1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniandes.dse.parcial1.entities.MercanciaEntity;
import co.edu.uniandes.dse.parcial1.entities.UbicacionBodegaEntity;
import co.edu.uniandes.dse.parcial1.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.parcial1.repositories.MercanciaRepository;
import co.edu.uniandes.dse.parcial1.repositories.UbicacionBodegaRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MercanciaUbicacionBodegaService {
    @Autowired
    private MercanciaRepository mercanciaRepository;
    @Autowired
    private UbicacionBodegaRepository ubicacionBodegaRepository;
    @Transactional
    public UbicacionBodegaEntity añadirMercanciaAubicacionBodega(Long mercanciaId, UbicacionBodegaEntity ubicacionBodegaEntity) throws EntityNotFoundException{
        MercanciaEntity mercancia = mercanciaRepository.findById(mercanciaId) .orElseThrow(() -> new EntityNotFoundException("Mercancia no encontrada") );
        ubicacionBodegaEntity.getCanasta().add(mercancia);
        UbicacionBodegaEntity saved = ubicacionBodegaRepository.save(ubicacionBodegaEntity);

        mercancia.setUbicacion(saved);
        mercanciaRepository.save(mercancia);
        return saved;
    }
}
