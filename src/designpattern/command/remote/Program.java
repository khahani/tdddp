package designpattern.command.remote;

public class Program {
  public static void main(String[] args) {
    Light light = new Light();
    GarageDoor garageDoor = new GarageDoor();

    CommandOnLight lightOn = new CommandOnLight(light);
    CommandOffLight offLight = new CommandOffLight(light);

    CommandGarageDoorOpen garageDoorOpen = new CommandGarageDoorOpen(garageDoor);
    CommandGarageDoorClose garageDoorClose = new CommandGarageDoorClose(garageDoor);

    SimpleRemoteControl remote = new SimpleRemoteControl();
    remote.setCommand(0, lightOn, offLight);
    remote.setCommand(1, garageDoorOpen, garageDoorClose);
    remote.buttonOnWasPressed(0);
    remote.buttonOnWasPressed(1);
    remote.buttonOffWasPressed(0);
    remote.buttonOffWasPressed(1);
    remote.undoButtonWasPushed();
  }
}
