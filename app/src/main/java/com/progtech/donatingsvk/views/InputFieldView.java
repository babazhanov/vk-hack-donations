package com.progtech.donatingsvk.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.progtech.donatingsvk.R;

public class InputFieldView extends ConstraintLayout {
    private String mLabel;
    private String mPlaceholder;
    private Integer mLines;

    public InputFieldView(Context context) {
        super(context);
        init(null, 0);
    }

    public InputFieldView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public InputFieldView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        // Load attributes
        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.InputFieldView, defStyle, 0);

        mLabel = a.getString(R.styleable.InputFieldView_Label);
        mPlaceholder = a.getString(R.styleable.InputFieldView_Placeholder);
        mLines = a.getInteger(R.styleable.InputFieldView_Lines, 1);

        a.recycle();

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (inflater != null) {
            View rootView = inflater.inflate(R.layout.input_field, this);
            TextView textView = rootView.findViewById(R.id.textViewLabel);
            EditText editText = rootView.findViewById(R.id.editTextField);

            textView.setText(mLabel);
            editText.setHint(mPlaceholder);
            editText.setLines(mLines);
        }

    }
}