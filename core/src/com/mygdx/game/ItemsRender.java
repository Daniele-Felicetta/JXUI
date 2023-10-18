package com.mygdx.game;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.XmlReader;

public class ItemsRender {
    public void button(XmlReader.Element jxElement, Table rootT, Skin skin) {
        for (XmlReader.Element main: jxElement.getChildrenByName("main")) {
            for (XmlReader.Element button : main.getChildrenByName("button")) {
                TextButton textButton = new TextButton(button.getText(), skin);
                try {
                    int width=Integer.parseInt(button.getAttribute("width"));
                    rootT.add(textButton).width(width);
                }
                catch(Exception e) {
                    rootT.add(textButton);
                }
            }
            for(XmlReader.Element row: main.getChildrenByName("row")){
                rootT.row();
            }
        }
    }
    public void debugXml(XmlReader.Element root){

        int childCount = root.getChildCount();
        System.out.println(childCount);
        for (int i = 0; i < childCount; i++) {
            XmlReader.Element element = root.getChild(i);
            System.out.println(element);
        }

        System.out.println("*********");
        System.out.println(root);
        System.out.println("*********");
    }

}
