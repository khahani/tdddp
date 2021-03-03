package designpattern.command.remote;

public class CommandOnLight implements Command {

  private Light light;

  public CommandOnLight(Light light) {
    this.light = light;
  }

  @Override
  public void execute() {
    if (light != null)
      light.on();
  }

  @Override
  public void undo() {
    if (light != null)
      light.off();
  }
}
