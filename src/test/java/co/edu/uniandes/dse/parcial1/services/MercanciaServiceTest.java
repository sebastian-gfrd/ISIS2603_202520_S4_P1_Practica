package co.edu.uniandes.dse.parcial1.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import co.edu.uniandes.dse.parcial1.entities.MercanciaEntity;
import jakarta.transaction.Transactional;

@DataJpaTest
@Transactional
@Import(MercanciaService.class)
public class MercanciaServiceTest {
    @Autowired
    MercanciaService mercanciaService;

    @Test
    void mercanciaExitosa(){
        MercanciaEntity mercanciaEntity = new MercanciaEntity();
        mercanciaEntity.setCodigo_de_barras("4537834");
        mercanciaEntity.setNombre("Mercancia correcta");
        mercanciaEntity.setFecha_de_recepcion(LocalDateTime.of(2007, 7, 6, 0, 0, 0));
        assertEquals(mercanciaEntity, mercanciaService.crearMercancia(mercanciaEntity));
    }
    @Test
    void mercanciaFallida(){
        MercanciaEntity mercanciaEntity = new MercanciaEntity();
        assertEquals(mercanciaEntity, mercanciaService.crearMercancia(mercanciaEntity));
    }
}