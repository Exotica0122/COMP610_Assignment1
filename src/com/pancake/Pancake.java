package com.pancake;

import java.awt.*;

public class Pancake implements Comparable<Pancake> {

    private Color color;
    private int size;
    private int selected;

    public Pancake(int size, Color color) {
        this.size = size;
        this.color = color;
    }

    public int getSize() {
        return this.size;
    }

    public void highlight(boolean selected) {
        if(selected == true) this.selected = 1;
        else this.selected=0;
    }

    public void draw(Graphics g, int height) {
        g.setColor(this.color);
        g.fillRect((500 - 10* this.size)/2,10 * height,10 * this.size, 10);
        g.setColor(Color.black);
        g.drawRect((500 - 10* this.size)/2,10 * height,10 * this.size, 10);
        g.drawString(Integer.toString(this.size), 500/2, 10 * height +10);
    }

    @Override
    public int compareTo(Pancake o) {
        return Integer.compare(this.size, o.getSize());
    }
}
