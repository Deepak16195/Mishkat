package mishkat.mdrd.com.mishkat.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mishkat.mdrd.com.mishkat.Adapters.BoutiqesListAdapter;
import mishkat.mdrd.com.mishkat.Adapters.MyAddressListAdapter;
import mishkat.mdrd.com.mishkat.R;

/**
 * Created by Deepak Jaiswal on 15-0-2019.
 */
public class ProductsFragment extends Fragment {


    public ProductsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_products, container, false);
        RecyclerView verticalRecycle2 = view.findViewById(R.id.Row1);
        verticalRecycle2.setAdapter(new BoutiqesListAdapter());
        return view;
    }

}
