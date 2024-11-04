module Gym.Membership.Management.System.With.Gui {
    requires javafx.controls;
    requires java.desktop;
    requires javafx.media;

    opens frontend;
    exports frontend;
    exports backend;
}