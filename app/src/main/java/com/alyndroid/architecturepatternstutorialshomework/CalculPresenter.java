package com.alyndroid.architecturepatternstutorialshomework;

public class CalculPresenter {
CalculView view ;

    public CalculPresenter(CalculView view) {
        this.view = view;
    }
   /* public void getMoviebyName(){
        view.onGetMovieName(getMovieName().getName());
    }*/
    public void CalculDivArith(){
        DataBase db = new DataBase();
       int result =   ( db.getNumbers().getFirstNum() ) /  ( db.getNumbers().getSecondNum());
     view.onGetDivCalcul(result);
    }
}
