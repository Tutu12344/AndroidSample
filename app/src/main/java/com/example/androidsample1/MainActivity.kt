package com.example.androidsample1


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.Toast
import com.example.androidsample1.MenuThanksActivity
import com.example.androidsample1.R

class MainActivity : AppCompatActivity() {

    //リストビューに表示するリストデータ。
    private var _menuList: MutableList<MutableMap<String, Any>> = mutableListOf()
    //SimpleAdapterの第4引数fromに使用するプロパティ。
    private val _from = arrayOf("name", "price")
    //SimpleAdapterの第5引数toに使用するプロパティ。
    private val _to = intArrayOf(R.id.tvMenuNameRow, R.id.tvMenuPriceRow)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        _menuList = createTeishokuList()
        // 画面部品ListViewを取得
        val lvMenu = findViewById<ListView>(R.id.lvMenu)
        // SimpleAdapterを生成。
        val adapter = SimpleAdapter(this@MainActivity, _menuList,R.layout.row, _from, _to)
        // アダプタの登録。
        lvMenu.adapter = adapter
        // リストタップのリスナクラス登録。
        lvMenu.onItemClickListener = ListItemClickListener()

        registerForContextMenu(lvMenu)
    }

    /**
     * リストがタップされたときの処理が記述されたメンバクラス。
     */
    private inner class ListItemClickListener : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
            // タップされた行のデータを取得。SimpleAdapterでは1行分のデータはMutableMap型!
            val item = parent.getItemAtPosition(position) as MutableMap<String, Any>

            order(item)
           }
    }

    private fun createTeishokuList() : MutableList<MutableMap<String,Any>>{
        val menuList:MutableList<MutableMap<String,Any>> = mutableListOf()

        var menu = mutableMapOf<String,Any>("name" to "から揚げ定食", "price" to 800,"desc" to "若鳥のから揚げにサラダ、ごはんとお味噌汁が付きます")
        menuList.add(menu)
        // 「ハンバーグ定食」のデータを格納するMapオブジェクトの用意とmenuListへのデータ登録。
        menu = mutableMapOf<String,Any>("name" to "ハンバーグ定食", "price" to 850,"desc" to "手ごねハンバーグにごはんとお味噌汁が付きます")
        menuList.add(menu)

        return menuList

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_options_menu_list,menu)
        return  true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var returnVal = true

        when(item.itemId){
            R.id.menuListOptionTeishoku ->
                    _menuList = createTeishokuList()
            R.id .menuListOptionCurry ->
                    _menuList = createCurryList()
            else ->
                returnVal = super.onOptionsItemSelected(item)
        }
        // 画面部品ListViewを取得
        val lvMenu = findViewById<ListView>(R.id.lvMenu)
        // SimpleAdapterを生成。
        val adapter = SimpleAdapter(this@MainActivity, _menuList,R.layout.row, _from, _to)
        // アダプタの登録。
        lvMenu.adapter = adapter

        return  returnVal
    }

    override fun onCreateContextMenu(
        menu: ContextMenu,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.menu_context_menu_list,menu)

        menu.setHeaderTitle(R.string.menu_list_context_header)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        var returnVal = true
        val info = item.menuInfo as AdapterView.AdapterContextMenuInfo

        val listPosition = info.position

        val menu = _menuList[listPosition]

        when(item.itemId){
            R.id.menuListContextDesc -> {
                val desc = menu["desc"] as String

                Toast.makeText(this@MainActivity,desc,Toast.LENGTH_LONG).show()
            }
            R.id.menuListContextOrder ->
                order(menu)

            else ->
                returnVal = super.onContextItemSelected(item)
        }
        return returnVal
    }

    private fun createCurryList(): MutableList<MutableMap<String,Any>>{
        //カレーメニューリスト用のListオブジェクトを用意。
        val menuList: MutableList<MutableMap<String, Any>> = mutableListOf()
        //「ビーフカレー」のデータを格納するMapオブジェクトの用意とmenuListへのデータ登録。
        var menu = mutableMapOf<String, Any>("name" to "ビーフカレー", "price" to 520, "desc" to "特選スパイスをきかせた国産ビーフ100%のカレーです。")
        menuList.add(menu)
        //「ポークカレー」のデータを格納するMapオブジェクトの用意とmenuListへのデータ登録。
        menu = mutableMapOf("name" to "ポークカレー", "price" to 420, "desc" to "特選スパイスをきかせた国産ポーク100%のカレーです。")
        menuList.add(menu)
        return menuList
    }

    private fun order(menu:MutableMap<String,Any>){
        // 定食名と金額を取得。
        val menuName = menu["name"] as String
        val menuPrice = menu["price"] as Int
        // インテントオブジェクトを生成。
        val intent2MenuThanks = Intent(this@MainActivity, MenuThanksActivity::class.java)
        // 第2画面に送るデータを格納。
        intent2MenuThanks.putExtra("menuPrice", "${menuPrice}円")
        intent2MenuThanks.putExtra("menuName", "menuName")

        // 第2画面の起動。
        startActivity(intent2MenuThanks)
    }
}
