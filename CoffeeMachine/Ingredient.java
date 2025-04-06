public class Ingredient {
    private String name = "";
    private double quantity =0;

    public Ingredient(String string, double i) {
        this.name= name;
        this.quantity= quantity;
    }

    public String getIngredientName(){
        return name; 
    }
    public double getIngredientQuanity(){
        return quantity; 
    }
    public synchronized void updateQuantity(int amount) {
        quantity += amount;
    }
    
} 
