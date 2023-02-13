package barista.matic.services;

public class BaristaMaticMachineService {

    public void display(Inventory inventory, Menu menu) {
        inventory.display();
        menu.display();
    }

    public void performOpertaion(Inventory inventory, Menu menu, char input) {
        switch (input) {
            case 'r':
                inventory.restock();
                inventory.display();
                menu.display();
                break;
            case '1':
                menu.makeDrink(0);
                inventory.display();
                menu.display();
                break;
            case '2':
                menu.makeDrink(1);
                inventory.display();
                menu.display();
                break;
            case '3':
                menu.makeDrink(2);
                inventory.display();
                menu.display();
                break;
            case '4':
                menu.makeDrink(3);
                inventory.display();
                menu.display();
                break;
            case '5':
                menu.makeDrink(4);
                inventory.display();
                menu.display();
                break;
            case '6':
                menu.makeDrink(5);
                inventory.display();
                menu.display();
                break;
            default:
                System.out.println("Invalid selection: " + input);
                inventory.display();
                menu.display();
                break;
        }
    }
}
