package net.reshetnikov.UI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import net.reshetnikov.DBService.Service;
import net.reshetnikov.Logic.*;
import org.controlsfx.dialog.Dialogs;

import java.sql.Connection;
import java.sql.Types;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class EditDialogController {

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
    private TextField field1;
    @FXML
    private TextField field2;
    @FXML
    private TextField field3;
    @FXML
    private TextField field4;
    @FXML
    private TextField field5;
    @FXML
    private TextField field6;

    @FXML
    private ComboBox comboBox1;
    @FXML
    private ComboBox comboBox2;
    @FXML
    private GridPane gridPane;
    private Stage dialogStage;
    private Object object;
    private String className;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @FXML
    private void initialize() {
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    private ObservableList data1 = FXCollections.observableArrayList();
    private ObservableList data2 = FXCollections.observableArrayList();

    public void setObject(Object object) {
        this.object = object;
        String strForParse = object.getClass().toString();
        className = strForParse.substring(28);
        Connection c;
        try {
            c = Service.openDB();
            String SQL = "SELECT idAnimalType,AnimalTypeTitle from animalType";
            String SQL1 = "SELECT idZone,ZoneTitle from zone";
            ResultSet rs = c.createStatement().executeQuery(SQL);
            while (rs.next()) {
                data1.add(rs.getString(2));
            }
            ResultSet rs1 = c.createStatement().executeQuery(SQL1);
            while (rs1.next()) {
                data2.add(rs1.getString(2));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        switch (className) {
            case "Animal": {
                Animal animal = (Animal) object;
                labelColumn1.setText("Кличка животного");
                labelColumn2.setText("Возраст");
                labelColumn3.setText("Пол");
                labelColumn4.setText("Тип животного");
                labelColumn5.setText("Зона обитания");
                labelColumn6.setText("");
                field1.setText(animal.getAnimalName());
                field2.setText(Integer.toString(animal.getAge()));
                field3.setText(animal.getSex());
                comboBox1.setItems(data1);
                comboBox1.setValue(animal.getAnimalType());
                comboBox2.setItems(data2);
                comboBox2.setValue(animal.getAnimalZone());
                gridPane.setRowIndex(comboBox1, 3);
                gridPane.setColumnIndex(comboBox1, 1);
                gridPane.setRowIndex(comboBox2, 4);
                gridPane.setColumnIndex(comboBox2, 1);
                field4.setVisible(false);
                field5.setVisible(false);
                //field4.setText(animal.getAnimalType());
                //field5.setText(animal.getAnimalZone());
                field6.setVisible(false);
                break;
            }
            case "AnimalType": {
                AnimalType animalType = (AnimalType) object;
                labelColumn1.setText("Тип животных");
                labelColumn2.setText("Количество животных");
                labelColumn3.setText("Потребление пищи в день");
                labelColumn4.setText("");
                labelColumn5.setText("");
                labelColumn6.setText("");
                field1.setText(animalType.getAnimalTypeTitle());
                field2.setText(Integer.toString(animalType.getAnimalCount()));
                field3.setText(Integer.toString(animalType.getFoodPerDay()));
                field4.setVisible(false);
                field5.setVisible(false);
                field6.setVisible(false);
                comboBox1.setVisible(false);
                comboBox2.setVisible(false);
                break;
            }
            case "Food": {
                Food food = (Food) object;
                labelColumn1.setText("Название пищи");
                labelColumn2.setText("Запас пищи");
                labelColumn3.setText("Дата доставки");
                labelColumn4.setText("Тип потребителей");
                labelColumn5.setText("");
                labelColumn6.setText("");
                field1.setText(food.getFoodTitle());
                field2.setText(Integer.toString(food.getFoodCount()));
                if (food.getDateOfDelivery() == null) {
                    field3.setText("");
                } else field3.setText(food.getDateOfDelivery().toString());
                field3.setPromptText("yyyy-mm-dd");
                comboBox1.setItems(data1);
                comboBox1.setValue(food.getAnimalTypeFood());
                gridPane.setRowIndex(comboBox1, 3);
                gridPane.setColumnIndex(comboBox1, 1);
                //field4.setText(food.getAnimalTypeFood());
                field4.setVisible(false);
                field5.setVisible(false);
                field6.setVisible(false);
                comboBox2.setVisible(false);
                break;
            }
            case "Overseer": {
                Overseer overseer = (Overseer) object;
                labelColumn1.setText("Имя");
                labelColumn2.setText("Фамилия");
                labelColumn3.setText("Контактный номер");
                labelColumn4.setText("Возраст");
                labelColumn5.setText("Болеет");
                labelColumn6.setText("Ответственный за зону");
                field1.setText(overseer.getName());
                field2.setText(overseer.getLastName());
                field3.setText(Integer.toString(overseer.getPhoneNumber()));
                field4.setText(Integer.toString(overseer.getAgeOverseer()));
                field5.setText(Boolean.toString(overseer.getIsSick()));
                field5.setPromptText("false or true");
                //field6.setText(overseer.getOverseerZone());
                comboBox2.setItems(data2);
                comboBox2.setValue(overseer.getOverseerZone());
                gridPane.setRowIndex(comboBox2, 5);
                gridPane.setColumnIndex(comboBox2, 1);
                field6.setVisible(false);
                comboBox1.setVisible(false);

                break;
            }
            case "Zone": {
                Zone zone = (Zone) object;
                labelColumn1.setText("Название зоны обитания животных");
                labelColumn2.setText("Популяция");
                labelColumn3.setText("");
                labelColumn4.setText("");
                labelColumn5.setText("");
                labelColumn6.setText("");
                field1.setText(zone.getZoneTitle());
                field2.setText(Integer.toString(zone.getPopulation()));
                field3.setVisible(false);
                field4.setVisible(false);
                field5.setVisible(false);
                field6.setVisible(false);
                comboBox1.setVisible(false);
                comboBox2.setVisible(false);
                break;
            }
            default:
                break;
        }
    }

    @FXML
    private void handleOk() throws ParseException {
        Connection c;
        PreparedStatement preparedStatement;
        if (isInputValid()) {
            switch (className) {
                case "Animal": {
                    Animal animal = (Animal) object;
                    animal.setAnimalName(field1.getText());
                    if (!field2.getText().equals("")) animal.setAge(Integer.parseInt(field2.getText()));
                    else animal.setAge(0);
                    animal.setSex(field3.getText());
                    //animal.setAnimalType(field4.getText());
                    animal.setAnimalType(comboBox1.getValue().toString());
                    animal.setAnimalZone(comboBox2.getValue().toString());
                    //animal.setAnimalZone(field5.getText());
                    try {
                        c = Service.openDB();
                        String SQL = "SELECT idAnimalType,AnimalTypeTitle,idZone,ZoneTitle from animalType,zone";
                        ResultSet rs = c.createStatement().executeQuery(SQL);
                        while (rs.next()) {
                            if (animal.getAnimalType().equals(rs.getString(2))) animal.setAnimalTypeId(rs.getInt(1));
                            if (animal.getAnimalZone().equals(rs.getString(4))) animal.setZoneId(rs.getInt(3));
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        c = Service.openDB();
                        if (animal.getAnimalId() == 0) {
                            preparedStatement = c.prepareStatement("INSERT INTO animals (AnimalName, Age, Sex, AnimalType_idAnimalType, Zone_idZone) VALUES (?, ?, ?, ?, ?);\n ");
                            preparedStatement.setString(1, animal.getAnimalName());
                            if (animal.getAge() == 0) preparedStatement.setNull(2, Types.INTEGER);
                            else preparedStatement.setInt(2, animal.getAge());
                            if (animal.getSex() == null) preparedStatement.setNull(3, Types.VARCHAR);
                            else preparedStatement.setString(3, animal.getSex());
                            preparedStatement.setInt(4, animal.getAnimalTypeId());
                            preparedStatement.setInt(5, animal.getZoneId());
                            preparedStatement.executeUpdate();
                        } else {
                            preparedStatement = c.prepareStatement("UPDATE animals SET AnimalName=?, Age=?, Sex=?, AnimalType_idAnimalType=?, Zone_idZone=? WHERE idAnimals=?\n ");
                            preparedStatement.setString(1, animal.getAnimalName());
                            if (animal.getAge() == 0) preparedStatement.setNull(2, Types.INTEGER);
                            else preparedStatement.setInt(2, animal.getAge());
                            if (animal.getSex() == null) preparedStatement.setNull(3, Types.VARCHAR);
                            else preparedStatement.setString(3, animal.getSex());
                            preparedStatement.setInt(4, animal.getAnimalTypeId());
                            preparedStatement.setInt(5, animal.getZoneId());
                            preparedStatement.setInt(6, animal.getAnimalId());
                            preparedStatement.executeUpdate();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "AnimalType": {
                    AnimalType animalType = (AnimalType) object;
                    animalType.setAnimalTypeTitle(field1.getText());
                    animalType.setAnimalCount(Integer.parseInt(field2.getText()));
                    animalType.setFoodPerDay(Integer.parseInt(field3.getText()));
                    try {
                        c = Service.openDB();
                        if (animalType.getAnimalTypeId() == 0) {
                            preparedStatement = c.prepareStatement("INSERT INTO animalType (AnimalTypeTitle, AnimalCount, FoodPerDay) VALUES (?, ?, ?);\n ");
                            preparedStatement.setString(1, animalType.getAnimalTypeTitle());
                            if (animalType.getAnimalCount() == 0) preparedStatement.setNull(2, Types.INTEGER);
                            else preparedStatement.setInt(2, animalType.getAnimalCount());
                            preparedStatement.setInt(3, animalType.getFoodPerDay());
                            preparedStatement.executeUpdate();
                        } else {
                            preparedStatement = c.prepareStatement("UPDATE animalsType SET AnimalTypeTitle=?, AnimalCount=?, FoodPerDay=? WHERE idAnimalType=?\n ");
                            preparedStatement.setString(1, animalType.getAnimalTypeTitle());
                            if (animalType.getAnimalCount() == 0) preparedStatement.setNull(2, Types.INTEGER);
                            else preparedStatement.setInt(2, animalType.getAnimalCount());
                            preparedStatement.setInt(3, animalType.getFoodPerDay());
                            preparedStatement.setInt(4, animalType.getAnimalTypeId());
                            preparedStatement.executeUpdate();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "Food": {
                    Food food = (Food) object;
                    food.setFoodTitle(field1.getText());
                    food.setFoodCount(Integer.parseInt(field2.getText()));
                    food.setDateOfDelivery(dateFormat.parse(field3.getText()));
                    food.setAnimalTypeFood(comboBox1.getValue().toString());
                    //food.setAnimalTypeFood(field4.getText());
                    try {
                        c = Service.openDB();
                        String SQL = "SELECT idAnimalType,AnimalTypeTitle from animalType";
                        ResultSet rs = c.createStatement().executeQuery(SQL);
                        while (rs.next()) {
                            if (food.getAnimalTypeFood().equals(rs.getString(2))) food.setAnimalTypeId(rs.getInt(1));
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        c = Service.openDB();
                        if (food.getFoodId() == 0) {
                            preparedStatement = c.prepareStatement("INSERT INTO food (FoodTitle, FoodCount, DateOfDelivery, AnimalType_idAnimalType) VALUES (?, ?, ?, ?);\n ");
                            preparedStatement.setString(1, food.getFoodTitle());

                            if (food.getFoodCount() == 0) preparedStatement.setNull(2, Types.INTEGER);
                            else preparedStatement.setInt(2, food.getFoodCount());
                            preparedStatement.setDate(3, new java.sql.Date(food.getDateOfDelivery().getTime()));
                            preparedStatement.setInt(4, food.getAnimalTypeId());
                            preparedStatement.executeUpdate();
                        } else {
                            preparedStatement = c.prepareStatement("UPDATE food SET FoodTitle=?, FoodCount=?, DateOfDelivery=?, AnimalType_idAnimalType=? WHERE idFood=?\n ");
                            preparedStatement.setString(1, food.getFoodTitle());
                            if (food.getFoodCount() == 0) preparedStatement.setNull(2, Types.INTEGER);
                            else preparedStatement.setInt(2, food.getFoodCount());
                            preparedStatement.setDate(3, new java.sql.Date(food.getDateOfDelivery().getTime()));
                            preparedStatement.setInt(4, food.getAnimalTypeId());
                            preparedStatement.setInt(5, food.getFoodId());
                            preparedStatement.executeUpdate();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "Overseer": {
                    Overseer overseer = (Overseer) object;
                    overseer.setName(field1.getText());
                    overseer.setLastName(field2.getText());
                    overseer.setPhoneNumber(Integer.parseInt(field3.getText()));
                    overseer.setAgeOverseer(Integer.parseInt(field4.getText()));
                    overseer.setIsSick(Boolean.parseBoolean(field5.getText()));
                    overseer.setOverseerZone(comboBox2.getValue().toString());
                    //overseer.setOverseerZone(field6.getText());
                    try {
                        c = Service.openDB();
                        String SQL = "SELECT idZone,ZoneTitle from zone";
                        ResultSet rs = c.createStatement().executeQuery(SQL);
                        while (rs.next()) {
                            if (overseer.getOverseerZone().equals(rs.getString(2))) overseer.setZoneId(rs.getInt(1));
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        c = Service.openDB();
                        if (overseer.getOverseerId() == 0) {
                            preparedStatement = c.prepareStatement("INSERT INTO overseers (Name, LastName, PhoneNumber, Age, isSick, Zone_idZone) VALUES (?, ?, ?, ?, ?, ?);\n ");
                            preparedStatement.setString(1, overseer.getName());
                            preparedStatement.setString(2, overseer.getLastName());
                            if (overseer.getPhoneNumber() == 0) preparedStatement.setNull(3, Types.INTEGER);
                            else preparedStatement.setInt(3, overseer.getPhoneNumber());
                            if (overseer.getAgeOverseer() == 0) preparedStatement.setNull(4, Types.INTEGER);
                            else preparedStatement.setInt(4, overseer.getAgeOverseer());
                            preparedStatement.setBoolean(5, overseer.getIsSick());
                            preparedStatement.setInt(6, overseer.getZoneId());
                            preparedStatement.executeUpdate();
                        } else {
                            preparedStatement = c.prepareStatement("UPDATE overseers SET Name=?, LastName=?, PhoneNumber=?, Age=?, isSick=?, Zone_idZone=? WHERE idOverseers=?\n ");
                            preparedStatement.setString(1, overseer.getName());
                            preparedStatement.setString(2, overseer.getLastName());
                            if (overseer.getPhoneNumber() == 0) preparedStatement.setNull(3, Types.INTEGER);
                            else preparedStatement.setInt(3, overseer.getPhoneNumber());
                            if (overseer.getAgeOverseer() == 0) preparedStatement.setNull(4, Types.INTEGER);
                            else preparedStatement.setInt(4, overseer.getAgeOverseer());
                            preparedStatement.setBoolean(5, overseer.getIsSick());
                            preparedStatement.setInt(6, overseer.getZoneId());
                            preparedStatement.setInt(7, overseer.getOverseerId());
                            preparedStatement.executeUpdate();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "Zone": {
                    Zone zone = (Zone) object;
                    zone.setZoneTitle(field1.getText());
                    zone.setPopulation(Integer.parseInt(field2.getText()));
                    try {
                        c = Service.openDB();
                        if (zone.getZoneId() == 0) {
                            preparedStatement = c.prepareStatement("INSERT INTO zone (ZoneTitle, Population) VALUES (?, ?);\n ");
                            preparedStatement.setString(1, zone.getZoneTitle());
                            if (zone.getPopulation() == 0) preparedStatement.setNull(2, Types.INTEGER);
                            else preparedStatement.setInt(2, zone.getPopulation());
                            preparedStatement.executeUpdate();
                        } else {
                            preparedStatement = c.prepareStatement("UPDATE zone SET ZoneTitle=?, Population=? WHERE idZone=?\n ");
                            preparedStatement.setString(1, zone.getZoneTitle());
                            if (zone.getPopulation() == 0) preparedStatement.setNull(2, Types.INTEGER);
                            else preparedStatement.setInt(2, zone.getPopulation());
                            preparedStatement.setInt(3, zone.getZoneId());
                            preparedStatement.executeUpdate();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                }
                default:
                    break;
            }
            dialogStage.close();
        }
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    private boolean isInputValid() {
        String errorMessage = "";
        switch (className) {
            case "Animal": {
                if (field1.getText() == null || field1.getText().length() == 0) {
                    errorMessage += "No valid animal name!\n";
                }
                if (comboBox1.getValue() == null) errorMessage += "No valid animal type!\n";
                if (comboBox2.getValue() == null) errorMessage += "No valid animal zone!\n";
                break;
            }
            case "AnimalType": {
                if (field1.getText() == null || field1.getText().length() == 0) {
                    errorMessage += "No valid animal type!\n";
                }
                if (field3.getText() == null || field3.getText().length() == 0) {
                    errorMessage += "No valid food per day !\n";
                }
                break;
            }
            case "Food": {
                if (field1.getText() == null || field1.getText().length() == 0) {
                    errorMessage += "No valid food name!\n";
                }
                if (field3.getText() == null || field3.getText().length() == 0) {
                    errorMessage += "No valid date!\n";
                } else {
                    //if (!field3.getText().matches("([0-9]{4})-([0-9]{2})-([0-9]{2})")) errorMessage += "No valid date format!\n";
                    if (!field3.getText().matches("((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])"))
                        errorMessage += "No valid date format!\n";
                    //dateFormat. проверка валидности даты
                }
                if (comboBox1.getValue() == null) errorMessage += "No valid animal type!\n";
                break;
            }
            case "Overseer": {
                if (field1.getText() == null || field1.getText().length() == 0) {
                    errorMessage += "No valid name!\n";
                }
                if (field2.getText() == null || field2.getText().length() == 0) {
                    errorMessage += "No valid last name!\n";
                }
                if (field5.getText() == null || field5.getText().length() == 0) {
                    errorMessage += "No valid isSick!\n";
                }
                if (comboBox2.getValue() == null) errorMessage += "No valid zone!\n";
                break;
            }
            case "Zone": {
                if (field1.getText() == null || field1.getText().length() == 0) {
                    errorMessage += "No valid title!\n";
                }
                break;
            }
            default:
                break;
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Dialogs.create()
                    .title("Invalid Fields")
                    .masthead("Please correct invalid fields")
                    .message(errorMessage)
                    .showError();
            return false;
        }
    }
}
