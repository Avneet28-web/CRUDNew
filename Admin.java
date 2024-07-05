package com.example.hrmanagementavneet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;
import java.sql.*;

public class AdminController implements Initializable {
    public TableView<Admin> adminTable;
    public TableColumn<Admin, Integer> userid;
    public TableColumn<Admin, String> name;
    public TableColumn<Admin, String> password;
    public TableColumn<Admin, String> country;
    public TextField uid;
    public TextField uname;
    public TextField upassword;
    public TextField ucountry;
    @FXML
    private Label welcomeText;

    ObservableList<Admin> list = FXCollections.observableArrayList().sorted();

    @FXML
    protected void onHelloButtonClick() {
        fetchData();
    }

    private void fetchData() {
        list.clear();

        String jdbcUrl = "jdbc:mysql://localhost:3306/csd_lab3_avneet";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            String query = "SELECT * FROM admin";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int userid = resultSet.getInt("Userid");
                String name = resultSet.getString("Name");
                String password = resultSet.getString("Password");
                String country = resultSet.getString("Country");
                adminTable.getItems().add(new Admin(userid, name, password, country));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userid.setCellValueFactory(new PropertyValueFactory<Admin, Integer>("userid"));
        name.setCellValueFactory(new PropertyValueFactory<Admin, String>("name"));
        password.setCellValueFactory(new PropertyValueFactory<Admin, String>("password"));
        country.setCellValueFactory(new PropertyValueFactory<Admin, String>("country"));
        adminTable.setItems(list);
    }

    public void InsertData(ActionEvent actionEvent) {
        String name = uname.getText();
        String password = upassword.getText();
        String country = ucountry.getText();

        String jdbcUrl = "jdbc:mysql://localhost:3306/csd_lab3_avneet";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            String query = "INSERT INTO admin (Name, Password, Country) VALUES ('" + name + "','" + password + "','" + country + "')";
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void UpdateData(ActionEvent actionEvent) {
        String userid = uid.getText();
        String name = uname.getText();
        String password = upassword.getText();
        String country = ucountry.getText();

        String jdbcUrl = "jdbc:mysql://localhost:3306/csd_lab3_avneet";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            String query = "UPDATE admin SET Name='" + name + "', Password='" + password + "', Country='" + country + "' WHERE Userid='" + userid + "'";
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void DeleteData(ActionEvent actionEvent) {
        String userid = uid.getText();

        String jdbcUrl = "jdbc:mysql://localhost:3306/csd_lab3_avneet";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            String query = "DELETE FROM admin WHERE Userid='" + userid + "'";
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void LoadData(ActionEvent actionEvent) {
        String userid = uid.getText();

        String jdbcUrl = "jdbc:mysql://localhost:3306/csd_lab3_avneet";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            String query = "SELECT * FROM admin WHERE Userid='" + userid + "'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                String name = resultSet.getString("Name");
                String password = resultSet.getString("Password");
                String country = resultSet.getString("Country");

                uname.setText(name);
                upassword.setText(password);
                ucountry.setText(country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}