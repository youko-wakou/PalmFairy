package jp.palmfairy.android.growing.palmfairy;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by appu2 on 2018/01/17.
 */

public class Pet extends GameObject {
//    ペット縦横大きさ
    public static final float PET_WIDTH = 3.0f;
    public static final float PET_HEIGHT = 3.0f;
//    ペット横動き
    public static final int PET_MOVE = 0;
//    ペット動く速度
    public static final float PET_MOVE_VELOCITY = 11.0f;

    int mState;
    public Pet(Texture texture,int srcX,int srcY,int srcWidth,int srcHeight){
        super(texture,srcX,srcY,srcWidth,srcHeight);
        setSize(PET_WIDTH,PET_HEIGHT);
        mState = PET_MOVE;
    }

    public void update(float delta,float accelX){
        velocity.add(0,GameScreen.GRAVITY * delta);
        velocity.x = -accelX/10*PET_MOVE_VELOCITY;
        setPosition(getX() + velocity.x * delta,getY() + velocity.y *delta);
//        キャラが横に移動したときの動き
        if(velocity.x >0||velocity.x <0){
            mState = PET_MOVE;
        }
        if(getX() +PET_WIDTH/2<0){
            setX(GameScreen.WORLD_WIDTH - PET_WIDTH/2);
        }else if(getX() +PET_WIDTH/2>GameScreen.WORLD_WIDTH){
            setX(0);
        }
    }
    public void hitStep(){
        velocity.x = PET_MOVE_VELOCITY;
        mState = PET_MOVE;
    }

}
