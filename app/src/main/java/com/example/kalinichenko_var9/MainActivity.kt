package com.example.kalinichenko_var9

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etSize: EditText
    private lateinit var btnGenerate: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etSize = findViewById(R.id.etSize)
        btnGenerate = findViewById(R.id.btnGenerate)
        tvResult = findViewById(R.id.tvResult)

        btnGenerate.setOnClickListener {
            // Получаем размер массива из поля ввода (если не указан или неверен — используем 10)
            val size = etSize.text.toString().toIntOrNull() ?: 10

            // Генерируем массив (случайные числа от -3 до 3, например)
            val arr = ZeroFinder.generateArray(size = size, min = -3, max = 3)

            // Находим индексы нулевых элементов (функциональный стиль внутри ZeroFinder)
            val zeroIndices = ZeroFinder.findZeroIndices(arr)

            // Формируем строку для вывода
            val sb = StringBuilder()
            sb.append("Сгенерированный массив (size = $size):\n")
            sb.append(ZeroFinder.formatArray(arr)).append("\n\n")

            if (zeroIndices.isEmpty()) {
                sb.append("Нулевые элементы не найдены.")
            } else {
                sb.append("Индексы нулевых элементов (0-based):\n")
                sb.append(ZeroFinder.formatArray(zeroIndices))
            }

            tvResult.text = sb.toString()
        }
    }
}

