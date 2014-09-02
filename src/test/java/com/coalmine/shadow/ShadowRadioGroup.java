package com.coalmine.shadow;

import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;
import org.robolectric.shadows.ShadowLinearLayout;

import android.widget.RadioGroup;

@Implements(RadioGroup.class)
public class ShadowRadioGroup extends ShadowLinearLayout {
	private boolean clearCheckCalled;

	@Implementation
	public void clearCheck() {
		clearCheckCalled = true;
	}

	public boolean wasClearCheckCalled() {
		return clearCheckCalled;
	}
}


