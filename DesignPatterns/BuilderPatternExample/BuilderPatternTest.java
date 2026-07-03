public class BuilderPatternTest {

    public static void main(String[] args) {

        Computer gamingPC = new Computer.Builder()
                .setCPU("Intel Core i9")
                .setRAM(32)
                .setStorage(1000)
                .setGraphicsCard("NVIDIA RTX 4080")
                .setOperatingSystem("Windows 11")
                .build();

        Computer officePC = new Computer.Builder()
                .setCPU("Intel Core i5")
                .setRAM(16)
                .setStorage(512)
                .setGraphicsCard("Integrated Graphics")
                .setOperatingSystem("Windows 10")
                .build();

        System.out.println("Gaming PC");
        gamingPC.display();

        System.out.println("Office PC");
        officePC.display();
    }
}