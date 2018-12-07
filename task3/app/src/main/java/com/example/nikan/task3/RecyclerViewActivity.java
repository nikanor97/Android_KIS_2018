package com.example.nikan.task3;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager verticalLinearLayoutManager;
    private RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        PersonRepository.initPersonList(this);

        recyclerView = findViewById(R.id.recycler);

        verticalLinearLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(verticalLinearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.getRecycledViewPool().setMaxRecycledViews(0, 15);

        adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setPersonList(PersonRepository.getPersonList());

    }

    private class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
        private List<Person> personList = new ArrayList<>();

        public void setPersonList(final List<Person> personList) {
            this.personList = personList;
            notifyDataSetChanged();
        }

        @Override
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int i) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
            return new RecyclerViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerViewHolder recyclerViewHolder, int position) {
            recyclerViewHolder.bind(personList.get(position));
        }

        @Override
        public int getItemCount() {
            return personList.size();
        }
    }

    private class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView personNameTextView;
        private long id;

        public RecyclerViewHolder(View itemView){
            super(itemView);
            personNameTextView = itemView.findViewById(R.id.title);
            personNameTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    final Context context = v.getContext();
                    context.startActivity(ProfileActivity.getIntent(context, id));
                }
            });
        }

        public void bind(Person person) {
            personNameTextView.setText(person.getName());
            id = person.getId();
        }
    }

}
