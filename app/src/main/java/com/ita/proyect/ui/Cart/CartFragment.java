package com.ita.proyect.ui.Cart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.ita.proyect.ActivityQR;
import com.ita.proyect.databinding.FragmentCartBinding;


public class CartFragment extends Fragment {

    private FragmentCartBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CartViewModel cartViewModel =
                new ViewModelProvider(this).get(CartViewModel.class);

        binding = FragmentCartBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void iniciarActividadB() {
        // Crea un Intent para iniciar la actividad B
        Intent intent = new Intent(getActivity(), ActivityQR.class);

        // Opcional: Puedes pasar información adicional a la nueva actividad utilizando putExtra
        //intent.putExtra("clave", valor);

        // Inicia la actividad B
        startActivity(intent);
    }

}