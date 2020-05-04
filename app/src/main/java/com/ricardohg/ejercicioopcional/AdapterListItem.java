package com.ricardohg.ejercicioopcional;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AdapterListItem extends RecyclerView.Adapter<AdapterListItem.ViewHolderDatos> {

    // List data:
    ArrayList<Integer> numberList;

    public AdapterListItem(ArrayList<Integer> itemList) {
        this.numberList = itemList;
    }

    @NonNull
    @Override
    public AdapterListItem.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);

        return new AdapterListItem.ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        holder.setItem(numberList.get(position));
    }

    @Override
    public int getItemCount() {
        return numberList.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder{
        TextView tvNumber;

        public ViewHolderDatos(View view) {
            super(view);
            tvNumber = (TextView) view.findViewById(R.id.tvNumber);
        }

        public void setItem(int number) {
            tvNumber.setText(Integer.toString(number));
        }
    }
}
