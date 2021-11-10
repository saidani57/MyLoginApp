package com.example.myloginapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.ktx.Firebase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;


public class MainActivity2 extends AppCompatActivity {
ImageView imageView;
Button button;
Firebase firebase;
FirebaseStorage firebaseStorage;
StorageReference storageReference;



/*    StorageReference imagesRef = storageRef.child("images");
    StorageReference spaceRef = storageRef.child("images/space.jpg");*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        imageView=(ImageView) findViewById(R.id.imageView2);
        button=(Button)findViewById(R.id.buttonSend);

        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReference();

button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
       download();
    }
});
    }

    public void Send(View view) {

    }

   /* public void download(){
        StorageReference imageRef=storageReference.child("image/capture.PNG");
        long MAXBYTES=400*400;
        imageRef.getBytes(MAXBYTES).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                int offset;
                Bitmap bitmap= BitmapFactory.decodeByteArray(bytes,offset= 0,bytes.length);
                imageView.setImageBitmap(bitmap);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
    }
*/
    public void downloadViaUrl(){
        StorageReference imageRef=storageReference.child("image/capture.PNG");
        imageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
    }

}