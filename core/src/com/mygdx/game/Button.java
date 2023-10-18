package com.mygdx.game;

import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.XmlReader;

public class Button {
    public void button(XmlReader.Element element, Table rootT, Skin skin) {
        if("space".equals(element.getName()));

        {

        }
        if ("button".equals(element.getName())) {
            TextButton textButton = new TextButton(element.getText(), skin);
            Cell cell = rootT.add(textButton);
            calling(element,cell);
        }
    }
    private void calling(XmlReader.Element element,Cell cell){
        width(element,cell);
        grow(element,cell);
        position(element,cell);
        margin(element,cell);
    }

    private void width(XmlReader.Element element,Cell cell) {
        if (element.hasAttribute("width")) {
            int width = Integer.parseInt(element.getAttribute("width"));
            cell.width(width);
        }
    }
    private void grow(XmlReader.Element element,Cell cell) {
        if (element.hasAttribute("grow")) {
            if (element.getAttribute("grow").equalsIgnoreCase("x")) {
                cell.growX();
            } else if (element.getAttribute("grow").equalsIgnoreCase("y")) {
                cell.growY();
            } else {
                cell.grow();
            }
        }
    }
    private void position(XmlReader.Element element,Cell cell) {
        if (element.hasAttribute("position")) {
            if (element.getAttribute("position").equalsIgnoreCase("right")) {
                cell.right();
            } else if (element.getAttribute("position").equalsIgnoreCase("left")) {
                cell.left();
            } else if (element.getAttribute("position").equalsIgnoreCase("top")) {
                cell.top();
            } else if (element.getAttribute("position").equalsIgnoreCase("bottom")) {
                cell.bottom();
            }
        }

        if (element.hasAttribute("position2")) {
            if (element.getAttribute("position2").equalsIgnoreCase("right")) {
                cell.right();
            } else if (element.getAttribute("position2").equalsIgnoreCase("left")) {
                cell.left();
            } else if (element.getAttribute("position2").equalsIgnoreCase("top")) {
                cell.top();
            } else if (element.getAttribute("position2").equalsIgnoreCase("bottom")) {
                cell.bottom();
            }
        }
    }

    private void margin(XmlReader.Element element,Cell cell) {

    }
}
