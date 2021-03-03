package designpattern.command.remote;

public class SimpleRemoteControl {

  private static final int COMMANDS_COUNT = 7;
  private Command[] onCommands;
  private Command[] offCommands;
  private Command undoCommand;

  public SimpleRemoteControl() {
    onCommands = new Command[COMMANDS_COUNT];
    offCommands = new Command[COMMANDS_COUNT];
    Command noCommand = new NoCommand();
    for (int i = 0; i < COMMANDS_COUNT; i++) {
      onCommands[i] = noCommand;
      offCommands[i] = noCommand;
    }
    undoCommand = noCommand;
  }

  public void setCommand(int slot, Command onCommand, Command offCommand) {
    isSlotValid(slot);
    onCommands[slot] = onCommand;
    offCommands[slot] = offCommand;
  }

  private void isSlotValid(int slot) {
    if (slot >= COMMANDS_COUNT)
      throw new IndexOutOfBoundsException("Maximum slot is " + (COMMANDS_COUNT - 1));
  }

  public void buttonOnWasPressed(int slot) {
    isSlotValid(slot);
    onCommands[slot].execute();
    undoCommand = onCommands[slot];
  }

  public void buttonOffWasPressed(int slot) {
    isSlotValid(slot);
    offCommands[slot].execute();
    undoCommand = offCommands[slot];
  }

  public void undoButtonWasPushed() {
    undoCommand.undo();
  }
}
