package com.alyndroid.architecturepatternstutorialshomework;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alyndroid.architecturepatternstutorialshomework.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener , CalculView{
    Button btnPlus;
    TextView tvPlus;
    DataBase db ;
    @BindView(R.id.div_result_textView) TextView tvDiv ;
    @BindView(R.id.div_button) Button btnDiv ;
    CalculPresenter presenter ;
    CalculMultViewModel viewModel ;
    ActivityMainBinding binding ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DataBase();
        presenter = new CalculPresenter(this);
        binding = DataBindingUtil.setContentView(this , R.layout.activity_main );
        viewModel = ViewModelProviders.of(this).get(CalculMultViewModel.class);
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);

        ButterKnife.bind(this);
        btnPlus = findViewById(R.id.plus_button);
        tvPlus = findViewById(R.id.plus_result_textView);
        btnPlus.setOnClickListener(this);
        btnDiv.setOnClickListener(this);




    }
    public int CalculPlusArith(){
        int result =   ( db.getNumbers().getFirstNum() )+  ( db.getNumbers().getSecondNum());
        return result ;
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.plus_button){
            tvPlus.setText(CalculPlusArith() +"");
        }else if(view.getId() == R.id.div_button){
            presenter.CalculDivArith();
        }
    }

    @Override
    public void onGetDivCalcul(int result) {
        tvDiv.setText(result +"");
    }
}
