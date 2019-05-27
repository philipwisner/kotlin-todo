package com.example.todo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val initalTextViewTranslationY = textView_progress.translationY

        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                textView_progress.text = progress.toString()

                val translationDistance = (initalTextViewTranslationY +
                        progress * resources.getDimension(R.dimen.text_anim_step) * -1)

                textView_progress.animate().translationY(translationDistance)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })

        button_reset.setOnClickListener { v ->
            seekBar.progress = 0
            textView_progress.animate().setDuration(500).rotationBy(360f)
                .translationY(initalTextViewTranslationY)
        }
    }
}
