package CoffeeMachine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoffeeMachine {
   private static final CoffeeMachine instance = new CoffeeMachine();
   List<Coffee> menu = new ArrayList<>();
   private final Map<String, Ingredient> ingredients;

    private CoffeeMachine() {
        menu = new ArrayList<>();
        ingredients = new HashMap<>();
        initializeIngredients();
        initializeCoffeeMenu();
    }
    public static CoffeeMachine getInstance() {
        return instance;
    }

    public void initializeIngredients(){
        ingredients.put("Milk",new Ingredient("Milk", 5));
        ingredients.put("Coffee",new Ingredient("Coffee", 5));
        ingredients.put("Water",new Ingredient("Water", 5));
    }
    public void initializeCoffeeMenu(){
        Map<Ingredient,Integer>  espressoRecipe= new HashMap<>();
        espressoRecipe.put(ingredients.get("Coffee"), 1);
        espressoRecipe.put(ingredients.get("Water"), 1);
        menu.add(new Coffee("Expresso",3.0,espressoRecipe));

        Map<Ingredient,Integer>  latteRecipe= new HashMap<>();
        latteRecipe.put(ingredients.get("Coffee"), 1);
        latteRecipe.put(ingredients.get("Water"), 1);
        menu.add(new Coffee("Latte",4.3,latteRecipe));

        Map<Ingredient,Integer>  cappacinoRecipe= new HashMap<>();
        cappacinoRecipe.put(ingredients.get("Coffee"), 1);
        cappacinoRecipe.put(ingredients.get("Water"), 1);
        menu.add(new Coffee("Cappacino",3.3,cappacinoRecipe));

    }

    public void displayMenu() {
        System.out.println("Coffee Menu:");
        for (Coffee coffee : menu) {
            System.out.println(coffee.getCoffeeName() + " - $" + coffee.getCoffeePrice());
        }
    }

    public synchronized Coffee selectCoffee(String coffeeName) {
        for (Coffee coffee : menu) {
            if (coffee.getCoffeeName().equalsIgnoreCase(coffeeName)) {
                return coffee;
            }
        }
        return null;
    }

    public synchronized void dispenseCoffee(Coffee coffee, Pay payment) {
        if (payment.getAmount() >= coffee.getCoffeePrice()) {
            if (hasEnoughIngredients(coffee)) {
                updateIngredients(coffee);
                System.out.println("Dispensing " + coffee.getCoffeeName() + "...");
                double change = payment.getAmount() - coffee.getCoffeePrice();
                if (change > 0) {
                    System.out.println("Please collect your change: $" + change);
                }
            } else {
                System.out.println("Insufficient ingredients to make " + coffee.getCoffeeName());
            }
        } else {
            System.out.println("Insufficient payment for " + coffee.getCoffeeName());
        }
    }

    private boolean hasEnoughIngredients(Coffee coffee) {
        for (Map.Entry<Ingredient, Integer> entry : coffee.getRecipe().entrySet()) {
            Ingredient ingredient = entry.getKey();
            int requiredQuantity = entry.getValue();
            if (ingredient.getIngredientQuanity() < requiredQuantity) {
                return false;
            }
        }
        return true;
    }

    private void updateIngredients(Coffee coffee) {
        for (Map.Entry<Ingredient, Integer> entry : coffee.getRecipe().entrySet()) {
            Ingredient ingredient = entry.getKey();
            int requiredQuantity = entry.getValue();
            ingredient.updateQuantity(-requiredQuantity);
            if (ingredient.getIngredientQuanity() < 3) {
                System.out.println("Low inventory alert: " + ingredient.getIngredientName());
            }
        }
    }

    

}
