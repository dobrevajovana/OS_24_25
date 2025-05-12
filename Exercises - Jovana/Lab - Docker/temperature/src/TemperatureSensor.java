import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class TemperatureSensor {
    public static void main(String[] args) {
        Random random = new Random();
        while (true) {
            try {
                FileWriter writer = new FileWriter("./app/temperature.txt", true); // Append mode
                for (int i = 0; i < 5; i++) {
                    int temperature = 5 + random.nextInt(46); // Generate temperature between 5 and 50
                    writer.write(temperature + "\n"); // Write each value on a new line
                }
                writer.close();
                Thread.sleep(30000); // Wait for 30 seconds before writing again
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
