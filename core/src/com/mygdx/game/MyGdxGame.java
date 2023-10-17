package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Value;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.XmlReader;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import org.xml.sax.XMLReader;

import javax.lang.model.element.Element;

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

		int childCount = root.getChildCount();
		System.out.println(childCount);
		for (int i = 0; i < childCount; i++) {
			XmlReader.Element element = root.getChild(i);
			System.out.println(element);
		}

		System.out.println("*********");
		System.out.println(root);
		System.out.println("*********");

		Table rootT = new Table();
		rootT.setFillParent(true);
		stage.addActor(rootT);
		rootT.defaults().grow();

		XmlReader.Element jxElement = root.getChildByName("JX");
		XmlReader.Element mainElement = root.getChildByName("main");

		for(XmlReader.Element child : jxElement.getChildrenByName("main")) {
			if(child!=null && mainElement!=null){
				for(XmlReader.Element grandchild : mainElement.getChildrenByName("button")) {
					System.out.println(mainElement);
					TextButton textButton = new TextButton("CIAO2", skin);
					rootT.add(textButton);
					rootT.row();
				}
			}
		}
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
