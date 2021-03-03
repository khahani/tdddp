package designpattern.command.actorModel;

import java.util.ArrayList;
import java.util.List;

public class Commands {
  static List<Command> commands = new ArrayList<>();

  public static void add(Command command) {
    commands.add(command);
  }

  public void run() {
    while (!commands.isEmpty()) {
      Command c = commands.get(0);
      commands.remove(0);
      c.execute();
    }
  }
}
