package com.example.clinic_kursach;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import butterknife.ButterKnife;

public class BookingActivity extends AppCompatActivity {

    ViewPager2 viewPager;
    Button btnPre, btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        ButterKnife.bind(BookingActivity.this);

        viewPager = findViewById(R.id.view_pager);
        btnPre = findViewById(R.id.buttonPrevious);
        btnNext = findViewById(R.id.buttonNext);

        setColorButton();

        try{
        viewPager.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager(),null));}
        catch (Exception e){
            System.out.println("Ошибка: " + e.getMessage().toString());      }
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if (position == 0)
                    btnPre.setEnabled(false);
                else
                    btnPre.setEnabled(true);

                setColorButton();
            }
        }
        );
    }

    private void setColorButton() {
        if (btnNext.isEnabled()) {
            btnNext.setBackgroundResource(R.color.red);
        }
        else {
            btnNext.setBackgroundResource(android.R.color.darker_gray);
        }

        if (btnPre.isEnabled()) {
            btnPre.setBackgroundResource(R.color.red);
        }
        else {
            btnPre.setBackgroundResource(android.R.color.darker_gray);
        }
    }

}