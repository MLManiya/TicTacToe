package com.example.tictactoe;

import static com.example.tictactoe.R.id.Start;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button Start,Restart,Player1,Player2,Pos0,Pos1,Pos2,Pos3,Pos4,Pos5,Pos6,Pos7,Pos8;
    Button Btn[] = new Button[9];
    int cnt=0,r;
    TextView Player1Score,Player2Score;
    ArrayList list = new ArrayList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Player1Score = findViewById(R.id.Player1Score);
        Player2Score = findViewById(R.id.Player2Score);
        Start = findViewById(R.id.Start);
        Restart = findViewById(R.id.Restart);
        Start.setOnClickListener(this);
        Restart.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        System.out.print("Player 1");
        for(int i=0;i<Btn.length;i++)
        {
            int id = getResources().getIdentifier("Pos"+i,"id",getPackageName());
            Btn[i] = findViewById(id);
            Btn[i].setOnClickListener(this);
        }
        for (int i=0;i<Btn.length;i++)
        {
            if(view.getId()==Btn[i].getId())
            {
                Btn[i].setText("X");
                list.add(i);
                Btn[i].setEnabled(false);
                System.out.println("btn"+i+"clicked");
                cnt++;
                winner();
              //  System.out.println("arraylist"+list);

                    while (cnt < 5)
                    {
                        r = (int) (Math.random()*9);
                        System.out.println("Random Pos = " +r);

                        if(list.contains(r) == false)
                        {
                            Btn[r].setText("O");
                            list.add(r);
                            Btn[r].setEnabled(false);
                            winner();
                            break;
                        }

                    }
            }
            System.out.println("hello"+list);

        }
        if(view.getId()==Start.getId())
        {
            start();
        }
        if(view.getId()==Restart.getId())
        {
            restart();
        }
    }

    int cntx = 0,cnto=0;
   public void winner()
    {
        if(Btn[0].getText()=="X" && Btn[1].getText()=="X" && Btn[2].getText()=="X" ||
           Btn[0].getText()=="X" && Btn[3].getText()=="X" && Btn[6].getText()=="X" ||
           Btn[0].getText()=="X" && Btn[4].getText()=="X" && Btn[8].getText()=="X" ||
           Btn[1].getText()=="X" && Btn[4].getText()=="X" && Btn[7].getText()=="X" ||
           Btn[2].getText()=="X" && Btn[6].getText()=="X" && Btn[8].getText()=="X" ||
           Btn[2].getText()=="X" && Btn[4].getText()=="X" && Btn[6].getText()=="X" ||
           Btn[3].getText()=="X" && Btn[4].getText()=="X" && Btn[5].getText()=="X" ||
           Btn[6].getText()=="X" && Btn[7].getText()=="X" && Btn[8].getText()=="X")
        {
            cntx++;
            int p11 =0;
            String p1 = String.valueOf(cntx);
            while (cntx<=5)
            {
                Player1Score.setText(""+p1);
                break;
            }
            for(int i=0;i<Btn.length;i++)
            {
                Btn[i].setEnabled(false);
                Btn[r].setEnabled(false);
            }
            System.out.println("X winner");

        } else if (Btn[0].getText()=="O" && Btn[1].getText()=="O" && Btn[2].getText()=="O" ||
                Btn[0].getText()=="O" && Btn[3].getText()=="O" && Btn[6].getText()=="O" ||
                Btn[0].getText()=="O" && Btn[4].getText()=="O" && Btn[8].getText()=="O" ||
                Btn[1].getText()=="O" && Btn[4].getText()=="O" && Btn[7].getText()=="O" ||
                Btn[2].getText()=="O" && Btn[6].getText()=="O" && Btn[8].getText()=="O" ||
                Btn[2].getText()=="O" && Btn[4].getText()=="O" && Btn[6].getText()=="O" ||
                Btn[3].getText()=="O" && Btn[4].getText()=="O" && Btn[5].getText()=="O" ||
                Btn[6].getText()=="O" && Btn[7].getText()=="O" && Btn[8].getText()=="O")
        {
            cnto++;
            int p22=0;
            String p2 = String.valueOf(cnto);
            while (cnto<=5)
            {
                Player2Score.setText(""+p2);
                break;
            }
            for(int i=0;i<Btn.length;i++)
            {
                Btn[i].setEnabled(false);
                Btn[r].setEnabled(false);
            }
            System.out.println("O winner");
        }
//        else {
//            String Name = "DRAW";
//            Start.setText(""+Name);
//        }

    }
    public void restart()
    {
        Restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Blank = " ";
                for (int i=0;i<Btn.length;i++)
                {
                    Btn[i].setText(" ");
                    cnt=0;
                    Btn[i].setEnabled(true);
                    Btn[r].setEnabled(true);
//                    Btn[0].setText(""+Blank);
//                    Btn[1].setText(""+Blank);
//                    Btn[2].setText(""+Blank);
//                    Btn[3].setText(""+Blank);
//                    Btn[4].setText(""+Blank);
//                    Btn[5].setText(""+Blank);
//                    Btn[6].setText(""+Blank);
//                    Btn[7].setText(""+Blank);
//                    Btn[8].setText(""+Blank);
                }
                list.clear();
            }
        });
    }
    public void start()
    {
        Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = "DRAW";
                Start.setText(""+Name);

            }
        });
    }
}