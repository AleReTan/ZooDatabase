package net.reshetnikov;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import net.reshetnikov.UI.EditDialogController;

import java.io.IOException;

public class MainApp extends Application {

    private static  Stage primaryStage;

    public MainApp() {
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            this.primaryStage=primaryStage;
            FXMLLoader loader = new FXMLLoader();
            loader.load(getClass().getClassLoader().getResourceAsStream("fxml/mainView.fxml"));
            Parent root = loader.getRoot();

            primaryStage.setTitle("Zoo Database");
//            DatabaseOverviewController controller = new DatabaseOverviewController();
//            controller.setMainApp(this);
            primaryStage.setScene(new Scene(root, 800, 600));
            primaryStage.show();
            //showPersonOverview();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showEditDialog(Object object) {
        try {
//            FXMLLoader loader = new FXMLLoader();
//            Parent root = FXMLLoader.load(getClass().getResource("fxml/editDialog.fxml"));
            FXMLLoader loader = new FXMLLoader();
            loader.load(MainApp.class.getClassLoader().getResourceAsStream("fxml/editDialog.fxml"));
            Parent root = loader.getRoot();
            //loader.setLocation(MainApp.class.getResource("editDialog.fxml"));
            //AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Person");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(MainApp.getPrimaryStage());
            Scene scene = new Scene(root);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            EditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setObject(object);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();



        } catch (IOException e) {
            //System.out.print("[eq");
            e.printStackTrace();

        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
