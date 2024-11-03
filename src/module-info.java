module Gym.Membership.Management.System.With.Gui {
    requires javafx.controls;
    requires java.desktop;

    opens frontend;
    exports frontend;
    exports backend;
}