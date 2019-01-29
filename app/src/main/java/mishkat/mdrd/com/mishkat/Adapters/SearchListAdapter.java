package mishkat.mdrd.com.mishkat.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import me.zhanghai.android.materialratingbar.MaterialRatingBar;
import mishkat.mdrd.com.mishkat.DeskBoardsPages.GetAllVenderModel;
import mishkat.mdrd.com.mishkat.DeskBoardsPages.VendorDetailModel;
import mishkat.mdrd.com.mishkat.R;
import mishkat.mdrd.com.mishkat.Teacher_DetailsActivity;

/**
 * Created by rahuljanagouda on 04/11/17.
 */

public class SearchListAdapter extends RecyclerView.Adapter<SearchListAdapter.HorizontalViewHolder> {

    private List<GetAllVenderModel.ResultEntity> list;
    Context mcontext;
    public List<GetAllVenderModel.ResultEntity> ListFiltered;

    @Override
    public HorizontalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.search_list_item, parent, false);
        return new HorizontalViewHolder(view);
    }

    public SearchListAdapter(Context context, List<GetAllVenderModel.ResultEntity> mlist) {
        this.list = mlist;
        this.mcontext = context;
        this.ListFiltered = mlist;
    }

    @Override
    public void onBindViewHolder(HorizontalViewHolder holder, int position) {
        /* holder.cardImage.setImageResource(R.drawable.phungdemac);*/
        holder.VanderName.setText(ListFiltered.get(position).getName() + "");
        holder.Mini_Order.setText("Minimum Order : " + ListFiltered.get(position).getMin_order() + "");
        holder.D_Time.setText("Delivery Time: " + ListFiltered.get(position).getDelivery_time() + "");
        holder.RatingBar.setNumStars(Integer.valueOf(ListFiltered.get(position).getRate()));
        Glide.with(mcontext).load(ListFiltered.get(position).getLogo()).placeholder(R.drawable.tlogo).error(R.drawable.tlogo).into(holder.Logo);
        Glide.with(mcontext).load(ListFiltered.get(position).getBanner()).placeholder(R.drawable.tech).error(R.drawable.tech).into(holder.Banner);
        String Open =ListFiltered.get(position).getOpen_status();
        if(Open.equalsIgnoreCase("1"))
        {
            holder.cardTitle.setText("Close");
        }


    }

    @Override
    public int getItemCount() {
        return ListFiltered.size();
    }

    class HorizontalViewHolder extends RecyclerView.ViewHolder {
        ImageView Banner, Logo;
        TextView cardTitle, VanderName, Mini_Order, D_Time;
        MaterialRatingBar RatingBar;

        public HorizontalViewHolder(View itemView) {
            super(itemView);
            /*  cardImage = itemView.findViewById(R.id.image);*/
            cardTitle = itemView.findViewById(R.id.text);
            VanderName = itemView.findViewById(R.id.VanderName);
            Mini_Order = itemView.findViewById(R.id.Mini_Order);
            D_Time = itemView.findViewById(R.id.D_Time);
            Banner = itemView.findViewById(R.id.Banneer);
            Logo = itemView.findViewById(R.id.Logo);
            RatingBar = itemView.findViewById(R.id.RatingBar);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, Teacher_DetailsActivity.class);
                    context.startActivity(intent);

                }
            });
        }
    }
}
