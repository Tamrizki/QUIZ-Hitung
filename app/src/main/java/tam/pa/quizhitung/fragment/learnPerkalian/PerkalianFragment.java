package tam.pa.quizhitung.fragment.learnPerkalian;

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

public class PerkalianFragment extends Fragment {
    LearnItem dataMateri;
    public PerkalianFragment(LearnItem learnItem) {
        this.dataMateri = learnItem;
    }
    @BindView(R.id.ivImage)
    ImageView ivImage;
    @BindView(R.id.ivTheory) ImageView ivTheory;
    @BindView(R.id.tvTitleMateri)
    TextView tvTitleMateri;
    @BindView(R.id.tvMateri) TextView tvMateri;
    @BindView(R.id.tvSecondMateri) TextView tvSecondMateri;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_perkalian, container, false);
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