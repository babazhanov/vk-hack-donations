package com.progtech.donatingsvk.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.progtech.donatingsvk.R;

public class CustomButtonView extends ConstraintLayout {
    private int mLeftDrawable;
    private String mCaption;
    private String mDescription;

    public CustomButtonView(Context context) {
        super(context);
        init(null, 0);
    }

    public CustomButtonView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public CustomButtonView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        // Load attributes
        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.CustomButtonView, defStyle, 0);

        mLeftDrawable = a.getResourceId(R.styleable.CustomButtonView_LeftDrawable, R.drawable.aim);
        mCaption = a.getString(R.styleable.CustomButtonView_Caption);
        mDescription = a.getString(R.styleable.CustomButtonView_Description);

        a.recycle();

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (inflater != null) {
            View rootView = inflater.inflate(R.layout.group_button_layout, this);

            ImageView imageView = rootView.findViewById(R.id.imageViewLeftDrawable);
            TextView textViewCaption = rootView.findViewById(R.id.textViewCaption);
            TextView textViewDescription = rootView.findViewById(R.id.textViewDescription);

            imageView.setImageResource(mLeftDrawable);
            textViewCaption.setText(mCaption);
            textViewDescription.setText(mDescription);
        }

    }
}