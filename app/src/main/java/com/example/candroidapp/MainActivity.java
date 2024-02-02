package com.example.candroidapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private LinearLayout orderEntryContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        orderEntryContainer = findViewById(R.id.orderEntryContainer);

        // Add 100 random order entries to showcase to Customer
        for (int i = 1; i <= 100; i++) {
            addOrderEntry(generateRandomDishName());
        }
    }

    private void addOrderEntry(String itemName) {
        // Inflate the OrderEntry layout
        View orderEntryView = LayoutInflater.from(this).inflate(R.layout.order_entry, null);

        // Set initial values
        TextView itemNameTextView = orderEntryView.findViewById(R.id.itemNameTextView);
        TextView quantityTextView = orderEntryView.findViewById(R.id.quantityTextView);

        itemNameTextView.setText(itemName);
        quantityTextView.setText("0");

        // Increase quantity when the + button is clicked
        Button increaseButton = orderEntryView.findViewById(R.id.increaseButton);
        increaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int quantity = Integer.parseInt(quantityTextView.getText().toString());
                quantity++;
                quantityTextView.setText(String.valueOf(quantity));
            }
        });

        // Decrease quantity when the - button is clicked
        Button decreaseButton = orderEntryView.findViewById(R.id.decreaseButton);
        decreaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int quantity = Integer.parseInt(quantityTextView.getText().toString());
                if (quantity > 0) {
                    quantity--;
                    quantityTextView.setText(String.valueOf(quantity));
                }
            }
        });

        // Add the OrderEntry to the container
        orderEntryContainer.addView(orderEntryView);
    }

    private String generateRandomDishName() {
        String[] dishNames = {
                "Spaghetti Bolognese",
                "Chicken Alfredo",
                "Margherita Pizza",
                "Caesar Salad",
                "Sushi Platter",
                "Beef Stir-Fry",
                "Cheeseburger",
                "Shrimp Scampi",
                "Vegetable Curry",
                "Chocolate Cake",
                "Tiramisu",
                "Mango Smoothie",
                "Caprese Salad",
                "Chicken Teriyaki",
                "Lobster Bisque",
                "Pasta Carbonara",
                "Pho Noodle Soup",
                "Fish Tacos",
                "Garlic Butter Shrimp",
                "Chicken Parmesan",
                "Döner Kebab",
                "Lamacune",
                "Hot Dog",
                "Chili Cheese Fries"
        };

        Random random = new Random();
        int randomIndex = random.nextInt(dishNames.length);
        return dishNames[randomIndex];
    }
}