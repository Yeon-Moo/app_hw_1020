package com.example.app_hw_1020

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ed_name = findViewById<EditText>(R.id.ed_name)
        val tv_test = findViewById<TextView>(R.id.tv_test)
        val btn_scissor = findViewById<RadioButton>(R.id.btn_scissor)
        val btn_paper = findViewById<RadioButton>(R.id.btn_paper)
        val btn_stone = findViewById<RadioButton>(R.id.btn_stone)
        val btn_mora = findViewById<Button>(R.id.btn_mora)
        val tv_name = findViewById<TextView>(R.id.tv_name)
        val tv_winner = findViewById<TextView>(R.id.tv_winner)
        val tv_mmora = findViewById<TextView>(R.id.tv_mmora)
        val tv_cmora = findViewById<TextView>(R.id.tv_cmora)

        btn_mora.setOnClickListener {
            if (ed_name.length() < 1) {
                tv_test.text = String.format("請確實輸入玩家姓名！！！")
                tv_name.text = String.format("名字")
                tv_mmora.text = String.format("我方出拳")
                tv_cmora.text = String.format("電腦出拳")
                tv_winner.text = String.format("勝利者")
            } else {
                tv_name.text = String.format("名字\n%s", ed_name.text)
                if (btn_scissor.isChecked) {
                    tv_mmora.text = String.format("我方出拳\n剪刀")
                } else if (btn_paper.isChecked) {
                    tv_mmora.text = String.format("我方出拳\n布")
                } else {
                    tv_mmora.text = String.format("我方出拳\n石頭")
                }

                val computer: Int = (Math.random() * 3).toInt()

                if (computer == 0)
                    tv_cmora.text = String.format("電腦出拳\n剪刀")
                else if (computer == 1)
                    tv_cmora.text = String.format("電腦出拳\n石頭")
                else
                    tv_cmora.text = String.format("電腦出拳\n布")
                if ((btn_scissor.isChecked && computer == 2) ||
                    (btn_stone.isChecked && computer == 0) ||
                    (btn_paper.isChecked && computer == 1)
                ) {
                    tv_winner.text = String.format("勝利者\n%s", ed_name.text.toString())
                    tv_test.text = "恭喜，你是大贏家！！！！"
                } else if ((btn_scissor.isChecked && computer == 1) ||
                    (btn_stone.isChecked && computer == 2) ||
                    (btn_paper.isChecked && computer == 0)
                ) {
                    tv_winner.text = String.format("勝利者\n電腦")
                    tv_test.text = "可惜，電腦獲勝了!"
                } else {
                    tv_winner.text = String.format("勝利者\n平手")
                    tv_test.text = "平局，請再試一次!"
                }
            }
        }
    }
}