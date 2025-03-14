package mx.uam.ayd.proyecto.presentacion.recibirpedidos;

import java.util.List;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import mx.uam.ayd.proyecto.negocio.modelo.Pedido;

import org.springframework.stereotype.Component;

@Component
public class VentanaRecibirPedidos {


		private Stage stage;
		private ControlRecibirPedidos control;
		private boolean initialized = false;
		private TableView<Pedido> tablaPedidos;
	    private ObservableList<Pedido> pedidos;
		/**
		 * Constructor without UI initialization
		 */
		public VentanaRecibirPedidos() {
			// Don't initialize JavaFX components in constructor
		}
		
		/**
		 * Initialize UI components on the JavaFX application thread
		 */
		private void initializeUI() {
			if (initialized) {
				return;
			}
			
			// Create UI only if we're on JavaFX thread
			if (!Platform.isFxApplicationThread()) {
				Platform.runLater(this::initializeUI);
				return;
			}
			
			stage = new Stage();
	        stage.setTitle("Recibir Pedidos");

	        // Crear etiqueta
	        Label lblTitulo = new Label("Pedidos Recibidos");


	        // Crear la tabla
	        tablaPedidos = new TableView<>();
	        pedidos = FXCollections.observableArrayList();
	        tablaPedidos.setItems(pedidos);

	        // Columnas de la tabla
	        TableColumn<Pedido, Long> columnaId = new TableColumn<>("ID Pedido");
	        columnaId.setCellValueFactory(new PropertyValueFactory<>("idPedido"));

	        TableColumn<Pedido, String> columnaProductos = new TableColumn<>("Productos");
	        columnaProductos.setCellValueFactory(new PropertyValueFactory<>("listaProductos"));


	        tablaPedidos.getColumns().addAll(columnaId, columnaProductos);

	        // Layout
	        VBox layout = new VBox(10);
	        layout.setPadding(new Insets(15));
	        layout.getChildren().addAll(lblTitulo, tablaPedidos);
	        
	        columnaId.setPrefWidth(100); 
	        columnaProductos.setPrefWidth(400);

	        // Crear escena
	        Scene scene = new Scene(layout, 500, 400);
	        stage.setScene(scene);

	        initialized = true;
			
			
		}
		
		public void muestra(ControlRecibirPedidos control) {
			this.control = control;
			
			if (!Platform.isFxApplicationThread()) {
				Platform.runLater(() -> this.muestra(control));
				return;
			}
			
			initializeUI();
			stage.show();
		}

}
