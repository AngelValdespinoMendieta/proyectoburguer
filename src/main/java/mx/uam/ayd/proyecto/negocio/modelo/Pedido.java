package mx.uam.ayd.proyecto.negocio.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPedido;

	private double costoTotal;
	
	@OneToMany // Relación: Un pedido puede tener muchos productos
	 //@JoinColumn(name = "idPedido")
	private List <Producto> productos = new ArrayList <> ();
	
	 /**
     * @return the idPedido
     */
    public long getIdPedido() {
        return idPedido;
    }

    /**
     * @param idPedido the idPedido to set
     */
    public void setIdPedido(long idPedido) {
        this.idPedido = idPedido;
    }

    /**
     * @return the costoTotal
     */
    public double getCostoTotal() {
        return costoTotal;
    }

    /**
     * @param costoTotal the costoTotal to set
     */
    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    /**
     * @return the productos
     */
    public List<Producto> getProductos() {
        return productos;
    }

    /**
     * @param productos the productos to set
     */
    public void setProductos(List<Producto> productos) {
        this.productos = productos;
        calcularCostoTotal();
    }

    /**
     * Agrega un producto al pedido y actualiza el costo total.
     */
    public void agregarProducto(Producto producto) {
        productos.add(producto);
        calcularCostoTotal();
    }

    /**
     * Elimina un producto del pedido y actualiza el costo total.
     */
    public void eliminarProducto(Producto producto) {
        productos.remove(producto);
        calcularCostoTotal();
    }

    /**
     * Calcula el costo total del pedido sumando los precios de los productos.
     */
    private void calcularCostoTotal() {
        this.costoTotal = productos.stream().mapToDouble(Producto::getPrecio).sum();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pedido other = (Pedido) obj;
        return idPedido == other.idPedido;
    }

    @Override
    public int hashCode() {
        return (int) (31 * idPedido);
    }

    @Override
    public String toString() {
        return "Pedido [idPedido=" + idPedido + ", costoTotal=" + costoTotal + ", productos=" + productos + "]";
    }
}
