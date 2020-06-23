package com.example.imymemine.Identify;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.example.imymemine.R;


public class IdentifyStudentFragment extends Fragment {
    private TextView studentText;
    private static final int VERIFY_PERMISSIONS_REQUEST = 1;
    private static final int CAMERA_REQUEST_CODE = 5;
    public static final String[] PERMISSIONS = {
            Manifest.permission.CAMERA
    };
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view;

        view = inflater.inflate(R.layout.fragment_identify_student, container, false);

        studentText = (TextView) view.findViewById(R.id.studentText);

        studentText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder ad = new AlertDialog.Builder(getActivity());
                ad.setTitle("학생증 인증");       // 제목 설정
                ad.setMessage("학생증을 등록하시겠습니까?");   // 내용 설정
                // 확인 버튼 설정
                ad.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();     //닫기
                        // Event
                        if (((IdentifyActivity) getActivity()).checkPermissions(Manifest.permission.CAMERA)) {
                            System.out.println("1번실행");
                            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            startActivityForResult(cameraIntent, CAMERA_REQUEST_CODE);
                        } else {
                            System.out.println("2번실행");
                            ActivityCompat.requestPermissions(getActivity(),PERMISSIONS
                                    ,
                                    VERIFY_PERMISSIONS_REQUEST
                            );
//                            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                            startActivityForResult(cameraIntent, CAMERA_REQUEST_CODE);
//                            Intent intent = new Intent(getActivity(),IdentifyActivity.class);
//                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                            startActivity(intent);

                        }

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
