package com.example.eduardocucharro.a3lab05;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    static String[] permissions = new String[]{
            Manifest.permission.CAMERA,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    private static final int REQUEST_CODE_PERMISSIONS = 1001;
    private static final int REQUEST_CODE_CAMERA = 1002;
    private static final int REQUEST_CODE_PICK_IMAGE = 1003;
    private static final String FILE_AUTHORITY = "br.com.cucha.fileprovider";
    private Uri uri;
    private AlertDialog unlockDialog;
    private AlertDialog disconnectDialog;
    private AlertDialog noSpaceDialog;
    private AlertDialog errorDialog;
    private AlertDialog chooserDialog;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.image_photo);
    }

    @Override
    public void onClick(View v) {
        //TODO verificar se app tem permissões camera e gravar no disco

        //TODO verificar se devo pedir permissoes

        //TODO verificar se tem disco suficiente

        //TODO verificar se o disco está disponivel

        //TODO tratar se tudo ocorreu como deveria
    }
}
