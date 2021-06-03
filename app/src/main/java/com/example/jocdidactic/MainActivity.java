package com.example.jocdidactic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private int raspunsCurent=0, punctaj=0;
    private int cnt = 0;
    private int raspCurent=0;
    ArrayList<Intrebare> listaIntrebari=new ArrayList<Intrebare>();

    TextView textViewCerinta;
    ImageView imageViewIntrebare, imageViewRaspuns1,imageViewRaspuns2,imageViewRaspuns3,imageViewNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewCerinta=findViewById(R.id.textViewCerinta);
        imageViewIntrebare=findViewById(R.id.imageViewIntrebare);
        imageViewRaspuns1=findViewById(R.id.imageViewRaspuns1);
        imageViewRaspuns2=findViewById(R.id.imageViewRaspuns2);
        imageViewRaspuns3=findViewById(R.id.imageViewRaspuns3);
        imageViewNext=findViewById(R.id.imageViewNext);

        Drawable red = getResources().getDrawable( R.drawable.border_red_image);
        imageViewRaspuns2.setBackground(red);
        imageViewRaspuns3.setBackground(red);
        imageViewRaspuns1.setBackground(red);

        creareListaIntrebari();
        Log.d("EMA",String.valueOf(listaIntrebari.size()));
        puneIntrebareInActivity(cnt);

    }

    private void puneIntrebareInActivity(int cnt){

        Resources res = getResources();
        int resIDIntr=0,resIDRasp1=0,resIDRasp2=0,resIDRasp3=0;

        Drawable red = getResources().getDrawable( R.drawable.border_red_image);
        imageViewRaspuns2.setBackground(red);
        imageViewRaspuns3.setBackground(red);
        imageViewRaspuns1.setBackground(red);
//        imageViewNext.setBackground(red);

        Intrebare intrebare=new Intrebare();
        String intr="";
        String rasp1="",rasp2="",rasp3="";


            intrebare = listaIntrebari.get(cnt);
            intr = intrebare.getIntrebare();
            rasp1 = intrebare.getRaspuns1();
            rasp2 = intrebare.getRaspuns2();
            rasp3 = intrebare.getRaspuns3();

            textViewCerinta.setText(intrebare.getTextCerinta());

            resIDIntr = res.getIdentifier(intr, "drawable", getPackageName());
            imageViewIntrebare.setImageResource(resIDIntr);

            resIDRasp1 = res.getIdentifier(rasp1, "drawable", getPackageName());
            imageViewRaspuns1.setImageResource(resIDRasp1);

            resIDRasp2 = res.getIdentifier(rasp2, "drawable", getPackageName());
            imageViewRaspuns2.setImageResource(resIDRasp2);

            resIDRasp3 = res.getIdentifier(rasp3, "drawable", getPackageName());
            imageViewRaspuns3.setImageResource(resIDRasp3);

            imageViewNext.setImageResource(R.drawable.red_arrow);

            imagini(intrebare.getRaspunsCorect());

    }

    private void imagini(int raspunsCorect){
        imageViewNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cnt = cnt + 1;

//                Drawable red = getResources().getDrawable( R.drawable.border_red_image);
//                imageViewNext.setBackground(red);

                if(cnt>8){

                    if(raspCurent==raspunsCorect)
                        punctaj++;

                    Intent intent = new Intent(MainActivity.this, Scor.class);
                    intent.putExtra("punctaj",String.valueOf(punctaj));
                    startActivity(intent);
                    //Toast.makeText(MainActivity.this, String.valueOf(punctaj), Toast.LENGTH_SHORT).show();
                }else {
                    if(raspCurent==raspunsCorect)
                        punctaj++;
                    puneIntrebareInActivity(cnt);
                }
            }
        });

        imageViewRaspuns1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                raspCurent=1;

                imageViewNext.setImageResource(R.drawable.ic_green_arrow);

                Drawable green = getResources().getDrawable( R.drawable.border_green_image);
                imageViewRaspuns1.setBackground(green);

                Drawable red = getResources().getDrawable( R.drawable.border_red_image);
                imageViewRaspuns2.setBackground(red);
                imageViewRaspuns3.setBackground(red);

            }
        });

        imageViewRaspuns2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                raspCurent=2;

                imageViewNext.setImageResource(R.drawable.ic_green_arrow);


                Drawable green = getResources().getDrawable( R.drawable.border_green_image);
                imageViewRaspuns2.setBackground(green);

                Drawable red = getResources().getDrawable( R.drawable.border_red_image);
                imageViewRaspuns1.setBackground(red);
                imageViewRaspuns3.setBackground(red);

            }
        });
        imageViewRaspuns3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                raspCurent=3;

                imageViewNext.setImageResource(R.drawable.ic_green_arrow);

                Drawable green = getResources().getDrawable( R.drawable.border_green_image);
                imageViewRaspuns3.setBackground(green);

                Drawable red = getResources().getDrawable( R.drawable.border_red_image);
                imageViewRaspuns2.setBackground(red);
                imageViewRaspuns1.setBackground(red);

            }
        });

    }

    private void creareListaIntrebari(){
        Intrebare intrebare1=new Intrebare("Care imbracaminte nu se potriveste?","fata","rochie","cravata","sandale",2);
        Intrebare intrebare2=new Intrebare("Care imagine nu reprezinta anotimpul toamna?","toamna","dulceata","ploaie","floare",3);
        Intrebare intrebare3=new Intrebare("Care imbracaminte nu se potriveste?","baiat","geanta","costum","palarie",1);
        Intrebare intrebare4=new Intrebare("Care animal este salbatic?","animaledomestice","caine","tigru","pisica",2);
        Intrebare intrebare5=new Intrebare("Gaseste intrusul!","semnulintrebarii","mamaruta1","mamaruta2","mamaruta3",3);
        Intrebare intrebare6=new Intrebare("Gaseste intrusul!","semnulintrebarii","delfin1","delfin2","delfin3",1);
        Intrebare intrebare7=new Intrebare("Gaseste intrusul!","semnulintrebarii","instrument1","instrument2","instrument3",2);
        Intrebare intrebare8=new Intrebare("Gaseste intrusul!","semnulintrebarii","minge1","minge2","minge3",3);
        Intrebare intrebare9=new Intrebare("Gaseste intrusul!","semnulintrebarii","sapca1","sapca2","sapca3",3);

        listaIntrebari.add(intrebare1);
        listaIntrebari.add(intrebare2);
        listaIntrebari.add(intrebare3);
        listaIntrebari.add(intrebare4);
        listaIntrebari.add(intrebare5);
        listaIntrebari.add(intrebare6);
        listaIntrebari.add(intrebare7);
        listaIntrebari.add(intrebare8);
        listaIntrebari.add(intrebare9);
    }
}