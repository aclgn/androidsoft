/* Copyright (c) 2010 Pierre LEVY androidsoft.org
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.androidsoft.games.utils.level;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import java.util.List;

/**
 *
 * @author pierre
 */
public class LevelAdapter extends BaseAdapter
{

    private Context mContext;
    private List<Level> mLevels;
    private int[] mButtons;

    public LevelAdapter(Context c, List<Level> levels , int[] buttons )
    {
        mContext = c;
        mLevels = levels;
        mButtons = buttons;
    }

    public int getCount()
    {
        return mLevels.size();
    }

    public Object getItem(int position)
    {
        return position;
    }

    public long getItemId(int position)
    {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        LevelView imageView;
        Level level = mLevels.get(position);
        if (convertView == null)
        {
            imageView = new LevelView(mContext, level);
            imageView.setLayoutParams(new GridView.LayoutParams(70, 70));
            imageView.setAdjustViewBounds(false);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else
        {
            imageView = (LevelView) convertView;
        }

        int button = mButtons[level.getStatus() + 1];
        imageView.setImageResource(button);
        return imageView;
//        return new LevelView( mContext );
    }
}
