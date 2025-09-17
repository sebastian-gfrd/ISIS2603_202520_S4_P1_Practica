package co.edu.uniandes.dse.parcial1.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class MercanciaEntity extends BaseEntity{
   private String nombre;
   @Id
   private String codigo_de_barras;
   private LocalDateTime fecha_de_recepcion;
   private Integer cantidad_disponible;
   @OneToOne
   private UbicacionBodegaEntity ubicacion;
}
