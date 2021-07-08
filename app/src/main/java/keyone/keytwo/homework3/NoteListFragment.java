package keyone.keytwo.homework3;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

// это типа названия городов
public class NoteListFragment extends Fragment {

    private boolean isLandscape;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note_list, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createTextViewList((LinearLayout) view);
    }

    private void createTextViewList(LinearLayout linearLayout) {
        String[] noteName = getResources().getStringArray(R.array.note_name);
        for (int i = 0; i < noteName.length; i++) {
            TextView textView = new TextView(getContext());
            textView.setText(noteName[i]);
            final int finalI = i;
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showPortNoteDescription(finalI);
                }
            });
            textView.setTextSize(25);
            linearLayout.addView(textView);
        }
    }

    private void showPortNoteDescription(int finalI) {
        Intent intent = new Intent(getActivity(), NoteDescriptionPortActivity.class);
        intent.putExtra(NoteDescriptionFragment.KEY_INDEX, finalI);
        startActivity(intent);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }
}