package pulkit.demo_real_parallex.com.demoimageslider.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pulkit.demo_real_parallex.com.demoimageslider.R;

/**
 * Created by pulkit on 08/12/2017.
 */
public class Fragment3 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.view_pager_item_3, container, false);
    }
}
