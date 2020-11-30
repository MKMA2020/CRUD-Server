package mkma.entity;

/**
 * Class will contain the information of a recipe.
 *
 * @author Martin Gros
 */
public class Recipe {

    /**
     * id Will contain the ID of the Recipe.
     */
    private Long id;

    /**
     * Name Will contain the Name of the Recipe.
     */
    private String Name;

    /**
     * steps Will contain the steps of the Recipe.
     */
    private String steps;

    /**
     * kCal Will contain the kCal value of the Recipe.
     */
    private float kCal;

    /**
     * type Will contain the type of the Recipe.
     */
    private RecipeType type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public float getkCal() {
        return kCal;
    }

    public void setkCal(float kCal) {
        this.kCal = kCal;
    }

    public RecipeType getType() {
        return type;
    }

    public void setType(RecipeType type) {
        this.type = type;
    }

}

/**
 * This enum will have the different types of Recipes.
 *
 * @author Martin Gros
 */
enum RecipeType {
    Breakfast,
    Snack,
    Lunch,
    Dinner;
}
