package br.com.fgr.mygdx.game.assets;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class AssetsManager {

	private static boolean somHabilitado = true;
	private static TextureRegion comSom = new TextureRegion(new Texture(
			"com_som.png"), 0, 0, 44, 44);
	private static TextureRegion semSom = new TextureRegion(new Texture(
			"sem_som.png"), 0, 0, 44, 44);
	private static Rectangle soundBounds = new Rectangle(15, 22, 44, 44);;

	public static boolean isSomHabilitado() {
		return somHabilitado;
	}

	public static void setSomHabilitado(boolean somHabilitado) {
		AssetsManager.somHabilitado = somHabilitado;
	}
	
	public static TextureRegion getComSom() {
		return comSom;
	}
	
	public static TextureRegion getSemSom() {
		return semSom;
	}
	
	public static Rectangle getSoundBounds(){
		return soundBounds;
	}

}