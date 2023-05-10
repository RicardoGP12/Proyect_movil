package com.ita.proyect.ui.dashboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ita.proyect.R;

import java.util.ArrayList;

public class productsAdaptor extends RecyclerView.Adapter<productsAdaptor.ViewHolder> {
    ArrayList<Comidas> catgoryComidas;

    public productsAdaptor(ArrayList<Comidas> comidas) {
        this.catgoryComidas = comidas;
    }


    @NonNull
    @Override
    public productsAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholer_popular,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull productsAdaptor.ViewHolder holder, int position) {
        holder.title.setText(catgoryComidas.get(position).getTitle());
       holder.fee.setText(String.valueOf(catgoryComidas.get(position).getFee()));

       holder.itemView.getContext().getResources().getIdentifier(catgoryComidas.get(position).getPic(),"drawable",holder.itemView.getContext().getPackageName());


    }

    @Override
    public int getItemCount() {
        return catgoryComidas.size();
    }

    public class ViewHolder  extends  RecyclerView.ViewHolder{
        TextView title,fee;
        ImageView pic;
        TextView addBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_2);
            fee = itemView.findViewById(R.id.fee);
            pic = itemView.findViewById(R.id.pic);
            addBtn = itemView.findViewById(R.id.addBtn);
        }
    }
}
