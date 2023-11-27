package view;

import interface_adapter.search_by_cuisine.SearchByCuisineController;
import interface_adapter.search_by_cuisine.SearchByCuisineViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchByCuisineView extends JPanel {
    public final String viewName = "search recipes by cuisine";
    private final SearchByCuisineController searchByCuisineController;
    private final SearchByCuisineViewModel searchByCuisineViewModel;

    public SearchByCuisineView(SearchByCuisineController searchByCuisineController, SearchByCuisineViewModel searchByCuisineViewModel) {
        this.searchByCuisineController = searchByCuisineController;
        this.searchByCuisineViewModel = searchByCuisineViewModel;

        setLayout(new FlowLayout());

        JLabel idLabel = new JLabel("Enter the recipe cuisine:");
        JTextField idTextField = new JTextField(10);
        JButton searchButton = new JButton("Search");

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String recipeCuisine = idTextField.getText();
                searchByCuisineController.execute(recipeCuisine);
                System.out.println("Searching for Recipe Cuisine: " + recipeCuisine);
            }
        });

        add(idLabel);
        add(idTextField);
        add(searchButton);

        setPreferredSize(new Dimension(600, 200));
    }
    // Add methods to update the view based on the ViewModel if needed here
}
