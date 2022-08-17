package com.example.database_connectivity.controller;

import com.example.database_connectivity.dao_entity.CatDao;
import com.example.database_connectivity.model_entity.CategoryEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class SecondController {
    public TextField txtIDCat;
    public TextField txtNamaCat;
    public TableView tbviewCategory;
    public ObservableList<CategoryEntity>olistCategory;
    public TableColumn colID;
    public TableColumn colNameCat;
    public Button btnSave;

    public void initialize(){
        CatDao dao = new CatDao();
        olistCategory = FXCollections.observableArrayList(dao.getdata());
        tbviewCategory.setItems(olistCategory);
        colID.setCellValueFactory(new PropertyValueFactory<>("idCategory"));
        colNameCat.setCellValueFactory(new PropertyValueFactory<>("nama"));

    }
    public void onSaveCategory(ActionEvent event) {
        CatDao dao = new CatDao();
        if (txtIDCat.getText().isEmpty() || txtNamaCat.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR,"please fill in all the field", ButtonType.OK);
            alert.showAndWait();
        }else {
            CategoryEntity cat = new CategoryEntity();
            cat.setIdCategory(Integer.valueOf(txtIDCat.getText()));
            cat.setNama(txtNamaCat.getText());
            dao.addData(cat);
            olistCategory = FXCollections.observableArrayList(dao.getdata());
            tbviewCategory.setItems(olistCategory);
        }

    }
}
