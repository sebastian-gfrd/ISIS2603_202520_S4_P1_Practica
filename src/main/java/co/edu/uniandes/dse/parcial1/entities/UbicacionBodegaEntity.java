package co.edu.uniandes.dse.parcial1.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class UbicacionBodegaEntity extends BaseEntity{
    @Id
    private Integer numero_de_estante;
    @OneToMany
    private List<MercanciaEntity> canasta = new ArrayList<MercanciaEntity>();
    private Integer peso_maximo;
}   
