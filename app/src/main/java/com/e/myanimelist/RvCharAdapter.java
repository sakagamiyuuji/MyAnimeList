package com.e.myanimelist;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RvCharAdapter extends RecyclerView.Adapter<RvCharAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<CharacterData> data;

    public RvCharAdapter(Context context, ArrayList<CharacterData> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cardview_character, parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.tvTitleChar.setText(data.get(position).getNama());
        holder.imgChar.setImageResource(data.get(position).getImages());
        holder.cardViewChar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,CharacterDeskripsiActivity.class);
                intent.putExtra("obj", data.get(position)); // object CharData
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvTitleChar;
        ImageView imgChar;
        CardView cardViewChar;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitleChar = itemView.findViewById(R.id.title_char_cv);
            imgChar = itemView.findViewById(R.id.image_char_cv);
            cardViewChar = itemView.findViewById(R.id.cardview_char);
        }
    }
}
