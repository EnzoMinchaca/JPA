package Entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import lombok.*;
import org.hibernate.engine.internal.Cascade;


@Entity
@Table(name = "articulo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Articulo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "denominacion")
    private String denominacion;

    @Column(name = "precio")
    private int precio;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name="articulo_categoria", joinColumns = @JoinColumn(name = "articulo_id"),
    inverseJoinColumns = @JoinColumn(name="categoria_id"))
    private List<Categoria> categorias = new ArrayList<Categoria>();

    @OneToMany(mappedBy = "articulo", cascade = CascadeType.PERSIST)
    private List<DetalleFactura> detalle = new ArrayList<DetalleFactura>();
}