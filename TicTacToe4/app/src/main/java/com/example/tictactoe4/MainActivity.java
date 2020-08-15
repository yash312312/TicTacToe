package com.example.tictactoe4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int played[]={2,2,2,2,2,2,2,2,2,2};
    int x=0;
    String s1="",s2="";
    int count=0;
    public void pressed(View view)
    {

        ImageView counter = (ImageView)view;
        int i=Integer.parseInt(counter.getTag().toString());
        if((i==1||i==2||i==3)&&played[i]==2)
        {
            counter.setTranslationY(-1000f);
        }
        else if((i==4)&&played[i]==2)
        {
            counter.setTranslationX(-1000f);
        }
        else if((i==6)&&played[i]==2)
        {
            counter.setTranslationX(1000f);
        }
        else if((i==7||i==8||i==9)&&played[i]==2)
        {
            counter.setTranslationY(1000f);
        }

        if(x==0&&played[i]==2)
        {
            //turn.setText(s2);

            counter.setBackgroundResource(R.drawable.cross2);

            if(i==1||i==2||i==3)
            {
                counter.animate().translationYBy(1000f).setDuration(200);
            }
            else if(i==4)
            {
                counter.animate().translationXBy(1000f).setDuration(200);
            }
            else if(i==6)
            {
                counter.animate().translationXBy(-1000f).setDuration(200);
            }
            else if(i==7||i==8||i==9)
            {
                counter.animate().translationYBy(-1000f).setDuration(200);
            }
            setName(s2);
            played[i]=x;
            isWinner(x);
            count++;
            x=1;
        }
        else if(x==1&&played[i]==2)
        {
            //turn.setText(s1);

            counter.setBackgroundResource(R.drawable.circle);

            if(i==1||i==2||i==3)
            {
                counter.animate().translationYBy(1000f).setDuration(200);
            }
            else if(i==4)
            {
                counter.animate().translationXBy(1000f).setDuration(200);
            }
            else if(i==6)
            {
                counter.animate().translationXBy(-1000f).setDuration(200);
            }
            else if(i==7||i==8||i==9)
            {
                counter.animate().translationYBy(-1000f).setDuration(200);
            }
            setName(s1);
            played[i]=x;
            isWinner(x);
            count++;
            x=0;
        }

        if(count==9&&played[0]!=-2)
        {
            winner(2);
            return;
        }
    }
    public void start(View view)
    {
        EditText player1 = (EditText) findViewById(R.id.player1);
        EditText player2=(EditText)findViewById(R.id.player2);
        s1=player1.getText().toString();
        s2=player2.getText().toString();
        int l1=s1.length();
        int l2=s2.length();
        int check1=0,check2=0;
        for(int i=0;i<l1;i++)
        {
            char ch= s1.charAt(i);
            if(ch!=' ')
            {
                check1=1;
                break;
            }
        }
        for(int i=0;i<l2;i++)
        {
            char ch= s2.charAt(i);
            if(ch!=' ')
            {
                check2=1;
                break;
            }
        }
        if(s1.isEmpty()||s2.isEmpty()||check1==0||check2==0)
        {
            Toast.makeText(this, "Enter Both Players Name", Toast.LENGTH_SHORT).show();
        }
        else
        {
            setContentView(R.layout.activity_main);
            setName(s1);
        }
    }

    public void setName(String s)
    {
        TextView player = (TextView)findViewById(R.id.textView);
        String set=s+"\'s turn";
        player.setText(set);
    }

    public void isWinner(int x)
    {
        if(played[1]==x&&played[2]==x&&played[3]==x)
        {
            for(int i=0;i<10;i++)
            {
                played[i]=-2;
            }
            winner(x);
        }
        else if(played[4]==x&&played[5]==x&&played[6]==x)
        {
            for(int i=0;i<10;i++)
            {
                played[i]=-2;
            }
            winner(x);
        }
        else if(played[7]==x&&played[8]==x&&played[9]==x)
        {
            for(int i=0;i<10;i++)
            {
                played[i]=-2;
            }
            winner(x);
        }
        else if(played[1]==x&&played[4]==x&&played[7]==x)
        {
            for(int i=0;i<10;i++)
            {
                played[i]=-2;
            }
            winner(x);
        }
        else if(played[2]==x&&played[5]==x&&played[8]==x)
        {
            for(int i=0;i<10;i++)
            {
                played[i]=-2;
            }
            winner(x);
        }
        else if(played[3]==x&&played[6]==x&&played[9]==x)
        {
            for(int i=0;i<10;i++)
            {
                played[i]=-2;
            }
            winner(x);
        }
        else if(played[1]==x&&played[5]==x&&played[9]==x)
        {
            for(int i=0;i<10;i++)
            {
                played[i]=-2;
            }
            winner(x);
        }
        else if(played[3]==x&&played[5]==x&&played[7]==x)
        {
            for(int i=0;i<10;i++)
            {
                played[i]=-2;
            }
            winner(x);
        }
    }
    public void again(View view)
    {
        if(count==9||played[0]==-2)
        {
            setContentView(R.layout.log_in);
            x = 0;
            for (int i = 0; i < 10; i++) {
                played[i] = 2;
            }
            count = 0;
        }
    }
    public void winner(int x)
    {
        String k=" is the Winner";
        //setContentView(R.layout.winner);
        TextView win_draw = (TextView)findViewById(R.id.textView);
        Button again = (Button) findViewById(R.id.again);
        again.setAlpha(1f);

        if(x==0)
        {
            k=s1+k;
            win_draw.setText(k);
        }
        else if(x==1)
        {
            k=s2+k;
            win_draw.setText(k);
        }
        else
            win_draw.setText("It\'s a draw");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);
    }
}
