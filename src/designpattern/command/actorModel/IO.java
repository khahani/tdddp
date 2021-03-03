package designpattern.command.actorModel;

public class IO {
  public static final int BUTTON_ADDRES = 0x12;
  public static final int LIGHT_ADDRESS = 0x13;

  public static int buttonPressed = 1;
  private static int lightPressed = 0;

  public static int in(int buttonAddres) {
    return buttonPressed;
  }

  public static void out(int lightAddress, int status) {
    lightPressed = status;
  }
}
