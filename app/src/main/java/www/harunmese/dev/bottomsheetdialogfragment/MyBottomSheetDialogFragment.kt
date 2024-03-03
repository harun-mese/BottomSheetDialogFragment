package www.harunmese.dev.bottomsheetdialogfragment

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MyBottomSheetDialogFragment : BottomSheetDialogFragment() {

     override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
         return inflater.inflate(R.layout.fragment_bottom_sheet_dialog, container, false)
     }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // burasi ekran scroll oldugunda kapanmamasi icin

        val scrollView = view.findViewById<ScrollView>(R.id.scrollView)
        scrollView.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            // Yalnızca en üstteyken scroll yaparsa, kapatmabilir

            if (scrollY == 0) {
                dialog?.setCancelable(true)
                dialog?.setCanceledOnTouchOutside(true)
            } else {
                dialog?.setCancelable(false)
                dialog?.setCanceledOnTouchOutside(false)
            }
        }

    }


    // burasi bottom sheet basladiginda tam ekran olmasi icin
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = BottomSheetDialog(requireContext(), theme)
        dialog.behavior.state = BottomSheetBehavior.STATE_EXPANDED
        return dialog
    }


}