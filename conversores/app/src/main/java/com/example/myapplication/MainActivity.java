package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    /*
    * Monedas, Masa, Volumen, Longitud, Almacenamiento, Tiempo,
    * Transferencia de Datos
    *
    * */
    TextView tempVal;
    Button btn;
    Spinner spn;
    // Matriz dimensional conteniendo las conversiones base
    Double valores[][] = {
            {1.0, 0.85, 7.67, 26.42, 36.80, 495.77, 3.35, 1.00, 17.16, 1.36}, //moendas
            {}, // Masa
            {}, //volumen
            {1.0, 1000.0, 100.0, 39.3701, 3.280841666667, 1.1963081929167, 1.09361, 0.001,0.000621371}, //longitud
            {}, //Almacenamiento
            {}, // Tiempo
            {}, // Transferencia de datos
    };


    /* Monedas
     * Dólar (USD) - unidad base
     * Euro (EUR)
     * Quetzal (GTQ)
     * Lempira (HNL)
     * Córdoba (NIO)
     * Colón costarricense (CRC)
     * Sol (PEN)
     * Balboa (PAB)
     * Peso mexicano (MXN)
     * Dólar canadiense (CAD)
     */


    /*
    * /* Longitud
     * Metro (m) - unidad base
     * Centímetro (cm)
     * Milímetro (mm)
     * Pulgada (in)
     * Pie (ft)
     * Yarda (yd)
     * Kilometro (km)
     * Milla (mi)
    * */

    /* Masa
     * Kilogramo (kg) - unidad base
     * Gramo (g)
     * Miligramo (mg)
     * Decagramo (dag)
     * Hectogramo (hg)
     *  Quilate (ct)
     * Onza (oz)
     * Libra (lb)
     * Stone (st)
     * Tonelada (t)
     */

    /* Volumen
     * Litro (L) - unidad base
     * Mililitro (mL)
     * Metro cúbico (m³)
     * Centímetro cúbico (cm³)
     * Galón estadounidense (gal US)
     * Galón imperial (gal UK)
     * Onza líquida (fl oz)
     * Pinta (pt)
     * Cuarto (qt)
     * Barril (bbl)
     */

    /* Almacenamiento
     * Bit (b) - unidad base
     * Byte (B)
     * Kilobyte (KB)
     * Megabyte (MB)
     * Gigabyte (GB)
     * Terabyte (TB)
     * Petabyte (PB)
     * Exabyte (EB)
     * Zettabyte (ZB)
     * Yottabyte (YB)
     */

    /* Tiempo
     * Año - unidad base
     * Mes
     * Semana
     * Día
     * Hora
     * Minuto
     * Segundo
     * Milisegundo
     * Microsegundo
     * Nanosegundo
     */


    /* Transferencia de Datos
     * Bit por segundo (bps) - unidad base
     * Kilobit por segundo (Kbps)
     * Megabit por segundo (Mbps)
     * Gigabit por segundo (Gbps)
     * Terabit por segundo (Tbps)
     * Petabit por segundo (Pbps)
     * Exabit por segundo (Ebps)
     * Zettabit por segundo (Zbps)
     * Yottabit por segundo (Ybps)
     * Byte por segundo (Bps)
     */





    String[][] etiquetas = {
            {
                "Dólar (USD)",
                    "Euro (EUR)",
                    "Quetzal (GTQ)",
                    "Lempira (HNL)",
                    "Córdoba (NIO)",
                    "Colón costarricense (CRC)",
                    "Sol (PEN)", "Balboa (PAB)",
                    "Peso mexicano (MXN)",
                    "Dólar canadiense (CAD)"
            }, //monedas

            {"Kilogramo (kg)",
                    "Gramo (g)",
                    "Miligramo (mg)",
                    "Decagramo (dag)",
                    "Hectogramo (hg)",
                    "Quilate (ct)",
                    "Onza (oz)",
                    "Libra (lb)",
                    "Stone (st)",
                    "Tonelada (t)"}, // Masa

            {"Litro (L)",
                    "Mililitro (mL)",
                    "Metro cúbico (m³)",
                    "Centímetro cúbico (cm³)",
                    "Galón estadounidense (gal US)",
                    "Galón imperial (gal UK)",
                    "Onza líquida (fl oz)",
                    "Pinta (pt)", "Cuarto (qt)",
                    "Barril (bbl)"}, // volumen,

            {"Metro (m)", "Centímetro (cm)"
                    , "Milímetro (mm)",
                    "Pulgada (in)",
                    "Pie (ft)",
                    "Yarda (yd)",
                    "Kilómetro (km)",
                    "Milla (mi)"}, //Longitud
            {"Bit (b)",
                    "Byte (B)",
                    "Kilobyte (KB)",
                    "Megabyte (MB)",
                    "Gigabyte (GB)",
                    "Terabyte (TB)",
                    "Petabyte (PB)",
                    "Exabyte (EB)",
                    "Zettabyte (ZB)",
                    "Yottabyte (YB)"}, // almacenamiento

            {"Año",
                    "Mes",
                    "Semana",
                    "Día",
                    "Hora",
                    "Minuto",
                    "Segundo",
                    "Milisegundo",
                    "Microsegundo",
                    "Nanosegundo"}, // tiempo

            {"Bit por segundo (bps)",
                    "Kilobit por segundo (Kbps)",
                    "Megabit por segundo (Mbps)",
                    "Gigabit por segundo (Gbps)",
                    "Terabit por segundo (Tbps)",
                    "Petabit por segundo (Pbps)",
                    "Exabit por segundo (Ebps)",
                    "Zettabit por segundo (Zbps)",
                    "Yottabit por segundo (Ybps)",
                    "Byte por segundo (Bps)"} // transferencia de datos

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btnConvertir);
        btn.setOnClickListener(v->convertir());

        cambiarEtiqueta(0);//valores predeterminaods

        spn= findViewById(R.id.spnTipo);
        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                cambiarEtiqueta(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void cambiarEtiqueta(int posicion){
        ArrayAdapter<String> aaEtiquetas = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                etiquetas[posicion]
        );

        aaEtiquetas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn= findViewById(R.id.spnDe);
        spn.setAdapter(aaEtiquetas);

        spn = findViewById(R.id.spnA);
        spn.setAdapter(aaEtiquetas);

    }

    private void convertir(){
        // Pociscion selecionada de 0 a 5  del primer spinner
        spn = findViewById(R.id.spnTipo);
        int tipo = spn.getSelectedItemPosition();

        // Pociscion selecionada de 0 a 5  del primer spinner
        spn = findViewById(R.id.spnDe);
        int de = spn.getSelectedItemPosition();

        // Pociscion selecionada de 0 a 5 del segundo spinner
        spn = findViewById(R.id.spnA);
        int a = spn.getSelectedItemPosition();

        // Obtenemos el valor dado en el input/textbox
        tempVal = findViewById(R.id.txtCantidad);
        double cantidad = Double.parseDouble(tempVal.getText().toString());

        // Variable que almacena el calculo de la funcion
        double respuesta = conversor(tipo, de, a, cantidad);

        // Mostrar el resultado en el label
        tempVal = findViewById(R.id.lblRespuesta);
        tempVal.setText("Respuesta: "+ respuesta);
    }


    // Funcion que toma de argumentos a, de y cantidad a convertir devolviendo Double para su uso
    double conversor(int tipo, int de, int a, double cantidad){
        return valores[tipo][a]/valores[tipo][de] * cantidad;
    }
}