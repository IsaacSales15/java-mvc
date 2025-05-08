module com.sales {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.sales to javafx.fxml;
    exports com.sales;
}
