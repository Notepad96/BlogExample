package com.example.imagelibcoil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import coil.load
import coil.size.*
import coil.transform.BlurTransformation
import coil.transform.CircleCropTransformation
import coil.transform.GrayscaleTransformation
import coil.transform.RoundedCornersTransformation
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        img_test01.load(R.drawable.img01) {
            // 1. Circle(둥글게) 처리 CircleCropTransformation()
//            transformations(CircleCropTransformation())

            // 2. Blur 처리 BlurTransformation(context, radius, sample)
            // radius: Blur 반경, sample: 이미지 크기를 조정. 기본값 1로 보다 큰값은 축소하며 작은값은 확대함
//           transformations(BlurTransformation(applicationContext, 1f, 1f))

            // 3. 회색 처리 GrayscaleTransformation()
            transformations(GrayscaleTransformation())

            // 4. 모서리 라운드 처리 RoundedCornersTransformation(topLeft, topRight, bottomLeft, bottomRight)
            // 모서리 4개의 각각의 코너 값 지정 가능
//            transformations(RoundedCornersTransformation(5f, 10f, 15f, 20f))
        }

        img_test02.load(R.drawable.img02) {
            placeholder(R.drawable.img03) // 대체 이미지
            error(R.drawable.img03) // Load Error 시 보여줄 이미지
            size(300)
        }

        btn_test.setOnClickListener {
            img_test03.load(R.drawable.img03) {
                transformations(CircleCropTransformation())
                crossfade(2000) // 이미지 fade in Animation
            }
        }
    }
}