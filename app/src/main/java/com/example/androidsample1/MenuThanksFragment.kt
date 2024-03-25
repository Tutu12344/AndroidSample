package com.example.androidsample1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
class MenuThanksFragment : Fragment(R.layout.fragment_menu_thanks) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 定食名と金額を取得。
        val menuName = arguments?.getString("menuName") ?: ""
        val menuPrice = arguments?.getString("menuPrice") ?: ""
        // 定食名と金額を表示させるTextViewを取得。
        val tvMenuName = view.findViewById<TextView>(R.id.tvMenuName)
        val tvMenuPrice = view.findViewById<TextView>(R.id.tvMenuPrice)
        // TextViewに定食名と金額を表示。
        tvMenuName.text = menuName
        tvMenuPrice.text = menuPrice

        // 戻るボタンを取得。
        val btBackButton = view.findViewById<Button>(R.id.btThxBack)
        // 戻るボタンにリスナを登録。
        btBackButton.setOnClickListener(ButtonClickListener())
    }

    /**
     * ［リストに戻る］ボタンが押されたときの処理が記述されたメンバクラス。
     */
    private inner class ButtonClickListener : View.OnClickListener {
        override fun onClick(view: View) {
            // 自分が所属するアクティビティがnullじゃないなら…
            activity?.let {
                // 自分が所属するアクティビティからfragmentMainContainerを取得。
                val fragmentMainContainer = it.findViewById<View>(R.id.fragmentMainContainer)
                // fragmentMainContainerが存在するなら…
                if(fragmentMainContainer != null) {
                    // バックスタックのひとつ前の状態に戻る。
                    parentFragmentManager.popBackStack()
                }
                // fragmentMainContainerが存在しないなら…
                else {
                    // フラグメントトランザクションの開始。
                    val transaction = parentFragmentManager.beginTransaction()
                    // フラグメントトランザクションが正しく動作するように設定。
                    transaction.setReorderingAllowed(true)
                    // 自分自身を削除。
                    transaction.remove(this@MenuThanksFragment)
                    // フラグメントトランザクションのコミット。
                    transaction.commit()
                }
            }
        }
    }
}
