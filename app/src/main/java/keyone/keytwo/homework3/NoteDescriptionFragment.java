package keyone.keytwo.homework3;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

// это типа гербы
public class NoteDescriptionFragment extends Fragment {

    public static final String ARG_NOTE = "note";
    private Note note;

    public static NoteDescriptionFragment newInstance(Note note) {
        NoteDescriptionFragment fragment = new NoteDescriptionFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_NOTE, note);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            note = getArguments().getParcelable(ARG_NOTE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note_description, container, false);
        TextView textViewName = view.findViewById(R.id.textViewName);
        TextView textViewBody = view.findViewById(R.id.textViewBody);
        textViewName.setText(note.getNoteName(getContext()));
        textViewBody.setText(note.getNoteBody(getContext()));
        return view;
    }
}