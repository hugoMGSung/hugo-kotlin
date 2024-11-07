package com.hugo83.fragmenttest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class ExampleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // fragment_example.xml을 사용하여 Fragment의 뷰를 생성
        val view = inflater.inflate(R.layout.fragment_example, container, false)

        // TextView와 Button을 참조
        val textView = view.findViewById<TextView>(R.id.fragmentTextView)
        val button = view.findViewById<Button>(R.id.changeTextButton)

        // Button 클릭 시 TextView의 텍스트를 변경
        button.setOnClickListener {
            textView.text = "Text Changed!"
        }

        return view
    }
}