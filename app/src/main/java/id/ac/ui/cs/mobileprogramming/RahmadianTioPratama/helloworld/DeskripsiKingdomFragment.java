package id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.helloworld;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DeskripsiKingdomFragment extends Fragment{
    int posisi = 0;
    TextView namaKingdom;
    TextView deskripsiKingdom;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState == null){
            if(getArguments() != null) {
                posisi = getArguments().getInt("position", 0);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup parent, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_deskripsi_kingdom, parent, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        namaKingdom = (TextView) view.findViewById(R.id.namaKingdom);
        deskripsiKingdom = (TextView) view.findViewById(R.id.deskripsiKingdom);
        namaKingdom.setText(Kingdom.namaKingdom[posisi]);
        deskripsiKingdom.setText(Kingdom.deskripsiKingdom[posisi]);
    }

    public void updateView(int posisi){
        namaKingdom.setText(Kingdom.namaKingdom[posisi]);
        deskripsiKingdom.setText(Kingdom.namaKingdom[posisi]);
    }
}
