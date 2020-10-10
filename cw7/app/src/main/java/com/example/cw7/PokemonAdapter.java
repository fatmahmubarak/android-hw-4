package com.example.cw7;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PokemonAdapter extends RecyclerView.Adapter {

    ArrayList<pokemon> pArray;
    Context context;

    public PokemonAdapter(ArrayList<pokemon> pArray, Context context) {
        this.pArray = pArray;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemon_list_item,parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ((ViewHolder) holder).img.setImageResource(pArray.get(position).getImage());
        ((ViewHolder) holder).total.setText(pArray.get(position).getTotal()+"");
        ((ViewHolder) holder).name.setText(pArray.get(position).getName());
        ((ViewHolder) holder).view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,MainActivity2.class);
                intent.putExtra("image",pArray.get(position).getImage());
                intent.putExtra("name",pArray.get(position).getName());
                intent.putExtra("total",pArray.get(position).getTotal()+"");
                intent.putExtra("def",pArray.get(position).getDefence()+"");
                intent.putExtra("atact",pArray.get(position).getAttack()+"");
                context.startActivity(intent);
            }
        });

        ((ViewHolder) holder).delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pArray.remove(position);
                notifyDataSetChanged();
                Toast.makeText(context, "item is deleted", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return pArray.size();
    }



    public static class ViewHolder extends RecyclerView.ViewHolder{
      public ImageView img;
      public TextView name;
      public TextView total;
      public ImageView delete;
      public View view;
//      public RelativeLayout relative;
   //   public ImageView mDeleteImage;
//
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            img = itemView.findViewById(R.id.imageView);
            name = itemView.findViewById(R.id.textView);
            total = itemView.findViewById(R.id.textView3);
            delete = itemView.findViewById(R.id.delete);
//            relative = itemView.findViewById(R.id.relative);
         //   mDeleteImage = itemView.findViewById(R.id.image_delete);
        }
    }


}
