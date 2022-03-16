package com.boid;

public abstract class AbstractBoid implements BoidInterface {
    public int WORLD_WIDTH = 700;
    public int WORLD_HEIGHT = 400;
    public int BOID_SIZE = 20;
    public int RADIUS_DETECTION = 100;
    public float COHESION_WEIGHT;
    public float SEPARATION_WEIGHT;
    public float ALIGNMENT_WEIGHT;
    public float MAX_SPEED = 10;
}
