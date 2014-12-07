package net.reshetnikov.UI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import net.reshetnikov.DBService.InteractionService;
import net.reshetnikov.Logic.*;
import net.reshetnikov.MainApp;
import org.controlsfx.dialog.Dialogs;

import java.util.ArrayList;
import java.util.List;

public class DatabaseOverviewController {

    @FXML
    private TabPane tabPane;
    @FXML
    private Tab animalTab;
    @FXML
    private TableView<Animal> animalTable;
    @FXML
    private TableColumn animalNumber;
    @FXML
    private TableColumn animalName;
    @FXML
    private TableColumn age;
    @FXML
    private TableColumn sex;
    @FXML
    private TableColumn animalType;
    @FXML
    private TableColumn animalZone;

    @FXML
    private Tab animalTypeTab;
    @FXML
    private TableView<AnimalType> animalTypeTable;
    @FXML
    private TableColumn animalTypeNumber;
    @FXML
    private TableColumn animalTypeTitle;
    @FXML
    private TableColumn animalCount;
    @FXML
    private TableColumn foodPerDay;

    @FXML
    private Tab foodTab;
    @FXML
    private TableView foodTable;
    @FXML
    private TableColumn foodNumber;
    @FXML
    private TableColumn foodTitle;
    @FXML
    private TableColumn foodCount;
    @FXML
    private TableColumn dateOfDelivery;
    @FXML
    private TableColumn animalTypeFood;

    @FXML
    private Tab overseersTab;
    @FXML
    private TableView overseersTable;
    @FXML
    private TableColumn overseersNumber;
    @FXML
    private TableColumn name;
    @FXML
    private TableColumn lastName;
    @FXML
    private TableColumn phoneNumber;
    @FXML
    private TableColumn ageOverseers;
    @FXML
    private TableColumn isSick;
    @FXML
    private TableColumn overseersZone;

    @FXML
    private Tab zoneTab;
    @FXML
    private TableView zoneTable;
    @FXML
    private TableColumn zoneNumber;
    @FXML
    private TableColumn zoneTitle;
    @FXML
    private TableColumn population;

    @FXML
    private Tab reviewTab;
    @FXML
    private TableView reviewTable;
    @FXML
    private TableColumn reviewNumber;
    @FXML
    private TableColumn reviewZoneTitle;
    @FXML
    private TableColumn reviewPopulation;

    @FXML
    private Button addButton;
    @FXML
    private Button editButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button refreshButton;
    @FXML
    private Button collectButton;

    @FXML
    private Label labelColumn1;
    @FXML
    private Label labelColumn2;
    @FXML
    private Label labelColumn3;
    @FXML
    private Label labelColumn4;
    @FXML
    private Label labelColumn5;
    @FXML
    private Label labelColumn6;
    @FXML
    private Label contentLable1;
    @FXML
    private Label contentLable2;
    @FXML
    private Label contentLable3;
    @FXML
    private Label contentLable4;
    @FXML
    private Label contentLable5;
    @FXML
    private Label contentLable6;
    @FXML
    private DatePicker datePicker1;
    @FXML
    private DatePicker datePicker2;


    @FXML
    private void initialize() {
        initCell();
        InteractionService.refreshAnimalTable(animalTable);
        InteractionService.refreshAnimalTypeTable(animalTypeTable);
        InteractionService.refreshFoodTable(foodTable);
        InteractionService.refreshOverseersTable(overseersTable);
        InteractionService.refreshZoneTable(zoneTable);

        animalTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showAnimalDetails(newValue));
        animalTypeTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showAnimalTypeDetails(newValue));
        foodTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showFoodDetails((Food) newValue));
        overseersTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showOverseerDetails((Overseer) newValue));
        zoneTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showZoneDetails((Zone) newValue));
        showAnimalDetails(null);
        showAnimalTypeDetails(null);
        showFoodDetails(null);
        showOverseerDetails(null);
        showZoneDetails(null);
    }

    @FXML
    private void newObject() {
        Object tempObject = new Object();
        if (animalTab.isSelected()) {
            tempObject = new Animal();
        }
        if (animalTypeTab.isSelected()) {
            tempObject = new AnimalType();
        }
        if (foodTab.isSelected()) {
            tempObject = new Food();
        }
        if (overseersTab.isSelected()) {
            tempObject = new Overseer();
        }
        if (zoneTab.isSelected()) {
            tempObject = new Zone();
        }

        MainApp.showEditDialog(tempObject);
    }

    @FXML
    private void editObject() {
        Object selectedObject = null;
        if (animalTab.isSelected())
            selectedObject = animalTable.getSelectionModel().getSelectedItem();

        if (animalTypeTab.isSelected())
            selectedObject = animalTypeTable.getSelectionModel().getSelectedItem();

        if (foodTab.isSelected())
            selectedObject = foodTable.getSelectionModel().getSelectedItem();

        if (overseersTab.isSelected())
            selectedObject = overseersTable.getSelectionModel().getSelectedItem();

        if (zoneTab.isSelected())
            selectedObject = zoneTable.getSelectionModel().getSelectedItem();



        if (selectedObject != null) {
            MainApp.showEditDialog(selectedObject);
        } else {
            // Nothing selected.
            Dialogs.create()
                    .title("No Selection")
                    .masthead("No Person Selected")
                    .message("Please select a person in the table.")
                    .showWarning();
        }
    }

    private void showAnimalDetails(Animal animal) {
        labelColumn1.setText(animalName.getText());
        labelColumn2.setText(age.getText());
        labelColumn3.setText(sex.getText());
        labelColumn4.setText(animalType.getText());
        labelColumn5.setText(animalZone.getText());
        labelColumn6.setText("");
        if (animal != null) {
            contentLable1.setText(animal.getAnimalName());
            contentLable2.setText(Integer.toString(animal.getAge()));
            contentLable3.setText(animal.getSex());
            contentLable4.setText(animal.getAnimalType());
            contentLable5.setText(animal.getAnimalZone());
            contentLable6.setText("");
        } else {
            contentLable1.setText("");
            contentLable2.setText("");
            contentLable3.setText("");
            contentLable4.setText("");
            contentLable5.setText("");
            contentLable6.setText("");
        }
    }

    private void showAnimalTypeDetails(AnimalType animalType) {
        labelColumn1.setText(animalTypeTitle.getText());
        labelColumn2.setText(animalCount.getText());
        labelColumn3.setText(foodPerDay.getText());
        labelColumn4.setText("");
        labelColumn5.setText("");
        labelColumn6.setText("");
        if (animalType != null) {
            contentLable1.setText(animalType.getAnimalTypeTitle());
            contentLable2.setText(Integer.toString(animalType.getAnimalCount()));
            contentLable3.setText(Integer.toString(animalType.getFoodPerDay()));
            contentLable4.setText("");
            contentLable5.setText("");
            contentLable6.setText("");
        } else {
            contentLable1.setText("");
            contentLable2.setText("");
            contentLable3.setText("");
            contentLable4.setText("");
            contentLable5.setText("");
            contentLable6.setText("");
        }
    }

    private void showFoodDetails(Food food) {
        labelColumn1.setText(foodTitle.getText());
        labelColumn2.setText(foodCount.getText());
        labelColumn3.setText(dateOfDelivery.getText());
        labelColumn4.setText(animalTypeFood.getText());
        labelColumn5.setText("");
        labelColumn6.setText("");
        if (food != null) {
            contentLable1.setText(food.getFoodTitle());
            contentLable2.setText(Integer.toString(food.getFoodCount()));
            contentLable3.setText(food.getDateOfDelivery().toString());
            contentLable4.setText(food.getAnimalTypeFood());
            contentLable5.setText("");
            contentLable6.setText("");
        } else {
            contentLable1.setText("");
            contentLable2.setText("");
            contentLable3.setText("");
            contentLable4.setText("");
            contentLable5.setText("");
            contentLable6.setText("");
        }
    }

    private void showOverseerDetails(Overseer overseer) {
        labelColumn1.setText(name.getText());
        labelColumn2.setText(lastName.getText());
        labelColumn3.setText(phoneNumber.getText());
        labelColumn4.setText(ageOverseers.getText());
        labelColumn5.setText(isSick.getText());
        labelColumn6.setText(overseersZone.getText());
        if (overseer != null) {
            contentLable1.setText(overseer.getName());
            contentLable2.setText(overseer.getLastName());
            contentLable3.setText(Integer.toString(overseer.getPhoneNumber()));
            contentLable4.setText(Integer.toString(overseer.getAgeOverseer()));
            contentLable5.setText(Boolean.toString(overseer.getIsSick()));
            contentLable6.setText(overseer.getOverseerZone());
        } else {
            contentLable1.setText("");
            contentLable2.setText("");
            contentLable3.setText("");
            contentLable4.setText("");
            contentLable5.setText("");
            contentLable6.setText("");
        }
    }

    private void showZoneDetails(Zone zone) {
        labelColumn1.setText(zoneTitle.getText());
        labelColumn2.setText(population.getText());
        labelColumn3.setText("");
        labelColumn4.setText("");
        labelColumn5.setText("");
        labelColumn6.setText("");
        if (zone != null) {
            contentLable1.setText(zone.getZoneTitle());
            contentLable2.setText(Integer.toString(zone.getPopulation()));
            contentLable3.setText("");
            contentLable4.setText("");
            contentLable5.setText("");
            contentLable6.setText("");
        } else {
            contentLable1.setText("");
            contentLable2.setText("");
            contentLable3.setText("");
            contentLable4.setText("");
            contentLable5.setText("");
            contentLable6.setText("");
        }
    }

    public void initCell() {
        animalNumber.setCellValueFactory(new PropertyValueFactory("animalNumber"));
        animalName.setCellValueFactory(new PropertyValueFactory("animalName"));
        age.setCellValueFactory(new PropertyValueFactory("age"));
        sex.setCellValueFactory(new PropertyValueFactory("sex"));
        animalType.setCellValueFactory(new PropertyValueFactory("animalType"));
        animalZone.setCellValueFactory(new PropertyValueFactory("animalZone"));

        animalTypeNumber.setCellValueFactory(new PropertyValueFactory("animalTypeNumber"));
        animalTypeTitle.setCellValueFactory(new PropertyValueFactory("animalTypeTitle"));
        animalCount.setCellValueFactory(new PropertyValueFactory("animalCount"));
        foodPerDay.setCellValueFactory(new PropertyValueFactory("foodPerDay"));

        foodNumber.setCellValueFactory(new PropertyValueFactory("foodNumber"));
        foodTitle.setCellValueFactory(new PropertyValueFactory("foodTitle"));
        foodCount.setCellValueFactory(new PropertyValueFactory("foodCount"));
        dateOfDelivery.setCellValueFactory(new PropertyValueFactory("dateOfDelivery"));
        animalTypeFood.setCellValueFactory(new PropertyValueFactory("animalTypeFood"));


        overseersNumber.setCellValueFactory(new PropertyValueFactory("overseerNumber"));
        name.setCellValueFactory(new PropertyValueFactory("name"));
        lastName.setCellValueFactory(new PropertyValueFactory("lastName"));
        phoneNumber.setCellValueFactory(new PropertyValueFactory("phoneNumber"));
        ageOverseers.setCellValueFactory(new PropertyValueFactory("ageOverseer"));
        isSick.setCellValueFactory(new PropertyValueFactory("isSick"));
        overseersZone.setCellValueFactory(new PropertyValueFactory("overseerZone"));

        zoneNumber.setCellValueFactory(new PropertyValueFactory("zoneNumber"));
        zoneTitle.setCellValueFactory(new PropertyValueFactory("zoneTitle"));
        population.setCellValueFactory(new PropertyValueFactory("population"));

        reviewNumber.setCellValueFactory(new PropertyValueFactory("reviewNumber"));
        reviewZoneTitle.setCellValueFactory(new PropertyValueFactory("reviewZoneTitle"));
        reviewPopulation.setCellValueFactory(new PropertyValueFactory("reviewPopulation"));
    }

    public void delete() {
        if (animalTab.isSelected()) {
            int selectedIndex = animalTable.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0) {
                InteractionService.deleteAnimal(animalTable.getItems().get(selectedIndex));
                animalTable.getItems().remove(selectedIndex);
            } else {
                // Nothing selected.
                Dialogs.create()
                        .title("No Selection")
                        .masthead("No Animal Selected")
                        .message("Please select a animal in the table.")
                        .showWarning();
            }
        }

        if (animalTypeTab.isSelected()) {
            int selectedIndex = animalTypeTable.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0) {
                InteractionService.deleteAnimalType(animalTypeTable.getItems().get(selectedIndex));
                animalTypeTable.getItems().remove(selectedIndex);
            } else {
                // Nothing selected.
                Dialogs.create()
                        .title("No Selection")
                        .masthead("No AnimalType Selected")
                        .message("Please select a animaltype in the table.")
                        .showWarning();
            }
        }

        if (foodTab.isSelected()) {
            int selectedIndex = foodTable.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0) {
                InteractionService.deleteFood((Food) foodTable.getItems().get(selectedIndex));
                foodTable.getItems().remove(selectedIndex);
            } else {
                // Nothing selected.
                Dialogs.create()
                        .title("No Selection")
                        .masthead("No Food Selected")
                        .message("Please select a food in the table.")
                        .showWarning();
            }
        }

        if (overseersTab.isSelected()) {
            int selectedIndex = overseersTable.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0) {
                InteractionService.deleteOverseer((Overseer) overseersTable.getItems().get(selectedIndex));
                overseersTable.getItems().remove(selectedIndex);
            } else {
                // Nothing selected.
                Dialogs.create()
                        .title("No Selection")
                        .masthead("No Overseer Selected")
                        .message("Please select a overseer in the table.")
                        .showWarning();
            }
        }

        if (zoneTab.isSelected()) {
            int selectedIndex = zoneTable.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0) {
                InteractionService.deleteZone((Zone) zoneTable.getItems().get(selectedIndex));
                zoneTable.getItems().remove(selectedIndex);
            } else {
                // Nothing selected.
                Dialogs.create()
                        .title("No Selection")
                        .masthead("No Zone Selected")
                        .message("Please select a zone in the table.")
                        .showWarning();
            }
        }
        refresh();
    }

    public void refresh() {
        if (animalTab.isSelected()) InteractionService.refreshAnimalTable(animalTable);
        if (animalTypeTab.isSelected()) InteractionService.refreshAnimalTypeTable(animalTypeTable);
        if (foodTab.isSelected()) InteractionService.refreshFoodTable(foodTable);
        if (overseersTab.isSelected()) InteractionService.refreshOverseersTable(overseersTable);
        if (zoneTab.isSelected()) InteractionService.refreshZoneTable(zoneTable);

    }

    public void hideButton(){
        addButton.setVisible(false);
        editButton.setVisible(false);
        deleteButton.setVisible(false);
        refreshButton.setVisible(false);
        collectButton.setVisible(true);

    }

    public void showButton(){
        try {
            if (!addButton.isVisible()) addButton.setVisible(true);
            if (!editButton.isVisible()) editButton.setVisible(true);
            if (!deleteButton.isVisible()) deleteButton.setVisible(true);
            if (!refreshButton.isVisible()) refreshButton.setVisible(true);
            if (collectButton.isVisible()) collectButton.setVisible(false);
        }
        catch (NullPointerException e){
            System.out.println("NullPointer When Started");
        }

    }
    private ObservableList data = FXCollections.observableArrayList();
    public void collectStatics(){
        data=animalTable.getItems();
        for (int i=0; i<data.size();i++){
           System.out.println(data.get(i));
        }

    }
}

