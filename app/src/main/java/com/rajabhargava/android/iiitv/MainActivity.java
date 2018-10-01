package com.rajabhargava.android.iiitv;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // Create a new dis with a first, middle, and last name
        Map<String, Object> dis = new HashMap<>();
        dis.put("content", "INTRODUCTION TO PROGRAMMING: Programming methods, paradigms, problem solving techniques, algorithm development, flow charts.\n" +
                "LINUX ENVIRONMENT: Editor, compiler, debugger.\n" +
                "BASICS OF PROCEDURAL PROGRAMMING: Constants, variables, expressions, operators, assignment, basic input and output, built-in functions, program debugging.\n" +
                "VARIABLES AND OPERATORS: Basic data types, precedence and order of evaluation, pointers, memory allocation of variables.\n" +
                "CONTROL STRUCTURES: Selection statements, iteration statements.");
        dis.put("textbook", "Digital Fundamentals,10thEd, Floyd T L, Prentice Hall, 2009");
        dis.put("refbook", "1) Digital Design-Principles and Practices, 4thEd, J F Wakerly, Prentice Hall, 2006.\n" +
                "2)Digital Design, Morris Mano, Prentice Hall, 2002\n" +
                "3) Digital Systems: Principles and Applications, Ronald J. Tocci, Neal S. Widmer, Gregory\n" +
                "L. Moss, Pearson Education, Limited, 2011.\n" +
                "4) Fundamentals of Digital Logic with Verilog Design, 2nd Ed, S. Brown and Z. Vrsaniec,\n" +
                "McGraw Hill, 2007");
        dis.put("credits", "Lecture-3\n" + "Tutorial-0\n" + "Practical-4\n" + "Total-5");

// Add a new document with a generated ID
        db.collection("all_courses").document("sem1").collection("dld").document("about")
                .set(dis, SetOptions.merge());
    }
}
