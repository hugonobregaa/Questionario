package com.example.hugon.questionario;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by hugon on 19/09/2016.
 */
public class Activity1 extends AppCompatActivity {

    private Button btProximaPergunta, btSim, btNao;
    private LinearLayout layout;
    private TextView tvPergunta;
    private Pergunta pergunta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        pergunta = Pergunta.PERGUNTA1;
        configuraWidgets();
    }

    private void configuraWidgets() {
        btProximaPergunta = (Button) findViewById(R.id.bt_proxima_pergunta);
        btProximaPergunta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibe.vibrate(400);
                carregaProximaTela();
            }
        });

        btSim = (Button) findViewById(R.id.btSim);
        btSim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btSim.setBackgroundColor(getResources().getColor(R.color.selecteGreen));
                btNao.setBackgroundResource(android.R.drawable.btn_default);
                Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibe.vibrate(100);
            }
        });


        btNao = (Button) findViewById(R.id.btNao);
        btNao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btNao.setBackgroundColor(getResources().getColor(R.color.selectedRed));
                btSim.setBackgroundResource(android.R.drawable.btn_default);
                Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibe.vibrate(100);
            }
        });

    }

    public void mudaTexto() {
        tvPergunta = (TextView) findViewById(R.id.tvPergunta);
        tvPergunta.setText("Teste");
    }

    private void carregaProximaTela() {
        if (pergunta != Pergunta.PERGUNTA9) {
            setContentView(R.layout.tela_transicao);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Activity1.this.preparaTela();
                }
            }, 2000);
        }
        else
        {
                setContentView(R.layout.tela_fim);
        }

    };

    protected void preparaTela() {
        setContentView(R.layout.activity_1);
        tvPergunta = (TextView) findViewById(R.id.tvPergunta);
        configuraWidgets();
        switch (pergunta) {
            case PERGUNTA1:
                pergunta = Pergunta.PERGUNTA2;
                tvPergunta.setText(R.string.pergunta2);
                break;
            case PERGUNTA2:
                pergunta = Pergunta.PERGUNTA3;
                tvPergunta.setText(R.string.pergunta3);
                break;
            case PERGUNTA3:
                pergunta = Pergunta.PERGUNTA4;
                tvPergunta.setText(R.string.pergunta4);
                break;
            case PERGUNTA4:
                pergunta = Pergunta.PERGUNTA5;
                tvPergunta.setText(R.string.pergunta5);
                break;
            case PERGUNTA5:
                pergunta = Pergunta.PERGUNTA6;
                tvPergunta.setText(R.string.pergunta6);
                break;
            case PERGUNTA6:
                pergunta = Pergunta.PERGUNTA7;
                tvPergunta.setText(R.string.pergunta7);
                break;
            case PERGUNTA7:
                pergunta = Pergunta.PERGUNTA8;
                tvPergunta.setText(R.string.pergunta8);
                break;
            case PERGUNTA8:
                pergunta = Pergunta.PERGUNTA9;
                tvPergunta.setText(R.string.pergunta9);
        }

    }



    private enum Pergunta {
        PERGUNTA1, PERGUNTA2, PERGUNTA3, PERGUNTA4, PERGUNTA5,
        PERGUNTA6, PERGUNTA7, PERGUNTA8, PERGUNTA9
    }
}
