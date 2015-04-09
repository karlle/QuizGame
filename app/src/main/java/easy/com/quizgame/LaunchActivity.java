package easy.com.quizgame;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class LaunchActivity extends ActionBarActivity {

    private Button game1Button;
    private Button game2Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        game1Button = (Button)findViewById(R.id.africaGame);
        game1Button.setOnClickListener(new Button.OnClickListener(){

            public void onClick (View v) {
                startGame1();
            }

        });

        game1Button = (Button)findViewById(R.id.scrollGameAfrica);
        game1Button.setOnClickListener(new Button.OnClickListener(){

            public void onClick (View v) {
                startGame2();
            }

        });

    }

       public void startGame1(){
           Intent intent = new Intent(this, MainActivity.class);
           startActivity(intent);
       }

    public void startGame2(){
        Intent intent = new Intent(this, scrollGameActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_launch, menu);
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
