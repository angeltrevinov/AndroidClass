package com.example.roomexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.roomexample.productdb.Product;
import com.example.roomexample.productdb.ProductDatabase;

public class MainActivity extends AppCompatActivity {

    TextView idView;
    EditText productBox;
    EditText quantityBox;
    EditText editTextProductId;

    private ProductDatabase productDatabase;
    private Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idView = findViewById(R.id.productID);
        productBox = findViewById(R.id.productName);
        quantityBox = findViewById(R.id.productQuantity);
        editTextProductId = findViewById(R.id.editText_productId);

        productDatabase = ProductDatabase.getInstance(this);


    }

    public void newProduct(View view) {
        int quantity = Integer.parseInt(quantityBox.getText().toString());
        String name = productBox.getText().toString();

        Product product = new Product(name, quantity);

        long j;
        j = productDatabase.getProductDao().insertProduct(product);

        idView.setText("Product created with ID: " + j);
    }

    public void removeProduct(View view) {
    }

    public void lookupProduct(View view) {
        String id = editTextProductId.getText().toString();
        Product product = productDatabase.getProductDao().searchById(Integer.parseInt(id));

        if (product != null) {
            idView.setText(String.valueOf(product.getProduct_id()));
            productBox.setText(String.valueOf(product.getTitle()));
            quantityBox.setText(String.valueOf(product.getQuantity()));
        } else {
            idView.setText("Not found");
        }

    }
}