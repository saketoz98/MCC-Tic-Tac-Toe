package samples.speech.cognitiveservices.microsoft.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {
    private Button[][] buttons = new Button[3][3];
    private TextView player1, player2;
    private boolean player1turn = true;
    private int i,j, roundCount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        player1 = (TextView) findViewById(R.id.player1);
        player2 = (TextView) findViewById(R.id.player2);

        buttons[0][0] = findViewById(R.id.btn00);
        buttons[0][1] = findViewById(R.id.btn01);
        buttons[0][2] = findViewById(R.id.btn02);
        buttons[1][0] = findViewById(R.id.btn10);
        buttons[1][1] = findViewById(R.id.btn11);
        buttons[1][2] = findViewById(R.id.btn12);
        buttons[2][0] = findViewById(R.id.btn20);
        buttons[2][1] = findViewById(R.id.btn21);
        buttons[2][2] = findViewById(R.id.btn22);

        for(i=0;i<3;i++){
            for(j=0;j<3;j++){
                buttons[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Button b = (Button) view;
                        if(!b.getText().toString().equals("")){
                            return;}


                        if(player1turn){
                            b.setText("X");


                        }else{
                            b.setText("O");

                        }
                        roundCount++;

                        if(checkWin()){
                            if(player1turn){
                                player1.setText("Player 1 wins");
                            }else{
                                player2.setText("Player 2 wins");
                            }
                        }else{

                            if(roundCount==9){
                                player1.setText("draw");
                            }else{
                                player1turn = !player1turn;

                            }
                        }

                    }
                });
            }
        }




    }
    private boolean checkWin(){
        String fields[][] = new String[3][3];
        for(i=0;i<3;i++){
            for(j=0;j<3;j++){
                fields[i][j] = buttons[i][j].getText().toString();
            }
        }
        for(i=0;i<3;i++){

            if(fields[i][0].equals(fields[i][1]) && fields[i][1].equals(fields[i][2]) && !fields[i][0].equals("") ){
                return true;
            }
        }

        return false;

    }
}
