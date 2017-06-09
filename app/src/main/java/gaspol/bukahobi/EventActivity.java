package gaspol.bukahobi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import gaspol.bukahobi.adapters.CommentAdapter;
import gaspol.bukahobi.models.Comment;
import gaspol.bukahobi.models.TagHolder;

/**
 * Created by USER on 6/9/2017.
 */

public class EventActivity extends AppCompatActivity {
    private List<Comment> commentList = new ArrayList<>();
    private RecyclerView commentRecyclerView;
    private CommentAdapter commentAdapter;

    private TextView textViewCardViewMainEvent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        commentRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewComment);

        commentAdapter = new CommentAdapter(commentList);
        RecyclerView.LayoutManager commentRecyclerViewLayoutManager = new LinearLayoutManager(getApplicationContext());
        commentRecyclerView.setLayoutManager(commentRecyclerViewLayoutManager);
        commentRecyclerView.setItemAnimator(new DefaultItemAnimator());
        commentRecyclerView.setAdapter(commentAdapter);

        prepareComments();
        prepareMainEvent();
    }

    public void prepareComments() {
        Comment comment = new Comment(R.drawable.bear, "Pertamax gan!");
        commentList.add(comment);

        comment = new Comment(R.drawable.bear, "Keduax gan!");
        commentList.add(comment);

        comment = new Comment(R.drawable.bear, "Ketigax gan!");
        commentList.add(comment);

        commentAdapter.notifyDataSetChanged();
    }

    public void prepareMainEvent() {
        textViewCardViewMainEvent = (TextView) findViewById(R.id.textViewCardViewMainEvent);
        textViewCardViewMainEvent.setText("Hey this is an event!");
    }

    public void cardViewMainEventOnClickHandler(View view) {
        Snackbar.make(view, "Clicked event", Snackbar.LENGTH_SHORT)
                .setAction("Action", null).show();
    }

    public void cardViewCommentOnClickHandler(View view) {
        TextView comment = (TextView) view.findViewById(R.id.textViewComment);
        Snackbar.make(view, "Clicked comment " + comment.getText().toString(), Snackbar.LENGTH_SHORT)
                .setAction("Action", null).show();
    }
}
