package com.alyndroid.architecturepatternstutorialshomework;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CalculMultViewModel extends ViewModel {
    public MutableLiveData<String> multResMutableLiveData = new MutableLiveData<>();
    public void getMultipleDev(){
        DataBase db = new DataBase();
        int result = (db.getNumbers().getFirstNum()) * (db.getNumbers().getSecondNum());
        multResMutableLiveData.setValue(result+"");
    }

}
