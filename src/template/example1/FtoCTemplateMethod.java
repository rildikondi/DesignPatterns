package template.example1;

import java.io.*;

public class FtoCTemplateMethod extends Application {
    private BufferedReader input;
    private PrintStream output;

    public static void main(String[] args) {
        new FtoCTemplateMethod().run();
    }

    @Override
    protected void init() {
        input = new BufferedReader(new InputStreamReader(System.in));
        output = System.out;
    }

    @Override
    protected void idle() {
        String fahrString = null;
        try {
            fahrString = input.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (fahrString == null || fahrString.length() == 0)
            setDone();
        else {
            double fahr = Double.parseDouble(fahrString);
            double celcius = 5.0 / 9.0 * (fahr - 32);
            output.printf("F={%s}, C={%s}", fahr, celcius);
        }
    }

    @Override
    protected void cleanup() {
        output.println("ftoc exit");
    }
}
