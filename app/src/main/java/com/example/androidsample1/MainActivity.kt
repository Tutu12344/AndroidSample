package com.example.androidsample1


import android.Manifest
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Color
import android.media.MediaPlayer
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.provider.MediaStore
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.CompoundButton
import android.widget.EditText
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.switchmaterial.SwitchMaterial
import java.net.URLEncoder
import java.text.SimpleDateFormat
import java.util.Date

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Toolbarを取得。
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        //ツールバーにロゴを設定。
        toolbar.setLogo(R.mipmap.ic_launcher)
        //ツールバーにタイトル文字列を設定。
        toolbar.setTitle(R.string.toolbar_title)
        //ツールバーのタイトル文字色を設定。
        toolbar.setTitleTextColor(Color.WHITE)
        //ツールバーのサブタイトル文字列を設定。
        toolbar.setSubtitle(R.string.toolbar_subtitle)
        //ツールバーのサブタイトル文字色を設定。
        toolbar.setSubtitleTextColor(Color.LTGRAY)
        //アクションバーにツールバーを設定。
        setSupportActionBar(toolbar)

//*       CollapsingToolbarLayoutの場合*/
        //Toolbarを取得。
//        val toolbar = findViewById<Toolbar>(R.id.toolbar)
//        //ツールバーにロゴを設定。
//        toolbar.setLogo(R.mipmap.ic_launcher)
//        setSupportActionBar(toolbar)
//
//        val toolbarLayout = findViewById<CollapsingToolbarLayout>(R.id.toolbar)
//        toolbarLayout.title = getString(R.string.toolbar_title)
//        toolbarLayout.setExpandedTitleColor(Color.WHITE)
//        toolbarLayout.setCollapsedTitleTextColor(Color.LTGRAY)

    }

}
