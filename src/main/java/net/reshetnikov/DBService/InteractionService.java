package net.reshetnikov.DBService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import net.reshetnikov.Logic.*;
import org.controlsfx.dialog.Dialogs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InteractionService {
    private static ObservableList data;
    private static ObservableList data1;
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    //обновление таблицы животных
    public static void refreshAnimalTable(TableView tableView) {
        Connection c;
        try {
            c = Service.openDB();
            String SQL = "SELECT * from animals \n" +
                    "JOIN animaltype on (animals.AnimalType_idAnimalType=animaltype.idAnimalType)\n" +
                    "JOIN zone on (animals.Zone_idZone=zone.idZone)";
            data = FXCollections.observableArrayList();
            int i = 1;
            ResultSet rs = c.createStatement().executeQuery(SQL);
            while (rs.next()) {
                Animal animal = new Animal();
                animal.setAnimalNumber(i++);
                animal.setAnimalId(rs.getInt(1));
                animal.setAnimalName(rs.getString(2));
                animal.setAge(rs.getInt(3));
                animal.setSex(rs.getString(4));
                animal.setAnimalTypeId(rs.getInt(5));
                animal.setZoneId(rs.getInt(6));
                animal.setAnimalType(rs.getString(8));
                animal.setAnimalZone(rs.getString(12));
                data.add(animal);
            }
            tableView.setItems(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //обновление таблицы типов животных
    public static void refreshAnimalTypeTable(TableView tableView) {
        Connection c;
        try {
            c = Service.openDB();
            String SQL = "SELECT * from animalType";
            data = FXCollections.observableArrayList();
            int i = 1;
            ResultSet rs = c.createStatement().executeQuery(SQL);
            while (rs.next()) {
                AnimalType animalType = new AnimalType();
                animalType.setAnimalTypeNumber(i++);
                animalType.setAnimalTypeId(rs.getInt(1));
                animalType.setAnimalTypeTitle(rs.getString(2));
                animalType.setAnimalCount(rs.getInt(3));
                animalType.setFoodPerDay(rs.getInt(4));
                data.add(animalType);
            }
            tableView.setItems(data);
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //обновление таблицы пищи
    public static void refreshFoodTable(TableView tableView) {
        Connection c;
        try {
            c = Service.openDB();
            String SQL = "SELECT * from food \n" +
                    "JOIN animaltype on (food.AnimalType_idAnimalType=animaltype.idAnimalType)\n";
            data = FXCollections.observableArrayList();
            int i = 1;
            ResultSet rs = c.createStatement().executeQuery(SQL);
            while (rs.next()) {
                Food food = new Food();
                food.setFoodNumber(i++);
                food.setFoodId(rs.getInt(1));
                food.setFoodTitle(rs.getString(2));
                food.setFoodCount(rs.getInt(3));
                food.setDateOfDelivery(rs.getDate(4));
                food.setAnimalTypeId(rs.getInt(5));
                food.setAnimalTypeFood(rs.getString(7));
                data.add(food);
            }
            tableView.setItems(data);
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //обновление таблицы наблюдателей
    public static void refreshOverseersTable(TableView tableView) {
        Connection c;
        try {
            c = Service.openDB();
            String SQL = "SELECT * from overseers \n" +
                    "JOIN zone on (overseers.Zone_idZone=zone.idZone)\n";
            data = FXCollections.observableArrayList();
            int i = 1;
            ResultSet rs = c.createStatement().executeQuery(SQL);
            while (rs.next()) {
                Overseer overseer = new Overseer();
                overseer.setOverseerNumber(i++);
                overseer.setOverseerId(rs.getInt(1));
                overseer.setName(rs.getString(2));
                overseer.setLastName(rs.getString(3));
                overseer.setPhoneNumber(rs.getInt(4));
                overseer.setAgeOverseer(rs.getInt(5));
                overseer.setIsSick(rs.getBoolean(6));
                overseer.setZoneId(rs.getInt(7));
                overseer.setOverseerZone(rs.getString(9));
                data.add(overseer);
            }
            tableView.setItems(data);
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //обновление таблицы зон
    public static void refreshZoneTable(TableView tableView) {
        Connection c;
        try {
            c = Service.openDB();
            String SQL = "SELECT * from zone";
            data = FXCollections.observableArrayList();
            int i = 1;
            ResultSet rs = c.createStatement().executeQuery(SQL);
            while (rs.next()) {
                Zone zone = new Zone();
                zone.setZoneNumber(i++);
                zone.setZoneId(rs.getInt(1));
                zone.setZoneTitle(rs.getString(2));
                zone.setPopulation(rs.getInt(3));
                data.add(zone);
            }
            tableView.setItems(data);
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //обновление таблицы обзора
    public static void refreshReviewTable(TableView tableView1,TableView tableView2,String strDate1,String strDate2){
        data = FXCollections.observableArrayList();
        data1 = FXCollections.observableArrayList();
        int i = 1;
        Date date1 = new Date();
        Date date2 = new Date();
        try {
            date1 = dateFormat.parse(strDate1);
            date2 = dateFormat.parse(strDate2);
        }
        catch (ParseException e){
            e.printStackTrace();
        }
        if (date1.compareTo(date2)>0){
            Dialogs.create()
                    .title("Date error")
                    .masthead("Date is not valid")
                    .message("Please select a valid date.")
                    .showWarning();
        }
        data=tableView1.getItems();
        for (Object aData : data) {
            Food food =(Food)aData;
            Review review = new Review();
            review.setReviewFoodTitle(food.getFoodTitle());
            review.setReviewFoodCount(food.getFoodCount());
            review.setReviewDateOfDelivery(food.getDateOfDelivery());
            review.setReviewAimalTypeFood(food.getAnimalTypeFood());
            if ((review.getReviewDateOfDelivery().compareTo(date1) >= 0) && (review.getReviewDateOfDelivery().compareTo(date2) <= 0)) {
                review.setReviewNumber(i++);
                data1.add(review);
            }

        }
        tableView2.setItems(data1);
    }

    //удаление животного
    public static void deleteAnimal(Animal animal) {
        Connection c;
        PreparedStatement preparedStatement;
        try {
            c = Service.openDB();
            preparedStatement = c.prepareStatement("delete from animals where idAnimals = ?");
            preparedStatement.setInt(1, animal.getAnimalId());
            preparedStatement.executeUpdate();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //удаление типа животных
    public static void deleteAnimalType(AnimalType animalType) {
        Connection c;
        PreparedStatement preparedStatement;
        try {
            c = Service.openDB();
            preparedStatement = c.prepareStatement("delete from animalType where idAnimalType = ?");
            preparedStatement.setInt(1, animalType.getAnimalTypeId());
            preparedStatement.executeUpdate();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //удаление пищи
    public static void deleteFood(Food food) {
        Connection c;
        PreparedStatement preparedStatement;
        try {
            c = Service.openDB();
            preparedStatement = c.prepareStatement("delete from food where idFood = ?");
            preparedStatement.setInt(1, food.getFoodId());
            preparedStatement.executeUpdate();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //удаление наблюдателя
    public static void deleteOverseer(Overseer overseer) {
        Connection c;
        PreparedStatement preparedStatement;
        try {
            c = Service.openDB();
            preparedStatement = c.prepareStatement("delete from overseers where idOverseers = ?");
            preparedStatement.setInt(1, overseer.getOverseerId());
            preparedStatement.executeUpdate();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //удаление зоны
    public static void deleteZone(Zone zone) {
        Connection c;
        PreparedStatement preparedStatement;
        try {
            c = Service.openDB();
            preparedStatement = c.prepareStatement("delete from zone where idZone = ?");
            preparedStatement.setInt(1, zone.getZoneId());
            preparedStatement.executeUpdate();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
