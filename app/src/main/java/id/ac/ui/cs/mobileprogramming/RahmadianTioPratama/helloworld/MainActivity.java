package id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity  implements NamaKingdomFragment.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            NamaKingdomFragment namaKingdomFragment = new NamaKingdomFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.flContainer, namaKingdomFragment);
            ft.commit();
        }
    }

    @Override
    public void onKingdomSelected(int position) {
        DeskripsiKingdomFragment deskripsiKingdomFragment = new DeskripsiKingdomFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        deskripsiKingdomFragment.setArguments(args);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.flContainer, deskripsiKingdomFragment)
                .addToBackStack(null)
                .commit();
    }
}