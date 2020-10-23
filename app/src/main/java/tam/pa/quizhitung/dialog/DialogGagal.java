package tam.pa.quizhitung.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import androidx.annotation.NonNull;

import butterknife.BindView;
import butterknife.ButterKnife;
import tam.pa.quizhitung.R;
import tam.pa.quizhitung.activity.gamePlay.GamePlayActivity;
import tam.pa.quizhitung.activity.homePage.HomeActivity;

public class DialogGagal extends Dialog implements View.OnClickListener {
    private Context context;
    @BindView(R.id.btnKembali) Button btnKembali;
    @BindView(R.id.btnNext) Button btnMainLagi;
    public DialogGagal(@NonNull Context context) {
        super(context);
        this.context = context;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.dialog_gagal);
        ButterKnife.bind(this);
        btnKembali.setOnClickListener(this);
        btnMainLagi.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == btnKembali){
            context.startActivity(new Intent(context, HomeActivity.class));
            dismiss();
        }
        else if (view == btnMainLagi){
            context.startActivity(new Intent(context, GamePlayActivity.class));
            dismiss();
        }
    }
}
