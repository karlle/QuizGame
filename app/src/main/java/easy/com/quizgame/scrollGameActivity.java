package easy.com.quizgame;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class scrollGameActivity extends ActionBarActivity {

    private String [] questions;
    private String [] answers;
    private int currentQuestion;
    private TextView questionView;
    private TextView feedbackView;
    private Button nextQue;
    private int gameOver = 0;
    private RelativeLayout layout;
    private TextView wA;
    private int w = 0;
    private int o;
    private Map <String,String> queAns = new HashMap<String, String>();
    private ArrayList <String> capitals = new ArrayList<>();
    private String currentCapital;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_game);
        questionView = (TextView) findViewById(R.id.questionView2);
        feedbackView = (TextView) findViewById(R.id.feedbackView);
        nextQue = (Button) findViewById(R.id.nextQuestion);
        layout = (RelativeLayout) findViewById(R.id.Layout);
        wA = (TextView) findViewById(R.id.numberWrongs);
        newGame();

    }

    public void newGame (){

        String [] cities = {"Egypt",
                "Kenya", "Zimbabwe",
                "Liberia", "Indonesia", "Colombia", "Bangladesh", "Chile", "South Africa"};
        String [] capital = {"Cairo", "Nairobi", "Harare", "Monrovia", "Jakarta", "Bogata", "Dhaka",
                "Santiago", "Pretoria"
        };
        o = cities.length;
        int p;
        for (p=0; p<o; p++) {
            queAns.put(capital[p], cities[p]);
            capitals.add(p, capital[p]);
        }
        wA.setText("Wrong Answers: 0 /" + o);
        feedbackView.setText("Good Luck, Sir!");
        nextQuestion();

    }

    public void answer (View view) {
        String buttonText;
        buttonText = ((Button) view).getText().toString();

        if (buttonText.equalsIgnoreCase(queAns.get(currentCapital))) {
            feedbackView.setText("Right answer, good job sir! Now try this one");
            capitals.remove(currentCapital);
            nextQuestion();


        } else if (buttonText.equalsIgnoreCase("Next Question")) {
            feedbackView.setText("Question skipped, try this one instead!");
            nextQuestion();
        }

        else if (buttonText.equalsIgnoreCase("New Game")){
            nextQue.setText("Next Question");
            newGame();
        }


        else {
            feedbackView.setText("Wrong answer, try this one instead!");
            w++;
            wA.setText("Wrong Answers: "+ w + " / " + o);
            capitals.remove(currentCapital);
            nextQuestion();
        }
    }


    public void nextQuestion() {
        //currentQuestion ++;
        Random t = new Random();
        if (capitals.size()>0) {
        currentCapital = capitals.get(t.nextInt(capitals.size()));
        questionView.setText("Which country has the capital " + currentCapital );}

        else {
            feedbackView.setText("Game over, mathafakker");
            nextQue.setText("New Game");
            questionView.setText("Press 'New Game' to play again!");



            /*Button newGame = new Button (this);
            newGame.setText("New Game");
            RelativeLayout.LayoutParams p = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            p.addRule(layout.BELOW, R.id.nextQuestion);
            layout.addView(newGame);*/

        }

    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scroll_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
