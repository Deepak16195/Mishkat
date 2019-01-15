package mishkat.mdrd.com.mishkat.Adapters;

import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import mishkat.mdrd.com.mishkat.R;

/**
 * Created by Deepak Jaiswal on 15-0-2019.
 */

public class SearchSheetDialog extends BottomSheetDialogFragment  {

    protected RecyclerView mRVAdditiondetails;
    protected View rootView;
    protected Button btnSearch;
    protected Button btnCancel;
    RecyclerView.LayoutManager mLayoutManager;
    EditText txtSearch;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.lay_search, container, false);



        return rootView;
    }








}