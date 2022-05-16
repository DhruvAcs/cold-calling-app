package com.example.coldcallingapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RandomFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Student[] students = ((GlobalClass)getActivity().getApplication()).getStudents();
        View v = inflater.inflate(R.layout.fragment_random, container, false);
        ImageView studentImage = v.findViewById(R.id.image_view_student);
         TextView studentText = v.findViewById((R.id.text_view_student));
        Context context = studentImage.getContext();
        Button studentButton = v.findViewById(R.id.button_view_student);
        studentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int rand = (int)(Math.random()* students.length);
                Student picked = students[rand];

                while (picked.getTimesCalled() == 2 && System.currentTimeMillis() - picked.getLastcalled() <= 2400000){
                    rand = (int)(Math.random()* students.length);
                    picked = students[rand];
                }

                Glide.with(context).load(context.getResources().getIdentifier(picked.getFileName(),"drawable", context.getPackageName())).into(studentImage);
                if (picked.getTimesCalled() == 1) picked.setTimesCalled(2);
                else {
                    picked.setTimesCalled((1));
                    picked.setLastcalled(System.currentTimeMillis());
                }
                ((GlobalClass)getActivity().getApplication()).getUncalled().remove(picked);
                Date now = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("K:mm");
                ((GlobalClass)getActivity().getApplication()).getCalled().add(0,sdf.format(now) + " " + picked);

            }
        });
        return v;
    }
}
