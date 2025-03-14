package mx.uam.ayd.proyecto.presentacion.recibirpedidos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ControlRecibirPedidos {

	@Autowired
	private VentanaRecibirPedidos ventana;
	
	public void inicia() {

		ventana.muestra(this);
	}

}
