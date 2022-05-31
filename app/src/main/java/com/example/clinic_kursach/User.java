package com.example.clinic_kursach;

import android.widget.EditText;

public class User {
    public String polis;
    public String surname;
    public String name;
    public String fromfather;
    public String email;

    public User() {

    }

    public User (String polis, String surname, String name, String fromfather, String email) {
        this.polis = polis;
        this.surname = surname;
        this.name = name;
        this.fromfather = fromfather;
        this.email = email;
    }
    
}
