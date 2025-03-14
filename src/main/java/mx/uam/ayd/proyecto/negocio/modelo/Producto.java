package mx.uam.ayd.proyecto.negocio.modelo;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // Esto le dice a Spring que esta es una entidad persistente
public class Producto {

	@Id // Indica que este es el identificador
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Genera automáticamente el ID
	private long idProducto;

	private String nombre;
	
	private double precio;
	
	private String personalizacion;
	
	/**
	 * @return the idProducto
	 */
	public long getIdProducto() {
		return idProducto;
	}

	/**
	 * @param idProducto the idProducto to set
	 */
	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the precio
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * @return the personalizacion
	 */
	public String getPersonalizacion() {
		return personalizacion;
	}

	/**
	 * @param personalizacion the personalizacion to set
	 */
	public void setPersonalizacion(String personalizacion) {
		this.personalizacion = personalizacion;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return idProducto == other.idProducto;
	}
	
	@Override
	public int hashCode() {
		return (int) (31 * idProducto);
	}
	
	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", nombre=" + nombre + ", precio=" + precio + ", personalizacion=" + personalizacion + "]";
	}
}
