package com.okre.appeightdday

import android.app.DatePickerDialog
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.ImageView
import android.widget.TextView
import java.util.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*------------------------------------------------------------------------------------------
        * 이미지 뷰 흑백
        ------------------------------------------------------------------------------------------*/
        val image = findViewById<ImageView>(R.id.image)
        image.colorFilter = ColorMatrixColorFilter(ColorMatrix().apply { setSaturation(0f)})

        /*------------------------------------------------------------------------------------------
        * DatePickerDialog
        ------------------------------------------------------------------------------------------*/
        val startBtn = findViewById<Button>(R.id.startBtn)
        val endBtn = findViewById<Button>(R.id.endBtn)
        val dDay = findViewById<TextView>(R.id.dDay)

        //Calendar.getInstance() : 현재시간을 담고있는 Calendar 객체를 리턴
        val calendarStart = Calendar.getInstance()
        val calendarEnd = Calendar.getInstance()

        startBtn.setOnClickListener {
            val today = GregorianCalendar()
            val year = today.get(Calendar.YEAR)
            val month = today.get(Calendar.MONTH)
            val day = today.get(Calendar.DATE)

            val dlg = DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener{
                override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
                    // set(year: Int, month: Int, date: Int)
                    calendarStart.set(p1, p2+1, p3)
                }
            }, year, month, day)
            dlg.show()
        }

        endBtn.setOnClickListener {
            val today = GregorianCalendar()
            val year = today.get(Calendar.YEAR)
            val month = today.get(Calendar.MONTH)
            val day = today.get(Calendar.DATE)

            val dlg = DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener{
                override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
                    calendarEnd.set(p1, p2+1, p3)

                    // TimeUnit 메소드 MILLISECONDS 밀리세컨드를 Day로 변환
                    val finalDate = TimeUnit.MILLISECONDS.toDays(calendarEnd.timeInMillis - calendarStart.timeInMillis)
                    dDay.setText(finalDate.toString())
                }
            }, year, month, day)
            dlg.show()
        }
    }
}