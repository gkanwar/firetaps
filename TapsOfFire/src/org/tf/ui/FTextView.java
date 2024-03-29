/*
 * Taps of Fire
 * Copyright (C) 2009 Dmitry Skiba
 * 
 * This program is free software: you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as 
 * published by the Free Software Foundation, either version 3 of 
 * the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
*/
package org.tf.ui;

import org.tf.Config;
import org.tf.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

public class FTextView extends TextView {

	public FTextView(Context context) {
		super(context);
		setupTypeface(null,0);
	}

	public FTextView(Context context,AttributeSet attributes) {
		super(context,attributes);
		setupTypeface(attributes,0);
	}

	public FTextView(Context context,AttributeSet attributes,int style) {
		super(context,attributes,style);
		setupTypeface(attributes,style);
	}
	
	///////////////////////////////////////////// implementation
	
	private void setupTypeface(AttributeSet attributes,int style) {
		boolean fireTypeface=false;
		if (attributes!=null) {
			TypedArray a=getContext().obtainStyledAttributes(
				attributes,
				R.styleable.FTextView,
				style,0);
			fireTypeface=a.getBoolean(R.styleable.FTextView_fireTypeface,false);
			a.recycle();
		}
		if (fireTypeface) {
			setTypeface(Config.getFireTypeface());
		} else {
			setTypeface(Config.getDefaultTypeface());
		}
	}
}
