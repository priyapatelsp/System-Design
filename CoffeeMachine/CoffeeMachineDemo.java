package CoffeeMachine;

public class CoffeeMachineDemo {

    public static void run() {
        CoffeeMachine coffeeMachine = CoffeeMachine.getInstance();

        coffeeMachine.displayMenu();

        Coffee espresso = coffeeMachine.selectCoffee("Espresso");
        coffeeMachine.dispenseCoffee(espresso, new Pay(0.9));

        Coffee cappuccino = coffeeMachine.selectCoffee("Cappuccino");
        coffeeMachine.dispenseCoffee(cappuccino, new Pay(3.5));


        Coffee latte = coffeeMachine.selectCoffee("Latte");
        coffeeMachine.dispenseCoffee(latte, new Pay(4.0));
    }

    public static void main(String[] args){
        run();
    }
}