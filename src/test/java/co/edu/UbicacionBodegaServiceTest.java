package co.edu;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import co.edu.uniandes.dse.parcial1.entities.UbicacionBodegaEntity;
import co.edu.uniandes.dse.parcial1.repositories.UbicacionBodegaRepository;
import co.edu.uniandes.dse.parcial1.services.UbicacionBodegaService;
import jakarta.transaction.Transactional;

@DataJpaTest
@Transactional
@Import(UbicacionBodegaService.class)
public class UbicacionBodegaServiceTest {
    @Autowired 
    private UbicacionBodegaService ubicacionBodegaService;
    

    @Test
    void bodegaCorrecta(){
        UbicacionBodegaEntity ubicacionBodegaEntity = new UbicacionBodegaEntity();
        ubicacionBodegaEntity.setNumero_de_estante(2);
        assertEquals(ubicacionBodegaService.crearUbicacion(ubicacionBodegaEntity), ubicacionBodegaEntity);
    }
    
    @Test
    void bodegaNoCorrecta(){
        UbicacionBodegaEntity ubicacionBodegaEntity = new UbicacionBodegaEntity();
        assertEquals(ubicacionBodegaService.crearUbicacion(ubicacionBodegaEntity), ubicacionBodegaEntity);
    }
}
