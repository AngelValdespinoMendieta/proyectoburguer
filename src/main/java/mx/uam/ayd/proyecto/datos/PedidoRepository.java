package mx.uam.ayd.proyecto.datos;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Pedido;

	
	public interface PedidoRepository extends JpaRepository<Pedido, Long> {
		
	    List<Pedido> findAllByOrderByIdPedidoAsc(); 
	}


