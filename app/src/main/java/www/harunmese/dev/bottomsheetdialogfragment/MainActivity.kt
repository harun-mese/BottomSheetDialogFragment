package www.harunmese.dev.bottomsheetdialogfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import www.harunmese.dev.bottomsheetdialogfragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val bottomSheetFragment = MyBottomSheetDialogFragment()

        //butona basildiginda acmak icin
        binding.openBtn.setOnClickListener {
            bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)
        }



    }
}