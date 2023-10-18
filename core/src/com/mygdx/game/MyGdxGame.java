package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.XmlReader;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MyGdxGame extends ApplicationAdapter {

	private Skin skin;
	private Stage stage;

	@Override
	public void create () {
		skin = new Skin (Gdx.files.internal("metalui/metal-ui.json"));
		stage= new Stage(new ScreenViewport());
		Gdx.input.setInputProcessor(stage);

		XmlReader reader= new XmlReader();
		XmlReader.Element root= reader.parse(Gdx.files.internal("UI.xml"));
		XmlReader.Element jxElement = root.getChildByName("JX");

		Table rootT = new Table();
		rootT.setFillParent(true);
		stage.addActor(rootT);

		ItemsRender R= new ItemsRender();
		//R.debugXml(root);
		R.parseRender(jxElement,rootT,skin);

		Array<Cell> cells = rootT.getCells();
		int counter=0;
		for (Cell cell : cells) {
			Actor actor = cell.getActor();
			if (actor instanceof TextButton) {
				TextButton button = (TextButton) actor;
				System.out.println("Spazio Su: " + cell.getPadTop());
				System.out.println("Spazio Destra: " + cell.getPadRight());
				System.out.println("Spazio Giù: " + cell.getPadBottom());
				System.out.println("Spazio Sinistra: " + cell.getPadLeft());
			}
			System.out.println(counter);
			counter++;
		}
		System.out.println(cells);
	}


	@Override
	public void render () {
		Gdx.gl.glClearColor(3.9f,.9f,.9f,.9f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act();
		stage.draw();
	}

	@Override
	public void resize(int width,int height){
		stage.getViewport().update(width,height,true);
	}

	@Override
	public void dispose () {
		skin.dispose();
		stage.dispose();
	}
}
