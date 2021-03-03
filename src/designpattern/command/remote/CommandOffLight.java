package designpattern.command.remote;

public class CommandOffLight implements Command {
  Light light;

  public CommandOffLight(Light light) {
    this.light = light;
  }

  @Override
  public void execute() {
    if (light != null)
      light.off();
  }

  @Override
  public void undo() {
    if (light != null)
      light.on();
  }
}
