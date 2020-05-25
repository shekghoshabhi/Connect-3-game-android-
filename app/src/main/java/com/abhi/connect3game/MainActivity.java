package com.abhi.connect3game;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //red=0 and yellow=1  //
    int turn = 0 ;
    boolean activeGame= true ;
    // array arr is used to keep the account for which grid tag has been clicked on//
    int[] arr = {2,2,2,2,2,2,2,2,2} ;
    //array winningPos has all the config for a winning player
    int[][] winningPos = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}} ;

    public void dropIn(View view) {

        ImageView counter = (ImageView) view;


        // Log.i("tap",counter.getTag().toString()) ;


        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if(arr[tappedCounter]==2 && activeGame){


            arr[tappedCounter] = turn;

        //logic for the turn for red and yellow player
        if (turn == 0) {
            counter.setTranslationY(-1500);
            counter.setImageResource(R.drawable.yellow);
            turn = 1;
            counter.animate().translationYBy(1500).rotationXBy(3600).rotationYBy(3600).setDuration(1000);
        } else {
            counter.setTranslationY(1500);
            counter.setImageResource(R.drawable.red);
            turn = 0;
            counter.animate().translationYBy(-1500).rotationXBy(3600).rotationYBy(3600).setDuration(1000);
        }


        //loop to check the winner of the game
        for (int[] winningPosition : winningPos) {

            // Somone has won!

            if (arr[winningPosition[0]] == arr[winningPosition[1]] && arr[winningPosition[1]] == arr[winningPosition[2]] && arr[winningPosition[0]] != 2){

                activeGame = false;

            String winner = "";

            if (turn == 1) {
                winner = "Yellow";
            } else {
                winner = "Red";
            }
            //Toast.makeText(this,winner+"has won",Toast.LENGTH_LONG).show();
                TextView text= (TextView)findViewById(R.id.textView) ;
               text.setText(winner+" has won !!!");

                Button button = (Button)findViewById(R.id.button2) ;
                button.setText("Play Again!!!");

        }
        }
    }

    }
    // lOGIC for restarting the game

    public void playAgain(View view) {
        TextView text= (TextView)findViewById(R.id.textView) ;
        text.setText("Play!!!!");

        Button button = (Button)findViewById(R.id.button2) ;
        button.setText("Resart");

        GridLayout gridLayout = (GridLayout) findViewById(R.id.grid_layout);

        for(int i=0; i<gridLayout.getChildCount(); i++) {

            ImageView counter = (ImageView) gridLayout.getChildAt(i);

            counter.setImageDrawable(null);

        }

        for (int i=0; i<arr.length; i++) {
            arr[i] = 2;
        }
        turn = 0;
        activeGame = true;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



}
