package mkma.entity;

/**
 * The Ingredient class will contain the information of one Ingredient.
 *
 * @author Martin Valiente Ainz
 */
public class Ingredient {

    /**
     * id Will contain the ID of the Ingredient.
     */
    private long id;

    /**
     * name Will contain the name of the Ingredient.
     */
    private String name;

    /**
     * type Will contain the type of the Ingredient.
     */
    private IngredientType type;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IngredientType getType() {
        return type;
    }

    public void setType(IngredientType type) {
        this.type = type;
    }

}

/**
 * This enum will have the different types of Ingredients.
 *
 * @author Martin Valiente Ainz
 */
enum IngredientType {
    Dairy,
    FatAndOil,
    Additive,
    Mushroom,
    Legume,
    Vegetable,
    Fruit,
    Egg,
    Cereal,
    Fish,
    Seafood,
    Meat,
    Drink,
    Dessert;
}
