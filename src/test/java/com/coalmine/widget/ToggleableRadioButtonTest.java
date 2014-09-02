package com.coalmine.widget;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import com.coalmine.shadow.ShadowRadioGroup;

import android.content.Context;
import android.widget.RadioButton;
import android.widget.RadioGroup;

@RunWith(RobolectricTestRunner.class)
@Config(manifest=Config.NONE, shadows={ShadowRadioGroup.class})
public class ToggleableRadioButtonTest {
	private RadioGroup radioGroup;
	private ShadowRadioGroup shadowRadioGroup;

	private RadioButton initiallyCheckedRadioButton;
	private RadioButton initiallyUncheckedRadioButton;


	@Before
	public void setUp() throws Exception {
		Context context = Robolectric.application.getApplicationContext();

		radioGroup = new RadioGroup(context);
		shadowRadioGroup = (ShadowRadioGroup)Robolectric.shadowOf_(radioGroup);

		initiallyCheckedRadioButton = new ToggleableRadioButton(context);
		initiallyCheckedRadioButton.setChecked(true);
		radioGroup.addView(initiallyCheckedRadioButton);

		initiallyUncheckedRadioButton = new ToggleableRadioButton(context);
		radioGroup.addView(initiallyUncheckedRadioButton);
	}

	@Test
	public void testToggle_togglingChecksUncheckedButton() {
		initiallyUncheckedRadioButton.toggle();

		assertTrue("Clicking on an unselected radio button should continue to select it.",
				initiallyUncheckedRadioButton.isChecked());
	}

	@Test
	public void testToggle_togglingCheckedButtonClearsGroup() {
		initiallyCheckedRadioButton.toggle();

		assertTrue("Clicking on a selected radio button should clear its group buttons.",
				shadowRadioGroup.wasClearCheckCalled());
	}
}


