package com.example.clinic_kursach;

import java.util.List;
import com.example.clinic_kursach.Polyclinic;

public interface IPolyLoadListener {
    void onPolyLoadSuccess(List<Polyclinic> polyclinicList);
    void onPolyLoadFailed(String message);
}
