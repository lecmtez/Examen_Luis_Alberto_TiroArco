package com.edu.itchetumal.luis_.examen_luis_alberto;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int circCoordX = 0, circCoordY = 0;
    String mensaje = "0";
    int puntuacion, jugador1, jugador2 = 0;
    public int auxX,auxY;
    public int contador = 21;
    public int turno = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout layoutP = (LinearLayout) findViewById(R.id.layout_principal);

        Lienzo areaDibujo = new Lienzo(this);

        layoutP.addView(areaDibujo);

        View btn = findViewById(R.id.btnReiniciar);
        btn.setOnClickListener(this);
    }

    private int contador(){
        turno = contador%2;
        if (turno==0){
            Toast.makeText(this, "Jugador 2", Toast.LENGTH_SHORT).show();
            jugador2=jugador2+puntuacion;
        }
        if (turno==1){
            Toast.makeText(this, "Jugador 1", Toast.LENGTH_SHORT).show();
            jugador1=jugador1+puntuacion;
        }
        if (contador==0) {
            if (jugador1 > jugador2) {
                Toast.makeText(this, "El ganador es: Jugador 1", Toast.LENGTH_LONG).show();
            }
            if (jugador1 < jugador2) {
                Toast.makeText(this, "El ganador es: Jugador 2", Toast.LENGTH_LONG).show();
            }
            if (jugador1 == jugador2) {
                Toast.makeText(this, "Empate", Toast.LENGTH_LONG).show();
            }
        }
        contador--;
        return contador;
    }
    //reinicia una Activity
    public static void reiniciarActivity(Activity actividad){
        Intent intent=new Intent();
        intent.setClass(actividad, actividad.getClass());
        //llamamos a la actividad
        actividad.startActivity(intent);
        //finalizamos la actividad actual
        actividad.finish();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnReiniciar){
            reiniciarActivity(this);
        }
    }

    class Lienzo extends View {

        public Lienzo(Context context) {
            super(context);
        }

        protected void onDraw(Canvas canvas) {
            int ancho = canvas.getWidth();
            int alto = canvas.getHeight();

            auxX = ancho / 2;
            auxY = alto / 2;

            Paint pincel = new Paint();
            pincel.setAntiAlias(true);

            //dibujar circulo 5
            pincel.setStyle(Paint.Style.FILL);
            pincel.setColor(Color.CYAN);
            pincel.setStrokeWidth(5);
            canvas.drawCircle(ancho / 2, alto / 2, 480, pincel);
            //Dibujar texto
            pincel.setStyle(Paint.Style.FILL); //lo que se dibuja tiene un relleno
            pincel.setColor(Color.BLACK);
            pincel.setTextSize(50); //para aumnetar el tamaño del texto
            canvas.drawText("5", ancho / 2 + 420, alto / 2 + 20, pincel);

            //dibujar circulo 6
            pincel.setStyle(Paint.Style.FILL);
            pincel.setColor(Color.CYAN);
            pincel.setStrokeWidth(2);
            canvas.drawCircle(ancho / 2, alto / 2, 400, pincel);
            //Dibujar texto
            pincel.setStyle(Paint.Style.FILL); //lo que se dibuja tiene un relleno
            pincel.setColor(Color.BLACK);
            pincel.setTextSize(50); //para aumnetar el tamaño del texto
            canvas.drawText("6", ancho / 2 + 340, alto / 2 + 20, pincel);

            //dibujar circulo 7
            pincel.setStyle(Paint.Style.FILL);
            pincel.setColor(Color.RED);
            pincel.setStrokeWidth(5);
            canvas.drawCircle(ancho / 2, alto / 2, 320, pincel);
            //Dibujar texto
            pincel.setStyle(Paint.Style.FILL); //lo que se dibuja tiene un relleno
            pincel.setColor(Color.BLACK);
            pincel.setTextSize(50); //para aumnetar el tamaño del texto
            canvas.drawText("7", ancho / 2 + 260, alto / 2 + 20, pincel);

            //dibujar circulo 8
            pincel.setStyle(Paint.Style.FILL);
            pincel.setColor(Color.RED);
            pincel.setStrokeWidth(2);
            canvas.drawCircle(ancho / 2, alto / 2, 240, pincel);
            //Dibujar texto
            pincel.setStyle(Paint.Style.FILL); //lo que se dibuja tiene un relleno
            pincel.setColor(Color.BLACK);
            pincel.setTextSize(50); //para aumnetar el tamaño del texto
            canvas.drawText("8", ancho / 2 + 175, alto / 2 + 20, pincel);

            //dibujar circulo 9
            pincel.setStyle(Paint.Style.FILL);
            pincel.setColor(Color.YELLOW);
            pincel.setStrokeWidth(5);
            canvas.drawCircle(ancho / 2, alto / 2, 160, pincel);
            //Dibujar texto
            pincel.setStyle(Paint.Style.FILL); //lo que se dibuja tiene un relleno
            pincel.setColor(Color.BLACK);
            pincel.setTextSize(50); //para aumnetar el tamaño del texto
            canvas.drawText("9", ancho / 2 + 100, alto / 2 + 20, pincel);

            //dibujar circulo 10
            pincel.setStyle(Paint.Style.FILL);
            pincel.setColor(Color.YELLOW);
            pincel.setStrokeWidth(2);
            canvas.drawCircle(ancho / 2, alto / 2, 80, pincel);
            //Dibujar texto
            pincel.setStyle(Paint.Style.FILL); //lo que se dibuja tiene un relleno
            pincel.setColor(Color.BLACK);
            pincel.setTextSize(50); //para aumnetar el tamaño del texto
            canvas.drawText("10", ancho / 2 - 30, alto / 2 + 20, pincel);

            //dibujar contornos
            for(int f=0;f<7;f++) {
                pincel.setStyle(Paint.Style.STROKE);
                pincel.setColor(Color.BLACK);
                pincel.setStrokeWidth(5);
                canvas.drawCircle(ancho/2, alto/2, f*80, pincel);
            }

            //CIRCULO NEGRO
            pincel.setStyle(Paint.Style.FILL);
            pincel.setColor(Color.BLACK);
            pincel.setStrokeWidth(3);
            canvas.drawCircle(circCoordX, circCoordY, 30, pincel);
            pincel.setColor(Color.GREEN);

            //MENSAJE
            pincel.setColor(Color.BLACK);
            pincel.setTextSize(50);
            pincel.setStyle(Paint.Style.FILL);
            canvas.drawText("Acerto al: " + mensaje, 280, this.getLeft() + 80, pincel);
            canvas.drawText("Jugador 1: " + jugador1, 0, this.getMeasuredHeight() -180, pincel);
            canvas.drawText("Jugador 2: " + jugador2, 0, this.getMeasuredHeight() -130, pincel);
        }//onDraw

        //Métodos para eventos Touch
        @Override
        public boolean onTouchEvent(MotionEvent evento) {
            circCoordX = (int) evento.getX();
            circCoordY = (int) evento.getY();

            if(contador >=0) {

                if (evento.getAction() == MotionEvent.ACTION_DOWN) {
                    double impacto = Math.sqrt(Math.pow(circCoordX - auxX, 2) + Math.pow(circCoordY - auxY, 2));

                    if (impacto <= 90) {
                        mensaje = "10";
                        puntuacion = 10;
                    }
                    if (impacto > 90 & impacto <= 170) {
                        mensaje = "9";
                        puntuacion = 9;
                    }
                    if (impacto > 170 & impacto <= 250) {
                        mensaje = "8";
                        puntuacion = 8;
                    }
                    if (impacto > 250 & impacto <= 330) {
                        mensaje = "7";
                        puntuacion = 7;
                    }
                    if (impacto > 330 & impacto <= 390) {
                        mensaje = "6";
                        puntuacion = 6;
                    }
                    if (impacto >= 390 & impacto <= 470) {
                        mensaje = "5";
                        puntuacion = 5;
                    }
                    if (impacto > 470) {
                        mensaje = "0";
                        puntuacion = 0;
                    }
                    contador();
                }
                if (evento.getAction() == MotionEvent.ACTION_UP) {

                }
                if (evento.getAction() == MotionEvent.ACTION_MOVE) {
                }
            }
            invalidate();
            return true;
        }
    }//Lienzo
}
