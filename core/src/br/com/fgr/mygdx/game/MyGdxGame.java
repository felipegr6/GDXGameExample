package br.com.fgr.mygdx.game;

import br.com.fgr.mygdx.game.assets.AssetsManager;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class MyGdxGame extends MyGdxScreen {

	SpriteBatch batch;
	TextureRegion img;
	Music music;
	Rectangle iniciarBounds;
	Vector3 touchPoint;
	boolean soundEnabled = true;
	OrthographicCamera guiCam;

	public MyGdxGame(Game game) {

		super(game);

		iniciarBounds = new Rectangle(640, 136, 170, 144);
		touchPoint = new Vector3();
		guiCam = new OrthographicCamera(860, 542);
		guiCam.position.set(860 / 2, 542 / 2, 0);

	}

	@Override
	public void show() {

		img = new TextureRegion(new Texture("inicio.png"), 0, 0, 860, 542);

		batch = new SpriteBatch();
		// batch.getProjectionMatrix().setToOrtho2D(0, 0, 480, 320);

		music = Gdx.audio.newMusic(Gdx.files.internal("bg-music.mp3"));
		music.setLooping(true);
		music.play();

	}

	@Override
	public void render(float delta) {

		if (Gdx.input.justTouched()) {

			guiCam.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(),
					0));

			if (AssetsManager.getSoundBounds().contains(touchPoint.x,
					touchPoint.y)) {

				if (music.isPlaying()) {

					music.pause();
					AssetsManager.setSomHabilitado(false);

				} else {

					music.play();
					AssetsManager.setSomHabilitado(true);

				}

				return;

			}

			if (iniciarBounds.contains(touchPoint.x, touchPoint.y)) {

				music.stop();
				game.setScreen(new IniciarGame(game));

			}

		}

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		guiCam.update();
		batch.setProjectionMatrix(guiCam.combined);

		batch.disableBlending();
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();

		batch.enableBlending();
		batch.begin();
		batch.draw(AssetsManager.isSomHabilitado() ? AssetsManager.getComSom()
				: AssetsManager.getSemSom(), 15, 22, 44, 44);
		batch.end();

	}

}