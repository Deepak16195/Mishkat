package mishkat.mdrd.com.mishkat.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import mishkat.mdrd.com.mishkat.Item_list_Activity;
import mishkat.mdrd.com.mishkat.R;

/**
 * Created by rahuljanagouda on 04/11/17.
 */

public class MyAddressListAdapter extends RecyclerView.Adapter<MyAddressListAdapter.HorizontalViewHolder> {


    @Override
    public HorizontalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.myaddress_list_item, parent, false);
        return new HorizontalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HorizontalViewHolder holder, int position) {
       /* holder.cardImage.setImageResource(R.drawable.phungdemac);*/
        holder.cardTitle.setText("Offer");
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    class HorizontalViewHolder extends RecyclerView.ViewHolder {
        ImageView cardImage;
        TextView cardTitle;
        public HorizontalViewHolder(View itemView) {
            super(itemView);
          /*  cardImage = itemView.findViewById(R.id.image);*/
            cardTitle = itemView.findViewById(R.id.text);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Context context = v.getContext();
                    Intent intent = new Intent(context, Item_list_Activity.class);
                    context.startActivity(intent);

                }
            });
        }
    }
}
