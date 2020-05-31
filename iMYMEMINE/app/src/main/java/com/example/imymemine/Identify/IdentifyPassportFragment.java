package com.example.imymemine.Identify;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.imymemine.CameraActivity;
import com.example.imymemine.EmailActivity;
import com.example.imymemine.R;

public class IdentifyPassportFragment extends Fragment {
    private TextView passportText;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view;

        view = inflater.inflate(R.layout.fragment_identify_passport, container, false);
        passportText = (TextView) view.findViewById(R.id.passportText);

        passportText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder ad = new AlertDialog.Builder(getActivity());
                ad.setTitle("여권인증");       // 제목 설정
                ad.setMessage("여권을 등록하시겠습니까?");   // 내용 설정
                // 확인 버튼 설정
                ad.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();     //닫기
                        Intent intent = new Intent(getActivity(), CameraActivity.class);
                        startActivity(intent);
                        // Event
                    }
                });
                ad.setNegativeButton("아니요", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();     //닫기
                        // Event
                    }
                });
                ad.create();
                ad.show();
            }
        });
        return view;
    }
}
