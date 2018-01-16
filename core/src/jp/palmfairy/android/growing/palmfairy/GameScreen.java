package jp.palmfairy.android.growing.palmfairy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by appu2 on 2018/01/16.
 */

public class GameScreen extends ScreenAdapter {
    private PalamFairyGame mPalamFairyGame;

    Sprite mBg;
    public GameScreen(PalamFairyGame game){
        mPalamFairyGame = game;
//        背景画像
        Texture bgTexture = new Texture("back.png");
        mBg = new Sprite(new TextureRegion(bgTexture,0,0,540,810));
        mBg.setPosition(0,0);
    }
    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        mPalamFairyGame.batch.begin();
        mBg.draw(mPalamFairyGame.batch);
        mPalamFairyGame.batch.end();
    }
}
