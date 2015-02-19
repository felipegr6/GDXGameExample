package br.com.fgr.mygdx.game;

import com.badlogic.gdx.Game;

public class MyGdx extends Game {

	@Override
	public void create() {

		setScreen(new MyGdxGame(this));

	}

}
