package tam.pa.quizhitung.activity.gamePlay;

import android.content.Context;
import android.util.Log;

import java.util.Random;

import tam.pa.quizhitung.dialog.DialogGagal;

public class GamePlayPresenter {
    private Context context;
    private IViewPlay iViewPlay;
    private int val1 = 0, val2 = 0, indextRandom = 0, operasi = 0, hasil = 0;
    private int duration;
    private boolean checkValue = true;
    private Random random = new Random();
    private Integer[] result = new Integer[4];
    private String simbol = "";
    public GamePlayPresenter(Context context, IViewPlay iViewPlay) {
        this.context = context;
        this.iViewPlay = iViewPlay;
    }

    void onOperation(int level){
        indextRandom = random.nextInt(4);
        operasi = random.nextInt(3);
        Log.d("cekOperasi", String.valueOf(operasi));
        checkValue = true;
        while (checkValue){
            val1 = random.nextInt(100);
            val2 = random.nextInt(100);
            if (val1 > val2){
                checkValue = false;
            }
        }
        if (operasi == 0){
//            0 = penjumlahan
            this.hasil = val1 + val2;
            simbol = "+";
        }else if (operasi == 1){
//            1 = pengurangan
            this.hasil = val1 - val2;
            simbol = "-";
        }else{
//            2 = perkalian
            val1 = random.nextInt(10);
            val2 = random.nextInt(10);
            this.hasil = val1*val2;
            simbol = "*";
        }
        for (int j = 0; j < 4; j++) {
            if (j == indextRandom){
                result[j] = hasil;
                Log.d("isiHasil", j+" "+result[j]+" / hasil = "+hasil);
            }else {
                result[j] = random.nextInt(200);
            }
        }
        if (level == 1){
            duration = 10000;
        }else if (level == 2){
            duration = 7000;
        }else {
            duration = 5000;
        }

        iViewPlay.onGetHasil(hasil, val1, val2, result[0], result[1], result[2], result[3], simbol);
        iViewPlay.onNextLevel(level, duration);
    }

    void onKoreksi(int hasil, int jawaban){
        if (jawaban == hasil){
            iViewPlay.onJawaban(true);
        }else {
            iViewPlay.onJawaban(false);
        }
    }
}
