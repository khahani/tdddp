package designpattern.command.remote;

public class CommandGarageDoorClose implements Command {
  GarageDoor garageDoor;

  public CommandGarageDoorClose(GarageDoor garageDoor) {
    this.garageDoor = garageDoor;
  }

  @Override
  public void execute() {
    if (garageDoor != null)
      garageDoor.close();
  }

  @Override
  public void undo() {
    if (garageDoor != null)
      garageDoor.open();
  }
}
