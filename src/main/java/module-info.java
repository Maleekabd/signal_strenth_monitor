module com.signal_monitor.javafx_signal_strength_monitor {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;

    opens com.signal_monitor.javafx_signal_strength_monitor to javafx.fxml;
    exports com.signal_monitor.javafx_signal_strength_monitor;
}