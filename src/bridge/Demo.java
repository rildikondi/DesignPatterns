package bridge;

public class Demo {
    public static void main(String[] args) {
        Modem modem = new DialModemController(new ErnieModem());
        ModemClient modemClient  = new ModemClient(modem);


        DedicatedModemController dedicatedModemController = new DedicatedModemController(new HayesModem());
        DedicatedUser dedicatedUser = new DedicatedUser(dedicatedModemController);
    }
}
