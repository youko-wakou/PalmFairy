package jp.palmfairy.android.growing.palmfairy;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by appu2 on 2018/01/16.
 */

public class PalamFairyGame extends Game {
    public SpriteBatch batch;
    @Override
    public void create(){
        batch = new SpriteBatch();

        setScreen(new GameScreen(this));
    }
}
