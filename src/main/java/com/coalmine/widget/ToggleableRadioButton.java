package com.coalmine.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewParent;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/** RadioButton that clears its (immediate) parent RadioGroup if pressed while already selected. */
public class ToggleableRadioButton extends RadioButton {
	public ToggleableRadioButton(Context context) {
		super(context);
	}

	public ToggleableRadioButton(Context context, AttributeSet attributes) {
		super(context, attributes);
	}

	public ToggleableRadioButton(Context context, AttributeSet attributes, int defStyle) {
		super(context, attributes, defStyle);
	}


	@Override
	public void toggle() {
		if(isChecked()) {
			ViewParent parent = getParent();
			if(parent instanceof RadioGroup) {
				((RadioGroup) parent).clearCheck();
			}
		} else {
			setChecked(true);
		}
	}
}


