package designpattern.command.actorModel;

public class ButtonCommand implements Command {
  @Override
  public void execute() {
    Commands.add(buttonHasBeenPressed() ? new LightCommand() : this);
  }

  private boolean buttonHasBeenPressed() {
    return (IO.in(IO.BUTTON_ADDRES) == 0);
  }

  private class LightCommand implements Command {

    @Override
    public void execute() {
      IO.out(IO.LIGHT_ADDRESS, 1);
      System.out.println("Lights on");
    }
  }
}
