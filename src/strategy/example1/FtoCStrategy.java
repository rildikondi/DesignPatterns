package strategy.example1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class FtoCStrategy implements Application {
    private BufferedReader input;
    private PrintStream output;
    private boolean isDone = false;

    public static void main(String[] args) {
        (new ApplicationRunner(new FtoCStrategy())).run();
    }

    @Override
    public void init() {
        input = new BufferedReader(new InputStreamReader(System.in));
        output = System.out;
    }

    @Override
    public void idle() {
        String fahrString = null;
        try {
            fahrString = input.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (fahrString == null || fahrString.length() == 0)
            isDone = true;
        else {
            double fahr = Double.parseDouble(fahrString);
            double celcius = 5.0 / 9.0 * (fahr - 32);
            output.printf("F={%s}, C={%s}", fahr, celcius);
        }
    }

    @Override
    public void cleanup() {
        output.println("ftoc exit");
    }

    @Override
    public boolean done() {
        return isDone;
    }
}
