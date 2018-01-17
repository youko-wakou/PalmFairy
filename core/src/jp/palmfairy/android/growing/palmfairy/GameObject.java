package jp.palmfairy.android.growing.palmfairy;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by appu2 on 2018/01/17.
 */

public class GameObject extends Sprite {
    public final Vector2 velocity;

    public GameObject(Texture texture,int srcX,int srcY,int srcWidth,int srcHeight){
        super(texture,srcX,srcY,srcWidth,srcHeight);
        velocity = new Vector2();
    }
}
