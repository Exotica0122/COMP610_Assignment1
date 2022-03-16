package com.boid;

import java.awt.*;
import java.awt.geom.Line2D;
import java.util.List;

public class Boid extends AbstractBoid {

    private double x, y;
    private static double dx, dy;
    private boolean isAlive;
    private Color[] color;
    private BoidFlock flock;

    public Boid(BoidFlock flock) {

        this.flock = flock;
        this.isAlive = true;

        this.x = (Math.random() * WORLD_WIDTH);
        this.y = (Math.random() * WORLD_HEIGHT);

        this.dx = (Math.random() * WORLD_WIDTH);
        this.dy = (Math.random() * WORLD_HEIGHT);

//      set three random colors in Color[] color
        this.color = new Color[]{
                new Color((int) (Math.random()*256), (int) (Math.random()*256), (int) (Math.random()*256)),
                new Color((int) (Math.random()*256), (int) (Math.random()*256), (int) (Math.random()*256)),
                new Color((int) (Math.random()*256), (int) (Math.random()*256), (int) (Math.random()*256))
        };
    }

    @Override
    public void stop() {
        this.isAlive = false;
    }

    @Override
    public void run() {
        while(this.isAlive) {
//          x, y
            this.x = this.dx;
            this.y = this.dy;

//            this.dx = Math.random() * WORLD_WIDTH;
//            this.dy = Math.random() * WORLD_HEIGHT;



//          Neighbours
            List<Boid> neighbours = flock.getNeighbours(this);

//          All the BS stuff
            double pCenterX = 0;
            double pCenterY = 0;
            double vAvgX = 0;
            double vAvgY = 0;
            double VsX = 0;
            double VsY = 0;


            for(int i=0; i<neighbours.size(); i++) {
                pCenterX += neighbours.get(i).getPositionX();
                pCenterY += neighbours.get(i).getPositionY();

                double speed = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));

                vAvgX += (neighbours.get(i).BOID_SIZE * neighbours.get(i).dx) / (2 * speed);
                vAvgX += (neighbours.get(i).BOID_SIZE * neighbours.get(i).dy) / (2 * speed);

                double tempX = this.getPositionX() - neighbours.get(i).getPositionX();
                double tempY = this.getPositionY() - neighbours.get(i).getPositionY();
                double magnitude = Math.sqrt(Math.pow(tempX, 2) + Math.pow(tempY, 2));
                VsX += tempX / magnitude;
                VsY += tempY / magnitude;
            }

            pCenterX = pCenterX / neighbours.size();
            pCenterY = pCenterY / neighbours.size();
            double VcX = pCenterX - this.getPositionX();
            double VcY = pCenterY - this.getPositionY();

            double thisSpeed = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));

            vAvgX = vAvgX / neighbours.size();
            vAvgY = vAvgY / neighbours.size();
            double VaX = vAvgX - (this.BOID_SIZE * this.dx) / (2 * thisSpeed);
            double VaY = vAvgY - (this.BOID_SIZE * this.dy) / (2 * thisSpeed);

            double speed = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));

            double velX = (this.BOID_SIZE * this.dx) / (2 * speed);
            double velY = (this.BOID_SIZE * this.dy) / (2 * speed);

            double Vx = dx + velX + VcX + VaX + VsX;
            double Vy = dy + velY + VcY + VaY + VsY;


            this.dx = Vx;
            this.dy = Vy;


            this.flock.drawing();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public double getPositionX() { return this.x; }

    @Override
    public double getPositionY() { return this.y; }

    @Override
    public double getMovementX() {
        return this.dx;
    }

    @Override
    public double getMovementY() {
        return this.dy;
    }

    @Override
    public void setPositionX(double x) { this.x = x; }

    @Override
    public void setPositionY(double y) { this.y = y; }

    @Override
    public void setMovementX(double x) { this.dx = x; }

    @Override
    public void setMovementY(double y) { this.dy = y; }

    @Override
    public void draw(Graphics g) {

//          Set important variables
        double speed = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
        double velX = (this.BOID_SIZE * this.dx) / (2 * speed);
        double velY = (this.BOID_SIZE * this.dy) / (2 * speed);

//          Draw lines

        Graphics2D g2 = (Graphics2D) g;
        g2.draw(new Line2D.Double((int) this.x, (int) this.y,  (int) (this.x - velX + velY), (int) (this.y - velX - velY)));
        g2.setColor(this.color[0]);
        g2.draw(new Line2D.Double((int) this.x, (int) this.y,  (int) (this.x - 2 * velX), (int) (this.y - 2 * velY)));
        g2.setColor(this.color[1]);
        g2.draw(new Line2D.Double((int) this.x, (int) this.y,  (int) (this.x - velX - velY), (int) (this.y + velX - velY)));
        g2.setColor(this.color[2]);
    }
}
