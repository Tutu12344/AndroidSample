package com.example.androidsample1

import android.annotation.SuppressLint
import android.app.AppComponentFactory
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidsample1.ui.theme.AndroidSample1Theme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //ListViewオブジェクトを取得。
        val lvMenu = findViewById<ListView>(R.id.lvMenu)
        //リストビューに表示するリストデータを作成。
        var menuList = mutableListOf("から揚げ定食", "ハンバーグ定食", "生姜焼き定食", "ステーキ定食", "野菜炒め定食", "とんかつ定食", "ミンチかつ定食", "チキンカツ定食", "コロッケ定食",  "回鍋肉定食", "麻婆豆腐定食", "青椒肉絲定食", "八宝菜定食", "酢豚定食", "豚の角煮", "焼き鳥", "焼き魚定食", "焼肉定食")
        //アダプタオブジェクトを生成。
        val adapter = ArrayAdapter(this@MainActivity, android.R.layout.simple_list_item_1, menuList)
        //リストビューにアダプタオブジェクトを設定。
        lvMenu.adapter = adapter

        lvMenu.onItemClickListener = ListItemClickListener()

    }

    private inner class ListItemClickListener:AdapterView.OnItemClickListener{
        override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
            var item = parent.getItemAtPosition(position) as String

            val dialogFrament = OrderConfirmDialogFrament()

            dialogFrament.show(supportFragmentManager,"OrderConfirmDialogFrament")
        }

    }
}
