package com.example.yumyay_chef.model;

public class Ingrediant {
    private String ingredientName;
    private String ingredientMeasure;
    private String ingredientThumb;

    public Ingrediant(String ingredientName, String ingredientThumb, String ingredientMeasure) {
        this.ingredientName = ingredientName;
        this.ingredientThumb = ingredientThumb;
        this.ingredientMeasure = ingredientMeasure;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public String getIngredientMeasure() {
        return ingredientMeasure;
    }

    public void setIngredientMeasure(String ingredientMeasure) {
        this.ingredientMeasure = ingredientMeasure;
    }

    public String getIngredientThumb() {
        return ingredientThumb;
    }

    public void setIngredientThumb(String ingredientThumb) {
        this.ingredientThumb = ingredientThumb;
    }


}
