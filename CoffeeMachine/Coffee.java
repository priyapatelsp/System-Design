package CoffeeMachine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Coffee {

    private String name ;
    private double price;
    private Map< Ingredient, Integer> recipe;

    public Coffee(String name, Double price,Map<Ingredient,Integer> espressoRecipe){
        this.name = name;
        this.price = price;
        this.recipe = espressoRecipe;
    }
    public String getCoffeeName(){
        return this.name;
    }
    public double getCoffeePrice(){
        return this.price;
    }
    public Map< Ingredient, Integer> getRecipe(){
        return this.recipe;
    }
} 
