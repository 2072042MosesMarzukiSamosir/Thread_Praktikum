module com.example.database_connectivity {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jasperreports;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;

    opens com.example.database_connectivity.model_entity;
    opens com.example.database_connectivity to javafx.fxml;
    exports com.example.database_connectivity;
    exports com.example.database_connectivity.controller;
    exports com.example.database_connectivity.model_entity;
    opens com.example.database_connectivity.controller to javafx.fxml;
}