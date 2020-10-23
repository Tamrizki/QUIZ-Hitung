package tam.pa.quizhitung.activity.learnPage.adapter;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

import tam.pa.quizhitung.fragment.learnPembagian.PembagianFragment;
import tam.pa.quizhitung.fragment.learnPengurangan.PenguranganFragment;
import tam.pa.quizhitung.fragment.learnPenjumlahan.PenjumlahanFragment;
import tam.pa.quizhitung.fragment.learnPerkalian.PerkalianFragment;
import tam.pa.quizhitung.model.LearnItem;

public class LearnPageAdapter extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 4;
    private List<LearnItem> learnItemList;
    public LearnPageAdapter(@NonNull FragmentManager fm, List<LearnItem> listMateri) {
        super(fm);
        this.learnItemList = listMateri;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new PenjumlahanFragment(learnItemList.get(0));
            case 1:
                return new PenguranganFragment(learnItemList.get(1));
            case 2:
                return new PerkalianFragment(learnItemList.get(2));
            case 3:
                return new PembagianFragment(learnItemList.get(3));
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }
}
