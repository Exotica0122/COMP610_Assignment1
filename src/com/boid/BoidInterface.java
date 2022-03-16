package com.boid;

import java.awt.*;

public interface BoidInterface extends Runnable {
    public void stop();
    public void run();
    public double getPositionX();
    public double getPositionY();
    public double getMovementX();
    public double getMovementY();
    public void setPositionX(double x);
    public void setPositionY(double y);
    public void setMovementX(double x);
    public void setMovementY(double y);
    public void draw(Graphics g);
}
