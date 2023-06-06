package com.ita.proyect;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class ActivityQR extends AppCompatActivity {

    ImageView ivCodigoQR;
    EditText etDatos;
    Button btnGenerar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);

        ivCodigoQR = findViewById(R.id.ivCodigoQR);
        etDatos = findViewById(R.id.etDatos);
        btnGenerar = findViewById(R.id.btnGenerar);

        btnGenerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {

                    /* DATOS PARA MANEJAR
                     *  TELEFONO ES: tel:
                     *  SMS ES: numero:mensaje
                     *  MAIL: mailto
                     * */

                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.encodeBitmap("mailto:"+etDatos.getText().toString(), BarcodeFormat.QR_CODE, 750, 750);

                    ivCodigoQR.setImageBitmap(bitmap);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}