package id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.helloworld;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class NamaKingdomFragment extends Fragment {
    ArrayAdapter<String> itemsAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        itemsAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, Kingdom.namaKingdom);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup parent, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_nama_kingdom, parent, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        ListView itemKingdom = (ListView) view.findViewById(R.id.itemKingdom);
        itemKingdom.setAdapter(itemsAdapter);
        itemKingdom.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int posisi, long id) {
                listener.onKingdomSelected(posisi);
            }
        });
    }
    private OnItemSelectedListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnItemSelectedListener){
            this.listener = (OnItemSelectedListener) context;
        } else {
            throw new ClassCastException(context.toString()
                    + " must implement NamaKingdomFragment.OnItemSelectedListener");
        }
    }

    public interface OnItemSelectedListener {
        void onKingdomSelected(int posisi);
    }
}
