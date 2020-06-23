/**
 * @author Bill Glinton
 * @author Mandy Achieng
 * @author Dennis Gikunju
 */

/**
 * The Video Library Rentals System
 * Version 2.0
 */

import javafx.application.Application; 
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.scene.control.ComboBox; 
import javafx.scene.layout.GridPane; 
import javafx.scene.text.Text; 
import javafx.scene.control.TextField; 
import javafx.stage.Stage;
import java.sql.*; 

public class Genres extends Application{

    /**
     * Declaring some global DB variables
     */
    Connection conn = null; //Connection variable
    String url = "jdbc:mysql://localhost/vlrs";  //Database link
    String user = "root";   //Username
    String pass = "";   //Password

    /**
     * This method is used to display the entire GUI on a stage
     */
    @Override
    public void start(Stage stage) throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException ce) {
            System.out.println("Error: unable to load driver class!");
            System.exit(1);
        }
        /**
         * Label for Name
         */
        Text label_1 = new Text("Name:");

        /**
         * Label for Registered
         */
        Text label_2 = new Text("Registered:");

        /**
         * Text Field for Name
         */
        TextField textField1 = new TextField();

        /**
         * Combo Box For Registered
         */
        ComboBox comboBox = new ComboBox();

        /**
         * Save Button
         */
        Button saveButton = new Button("Save");

        /**
         * Remove Button
         */
        Button removeButton = new Button("Remove");

        /**
         * Save Button Event Handler
         */
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                System.out.println("Data successfully entered into the database");  //Notification Message
                try {
                    String sql = "INSERT INTO genres"+"(genre,isactive) VALUES(?,?)";   //INSERT statement
                    final PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1,textField1.getText());
                    stmt.setInt(2,1);
                    stmt.executeUpdate();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
        };
        saveButton.addEventHandler(MouseEvent.MOUSE_CLICKED,eventHandler);

        /**
         * Grid Pane
         */
        GridPane gridPane = new GridPane();
        
        /**
         * Size of the Pane
         */
        gridPane.setMinSize(600, 400);
        
        /**
         * Padding setting
         */
        gridPane.setPadding(new Insets(10, 10, 10, 10)); 

        /**
         * Vertical Gaps between the Columns Setting
         */
        gridPane.setVgap(5); 

        /**
         * Horizontal Gaps between the Columns Setting
         */
        gridPane.setHgap(5);
        
        /**
         * Grid alignment setting
         */
        gridPane.setAlignment(Pos.CENTER);

        /**
         * Arranging the label_1 Node in the grid
         */
        gridPane.add(label_1, 0, 0); 

        /**
         * Arranging the textField1 node in the grid
         */
        gridPane.add(textField1, 1, 0);

        /**
         * Arranging the saveButton node in the grid
         */
        gridPane.add(saveButton, 1, 1);

        /**
         * Arranging the label_2 node in the grid
         */
        gridPane.add(label_2,0,2);

        /**
         * Arranging the comboBox node in the grid
         */
        gridPane.add(comboBox,1,2);

        /**
         * Arranging the removeButton in the grid
         */
        gridPane.add(removeButton, 1, 3);

        /**
         * saveButton node style
         */
        saveButton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        
        /**
         * saveButton node size
         */
        saveButton.setMinSize(300, 30);

        /**
         * removeButton node style
         */
        removeButton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

        /**
         * removeButton node size
         */
        removeButton.setMinSize(300, 30);

        /**
         * comboBox node size
         */
        comboBox.setMinSize(300, 30);

        /**
         * label_1 node style
         */
        label_1.setStyle("-fx-font: normal bold 20px 'serif' ");

        /**
         * label_2 node style
         */
        label_2.setStyle("-fx-font: normal bold 20px 'serif' ");

        /**
         * gridPane node 
         */
        gridPane.setStyle("-fx-background-color: BEIGE;");
        
        /**
         * Scene object
         */
        Scene scene = new Scene(gridPane);

        /**
         * Stage Title
         */
        stage.setTitle("Genre Registration Page");

        /**
         * Stage scene
         */
        stage.setScene(scene);

        /**
         * Display the contents of the stage
         */
        stage.show();
    }
    /**
     * 
     * @param args
     */
    public static void main(String[] args){
        launch(args);
    }
    
}