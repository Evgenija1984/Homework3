package keyone.keytwo.homework3;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

// это типа гербы
public class NoteDescriptionFragment extends Fragment {

    public static final String KEY_INDEX = "index";
    private int index;

    public static NoteDescriptionFragment newInstance(int index) {
        NoteDescriptionFragment fragment = new NoteDescriptionFragment();
        Bundle args = new Bundle();
        //args.putString(KEY_INDEX, index);
        args.putInt(KEY_INDEX, index);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            index = getArguments().getInt(KEY_INDEX);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note_description, container, false);
        ImageView imageView = view.findViewById(R.id.coat_of_arms);
        TypedArray images = getResources().obtainTypedArray(R.array.numbers);
        imageView.setImageResource(images.getResourceId(index, -1));
        return view;
    }
}