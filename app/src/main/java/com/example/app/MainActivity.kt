  package com.example.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

  class MainActivity : AppCompatActivity() {
      // 保存抽奖名单
      val names = listOf<String>("李进","王澳冲","韩铭书")

      // 定时器 每隔一段时间切换一次名字
      lateinit var timer: Timer

      // 记录当前索引
      var index = 0;

      override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init(){
        // 设置默认显示第一个人
        mNameTextView.text = names[index]

        // 给按钮添加点击事件
        mStartBtn.setOnClickListener{
            // 判断是Start还是Stop
            if (mStartBtn.text.toString() == "START"){
                mStartBtn.text = "STOP"
                // 创建定时器
                timer = Timer()
                // 设置分配一个定时任务
                timer.schedule(object: TimerTask(){
                    override fun run() {
                        // 判断是否越界
                        index = if (index+1 > names.size-1) 0 else index+1
                        // 取出对应名字
                        mNameTextView.text = names[index]
                        // 改变索引值
                    }
                },0,100)
            }else{
                mStartBtn.text = "START"
                timer.cancel()
            }
        }
    }
}