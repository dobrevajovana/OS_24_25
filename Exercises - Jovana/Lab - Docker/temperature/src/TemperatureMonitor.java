import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TemperatureMonitor {
    public static void main(String[] args) {
        while (true) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader("./app/temperature.txt"));
                String line;
                int sum = 0, count = 0;

                // Read the temperature values from the file
                while ((line = reader.readLine()) != null) {
                    sum += Integer.parseInt(line);
                    count++;
                }
                reader.close();

                // Calculate the average temperature
                if (count > 0) {
                    int average = sum / count;
                    String level = getTemperatureLevel(average);

                    // Write the level to the temperaturelevel.txt file
                    FileWriter writer = new FileWriter("./app/temperature.txt", true); // Append mode
                    writer.write("Average Temperature: " + average + " °C, Level: " + level + "\n");
                    writer.close();
                }

                Thread.sleep(60000); // Wait for 60 seconds before recalculating
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static String getTemperatureLevel(int temperature) {
        if (temperature >= 5 && temperature <= 19) {
            return "Low";
        } else if (temperature >= 20 && temperature <= 35) {
            return "Medium";
        } else {
            return "High";
        }
    }
}
