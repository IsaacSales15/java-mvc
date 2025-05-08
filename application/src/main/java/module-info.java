module com.sales {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires transitive javafx.graphics;

    opens com.sales.controller to javafx.fxml;
    exports com.sales;
}
