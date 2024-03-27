package com.example.androidsample1


import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.CompoundButton
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import com.google.android.material.switchmaterial.SwitchMaterial

class MainActivity : AppCompatActivity() {
  //メディアプレーヤープロパティ
    private var _player:MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Intentから通知のタップからの引き継ぎデータを取得。
        val fromNotification = intent.getBooleanExtra("fromNotification", false)
        //引き継ぎデータが存在、つまり通知のタップからならば…
        if(fromNotification) {
            //再生ボタンをタップ不可に、停止ボタンをタップ可に変更。
            val btPlay = findViewById<Button>(R.id.btPlay)
            val btStop = findViewById<Button>(R.id.btStop)
            btPlay.isEnabled = false
            btStop.isEnabled = true
        }
    }

    fun onPlayButtonClick(view: View){
        var intent = Intent(this@MainActivity,SoundManageService::class.java)

        startService(intent)

        val btPlay =findViewById<Button>(R.id.btPlay)
        val btStop =findViewById<Button>(R.id.btStop)

        btPlay.isEnabled = false
        btStop.isEnabled = true

    }

    fun onStopButtonClick(view: View){
        //インテントオブジェクトを生成。
        val intent = Intent(this@MainActivity, SoundManageService::class.java)
        //サービスを停止。
        stopService(intent)
        //再生ボタンをタップ可に、停止ボタンをタップ不可に変更。
        val btPlay = findViewById<Button>(R.id.btPlay)
        val btStop = findViewById<Button>(R.id.btStop)
        btPlay.isEnabled = true
        btStop.isEnabled = false
    }



}
