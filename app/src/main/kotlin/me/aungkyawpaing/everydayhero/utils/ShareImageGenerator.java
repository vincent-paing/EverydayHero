package me.aungkyawpaing.everydayhero.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import me.aungkyawpaing.everydayhero.R;
import me.aungkyawpaing.everydayhero.model.Hero;
import me.aungkyawpaing.everydayhero.model.Quest;

/**
 * Created by vincentpaing on 8/23/17.
 */

public class ShareImageGenerator {

  private static int primaryColor;
  private static Resources resources;
  private static final int IMAGE_WIDTH = 720;
  private static final int IMAGE_HEIGHT = 400;
  private static final int LEFT_AVATAR_POS = 50;
  private static final int TOP_AVATAR_POS = 50;
  private static final int RIGHT_AVATAR_POS = 150;
  private static final int BOTTOM_AVATAR_POS = 150;

  private static final int TITLE_TEXT_SIZE = 24;
  private static final float SHADOW_RADIUS = 0.1f;
  private static final float TEXT_SPACING_DEFAULT = 1.0f;
  private static final int TITlE_TEXT_X = 25;
  private static final int TITlE_TEXT_Y = 200;
  private static final int TEXT_WIDTH = 400;

  public ShareImageGenerator(Context context) {
    resources = context.getResources();
    primaryColor = ContextCompat.getColor(context, R.color.primary);
  }

  public static Bitmap generateShareableImage(Quest quest, Hero hero, Bitmap heroAvatarBitmap) {
    Bitmap bitmap = Bitmap.createBitmap(IMAGE_WIDTH, IMAGE_HEIGHT, Bitmap.Config.ARGB_8888);

    Canvas canvas = new Canvas(bitmap);

    canvas.drawColor(primaryColor);

    //Draw Avatar
    canvas.drawBitmap(heroAvatarBitmap, null,
        new Rect(LEFT_AVATAR_POS, TOP_AVATAR_POS, RIGHT_AVATAR_POS, BOTTOM_AVATAR_POS), null);

    //Draw Name
    //Draw Title
    TextPaint textPaint = new TextPaint();
    textPaint.setTextSize(TITLE_TEXT_SIZE);
    textPaint.setColor(Color.WHITE);
    textPaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
    textPaint.setShadowLayer(SHADOW_RADIUS, 0, 0, Color.BLACK);
    textPaint.setAntiAlias(true);
    StaticLayout mTextLayout =
        new StaticLayout(hero.getName(), textPaint, TEXT_WIDTH, Layout.Alignment.ALIGN_NORMAL,
            TEXT_SPACING_DEFAULT, TEXT_SPACING_DEFAULT, false);
    canvas.save();
    canvas.translate(TITlE_TEXT_X, TITlE_TEXT_Y);
    mTextLayout.draw(canvas);
    canvas.restore();


    return bitmap;
  }
}
