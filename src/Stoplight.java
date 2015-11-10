    import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

    public class Stoplight extends Application {
      @Override // Override the start method in the Application class
      public void start(Stage primaryStage) {
        // Create a pane 
        Pane pane = new Pane();
        pane.getChildren().add(getVBox());
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Stoplight"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
      }
      

      
      private VBox getVBox() {
        VBox vBox = new VBox(15);
        
        Circle circle = new Circle();    
        circle.setRadius(50);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.RED);
        
        Circle circle1 = new Circle();
        circle1.setRadius(50);
        circle1.setStroke(Color.BLACK);
        circle1.setFill(Color.YELLOW);
        
        Circle circle2 = new Circle();
        circle2.setRadius(50);
        circle2.setStroke(Color.BLACK);
        circle2.setFill(Color.GREEN);
        
        Circle[] circles = {circle, circle1, 
            circle2};

        for (Circle c: circles) {
          VBox.setMargin(c, new Insets(0, 0, 0, 25));
          vBox.getChildren().add(c);
        }
        
        return vBox;
      }

      public static void main(String[] args) {
        launch(args);
      }
    } 
