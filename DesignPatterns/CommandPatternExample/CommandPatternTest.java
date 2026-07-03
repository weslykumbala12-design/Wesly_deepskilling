public class CommandPatternTest {

    public static void main(String[] args) {

        Light light = new Light();

        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);

        RemoteControl remote = new RemoteControl();

        System.out.println("Pressing ON Button");
        remote.setCommand(lightOn);
        remote.pressButton();

        System.out.println();

        System.out.println("Pressing OFF Button");
        remote.setCommand(lightOff);
        remote.pressButton();

    }

}