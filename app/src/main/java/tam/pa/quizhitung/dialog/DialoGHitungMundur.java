package tam.pa.quizhitung.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.Window;
import android.widget.TextView;

import androidx.annotation.NonNull;

import butterknife.BindView;
import butterknife.ButterKnife;
import tam.pa.quizhitung.R;
import tam.pa.quizhitung.activity.gamePlay.GamePlayActivity;

public class DialoGHitungMundur extends Dialog {
    private Context context;
    private CountDownTimer countDownTimer;
    @BindView(R.id.tvTime) TextView tvTime;
    private int sc = 5;
    public DialoGHitungMundur(@NonNull Context context) {
        super(context);
        this.context = context;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.dialog_hitung_mundur);
        ButterKnife.bind(this);
        SetTimer();
    }

    private void SetTimer() {
        countDownTimer = new CountDownTimer(4000, 1000) {
            @Override
            public void onTick(long l) {
                sc--;
                tvTime.setText(String.valueOf(sc));
            }
            @Override
            public void onFinish() {
                Intent intent = new Intent(context, GamePlayActivity.class);
                intent.putExtra("level", 1);
                context.startActivity(intent);
                dismiss();
            }
        };countDownTimer.start();
    }
}
