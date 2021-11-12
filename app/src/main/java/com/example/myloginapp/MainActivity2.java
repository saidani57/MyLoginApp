package com.example.myloginapp;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;


public class MainActivity2 extends AppCompatActivity {

ImageView imageView;
Button button;

FirebaseStorage firebaseStorage ;
StorageReference storageReference;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        imageView=(ImageView) findViewById(R.id.imageView2);
        button=(Button)findViewById(R.id.button);



        button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            downloadViaUrl();
        }
        });
    }

        public void downloadViaUrl(){


            StorageReference imageRef=FirebaseStorage.getInstance().getReference().child("opencv75.png");
            imageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                    Glide.with(MainActivity2.this).load(uri).error(R.drawable.ic_launcher_background).into(imageView);

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                }
            });
        }

    }



