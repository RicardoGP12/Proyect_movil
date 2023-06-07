package com.ita.proyect.ui.Cart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.ita.proyect.ActivityQR;
import com.ita.proyect.R;
import com.ita.proyect.databinding.FragmentCartBinding;


public class CartFragment extends Fragment {

    private FragmentCartBinding binding;
    Button pago;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CartViewModel cartViewModel =
                new ViewModelProvider(this).get(CartViewModel.class);

        binding = FragmentCartBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        View view = inflater.inflate(R.layout.fragment_cart, container, false);

        Button btnLanzarActivity = (Button) view.findViewById(R.id.button3);
        btnLanzarActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),ActivityQR.class);
                startActivity(intent);
            }
        });



        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void iniciarActivityQR() {
        // Crea un Intent para iniciar la actividad B
        Intent intent = new Intent(getActivity(), ActivityQR.class);

        // Opcional: Puedes pasar información adicional a la nueva actividad utilizando putExtra
        //intent.putExtra("clave", valor);

        // Inicia la actividad B
        startActivity(intent);
    }

}