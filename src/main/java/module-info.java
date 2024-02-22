module mx.arturogil.notepad {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens mx.arturogil.notepad to javafx.fxml;
    exports mx.arturogil.notepad;
}