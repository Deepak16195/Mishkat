package mishkat.mdrd.com.mishkat.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import mishkat.mdrd.com.mishkat.DeskBoardsPages.Models.VendorDetailModel;
import mishkat.mdrd.com.mishkat.DeskBoardsPages.Item_Deatils_Activity;
import mishkat.mdrd.com.mishkat.R;

/**
 * Created by rahuljanagouda on 04/11/17.
 */

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.HorizontalViewHolder> {

    private List<VendorDetailModel.ResultEntity> list;
    Context mcontext;
    public  List<VendorDetailModel.ResultEntity> ListFiltered;
    @Override
    public HorizontalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_row, parent, false);
        return new HorizontalViewHolder(view);
    }

    public ItemListAdapter(Context context, List<VendorDetailModel.ResultEntity> mlist) {
        this.list = mlist;
        this.mcontext = context;
        this.ListFiltered = mlist;
    }

    @Override
    public void onBindViewHolder(HorizontalViewHolder holder, int position) {
       /* holder.cardImage.setImageResource(R.drawable.phungdemac);*/
        holder.cardTitle.setText(ListFiltered.get(position).getName()+"");
    }

    @Override
    public int getItemCount() {
        return ListFiltered.size();
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
                    Intent intent = new Intent(context, Item_Deatils_Activity.class);
                    context.startActivity(intent);

                }
            });
        }
    }
}
