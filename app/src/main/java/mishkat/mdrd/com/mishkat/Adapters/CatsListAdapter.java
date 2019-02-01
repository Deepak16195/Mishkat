package mishkat.mdrd.com.mishkat.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;

import mishkat.mdrd.com.mishkat.DeskBoardsPages.Models.CatsModel;
import mishkat.mdrd.com.mishkat.R;

/**
 * Created by rahuljanagouda on 04/11/17.
 */

public class CatsListAdapter extends RecyclerView.Adapter<CatsListAdapter.HorizontalViewHolder> {

    private List<CatsModel.ResultEntity> list;
    Context mcontext;
    public  List<CatsModel.ResultEntity> ListFiltered;

    @Override
    public HorizontalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cats_list_row, parent, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
        return new HorizontalViewHolder(view);

    }

    public CatsListAdapter(Context context, List<CatsModel.ResultEntity> mlist) {
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
        public RadioButton rowCheckbox;

        public HorizontalViewHolder(View itemView) {
            super(itemView);
            /*  cardImage = itemView.findViewById(R.id.image);*/
            cardTitle = itemView.findViewById(R.id.Cat_Name);
            rowCheckbox = (RadioButton) itemView.findViewById(R.id.rowCheckbox);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (rowCheckbox.isChecked()) {
                        rowCheckbox.setChecked(false);
                    } else {
                        rowCheckbox.setChecked(true);
                    }
                }
            });


        }
    }
}
