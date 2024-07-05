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

public class EmployeeController implements Initializable {
    public TableView<Employee> employeeTable;
    public TableColumn<Employee, Integer> empid;
    public TableColumn<Employee, String> empname;
    public TableColumn<Employee, String> emppassw;
    public TableColumn<Employee, Double> salary;
    public TextField eid;
    public TextField ename;
    public TextField epassword;
    public TextField esalary;
    @FXML
    private Label welcomeText;

    ObservableList<Employee> list = FXCollections.observableArrayList();

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
            String query = "SELECT * FROM employee";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int empid = resultSet.getInt("Empid");
                String empname = resultSet.getString("Empname");
                String emppassw = resultSet.getString("EmpPassw");
                double salary = resultSet.getDouble("Salary");
                employeeTable.getItems().add(new Employee(empid, empname, emppassw, salary));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        empid.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("empid"));
        empname.setCellValueFactory(new PropertyValueFactory<Employee, String>("empname"));
        emppassw.setCellValueFactory(new PropertyValueFactory<Employee, String>("emppassw"));
        salary.setCellValueFactory(new PropertyValueFactory<Employee, Double>("salary"));
        employeeTable.setItems(list);
    }

    public void InsertData(ActionEvent actionEvent) {
        String empname = ename.getText();
        String emppassw = epassword.getText();
        double salary = Double.parseDouble(esalary.getText());

        String jdbcUrl = "jdbc:mysql://localhost:3306/csd_lab3_avneet";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            String query = "INSERT INTO employee (Empname, EmpPassw, Salary) VALUES ('" + empname + "','" + emppassw + "','" + salary + "')";
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void UpdateData(ActionEvent actionEvent) {
        int empid = Integer.parseInt(eid.getText());
        String empname = ename.getText();
        String emppassw = epassword.getText();
        double salary = Double.parseDouble(esalary.getText());

        String jdbcUrl = "jdbc:mysql://localhost:3306/csd_lab3_avneet";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            String query = "UPDATE employee SET Empname='" + empname + "', EmpPassw='" + emppassw + "', Salary='" + salary + "' WHERE Empid='" + empid + "'";
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void DeleteData(ActionEvent actionEvent) {
        int empid = Integer.parseInt(eid.getText());

        String jdbcUrl = "jdbc:mysql://localhost:3306/csd_lab3_avneet";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            String query = "DELETE FROM employee WHERE Empid='" + empid + "'";
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void LoadData(ActionEvent actionEvent) {
        int empid = Integer.parseInt(eid.getText());

        String jdbcUrl = "jdbc:mysql://localhost:3306/csd_lab3_avneet";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            String query = "SELECT * FROM employee WHERE Empid='" + empid + "'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                String empname = resultSet.getString("Empname");
                String emppassw = resultSet.getString("EmpPassw");
                double salary = resultSet.getDouble("Salary");

                ename.setText(empname);
                epassword.setText(emppassw);
                esalary.setText(String.valueOf(salary));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
