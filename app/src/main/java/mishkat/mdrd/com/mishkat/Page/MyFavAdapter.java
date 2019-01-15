package mishkat.mdrd.com.mishkat.Page;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import mishkat.mdrd.com.mishkat.Fragment.BoutiquesFragment;
import mishkat.mdrd.com.mishkat.Fragment.ProductsFragment;
/**
 * Created by Deepak Jaiswal on 15-0-2019.
 */

public class MyFavAdapter extends FragmentPagerAdapter {

    private Context myContext;
    int totalTabs;

    public MyFavAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                BoutiquesFragment homeFragment = new BoutiquesFragment();
                return homeFragment;
            case 1:
                ProductsFragment sportFragment = new ProductsFragment();
                return sportFragment;
            default:
                return null;
        }
    }
    // this counts total number of tabs
    @Override
    public int getCount() {
        return totalTabs;
    }


}
