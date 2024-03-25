package com.example.androidsample1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.TextView
class MenuThanksActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_thanks)

        //戻るボタンの記載
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // リスト画面から渡されたデータを取得。
        val menuName = intent.getStringExtra("menuName")
        val menuPrice = intent.getStringExtra("menuPrice")
//		val extras = intent.extras
//		val menuName = extras?.getString("menuName") ?: ""
//		val menuPrice = extras?.getString("menuPrice") ?: ""

        // 定食名と金額を表示させるTextViewを取得。
        val tvMenuName = findViewById<TextView>(R.id.tvMenuName)
        val tvMenuPrice = findViewById<TextView>(R.id.tvMenuPrice)

        // TextViewに定食名と金額を表示。
        tvMenuName.text = menuName
        tvMenuPrice.text = menuPrice
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var returnVal = true
        //戻る選択時の処理
        if(item.itemId == android.R.id.home){
            finish()
        }else{
            returnVal = super.onOptionsItemSelected(item)
        }

        return returnVal
    }
}
