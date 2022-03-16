package com.boid;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BoidFlock extends JPanel {
    private List<Boid> boids;

    public BoidFlock() {
        this.boids = new ArrayList<Boid>();
    }

    public void addBoid(Boid boid) {
        this.boids.add(boid);
    }

    public Boid removeBoid() {
        if(boids.size() <= 0 || boids == null ) { return null; }

        Boid removedBoid = boids.remove((int) (Math.random() * this.boids.size()));
        removedBoid.stop();
        return removedBoid;
    }

    public List<Boid> getNeighbours(Boid boid) {
        if(boids.size() <= 0 || boids == null ) { return null; }
        List<Boid> neighbours = new ArrayList<Boid>();

        for(Boid searchBoid : boids) {
            double distance = Math.sqrt( Math.pow(boid.getPositionX() - searchBoid.getPositionX(), 2) + Math.pow(boid.getPositionY() - searchBoid.getPositionY(), 2) );
            if(distance <= boid.RADIUS_DETECTION) { neighbours.add(searchBoid); }
        }

        return neighbours;
    }

    public int boidSize() { return boids.size(); }

    public void drawBoids(Graphics g) {
        super.paintComponent(g);

        if(this.boids == null || this.boids.size() <= 0) { return; }

        for(Boid boid : boids) {
            boid.draw(g);
        }
    }

    public void drawing() {
        repaint();
    }
}
