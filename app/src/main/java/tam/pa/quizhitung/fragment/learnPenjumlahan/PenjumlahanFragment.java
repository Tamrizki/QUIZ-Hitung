package tam.pa.quizhitung.fragment.learnPenjumlahan;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import tam.pa.quizhitung.R;
import tam.pa.quizhitung.model.LearnItem;

public class PenjumlahanFragment extends Fragment {
    private LearnItem dataMateri;
    public PenjumlahanFragment(LearnItem data) {
        this.dataMateri = data;
    }
    @BindView(R.id.ivImage) ImageView ivImage;
    @BindView(R.id.ivTheory) ImageView ivTheory;
    @BindView(R.id.tvTitleMateri) TextView tvTitleMateri;
    @BindView(R.id.tvMateri) TextView tvMateri;
    @BindView(R.id.tvSecondMateri) TextView tvSecondMateri;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_penjumlahan, container, false);
        ButterKnife.bind(this, view);
        setContent();
        return view;
    }

    private void setContent() {
        Picasso.with(getActivity())
                .load(dataMateri.getImage())
                .fit()
                .into(ivImage);
        Picasso.with(getActivity())
                .load(dataMateri.getImgTheory())
                .fit()
                .into(ivTheory);
        tvTitleMateri.setText(dataMateri.getTitle());
        tvMateri.setText(dataMateri.getFirstDescription());
        tvSecondMateri.setText(dataMateri.getSecondDecription());
    }
}