package ebazer;

import java.util.List;

import tables.DefaultData;
import tables.Product;
import tables.ProductListWindow;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ProductList extends Stage {
	private TableView<Product> table = new TableView<Product>();
	Stage primaryStage;
	Product selected;
	EbazaarMainFrame mainFrom;
	
	public void setData(ObservableList<Product> cats) {
		table.setItems(cats);
	}
	@SuppressWarnings("unchecked")
	public ProductList(EbazaarMainFrame mainFrom,Stage ps) {
		primaryStage = ps;
		setTitle("Product List");
		
		final Label label = new Label("Product List");
        label.setFont(new Font("Arial", 16));
        HBox labelHbox = new HBox(10);
        labelHbox.setAlignment(Pos.CENTER);
        labelHbox.getChildren().add(label);
		
		TableColumn<Product, String> catalogNameCol = new TableColumn<>("Product");
		catalogNameCol.setMinWidth(250);
		catalogNameCol.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
		catalogNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
		
		table.getColumns().addAll(catalogNameCol);
		
		Button viewButton = new Button("View Catalog");
		Button backButton = new Button("Back to Start");
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setVgap(10); 
		grid.setHgap(10);
		grid.add(labelHbox, 0, 0);
		grid.add(table, 0, 1);
		HBox btnBox = new HBox(10);
		btnBox.setAlignment(Pos.CENTER);
		btnBox.getChildren().add(viewButton);
		btnBox.getChildren().add(backButton);
		grid.add(btnBox,0,3);
		
        
		backButton.setOnAction(evt -> {
			primaryStage.show();
			hide();
		});
		 
		viewButton.setOnAction(evt -> {
			selected = table.getSelectionModel().getSelectedItem();
			//ProductListWindow prodList = new ProductListWindow(this, selected);
			//List<Product> prods = DefaultData.PRODUCT_LIST_DATA.get(selected);
			//prodList.setData(FXCollections.observableList(prods));
			//hide();
			//prodList.show();
			
		});
        
        
   
        Scene scene = new Scene(grid,300, 250);  
		setScene(scene);
	}
	
}
