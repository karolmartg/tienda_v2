/*
    Esta clase mapea los datos de la tabla proveniente de la BD
    El proceso debe ser el mismo para las demás tablas de la BD
*/

package com.tienda_v2.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "articulo") // articulo sale de la BD, tiene que llamarse igual
public class Articulo implements Serializable {
    private static final long serialVersionUID = 1L;    

    // Estas variables son las mismas que en la BD
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idArticulo;
    private Long idCategoria;
    private String descripcion;
    private String detalle;
    private int existencias;
    private boolean activo;

    // Constructor generico
    public Articulo() {
    }

    // Constructor especifico
    public Articulo(Long idCategoria, String descripcion, String detalle, int existencias, boolean activo) {
        this.idCategoria = idCategoria;
        this.descripcion = descripcion;
        this.detalle = detalle;
        this.existencias = existencias;
        this.activo = activo;
    }
}
