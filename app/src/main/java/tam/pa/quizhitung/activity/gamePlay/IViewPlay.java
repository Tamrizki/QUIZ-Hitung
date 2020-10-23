package tam.pa.quizhitung.activity.gamePlay;

interface IViewPlay {
    void onGetHasil(int jawaban, int val1, int val2, int hasil1, int hasil2, int hasil3, int hasil4, String type);
    void onNextLevel(int level, int duration);
    void onJawaban(boolean hasil);
}
