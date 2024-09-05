package Entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "factura")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha")
    private String fecha;

    @Column(name = "numero")
    private int numero;

    @Column(name = "total")
    private int total;

    //@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    //private List<DetalleFactura> detalles = new ArrayList<DetalleFactura>();

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleFactura> detalles = new ArrayList<DetalleFactura>();

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_cliente")
    private Cliente cliente;
}