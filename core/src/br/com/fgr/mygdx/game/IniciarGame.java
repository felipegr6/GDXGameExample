package br.com.fgr.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class IniciarGame extends MyGdxScreen {

	SpriteBatch batch;
	TextureRegion background;

	public IniciarGame(Game game) {

		super(game);

	}

	@Override
	public void show() {

		background = new TextureRegion(new Texture("bg_intro.png"), 0, 0, 860,
				542);

		batch = new SpriteBatch();
		batch.getProjectionMatrix().setToOrtho2D(0, 0, 860, 542);

	}

	@Override
	public void render(float delta) {

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.disableBlending();
		batch.begin();
		batch.draw(background, 0, 0);
		batch.end();

	}

}