import barista.matic.services.BaristaMaticMachineService;
import barista.matic.services.Inventory;
import barista.matic.services.Menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaristaMaticMachine {


    public static void main(String[] args) {
        BaristaMaticMachineService baristaMaticMachineService = new BaristaMaticMachineService();
        Inventory inventory = new Inventory();
        Menu menu = new Menu(inventory);
        baristaMaticMachineService.display(inventory, menu);
        while (true) {
            BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));
            String input = "";
            while (input.equals("")) {
                try {
                    input = dataIn.readLine();
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }

            char c = (input.length() > 1) ? 0 : input.toLowerCase().charAt(0);
            if (c == 'q') {
                break;
            }
            baristaMaticMachineService.performOpertaion(inventory, menu, c);
        }
    }

}