package designpattern.command.actorModel;

public class Program {
  public static void main(String[] args) {
    ButtonCommand command = new ButtonCommand();

    Commands.add(command);

    IO.buttonPressed = 1;
    Commands commands = new Commands();
    commands.run();

    System.out.println("Started...");

  }
}
