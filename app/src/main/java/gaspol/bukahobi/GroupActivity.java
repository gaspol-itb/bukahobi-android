package gaspol.bukahobi;

/**
 * Created by USER on 6/8/2017.
 */

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import gaspol.bukahobi.models.TagHolder;

public class GroupActivity extends AppCompatActivity
        implements AppBarLayout.OnOffsetChangedListener {

    private static final float PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR  = 0.9f;
    private static final float PERCENTAGE_TO_HIDE_TITLE_DETAILS     = 0.3f;
    private static final int ALPHA_ANIMATIONS_DURATION              = 200;

    private boolean mIsTheTitleVisible          = false;
    private boolean mIsTheTitleContainerVisible = true;

    private LinearLayout mTitleContainer;
    private TextView mTitle;
    private AppBarLayout mAppBarLayout;
    private Toolbar mToolbar;

    private Dialog dialogCreateEvent;

    private LayoutInflater layoutInflater;
    private LinearLayout linearLayoutEventContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        bindActivity();

        mAppBarLayout.addOnOffsetChangedListener(this);

        mToolbar.inflateMenu(R.menu.home);
        startAlphaAnimation(mTitle, 0, View.INVISIBLE);

        layoutInflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);

        linearLayoutEventContainer = (LinearLayout) findViewById(R.id.linearLayoutEventContainer);

        View cardViewEvent = layoutInflater.inflate(R.layout.cardview_event, linearLayoutEventContainer, false);
        TextView textViewCardViewEvent = (TextView) cardViewEvent.findViewById(R.id.textViewCardViewEvent);
        textViewCardViewEvent.setText("Hey! this is our first event! cheers!");

        View cardViewEvent2 = layoutInflater.inflate(R.layout.cardview_event, linearLayoutEventContainer, false);
        TextView textViewCardViewEvent2 = (TextView) cardViewEvent2.findViewById(R.id.textViewCardViewEvent);
        textViewCardViewEvent2.setText("Hey! this is our second event! cheers!");

        TagHolder tagHolder = new TagHolder();
        tagHolder.id = "1";

        cardViewEvent.setTag(tagHolder);

        TagHolder tagHolder2 = new TagHolder();
        tagHolder2.id = "2";
        cardViewEvent2.setTag(tagHolder2);

        linearLayoutEventContainer.addView(cardViewEvent);
        linearLayoutEventContainer.addView(cardViewEvent2);
    }

    private void bindActivity() {
        mToolbar        = (Toolbar) findViewById(R.id.main_toolbar);
        mTitle          = (TextView) findViewById(R.id.main_textview_title);
        mTitleContainer = (LinearLayout) findViewById(R.id.main_linearlayout_title);
        mAppBarLayout   = (AppBarLayout) findViewById(R.id.main_appbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int offset) {
        int maxScroll = appBarLayout.getTotalScrollRange();
        float percentage = (float) Math.abs(offset) / (float) maxScroll;

        handleAlphaOnTitle(percentage);
        handleToolbarTitleVisibility(percentage);
    }

    private void handleToolbarTitleVisibility(float percentage) {
        if (percentage >= PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR) {

            if(!mIsTheTitleVisible) {
                startAlphaAnimation(mTitle, ALPHA_ANIMATIONS_DURATION, View.VISIBLE);
                mIsTheTitleVisible = true;
            }

        } else {

            if (mIsTheTitleVisible) {
                startAlphaAnimation(mTitle, ALPHA_ANIMATIONS_DURATION, View.INVISIBLE);
                mIsTheTitleVisible = false;
            }
        }
    }

    private void handleAlphaOnTitle(float percentage) {
        if (percentage >= PERCENTAGE_TO_HIDE_TITLE_DETAILS) {
            if(mIsTheTitleContainerVisible) {
                startAlphaAnimation(mTitleContainer, ALPHA_ANIMATIONS_DURATION, View.INVISIBLE);
                mIsTheTitleContainerVisible = false;
            }

        } else {

            if (!mIsTheTitleContainerVisible) {
                startAlphaAnimation(mTitleContainer, ALPHA_ANIMATIONS_DURATION, View.VISIBLE);
                mIsTheTitleContainerVisible = true;
            }
        }
    }

    public static void startAlphaAnimation (View v, long duration, int visibility) {
        AlphaAnimation alphaAnimation = (visibility == View.VISIBLE)
                ? new AlphaAnimation(0f, 1f)
                : new AlphaAnimation(1f, 0f);

        alphaAnimation.setDuration(duration);
        alphaAnimation.setFillAfter(true);
        v.startAnimation(alphaAnimation);
    }

    public void fabCreateEventOnClickHandler (View view) {
        dialogCreateEvent = new Dialog(this);
        dialogCreateEvent.setContentView(R.layout.dialog_create_event);
        dialogCreateEvent.setCanceledOnTouchOutside(true);
        dialogCreateEvent.show();
    }

    public void buttonCreateEventOnClickHandler (View view) {
        EditText editTextCreateEventAmount = (EditText) dialogCreateEvent.findViewById(R.id.editTextCreateEventAmount);
        CheckBox checkBoxCreateEventFunding = (CheckBox) dialogCreateEvent.findViewById(R.id.checkBoxCreateEventFunding);

        if (!editTextCreateEventAmount.getText().toString().isEmpty()) {
            try {
                int fundingAmount = Integer.parseInt(editTextCreateEventAmount.getText().toString());
                System.out.println("Event created with amount set to " + fundingAmount);
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Amount must be a number!", Toast.LENGTH_SHORT).show();
                return;
            }
        } else {
            if (checkBoxCreateEventFunding.isChecked()) {
                Toast.makeText(this, "Amount must be set!", Toast.LENGTH_SHORT).show();
                return;
            }
        }

        if (dialogCreateEvent.isShowing()) {
            dialogCreateEvent.dismiss();
        }
    }

    public void checkBoxCreateEventFundingOnClickHandler (View view) {
        CheckBox checkBoxCreateEventFunding = (CheckBox) dialogCreateEvent.findViewById(R.id.checkBoxCreateEventFunding);

        if (checkBoxCreateEventFunding.isChecked()) {
            EditText editTextCreateEventAmount = (EditText) dialogCreateEvent.findViewById(R.id.editTextCreateEventAmount);
            editTextCreateEventAmount.setVisibility(View.VISIBLE);
        }
    }

    public void cardViewEventOnClickHandler (View view) {
        Intent intent = new Intent(this, EventActivity.class);
        startActivity(intent);
    }
}