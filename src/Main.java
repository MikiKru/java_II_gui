import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public Main() {
        System.out.println("kontstruktor");
    }
    @Override
    public void init(){
        System.out.println("init");
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        System.out.println("start");
        Parent root = FXMLLoader.load(getClass().getResource("/view/login.fxml"));
        primaryStage.setTitle("Login panel");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    @Override
    public void stop(){
        System.out.println("stop");
    }


    public static void main(String[] args) {
        launch(args);
    }
}
