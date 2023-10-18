package com.mygdx.game;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.XmlReader;

public class ItemsRender {
    public void button(XmlReader.Element element, Table rootT, Skin skin) {
        if ("button".equals(element.getName())) {
            TextButton textButton = new TextButton(element.getText(), skin);
            if(element.hasAttribute("width")) {
                int width = Integer.parseInt(element.getAttribute("width"));
                rootT.add(textButton).width(width);
            }

            else {
                rootT.add(textButton);
            }
        }
    }
    public void row(XmlReader.Element element, Table rootT, Skin skin) {
        if ("row".equals(element.getName())) {
            rootT.row();
        }
    }
    public void parseRender(XmlReader.Element element, Table rootT, Skin skin){

        button(element,rootT,skin);
        row(element,rootT,skin);

        for(int i=0;i< element.getChildCount();i++){
            XmlReader.Element childElement =element.getChild(i);
            parseRender(childElement,rootT,skin);
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
