package gaspol.bukahobi.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import gaspol.bukahobi.R;
import gaspol.bukahobi.models.Comment;

/**
 * Created by USER on 6/9/2017.
 */

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentViewHolder> {

    private List<Comment> commentList;

    public CommentAdapter(List<Comment> commentList) {
        this.commentList = commentList;
    }

    @Override
    public CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_comment, parent, false);

        return new CommentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CommentViewHolder holder, int position) {
        Comment comment = commentList.get(position);
        holder.imageViewCommentUserProfile.setImageResource(comment.getUserProfile());
        holder.textViewComment.setText(comment.getComment());
    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }

    public class CommentViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public CircleImageView imageViewCommentUserProfile;
        public TextView textViewComment;

        public CommentViewHolder(View itemView) {
            super(itemView);
            imageViewCommentUserProfile = (CircleImageView) itemView.findViewById(R.id.imageViewCommentUserProfile);
            textViewComment = (TextView) itemView.findViewById(R.id.textViewComment);
        }
    }
}
