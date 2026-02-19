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
import android.widget.Toast; // Importacion de Toast para notificaciones


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
            {1.0, 0.85, 7.67, 26.53, 36.71, 481.72, 3.35, 1.00, 17.22, 1.37}, //moendas Actualizado 18/2/2026
            {
                    1.0,           // Kilogramo (kg) - unidad base
                    1000.0,        // Gramo (g)
                    1000000.0,     // Miligramo (mg)
                    100.0,         // Decagramo (dag)
                    10.0,          // Hectogramo (hg)
                    5000.0,        // Quilate (ct) - 1 kg = 5000 ct
                    35.274,        // Onza (oz)
                    2.20462,       // Libra (lb)
                    0.157473,      // Stone (st)
                    0.001          // Tonelada (t)
            }, // Masa
            {1.0, 1000.0, 0.001, 1000.0, 0.264172, 0.219969, 33.814, 2.1138, 1.05669, 0.00628981}, //volumen
            {1.0, 1000.0, 100.0, 39.3701, 3.28084, 1.09361, 0.001,0.000621371}, //longitud arreglado
            {
                    1.0,           // Bit (b)
                    0.125,         // Byte (B)
                    0.000125,      // Kilobyte (KB)
                    1.25e-7,       // Megabyte (MB)
                    1.25e-10,      // Gigabyte (GB)
                    1.25e-13,      // Terabyte (TB)
                    1.25e-16,      // Petabyte (PB)
                    1.25e-19,      // Exabyte (EB)
                    1.25e-22,      // Zettabyte (ZB)
                    1.25e-25       // Yottabyte (YB)
            }, // Almacenamiento
            {1.0,12.0,52.1429,365.0,8760.0,525600.0,3.154e+7,3.154e+10,3.154e+13,3.154e+16}, // Tiempo
            {1.0, 0.001, 0.000125, 0.000976563, 1e-6, 1.25e-7,  9.5367e-7, 1e-9, 1.25e-10, 9.3132e-10, 1e-12, 1.25e-13, 9.0949e-13} // Transferencia de datos
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
       "Kilobit por segundo",
       "Kilobyte por segundo",
       "Kibibit por segundo",
       "Megabit por segundo",
       "Megabyte por segundo",
       "Mebibit por segundo",
       "Gigabit por segundo",
       "Gigabyte por segundo",
       "Gibibit por segundo",
       "Terabit por segundo",
       "Terabyte por segundo",
       "Tebibit por segundo"
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

            {"Metro (m)", "Milímetro (mm)",
                    "Centímetro (cm)",
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
                    "Kilobyte por segundo (KBps)",
                    "Kibibit por segundo (Kibps)",
                    "Megabit por segundo (Mbps)",
                    "Megabyte por segundo (MBps)",
                    "Mebibit por segundo (Mibps)",
                    "Gigabit por segundo (Gbps)",
                    "Gigabyte por segundo (GBps)",
                    "Gibibit por segundo (Gibps)",
                    "Terabit por segundo (Tbps)",
                    "Terabyte por segundo (TBps)",
                    "Tebibit por segundo (Tibps)"
            }// transferencia de datos

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

        // Pociscion selecionada de 0 a 5  del segundo spinner
        spn = findViewById(R.id.spnDe);
        int de = spn.getSelectedItemPosition();

        // Pociscion selecionada de 0 a 5 del tercer spinner
        spn = findViewById(R.id.spnA);
        int a = spn.getSelectedItemPosition();

        // Obtenemos el valor dado en el input/textbox
        tempVal = findViewById(R.id.txtCantidad);

        // ==== Intentamos la conversion ====
        try {
            // Obtenemos el texto del ultimo spinner
            String textoConvertido = spn.getSelectedItem().toString();

            double cantidad = Double.parseDouble(tempVal.getText().toString());

            // Variable que almacena el calculo de la funcion
            double respuesta = conversor(tipo, de, a, cantidad);


            // Mostrar el resultado en el label
            tempVal = findViewById(R.id.lblRespuesta);
            tempVal.setText(String.format("Respuesta: %.2f %s", respuesta, textoConvertido)); //String.format -> sirve para darle formato a los numeros en este caso 12.92 el formato

            // Toast sirve para notificaciones rapidas
            Toast.makeText(this, "Conversion exitosa a " + textoConvertido, Toast.LENGTH_SHORT).show();

        } catch (Exception e) { // ==== Manejo de error ====

            // Toast sirve para notificaciones rapidas
            Toast.makeText(this, "Ingrese un número válido", Toast.LENGTH_SHORT).show();
            return; // IMPORTANTE: detener el metodo
        }




    }


    // Funcion que toma de argumentos a, de y cantidad a convertir devolviendo Double para su uso
    double conversor(int tipo, int de, int a, double cantidad){
        return valores[tipo][a]/valores[tipo][de] * cantidad;
    }
}