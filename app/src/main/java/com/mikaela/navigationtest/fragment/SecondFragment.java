package com.mikaela.navigationtest.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.mikaela.navigationtest.MainActivity;
import com.mikaela.navigationtest.R;
import com.mikaela.navigationtest.adapter.ButtonsAdapter;
import com.mikaela.navigationtest.model.Question;
import com.mikaela.navigationtest.room.QuestionViewModel;

public class SecondFragment extends Fragment {

    private GridView grid;
    private TextView questionText;

    private ButtonsAdapter adapter;
    private QuestionViewModel questionViewModel;
    private Question question;

    public SecondFragment getInstance(int id) {
        SecondFragment fragment = new SecondFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("questionId", id);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        NavController nav = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
        questionViewModel = new ViewModelProvider(this).get(QuestionViewModel.class);

        grid = view.findViewById(R.id.grid);
        questionText = view.findViewById(R.id.question);
        TextView back = view.findViewById(R.id.back);
        back.setOnClickListener(v -> {
            nav.popBackStack();
        });

        Log.i("size", String.valueOf(nav.getBackQueue().getSize()));
        ((MainActivity)requireActivity()).logs(nav.getBackQueue());

        setPage();

        return view;
    }

    private void setPage() {
        int id = ((MainActivity)requireActivity()).getCurrentQuestionId();
        if (id==0)
            return;
        questionViewModel.getQuestion(id).observe(getViewLifecycleOwner(), q -> {
            question = q;
            questionText.setText(question.getQuestion());
            grid.setAdapter(new ButtonsAdapter(requireActivity(), question.getButtons()));
            grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    ((MainActivity)requireActivity()).nextPage(
                            (Integer) question.getButtons().keySet().toArray()[position]
                    );
                }
            });
        });
    }
}