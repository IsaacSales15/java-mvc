module com.sales {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.sales to javafx.fxml;
    exports com.sales;
}
