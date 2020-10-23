package tam.pa.quizhitung.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import butterknife.BindView;
import butterknife.ButterKnife;
import tam.pa.quizhitung.R;
import tam.pa.quizhitung.activity.gamePlay.GamePlayActivity;
import tam.pa.quizhitung.activity.homePage.HomeActivity;

public class DialogSuccess extends Dialog implements View.OnClickListener {
    private Context context;
    @BindView(R.id.tvLevel) TextView tvLevel;
    @BindView(R.id.btnKembali) Button btnKembali;
    @BindView(R.id.btnNext) Button btnNext;
    private int level = 0;
    public DialogSuccess(@NonNull Context context, int level) {
        super(context);
        this.context = context;
        this.level = level;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.dialog_success);
        ButterKnife.bind(this);
        tvLevel.setText(String.valueOf(level));
        btnKembali.setOnClickListener(this);
        btnNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == btnKembali){
            context.startActivity(new Intent(context, HomeActivity.class));
            dismiss();
        }
        else if (view == btnNext){
            level++;
            Intent intent = new Intent(context, GamePlayActivity.class);
            intent.putExtra("level", level);
            context.startActivity(intent);
        }
    }
}
