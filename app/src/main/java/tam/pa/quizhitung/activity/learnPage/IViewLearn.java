package tam.pa.quizhitung.activity.learnPage;

import java.util.List;

import tam.pa.quizhitung.model.LearnItem;

interface IViewLearn {
    void onDataMateri(List<LearnItem> dataMateri);
    void onError(String msg);
}
