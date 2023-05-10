package com.ita.proyect.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ita.proyect.R;
import com.ita.proyect.databinding.FragmentDashboardBinding;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
   private  RecyclerView.Adapter adapter;
   private  RecyclerView recyclerViewPopulatList;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);
        // Instancia del ListView.

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private  void  recyclerViewPopular(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerViewPopulatList = getView().findViewById(R.id.recyclerView_2);
        recyclerViewPopulatList.setLayoutManager(linearLayoutManager);

        ArrayList<Comidas> comidas =new ArrayList<>();
        comidas.add(new Comidas("Pizza de Pepperoni","comida1","Deliciosa pizza con delicioso queso",80.00));
        comidas.add(new Comidas("Hamburguesa","comida21","Contiene doble carne con extra queso y tocino",75.00));
        comidas.add(new Comidas("Orden de fautas","comida3","Crugientes rollos de tortilla rellenos con pollo y su deliciosa salsa",50.00));

        adapter = new productsAdaptor(comidas);
        recyclerViewPopulatList.setAdapter(adapter);


    }
}