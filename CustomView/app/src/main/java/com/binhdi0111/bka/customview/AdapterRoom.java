package com.binhdi0111.bka.customview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterRoom extends RecyclerView.Adapter<AdapterRoom.ViewHolder>{
    Context context;
    ArrayList<Room> arrayList;

    public AdapterRoom(Context context, ArrayList<Room> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public AdapterRoom.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRoom.ViewHolder holder, int position) {
        Room room = arrayList.get(position);
        holder.txtRoom.setText(room.getName());
        boolean isVisibility= room.visibility;
        holder.constraintLayout.setVisibility(isVisibility ?View.VISIBLE :View.GONE );
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtRoom;
        ConstraintLayout constraintLayout;
        ImageView imgDrop;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtRoom = (TextView)itemView.findViewById(R.id.textViewUser);
            constraintLayout  = (ConstraintLayout) itemView.findViewById(R.id.constraintLayoutRecy);
            imgDrop = (ImageView) itemView.findViewById(R.id.imageViewDrop);
            imgDrop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Room room = arrayList.get(getAdapterPosition());
                    room.setVisibility(!room.isVisibility());
                    notifyItemChanged(getAdapterPosition());
                }
            });

        }
    }
}
