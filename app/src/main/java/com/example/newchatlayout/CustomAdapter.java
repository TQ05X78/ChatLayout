package com.example.newchatlayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private List<ObjectoListView> objectoListViews;
    private Context context;


    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv1,tv2,tv3;
        private ImageView imageView;
        public RelativeLayout  rel_background;
        public LinearLayout rel_foreground;

        public ViewHolder(View itemView){
            super(itemView);
            tv1 = (TextView) itemView.findViewById(R.id.textNumber);
            tv2 = (TextView) itemView.findViewById(R.id.textFecha);
            tv3 = (TextView) itemView.findViewById(R.id.textMensaje);
            rel_foreground = itemView.findViewById(R.id.rel_foreground);
            rel_background = itemView.findViewById(R.id.rel_background);

            imageView = (ImageView)itemView.findViewById(R.id.img_profile);
        }
    }


    public CustomAdapter(Context context, List<ObjectoListView> objectoListViews){
        this.objectoListViews = objectoListViews;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout_listview,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }




    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv1.setText(objectoListViews.get(position).getNumber());
        holder.tv2.setText(objectoListViews.get(position).getFecha());
        holder.tv3.setText(objectoListViews.get(position).getMensaje());

        holder.imageView.setImageResource(objectoListViews.get(position).getPhoto());

    }




    @Override
    public int getItemCount() {
        return objectoListViews.size();
    }




    public void removeItem(int position){
        objectoListViews.remove(position);
        notifyItemRemoved(position);
    }



    public void restoreItem(ObjectoListView item, int position)
    {
        objectoListViews.add(position, item);
        notifyItemInserted(position);
    }




    //public List<ObjectoListView> getobjectoListView(){
      //  return objectoListViews;
    //}


}
