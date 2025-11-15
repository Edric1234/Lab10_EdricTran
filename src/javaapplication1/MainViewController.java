package javaapplication1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;

public class MainViewController {

    public void initialize(URL location, ResourceBundle resources) {
        ToggleGroup tg = new ToggleGroup();
        smallItem.setToggleGroup(tg);
        mediumItem.setToggleGroup(tg);
        largeItem.setToggleGroup(tg);
        closeItem.setDisable(true); // disabled until a file is "opened"

        ContextMenu popup = new ContextMenu();
        MenuItem help = new MenuItem("Help");
        MenuItem inspect = new MenuItem("Inspect");
        popup.getItems().addAll(help, inspect);
        newItem.setAccelerator(KeyCombination.keyCombination("Ctrl+N"));
        
        mainPane.setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.SECONDARY) {
                popup.show(mainPane, e.getScreenX() - 50, e.getScreenY() - 25);
            }
        });
    }

    @FXML
    private MenuItem closeItem;

    @FXML
    private MenuItem copyItem;

    @FXML
    private MenuItem findItem;

    @FXML
    private CheckMenuItem gridItem;

    @FXML
    private RadioMenuItem largeItem;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private RadioMenuItem mediumItem;

    @FXML
    private MenuItem newItem;

    @FXML
    private MenuItem openItem;

    @FXML
    private MenuItem replaceItem;

    @FXML
    private MenuItem saveItem;

    @FXML
    private Menu searchMenu;

    @FXML
    private RadioMenuItem smallItem;

    @FXML
    void handleClose(ActionEvent event) {
        System.out.println("CLOSE has been pressed");
        closeItem.setDisable(true);
        openItem.setDisable(false);
        newItem.setDisable(false);

    }

    @FXML
    void handleCopy(ActionEvent event) {
        System.out.println("COPY has been pressed");
    }

    @FXML
    void handleFind(ActionEvent event) {
        System.out.println("FIND has been pressed");
        findItem.setDisable(true);
        replaceItem.setDisable(false);
    }

    @FXML
    void handleGrid(ActionEvent event) {
        if (gridItem.isSelected()) {
            System.out.println("Use GRIDLINES selected");
        } else {
            System.out.println("Use GRIDLINES unselected");
        }
    }

    @FXML
    void handleNew(ActionEvent event) {
        System.out.println("NEW has been pressed");
        newItem.setDisable(true);
        openItem.setDisable(false);
        closeItem.setDisable(false);
    }

    @FXML
    void handleOpen(ActionEvent event) {
        System.out.println("OPEN has been pressed");
        openItem.setDisable(true);
        closeItem.setDisable(false);
    }

    @FXML
    void handleReplace(ActionEvent event) {
        System.out.println("REPLACE has been pressed");
        replaceItem.setDisable(true);
        findItem.setDisable(false);
    }

    @FXML
    void handleSizeLarge(ActionEvent event) {
        System.out.println("LARGE selected");
        smallItem.setSelected(false);
        mediumItem.setSelected(false);
    }

    @FXML
    void handleSizeMedium(ActionEvent event) {
        System.out.println("MEDIUM selected");
        smallItem.setSelected(false);
        largeItem.setSelected(false);
    }

    @FXML
    void handleSizeSmall(ActionEvent event) {
        System.out.println("SMALL selected");
        mediumItem.setSelected(false);
        largeItem.setSelected(false);

    }

}
