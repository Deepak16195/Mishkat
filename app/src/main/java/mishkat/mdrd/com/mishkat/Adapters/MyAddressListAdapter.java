package mishkat.mdrd.com.mishkat.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import mishkat.mdrd.com.mishkat.Address.EditAddreessActivity;
import mishkat.mdrd.com.mishkat.Address.Model.MyAddressModel;
import mishkat.mdrd.com.mishkat.Address.My_AddressActivity;
import mishkat.mdrd.com.mishkat.Data.SharePrefarence;
import mishkat.mdrd.com.mishkat.DeskBoardsPages.Item_list_Activity;
import mishkat.mdrd.com.mishkat.DeskBoardsPages.Models.VendorDetailModel;
import mishkat.mdrd.com.mishkat.R;
import mishkat.mdrd.com.mishkat.UtilsTools.UtilsTool;
import mishkat.mdrd.com.mishkat.api.API;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by rahuljanagouda on 04/11/17.
 */

public class MyAddressListAdapter extends RecyclerView.Adapter<MyAddressListAdapter.HorizontalViewHolder> {

    private List<MyAddressModel.ResultEntity> list;
    Context mcontext;
    public  List<MyAddressModel.ResultEntity> ListFiltered;

    @Override
    public HorizontalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.myaddress_list_item, parent, false);
        return new HorizontalViewHolder(view);
    }

    public MyAddressListAdapter(Context context, List<MyAddressModel.ResultEntity> mlist) {
        this.list = mlist;
        this.mcontext = context;
        this.ListFiltered = mlist;
    }

    @Override
    public void onBindViewHolder(HorizontalViewHolder holder, final int position) {
       /* holder.cardImage.setImageResource(R.drawable.phungdemac);*/
        holder.cardTitle.setText(ListFiltered.get(position).getTitle());

        holder.Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Context context = v.getContext();
                Intent intent = new Intent(context, EditAddreessActivity.class);
                EditAddreessActivity.Addressid = ListFiltered.get(position).getAddress_id();
                context.startActivity(intent);

            }
        });


        holder.Delete_Addreess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(mcontext);
                alertDialog.setMessage("This will Delete the Adreess . Are you sure you want to do it?");
                alertDialog.setPositiveButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // DO SOMETHING HERE
                        dialog.dismiss();
                    }
                });
                alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String Userid = SharePrefarence.getmInstance(mcontext).getUserId() + "";
                        String mealid = ListFiltered.get(position).getAddress_id();
                        DeleteAddress(Userid, mealid, position);

                    }
                });
                AlertDialog dialog = alertDialog.create();
                dialog.show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return ListFiltered.size();
    }

    class HorizontalViewHolder extends RecyclerView.ViewHolder {
        ImageView cardImage,Delete_Addreess,Edit;
        TextView cardTitle;
        public HorizontalViewHolder(View itemView) {
            super(itemView);
            Delete_Addreess = itemView.findViewById(R.id.Delete_Addreess);
            cardTitle = itemView.findViewById(R.id.text);
            Edit = itemView.findViewById(R.id.Edit);
           /* itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Context context = v.getContext();
                    Intent intent = new Intent(context, Item_list_Activity.class);
                    context.startActivity(intent);

                }
            });*/
        }
    }

    public void removeAt(int position) {
        ListFiltered.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, ListFiltered.size());
    }

    private void DeleteAddress(String userid, String AddrresId, final int position) {
        API.getAPIService().Remove_Address(userid,AddrresId).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MyAddressModel>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        UtilsTool.custoAlert(mcontext,e.getMessage());
                    }

                    @Override
                    public void onNext(MyAddressModel response) {
                        UtilsTool.hideProgressDialog();
                        if (response.getStatus()) {
                            removeAt(position);
                            Toast.makeText(mcontext, "Address Removed!", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}
