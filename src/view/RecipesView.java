package view;

import interface_adapter.display_recipes.RecipesViewModel;
import interface_adapter.display_recipes.TaggedRecipesController;
import interface_adapter.display_recipes.FavouriteRecipesController;

import interface_adapter.display_user_tags.UserTagsViewModel;
import interface_adapter.display_user_tags.UserTagsController;

import javax.swing.*;
import java.awt.*;

public class RecipesView extends JPanel{

    public final String viewName = "user recipes";

    private final TaggedRecipesController taggedRecipesController;
    private final FavouriteRecipesController favouriteRecipesController;

    private final UserTagsController userTagsController;
    private final RecipesViewModel recipesViewModel;

    private final UserTagsViewModel userTagsViewModel;


    public RecipesView(TaggedRecipesController taggedRecipesController, FavouriteRecipesController favouriteRecipesController, UserTagsController userTagsController, RecipesViewModel recipesViewModel, UserTagsViewModel UserTagsViewModel) {
        this.taggedRecipesController = taggedRecipesController;
        this.favouriteRecipesController = favouriteRecipesController;
        this.userTagsController = userTagsController;
        this.recipesViewModel = recipesViewModel;
        this.userTagsViewModel = UserTagsViewModel;

        setLayout(new FlowLayout());

        JLabel optionLabel = new JLabel("Select an option: ");
        JLabel favouriteButton = new JLabel("Favourite Recipes");
        JButton taggedButton = new JButton("Tagged Recipes");

        favouriteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                displayFavouriteRecipes();
            }
        });


    }

    public void displayFavouriteRecipes() {
        favouriteRecipesController.execute();
    }

    public void displayUserTags() {
        String selectedTag = (String) JOptionPane.showInputDialog(this, "Select a tag:", "Tag Selection", JOptionPane.PLAIN_MESSAGE, null, userTagsController.execute(), null);

        if (selectedTag != null) {
            // User selected a tag, now display the tagged recipes list.
            taggedRecipesController.execute(selectedTag);
        }
    }
}
