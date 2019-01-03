package com.maho.upi.pamarray.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.maho.upi.pamarray.Model.ModelListData;
import com.maho.upi.pamarray.R;
import com.squareup.picasso.Picasso;

import java.util.List;

@SuppressWarnings("ALL")
public class RecyclerListDataAdapter extends RecyclerView.Adapter<RecyclerListDataAdapter.MyviewHolder> {
    @NonNull
    Context context;
    List<ModelListData> modelListData;

    //Constructor
    public RecyclerListDataAdapter(@NonNull Context context, List<ModelListData> modelListData) {
        this.context = context;
        this.modelListData = modelListData;
    }

    //Setter


    public void setModelListData(List<ModelListData> modelListData) {
        this.modelListData = modelListData;
        notifyDataSetChanged();
    }

    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.listdata, parent, false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerListDataAdapter.MyviewHolder myviewHolder, int position) {
        myviewHolder.listnama.setText("" + modelListData.get(position).getNama());
        myviewHolder.listPosisi.setText("" + modelListData.get(position).getPosisi());
        myviewHolder.listNegara.setText("" + modelListData.get(position).getNegara());
        myviewHolder.listNomor.setText("" + modelListData.get(position).getNomor());

        Picasso.with(context).load(modelListData.get(position).getProfile()).into(myviewHolder.listgambar);

    }

    @Override
    public int getItemCount() {
        if (modelListData != null){
            return modelListData.size();
        }
        return 0;
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        TextView listnama, listPosisi, listNegara, listNomor ;
        ImageView listikon, listgambar;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);

            listnama = (TextView) itemView.findViewById(R.id.txtNama);
            listPosisi = (TextView) itemView.findViewById(R.id.txtPosisi);
            listNegara = (TextView) itemView.findViewById(R.id.txtNegara);
            listNomor = (TextView) itemView.findViewById(R.id.txtNopung);
            listgambar = (ImageView) itemView.findViewById(R.id.imgProfile);


        }
    }
}
