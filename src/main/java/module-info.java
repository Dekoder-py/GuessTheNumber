module co.dekoderpy.guessthenumber {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.dekoderpy.guessthenumber to javafx.fxml;
    exports co.dekoderpy.guessthenumber;
}