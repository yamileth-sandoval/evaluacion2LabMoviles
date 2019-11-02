package com.example.evaluacion2labmoviles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnAC,btnDEL,btnMas,btnMenos;
    Button btnSiete,btnOcho,btnNueve,btnDivision;
    Button btnCuatro,btnCinco,btnSeis,btnMultiplicacion;
    Button btnUno,btnDos,btnTres,btnIgual;
    Button btnAbrirParentesis,btnCerrarParentesis,btnPunto,btnCero;
    TextView txtOperandos,txtRespuesta;
    String textoOperandos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.txtOperandos=findViewById(R.id.txtOperandos);
        this.txtRespuesta=findViewById(R.id.txtRespuesta);
        //inicializar las variables numericas
        this.btnCero=findViewById(R.id.btnCero);//0
        this.btnUno=findViewById(R.id.btnUno);//1
        this.btnDos=findViewById(R.id.btnDos);//2
        this.btnTres=findViewById(R.id.btnTres);//3
        this.btnCuatro=findViewById(R.id.btnCuatro);//4
        this.btnCinco=findViewById(R.id.btnCinco);//5
        this.btnSeis=findViewById(R.id.btnSeis);//6
        this.btnSiete=findViewById(R.id.btnSiete);//7
        this.btnOcho=findViewById(R.id.btnOcho);//8
        this.btnNueve=findViewById(R.id.btnNueve);//9
        //inicializar variables de operacion
        this.btnAC=findViewById(R.id.btnAC);//AC borra
        this.btnDEL=findViewById(R.id.btnDEL);//DEL borra el ultimo caracter
        this.btnMas=findViewById(R.id.btnMas);//suma
        this.btnMenos=findViewById(R.id.btnMenos);//resta
        this.btnDivision=findViewById(R.id.btnDivision);//divide
        this.btnMultiplicacion=findViewById(R.id.btnMultiplicacion);//multiplicacion
        this.btnIgual=findViewById(R.id.btnIgual);//resultado final

        this.btnCero.setOnClickListener(this);
        this.btnUno.setOnClickListener(this);
        this.btnDos.setOnClickListener(this);
        this.btnTres.setOnClickListener(this);
        this.btnCuatro.setOnClickListener(this);
        this.btnCinco.setOnClickListener(this);
        this.btnSeis.setOnClickListener(this);
        this.btnSiete.setOnClickListener(this);
        this.btnOcho.setOnClickListener(this);
        this.btnNueve.setOnClickListener(this);
        this.btnAC.setOnClickListener(this);
        this.btnDEL.setOnClickListener(this);
        this.btnMas.setOnClickListener(this);
        this.btnMenos.setOnClickListener(this);
        this.btnDivision.setOnClickListener(this);
        this.btnMultiplicacion.setOnClickListener(this);
        this.btnIgual.setOnClickListener(this);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            this.btnAbrirParentesis=findViewById(R.id.btnAbrirParentesis);
            this.btnCerrarParentesis=findViewById(R.id.btnCerrarParentesis);
            this.btnPunto=findViewById(R.id.btnPunto);
            this.btnPunto.setOnClickListener(this);
            this.btnCerrarParentesis.setOnClickListener(this);
            this.btnAbrirParentesis.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        textoOperandos=this.txtOperandos.getText().toString();
        switch (view.getId()){
            case R.id.btnCero:{
                this.txtOperandos.setText(textoOperandos+"0");
            }break;

            case R.id.btnUno:{
                this.txtOperandos.setText(textoOperandos+"1");
            }break;

            case R.id.btnDos:{
                this.txtOperandos.setText(textoOperandos+"2");
            }break;

            case R.id.btnTres:{
                this.txtOperandos.setText(textoOperandos+"3");
            }break;

            case R.id.btnCuatro:{
                this.txtOperandos.setText(textoOperandos+"4");
            }break;

            case R.id.btnCinco:{
                this.txtOperandos.setText(textoOperandos+"5");
            }break;

            case R.id.btnSeis:{
                this.txtOperandos.setText(textoOperandos+"6");
            }break;

            case R.id.btnSiete:{
                this.txtOperandos.setText(textoOperandos+"7");
            }break;

            case R.id.btnOcho:{
                this.txtOperandos.setText(textoOperandos+"8");
            }break;

            case R.id.btnNueve:{
                this.txtOperandos.setText(textoOperandos+"9");
            }break;

            case R.id.btnMas:{
                calcularUltimoCaracter("+");
               // this.txtOperandos.setText(textoOperandos+"+");
            }break;

            case R.id.btnMenos:{
                calcularUltimoCaracter("-");
                //this.txtOperandos.setText(textoOperandos+"-");
            }break;

            case R.id.btnDivision:{
                calcularUltimoCaracter("/");
               // this.txtOperandos.setText(textoOperandos+"/");
            }break;

            case R.id.btnMultiplicacion:{
                calcularUltimoCaracter("*");
               // this.txtOperandos.setText(textoOperandos+"*");
            }break;

            case R.id.btnAC:{
                this.txtOperandos.setText("");
                if(getResources().getConfiguration().orientation==Configuration.ORIENTATION_PORTRAIT){
                    if(txtRespuesta.getVisibility()==View.VISIBLE){
                        txtRespuesta.setVisibility(View.INVISIBLE);
                    }
                }
            }break;

            case R.id.btnDEL:{
                if(!textoOperandos.isEmpty()){
                    this.txtOperandos.setText(textoOperandos.substring(0,textoOperandos.length()-1));
                    if(getResources().getConfiguration().orientation==Configuration.ORIENTATION_PORTRAIT){
                        if(txtRespuesta.getVisibility()==View.VISIBLE){
                            txtRespuesta.setVisibility(View.INVISIBLE);
                        }
                    }
                }
            }break;

            case R.id.btnIgual:{
                calcularResultado();
            }break;
        }
       if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            switch (view.getId()){
                case R.id.btnPunto:{
                    if(!textoOperandos.isEmpty()){
                        if(!textoOperandos.substring(textoOperandos.length()-1).equals("+") && !textoOperandos.substring(textoOperandos.length()-1).equals("-") &&
                                !textoOperandos.substring(textoOperandos.length()-1).equals("*") && !textoOperandos.substring(textoOperandos.length()-1).equals("/") &&
                                !textoOperandos.substring(textoOperandos.length()-1).equals(")")){
                            this.txtOperandos.setText(textoOperandos+".");
                        }
                    }else {
                        this.txtOperandos.setText("0.");
                    }
                }break;

                case R.id.btnAbrirParentesis:{
                    if(textoOperandos.isEmpty() || textoOperandos.substring(textoOperandos.length()-1).equals("+") || textoOperandos.substring(textoOperandos.length()-1).equals("-") ||
                            textoOperandos.substring(textoOperandos.length()-1).equals("*") || textoOperandos.substring(textoOperandos.length()-1).equals("/")){
                        this.txtOperandos.setText(textoOperandos+"(");
                    }
                }break;

                case R.id.btnCerrarParentesis:{
                    if(!textoOperandos.isEmpty() && !textoOperandos.substring(textoOperandos.length()-1).equals("+") && !textoOperandos.substring(textoOperandos.length()-1).equals("-") &&
                            !textoOperandos.substring(textoOperandos.length()-1).equals("*") && !textoOperandos.substring(textoOperandos.length()-1).equals("/")){
                        this.txtOperandos.setText(textoOperandos+")");
                    }
                }break;
            }
        }
    }

    private void calcularUltimoCaracter(String caracter){
        if(!textoOperandos.isEmpty()){
            if(textoOperandos.substring(textoOperandos.length()-1).equals("+") || textoOperandos.substring(textoOperandos.length()-1).equals("-") ||
                    textoOperandos.substring(textoOperandos.length()-1).equals("*") || textoOperandos.substring(textoOperandos.length()-1).equals("/") ||
                    textoOperandos.substring(textoOperandos.length()-1).equals(".")){
                //textoOperandos.substring(0,textoOperandos.length()-1);
                txtOperandos.setText(textoOperandos.substring(0,textoOperandos.length()-1)+caracter);
                //Toast.makeText(this,"Si",Toast.LENGTH_SHORT).show();
            }else {
                this.txtOperandos.setText(textoOperandos+caracter);
                //Toast.makeText(this,"No",Toast.LENGTH_SHORT).show();
            }
        }if(caracter.equals(".")){
            this.txtOperandos.setText("0.");
        }
    }

    private void calcularResultado(){
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            if(!textoOperandos.isEmpty()){
                if(textoOperandos.substring(textoOperandos.length()-1).equals("+") || textoOperandos.substring(textoOperandos.length()-1).equals("-") ||
                        textoOperandos.substring(textoOperandos.length()-1).equals("*") || textoOperandos.substring(textoOperandos.length()-1).equals("/") ||
                        textoOperandos.substring(textoOperandos.length()-1).equals(".")){
                    Toast.makeText(this,"Expresion no Valida!!!",Toast.LENGTH_SHORT).show();
                }else if(parentesis()){
                    ScriptEngine engine =new ScriptEngineManager().getEngineByName("rhino");
                    Object resultado=null;
                    try {
                        resultado=engine.eval(textoOperandos);
                    }catch (ScriptException e){
                        Log.d("Calculadora", "error: " + e.getMessage());
                    }
                    this.txtOperandos.setText(resultado.toString());
                }else {
                    Toast.makeText(this,"Expresion no Valida!!!",Toast.LENGTH_SHORT).show();
                }
            }else {
                Toast.makeText(this,"Escriba una Operacion!!!",Toast.LENGTH_SHORT).show();
            }
        }else {
            if(!textoOperandos.isEmpty()){
                if(textoOperandos.substring(textoOperandos.length()-1).equals("+") || textoOperandos.substring(textoOperandos.length()-1).equals("-") ||
                        textoOperandos.substring(textoOperandos.length()-1).equals("*") || textoOperandos.substring(textoOperandos.length()-1).equals("/")){
                    Toast.makeText(this,"Expresion no Valida!!!",Toast.LENGTH_SHORT).show();
                }else {
                    ScriptEngine engine =new ScriptEngineManager().getEngineByName("rhino");
                    Object resultado=null;
                    try {
                        resultado=engine.eval(textoOperandos);
                    }catch (ScriptException e){
                        Log.d("Calculadora", "error: " + e.getMessage());
                    }
                    this.txtRespuesta.setVisibility(View.VISIBLE);
                    this.txtRespuesta.setText("="+resultado.toString());
                }
            }else {
                Toast.makeText(this,"Escriba una Operacion!!!",Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean parentesis(){
        boolean var=false;
        int a=0, c=0;
        for (int i=0; i<=textoOperandos.length();i++){
            if(textoOperandos.substring(i).equals("(")){
                a=a+1;
            }
            if(textoOperandos.substring(i).equals(")")){
                c=c+1;
            }
        }

        if(a==c){
            var=true;
        }
        return var;
    }
}
