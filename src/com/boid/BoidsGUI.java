package com.boid;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoidsGUI extends JComponent{
    private final static BoidFlock boidFlock = new BoidFlock();

    public void drawing() {
        Timer timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        boidFlock.drawBoids(g);
    }

    public Dimension getPreferredSize() { return new Dimension(700, 400); }

    public static void main(String[] args) {
        BoidsGUI gui = new BoidsGUI();
        gui.setBounds(100, 100, 700, 400);
        gui.drawing();
        gui.setBackground(new Color(255, 255, 255));


        JFrame frame = new JFrame("Boids - Flocking Algorithm");

        frame.setBackground(new Color(173, 173, 173));

//      Text
        JLabel sizeLabel = new JLabel("Num Boids: " + boidFlock.boidSize());
        sizeLabel.setBounds(300, 0, 95, 30);


//      Add BoidFlock JButton
        JButton addBoid = new JButton("Add Boid");
        addBoid.setBounds(450, 430, 100, 20);
        addBoid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Boid newBoid = new Boid(boidFlock);
                Thread thread = new Thread(newBoid);
                thread.start();
                boidFlock.addBoid(newBoid);
                sizeLabel.setText("Num Boids: " + boidFlock.boidSize());
            }
        });

//      Add BoidFlock JButton
        JButton removeBoid = new JButton("Remove Boid");
        removeBoid.setBounds(560, 430, 120, 20);
        removeBoid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boidFlock.removeBoid();
                sizeLabel.setText("Num Boids: " + boidFlock.boidSize());
            }
        });

        JSlider separation = new JSlider(0, 100, 0);
        separation.setBounds(10, 430, 100, 20);
        separation.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
            }
        });
        JLabel separationLabel = new JLabel("Separation Weight");
        separationLabel.setFont(new Font("Serif", Font.PLAIN, 12));
        separationLabel.setBounds(10, 410, 100, 20);

        JSlider alignment = new JSlider(0, 100, 0);
        alignment.setBounds(115, 430, 100, 20);
        JLabel alignmentLabel = new JLabel("Alignment Weight");
        alignmentLabel.setFont(new Font("Serif", Font.PLAIN, 12));
        alignmentLabel.setBounds(115, 410, 100, 20);

        JSlider cohesion = new JSlider(0, 100, 0);
        cohesion.setBounds(220, 430, 100, 20);
        JLabel cohesionLabel = new JLabel("Cohesion Weight");
        cohesionLabel.setFont(new Font("Serif", Font.PLAIN, 12));
        cohesionLabel.setBounds(220, 410, 100, 20);

        JSlider radius = new JSlider(0, 100, 0);
        radius.setBounds(325, 430, 100, 20);
        JLabel radiusLabel = new JLabel("Radius Weight");
        radiusLabel.setFont(new Font("Serif", Font.PLAIN, 12));
        radiusLabel.setBounds(325, 410, 100, 20);



        frame.add(sizeLabel);
        frame.add(addBoid);
        frame.add(removeBoid);

        frame.add(separation);
        frame.add(separationLabel);

        frame.add(alignment);
        frame.add(alignmentLabel);

        frame.add(cohesion);
        frame.add(cohesionLabel);

        frame.add(radius);
        frame.add(radiusLabel);

        frame.add(gui);

        frame.pack();
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


    }
}
