package edu.unc.svkathcs.assignment1;

import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    TextView grid00, grid01, grid02, grid03,
            grid04, grid05, grid06, grid07,
            grid08, grid09, grid10, grid11,
            grid12, grid13, grid14, grid15,
            move_count, move_history, solution_display;
    Button but_a, but_b, but_c, but_d,
            but_e, but_f, but_g, but_h,
            but_i, but_j;
    String solution = new String();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        grid00 = (TextView) findViewById(R.id.grid00);
        grid01 = (TextView) findViewById(R.id.grid01);
        grid02 = (TextView) findViewById(R.id.grid02);
        grid03 = (TextView) findViewById(R.id.grid03);
        grid04 = (TextView) findViewById(R.id.grid04);
        grid05 = (TextView) findViewById(R.id.grid05);
        grid06 = (TextView) findViewById(R.id.grid06);
        grid07 = (TextView) findViewById(R.id.grid07);
        grid08 = (TextView) findViewById(R.id.grid08);
        grid09 = (TextView) findViewById(R.id.grid09);
        grid10 = (TextView) findViewById(R.id.grid10);
        grid11 = (TextView) findViewById(R.id.grid11);
        grid12 = (TextView) findViewById(R.id.grid12);
        grid13 = (TextView) findViewById(R.id.grid13);
        grid14 = (TextView) findViewById(R.id.grid14);
        grid15 = (TextView) findViewById(R.id.grid15);
        but_a = (Button) findViewById(R.id.but_a);
        but_b = (Button) findViewById(R.id.but_b);
        but_c = (Button) findViewById(R.id.but_c);
        but_d = (Button) findViewById(R.id.but_d);
        but_e = (Button) findViewById(R.id.but_e);
        but_f = (Button) findViewById(R.id.but_f);
        but_g = (Button) findViewById(R.id.but_g);
        but_h = (Button) findViewById(R.id.but_h);
        but_i = (Button) findViewById(R.id.but_i);
        but_j = (Button) findViewById(R.id.but_j);
        move_count = (TextView) findViewById(R.id.move_count);
        move_history = (TextView) findViewById(R.id.history);
        move_history.setMovementMethod(new ScrollingMovementMethod());
        solution_display = (TextView) findViewById(R.id.solution);
        newGame();
    }

    int[] toggle_butts = new int[16];
    int total_moves = 0;
    String move_list = "";

    public void buttonPress_A(View v) {
        buttonPress_A();
        logMove("A");
        if(checkWin())
            playerWon();
        return;
    }
    public void buttonPress_B(View v) {
        buttonPress_B();
        logMove("B");
        if(checkWin())
            playerWon();
        return;
    }
    public void buttonPress_C(View v) {
        buttonPress_C();
        logMove("C");
        if(checkWin())
            playerWon();
        return;
    }
    public void buttonPress_D(View v) {
        buttonPress_D();
        logMove("D");
        if(checkWin())
            playerWon();
        return;
    }
    public void buttonPress_E(View v) {
        buttonPress_E();
        logMove("E");
        if(checkWin())
            playerWon();
        return;
    }
    public void buttonPress_F(View v) {
        buttonPress_F();
        logMove("F");
        if(checkWin())
            playerWon();
        return;
    }
    public void buttonPress_G(View v) {
        buttonPress_G();
        logMove("G");
        if(checkWin())
            playerWon();
        return;
    }
    public void buttonPress_H(View v) {
        buttonPress_H();
        logMove("H");
        if(checkWin())
            playerWon();
        return;
    }
    public void buttonPress_I(View v) {
        buttonPress_I();
        logMove("I");
        if(checkWin())
            playerWon();
        return;
    }
    public void buttonPress_J(View v) {
        buttonPress_J();
        logMove("J");
        if(checkWin())
            playerWon();
        return;
    }

    public void buttonPress_A() {
        setToggle(0, grid00);
        setToggle(1, grid01);
        setToggle(2, grid02);
        return;
    }
    public void buttonPress_B() {
        setToggle(3, grid03);
        setToggle(7, grid07);
        setToggle(9, grid09);
        setToggle(11, grid11);
        return;
    }
    public void buttonPress_C() {
        setToggle(4, grid04);
        setToggle(10, grid10);
        setToggle(14, grid14);
        setToggle(15, grid15);
        return;
    }
    public void buttonPress_D() {
        setToggle(0, grid00);
        setToggle(4, grid04);
        setToggle(5, grid05);
        setToggle(6, grid06);
        setToggle(7, grid07);
        return;
    }
    public void buttonPress_E() {
        setToggle(6, grid06);
        setToggle(7, grid07);
        setToggle(8, grid08);
        setToggle(10, grid10);
        setToggle(12, grid12);
        return;
    }
    public void buttonPress_F() {
        setToggle(0, grid00);
        setToggle(2, grid02);
        setToggle(14, grid14);
        setToggle(15, grid15);
        return;
    }
    public void buttonPress_G() {
        setToggle(3, grid03);
        setToggle(14, grid14);
        setToggle(15, grid15);
        return;
    }
    public void buttonPress_H() {
        setToggle(4, grid04);
        setToggle(5, grid05);
        setToggle(7, grid07);
        setToggle(14, grid14);
        setToggle(15, grid15);
        return;
    }
    public void buttonPress_I() {
        setToggle(1, grid01);
        setToggle(2, grid02);
        setToggle(3, grid03);
        setToggle(4, grid04);
        setToggle(5, grid05);
        return;
    }
    public void buttonPress_J() {
        setToggle(3, grid03);
        setToggle(4, grid04);
        setToggle(5, grid05);
        setToggle(9, grid09);
        setToggle(13, grid13);
        return;
    }

    // Update a list of moves and increment the count
    public void logMove(String s) {
        modifySolution(s);
        total_moves++;
        String moves_str = "" + total_moves;
        move_count.setText(moves_str);
        move_list = move_list + s + "\n";
        move_history.setText(move_list);
        if(total_moves > 21)
            move_history.scrollBy(0, 43);
        else
            move_history.scrollTo(0, 0);
        return;
    }

    // Returns true if all of the squares are the same color
    public boolean checkWin() {
        for(int i = 1; i < 16; i++) {
            if(toggle_butts[0] % 2 != toggle_butts[i] % 2)
                return false;
        }
        return true;
    }

    // Alerts the player that they won.
    public void playerWon() {
        //Toast message - you win
        Toast.makeText(this, "You solved it!", Toast.LENGTH_SHORT).show();
        return;
    }

    public void showSolution(View v) {
        solution_display.setVisibility(View.VISIBLE);
        if(!solution.equalsIgnoreCase(""))
            animateSolution(solution);
        else
            solution_display.setVisibility(View.INVISIBLE);
        solution = "";

    }

    public void animateSolution(String s) {
        Button b = null;
        char currentPress = s.charAt(0);
        switch (currentPress) {
            case 'A': b = but_a; buttonPress_A(); break;
            case 'B': b = but_b; buttonPress_B(); break;
            case 'C': b = but_c; buttonPress_C(); break;
            case 'D': b = but_d; buttonPress_D(); break;
            case 'E': b = but_e; buttonPress_E(); break;
            case 'F': b = but_f; buttonPress_F(); break;
            case 'G': b = but_g; buttonPress_G(); break;
            case 'H': b = but_h; buttonPress_H(); break;
            case 'I': b = but_i; buttonPress_I(); break;
            case 'J': b = but_j; buttonPress_J(); break;
        }
        Animation fadeout = new AlphaAnimation(0.f, 1.f);
        fadeout.setDuration(750);
        b.startAnimation(fadeout);
        final String next = s.replaceAll(currentPress + "", "");
        b.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(!next.equalsIgnoreCase(""))
                    animateSolution(next);
                else
                    solution_display.setVisibility(View.INVISIBLE);
            }
        }, 750);
    }




    public void newGame(View v) {
        newGame();
    }
    public void newGame() {
        // Set all squares to either black or white
        int random_start = (int)Math.floor(Math.random() * 2);
        for(int i = 0; i < 16; i++)
            toggle_butts[i] = random_start;
        setToggle(0, grid00);
        setToggle(1, grid01);
        setToggle(2, grid02);
        setToggle(3, grid03);
        setToggle(4, grid04);
        setToggle(5, grid05);
        setToggle(6, grid06);
        setToggle(7, grid07);
        setToggle(8, grid08);
        setToggle(9, grid09);
        setToggle(10, grid10);
        setToggle(11, grid11);
        setToggle(12, grid12);
        setToggle(13, grid13);
        setToggle(14, grid14);
        setToggle(15, grid15);
        solution = "";
        solution_display.setVisibility(View.INVISIBLE);

        // Create a random but solvable arrangement of squares
        for(int i = 0; i < 100; i++) {
            int random = (int)Math.floor(Math.random()*10);
            switch(random) {
                case 0:
                    buttonPress_A();
                    modifySolution("A");
                    break;
                case 1:
                    buttonPress_B();
                    modifySolution("B");
                    break;
                case 2:
                    buttonPress_C();
                    modifySolution("C");
                    break;
                case 3:
                    buttonPress_D();
                    modifySolution("D");
                    break;
                case 4:
                    buttonPress_E();
                    modifySolution("E");
                    break;
                case 5:
                    buttonPress_F();
                    modifySolution("F");
                    break;
                case 6:
                    buttonPress_G();
                    modifySolution("G");
                    break;
                case 7:
                    buttonPress_H();
                    modifySolution("H");
                    break;
                case 8:
                    buttonPress_I();
                    modifySolution("I");
                    break;
                case 9:
                    buttonPress_J();
                    modifySolution("J");
                    break;
                default: break;
            }
        }

        // Reset defaults
        total_moves = 0;
        move_count.setText(total_moves + "");
        move_list = "";
        move_history.setText(move_list);
    }
    public void setToggle(int i, TextView v) {
        toggle_butts[i]++;
        if(toggle_butts[i] % 2 == 1) {
            v.setBackgroundColor(Color.BLACK);
            v.setTextColor(Color.WHITE);
        }
        else {
            v.setBackgroundColor(Color.WHITE);
            v.setTextColor(Color.BLACK);
        }
    }
    public void modifySolution(String s) {
        String newSolution = new String();
        if(!solution.contains(s)) {
            solution = solution + s;
            newSolution = solution;
        }
        else {
            newSolution = solution.replaceAll(s, "");
            solution = newSolution;
        }
        solution_display.setText("Solution: " + newSolution);
    }
}
