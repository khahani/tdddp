package designpattern.command.remote;

public class CommandGarageDoorOpen implements Command {
  GarageDoor garageDoor;

  public CommandGarageDoorOpen(GarageDoor garageDoor) {
    this.garageDoor = garageDoor;
  }

  @Override
  public void execute() {
    if (garageDoor != null)
      garageDoor.open();
  }

  @Override
  public void undo() {
    if (garageDoor != null)
      garageDoor.close();
  }
}
