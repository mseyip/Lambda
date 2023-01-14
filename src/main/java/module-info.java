module com.example.lambda {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lambda to javafx.fxml;
    exports com.example.lambda;
}