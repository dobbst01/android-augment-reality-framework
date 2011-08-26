package com.jwetherell.augmented_reality.ui;

import com.jwetherell.augmented_reality.ui.objects.PaintableIcon;
import com.jwetherell.augmented_reality.ui.objects.PaintablePosition;
import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * This class extends Marker and draws an icon instead of a circle for it's visual representation.
 * 
 * @author Justin Wetherell <phishman3579@gmail.com>
 */
public class IconMarker extends Marker {
    private Bitmap bitmap = null;

    public IconMarker(String name, double latitude, double longitude, double altitude, int color, Bitmap bitmap) {
        super(name, latitude, longitude, altitude, color);
        this.bitmap = bitmap;
    }
    
    @Override
    public void drawIcon(Canvas canvas) {
    	if(bitmap==null) return;
    	
        float maxHeight = Math.round(canvas.getHeight() / 10f) + 1;
        
        PaintableIcon icon = new PaintableIcon(bitmap);
        PaintablePosition iconContainter = new PaintablePosition(icon, (circleVector.x - maxHeight/1.5f), (circleVector.y - maxHeight/1.5f), 0, 2);
        iconContainter.paint(canvas);
    }
}