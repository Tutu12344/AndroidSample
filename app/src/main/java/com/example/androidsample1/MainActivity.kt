package com.example.androidsample1


import android.Manifest
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
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
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.google.android.material.switchmaterial.SwitchMaterial
import java.net.URLEncoder
import java.text.SimpleDateFormat
import java.util.Date

class MainActivity : AppCompatActivity() {
    private val _cameraLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult(), ActivityResultCallbackFromCamera())
    private var _imageUri:Uri? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    // 画像部分がタップされたときの処理メソッド。
    fun onCameraImageClick(view: View) {

        val dataFormat = SimpleDateFormat("yyyyMMddHHmmss")
        val now = Date()
        val nowStr = dataFormat.format(now)
        val fileName = "CameraIntentSample_${nowStr}.jpg"

        val values = ContentValues()
        values.put(MediaStore.Images.Media.TITLE,fileName)
        values.put(MediaStore.Images.Media.MIME_TYPE,"image/jpeg")

        _imageUri = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,values)

        // Intentオブジェクトを生成。
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        intent.putExtra(MediaStore.EXTRA_OUTPUT,_imageUri)
        // アクティビティを起動。
        _cameraLauncher.launch(intent)
    }


    // Cameraアクティビティから戻ってきたときの処理が記述されたコールバッククラス。
    private inner class ActivityResultCallbackFromCamera : ActivityResultCallback<ActivityResult> {
        override fun onActivityResult(result: ActivityResult) {
            // カメラアプリで撮影成功の場合
            if(result.resultCode == RESULT_OK) {
                val lvCamera = findViewById<ImageView>(R.id.ivCamera)
                lvCamera.setImageURI(_imageUri)
                //カメラ撮影の処理
//                // 撮影された画像のビットマップデータを取得。
//                val bitmap = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//                    result.data?.getParcelableExtra("data", Bitmap::class.java)
//                }
//                else {
//                    result.data?.getParcelableExtra<Bitmap>("data")
//                }
//                // 画像を表示するImageViewを取得。
//                val ivCamera = findViewById<ImageView>(R.id.ivCamera)
//                // 撮影された画像をImageViewに設定。
//                ivCamera.setImageBitmap(bitmap)
            }
        }
    }

}
