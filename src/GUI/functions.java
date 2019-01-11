package GUI;

import database.DataHandler;
import database.Entry;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

public class functions {
    public void updateSearch() {
        ObservableList<Entry> list = FXCollections.observableArrayList(DataHandler.getEntries());
        ObservableList<Entry> searchlist = FXCollections.observableArrayList();
        for (Entry entry : list) {
            if (!searchlist.contains(entry)) {
                if (checkf.isSelected()) {
                    if (entry.getFirstname().toLowerCase().contains(search.getText().toLowerCase())) {
                        firstname.setCellValueFactory(new PropertyValueFactory<>("firstname"));
                        lastname.setCellValueFactory(new PropertyValueFactory<>("lastname"));
                        phone.setCellValueFactory(new PropertyValueFactory<>("phonenumber"));
                        street.setCellValueFactory(new PropertyValueFactory<>("street"));
                        hn.setCellValueFactory(new PropertyValueFactory<>("housenumber"));
                        town.setCellValueFactory(new PropertyValueFactory<>("town"));
                        plz.setCellValueFactory(new PropertyValueFactory<>("postcode"));
                        searchlist.add(entry);
                    }
                }
            }
            if (!searchlist.contains(entry)) {
                if (checkl.isSelected()) {
                    if (entry.getLastname().toLowerCase().contains(search.getText().toLowerCase())) {
                        firstname.setCellValueFactory(new PropertyValueFactory<>("firstname"));
                        lastname.setCellValueFactory(new PropertyValueFactory<>("lastname"));
                        phone.setCellValueFactory(new PropertyValueFactory<>("phonenumber"));
                        street.setCellValueFactory(new PropertyValueFactory<>("street"));
                        hn.setCellValueFactory(new PropertyValueFactory<>("housenumber"));
                        town.setCellValueFactory(new PropertyValueFactory<>("town"));
                        plz.setCellValueFactory(new PropertyValueFactory<>("postcode"));
                        searchlist.add(entry);
                    }
                }
            }
            if (!searchlist.contains(entry)) {
                if (checkpn.isSelected()) {
                    if (entry.getPhonenumber().toLowerCase().contains(search.getText().toLowerCase())) {
                        firstname.setCellValueFactory(new PropertyValueFactory<>("firstname"));
                        lastname.setCellValueFactory(new PropertyValueFactory<>("lastname"));
                        phone.setCellValueFactory(new PropertyValueFactory<>("phonenumber"));
                        street.setCellValueFactory(new PropertyValueFactory<>("street"));
                        hn.setCellValueFactory(new PropertyValueFactory<>("housenumber"));
                        town.setCellValueFactory(new PropertyValueFactory<>("town"));
                        plz.setCellValueFactory(new PropertyValueFactory<>("postcode"));
                        searchlist.add(entry);
                    }
                }
            }
            if (!searchlist.contains(entry)) {
                if (checks.isSelected()) {
                    if (entry.getStreet().toLowerCase().contains(search.getText().toLowerCase())) {
                        firstname.setCellValueFactory(new PropertyValueFactory<>("firstname"));
                        lastname.setCellValueFactory(new PropertyValueFactory<>("lastname"));
                        phone.setCellValueFactory(new PropertyValueFactory<>("phonenumber"));
                        street.setCellValueFactory(new PropertyValueFactory<>("street"));
                        hn.setCellValueFactory(new PropertyValueFactory<>("housenumber"));
                        town.setCellValueFactory(new PropertyValueFactory<>("town"));
                        plz.setCellValueFactory(new PropertyValueFactory<>("postcode"));
                        searchlist.add(entry);
                    }
                }
            }
            if (!searchlist.contains(entry)) {
                if (checkh.isSelected()) {
                    if (entry.getHousenumber().toLowerCase().contains(search.getText().toLowerCase())) {
                        firstname.setCellValueFactory(new PropertyValueFactory<>("firstname"));
                        lastname.setCellValueFactory(new PropertyValueFactory<>("lastname"));
                        phone.setCellValueFactory(new PropertyValueFactory<>("phonenumber"));
                        street.setCellValueFactory(new PropertyValueFactory<>("street"));
                        hn.setCellValueFactory(new PropertyValueFactory<>("housenumber"));
                        town.setCellValueFactory(new PropertyValueFactory<>("town"));
                        plz.setCellValueFactory(new PropertyValueFactory<>("postcode"));
                        searchlist.add(entry);
                    }
                }
            }
            if (!searchlist.contains(entry)) {
                if (checkt.isSelected()) {
                    if (entry.getTown().toLowerCase().contains(search.getText().toLowerCase())) {
                        firstname.setCellValueFactory(new PropertyValueFactory<>("firstname"));
                        lastname.setCellValueFactory(new PropertyValueFactory<>("lastname"));
                        phone.setCellValueFactory(new PropertyValueFactory<>("phonenumber"));
                        street.setCellValueFactory(new PropertyValueFactory<>("street"));
                        hn.setCellValueFactory(new PropertyValueFactory<>("housenumber"));
                        town.setCellValueFactory(new PropertyValueFactory<>("town"));
                        plz.setCellValueFactory(new PropertyValueFactory<>("postcode"));
                        searchlist.add(entry);
                    }
                }
            }
            if (!searchlist.contains(entry)) {
                if (checkplz.isSelected()) {
                    if (entry.getPostcode().toLowerCase().contains(search.getText().toLowerCase())) {
                        firstname.setCellValueFactory(new PropertyValueFactory<>("firstname"));
                        lastname.setCellValueFactory(new PropertyValueFactory<>("lastname"));
                        phone.setCellValueFactory(new PropertyValueFactory<>("phonenumber"));
                        street.setCellValueFactory(new PropertyValueFactory<>("street"));
                        hn.setCellValueFactory(new PropertyValueFactory<>("housenumber"));
                        town.setCellValueFactory(new PropertyValueFactory<>("town"));
                        plz.setCellValueFactory(new PropertyValueFactory<>("postcode"));
                        searchlist.add(entry);
                    }
                }
            }
        }
        tabelle.setItems(searchlist);
    }
}
