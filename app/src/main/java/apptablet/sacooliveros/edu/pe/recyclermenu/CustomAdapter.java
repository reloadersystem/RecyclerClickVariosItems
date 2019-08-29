package apptablet.sacooliveros.edu.pe.recyclermenu;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {


    private onDiaListener onDiaListener;

    public void setOnDiaListener(onDiaListener onDiaListener) {
        this.onDiaListener = onDiaListener;
    }

    private List<MyList> list;
    private Context mCtx;


    public CustomAdapter(List<MyList> list, Context mCtx) {
        this.list = list;
        this.mCtx = mCtx;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v, onDiaListener);
    }

    @Override
    public void onBindViewHolder(final CustomAdapter.ViewHolder holder, int position) {
        MyList myList = list.get(position);
        holder.textViewHead.setText(myList.getHead());
        holder.textViewDesc.setText(myList.getDesc());
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

//    @Override
//    public void onFondoClicked(int position) {
//        Log.d("LogClick", " fondo Clicked" + position);
//    }
//
//    @Override
//    public void onAccionClicked(int position) {
//        Log.d("ItemClick", " Accion Clicked" + position);
//    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewHead;
        public TextView textViewDesc;
        public TextView buttonViewOption;

        public ViewHolder(View itemView, final onDiaListener onDiaListener) {
            super(itemView);

            textViewHead = (TextView) itemView.findViewById(R.id.textViewHead);
            textViewDesc = (TextView) itemView.findViewById(R.id.textViewDesc);
            buttonViewOption = (TextView) itemView.findViewById(R.id.textViewOptions);

            //click sobre la  celda

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int position = getAdapterPosition();
                    //posicion del item que seleccione
                    if (position != RecyclerView.NO_POSITION) {
                        //Log.d("LogClick", " fondo Clicked" + position);
                        onDiaListener.onFondoClicked(position);
                    }
                }
            });
//click sobre un item de la celda
            buttonViewOption.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    //posicion del item que seleccione
                    if (position != RecyclerView.NO_POSITION) {
                        //  Log.d("LogClickItem", " Item Clicked" + position);

                        onDiaListener.onAccionClicked(position);
                    }
                }
            });
        }
    }
}
