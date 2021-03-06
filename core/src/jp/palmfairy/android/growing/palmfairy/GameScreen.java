package jp.palmfairy.android.growing.palmfairy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.viewport.FitViewport;

/**
 * Created by appu2 on 2018/01/16.
 */

public class GameScreen extends ScreenAdapter {
    static final float CAMERA_WIDTH = 10;
    static final float CAMERA_HEIGHT = 15;

    static final float WORLD_WIDTH = 10;
    static final float WORLD_HEIGHT = 15;

    static final int GAME_STATE_READY = 0;
    static final int GAME_STATE_PLAYING = 1;
    static final int GAME_STATE_GAMEOVER = 2;

    static final float GRAVITY = -12;
    private PalamFairyGame mPalamFairyGame;

    Sprite mBg;
    OrthographicCamera mCamera;
    FitViewport mViewPort;

    Pet mPet;

    int mGameState;

    public GameScreen(PalamFairyGame game){
        mPalamFairyGame = game;
//        背景画像
        Texture bgTexture = new Texture("bagset.png");
        mBg = new Sprite(new TextureRegion(bgTexture,0,0,540,810));
        mBg.setSize(CAMERA_WIDTH,CAMERA_HEIGHT);
        mBg.setPosition(0,0);

        mCamera = new OrthographicCamera();
        mCamera.setToOrtho(false,CAMERA_WIDTH,CAMERA_HEIGHT);
        mViewPort = new FitViewport(CAMERA_WIDTH,CAMERA_HEIGHT,mCamera);

        mGameState = GAME_STATE_READY;
        createStage();

    }
    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        mCamera.update();
        mPalamFairyGame.batch.setProjectionMatrix(mCamera.combined);

        mPalamFairyGame.batch.begin();
        mBg.setPosition(mCamera.position.x - CAMERA_WIDTH/2,mCamera.position.y - CAMERA_HEIGHT/2);

        mBg.draw(mPalamFairyGame.batch);
        mPet.draw(mPalamFairyGame.batch);
        mPalamFairyGame.batch.end();

    }
    @Override
    public void resize(int width,int height){
        mViewPort.update(width,height);
    }

    private void createStage(){
        Texture petTexture = new Texture("pet.png");

        mPet = new Pet(petTexture,0,0,230,230);
        mPet.setPosition(WORLD_WIDTH/2-mPet.getWidth()/2,WORLD_HEIGHT/6);
    }
    private void update(float delta){
        switch (mGameState){
            case GAME_STATE_READY:
                break;
            case GAME_STATE_PLAYING:
                break;
            case GAME_STATE_GAMEOVER:
                break;
        }
    }
}
