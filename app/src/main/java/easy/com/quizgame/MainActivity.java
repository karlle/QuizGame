package easy.com.quizgame;

import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private int currentQuestion;
    private String [] questions;
    private String [] answers;
    private Button answerButton;
    private Button questionButton;
    private TextView questionView;
    private TextView answerView;
    private EditText answerText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        showQuestion();
    }

    public void init(){
        questions = new String [] {"What is the capital of Egypt?",
                "What is the capital of Kenya?", "What is the capital of Zimbabwe?",
                "What is the capital of Liberia?"};
        answers = new String [] {"Cairo", "Nairobi", "Harare", "Monrovia" };
        currentQuestion = -1;
        answerButton = (Button)findViewById(R.id.AnswerButton);
        questionButton = (Button)findViewById(R.id.QuestionButton);
        questionView = (TextView) findViewById(R.id.questionTextView);
        answerView = (TextView) findViewById (R.id.answerTextView);
        answerText = (EditText) findViewById (R.id.answerText);

        answerButton.setOnClickListener(new Button.OnClickListener(){

        public void onClick (View v) {
                    checkAnswer();
            }
        });

        questionButton.setOnClickListener(new Button.OnClickListener(){

            public void onClick (View v) {
                    showQuestion();
            }

        });

    }


    public void showQuestion(){

        currentQuestion ++;
        if (currentQuestion == questions.length)
               currentQuestion = 0;

        questionView.setText(questions[currentQuestion]);
        answerView.setText("");
        answerText.setText("");
    }

    public boolean isCorrect(String answer){
        //return (answer.equalsIgnoreCase(answers[currentQuestion]));
        return (answer.equalsIgnoreCase (answers[currentQuestion]));
    }

    public void checkAnswer(){

        String answer = answerText.getText().toString();
        if (isCorrect(answer))
               answerView.setText("Good!");
        else answerView.setText("Sorry, the correct answer is " + answers[currentQuestion] +
        " your answer was: " + answer);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
