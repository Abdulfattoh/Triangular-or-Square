package com.example.number;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    class Number {
        int number;

        boolean isSquare() {
            double squareRoot = Math.sqrt(number);
            return squareRoot == Math.floor(squareRoot);
        }

        boolean isTriangular() {
            int x = 1;
            int triangularNumber = 1;

            while (triangularNumber < number) {
                x++;
                triangularNumber = triangularNumber + x;
            }
            // x    1 2 3 4 5 6 7 8
            // tri  1 3 6 10 15 21 28
            return triangularNumber == number;
        }
    }

    public void checkNumber(View view) {
        EditText usersNumber = findViewById(R.id.editText);
        String message = "";

        if (usersNumber.getText().toString().isEmpty()) {
            message = "Please enter the number";
        } else {
            Number myNumber = new Number();
            myNumber.number = Integer.parseInt(usersNumber.getText().toString());

            if (myNumber.isSquare() && myNumber.isTriangular()){
                message = myNumber.number + " is both triangular and square";
            }else if (myNumber.isSquare()){
                message = myNumber.number + " is square not triangular";
            }else if (myNumber.isTriangular()){
                message = myNumber.number + " is triangular not square";
            }else {
                message = "Number neither square nor triangular";
            }
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
