package com.pancake;

import com.boid.Boid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class PancakeGUI extends JComponent {

    private final static PancakeStack pancakeStack = new PancakeStack();

    public void drawing(int num) {
        if(num == 0) repaint();
        else {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    super.run();
                    for(int i=pancakeStack.arrayStack.size()-1; i>=0; i--) {

                        int index = pancakeStack.findMax(i);
                        pancakeStack.flip(index);
                        repaint();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        pancakeStack.flip(i);
                        repaint();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            thread.start();
        }

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for(int i=0; i < pancakeStack.arrayStack.size(); i++) {
            pancakeStack.arrayStack.get(i).draw(g, i+1);
        }
    }

    public static void main(String[] args) {
        pancakeStack.push(new Pancake(1, new Color(255, 255, 255)));
        pancakeStack.push(new Pancake(2, new Color(45,79,245)));
        pancakeStack.push(new Pancake(3, new Color(196,76,56)));
        pancakeStack.push(new Pancake(4, new Color(196,76,56)));
        pancakeStack.push(new Pancake(5, new Color(196,76,56)));
        pancakeStack.push(new Pancake(6, new Color(196,76,56)));
        pancakeStack.push(new Pancake(7, new Color(196,76,56)));
        pancakeStack.push(new Pancake(8, new Color(196,76,56)));
        pancakeStack.push(new Pancake(9, new Color(196,76,56)));
        pancakeStack.push(new Pancake(10, new Color(196,76,56)));
        pancakeStack.push(new Pancake(11, new Color(196,76,56)));
        pancakeStack.push(new Pancake(12, new Color(196,76,56)));
        pancakeStack.push(new Pancake(13, new Color(196,76,56)));
        pancakeStack.push(new Pancake(14, new Color(196,76,56)));
        pancakeStack.push(new Pancake(15, new Color(196,76,56)));
        pancakeStack.push(new Pancake(16, new Color(196,76,56)));
        pancakeStack.push(new Pancake(17, new Color(196,76,56)));
        pancakeStack.push(new Pancake(18, new Color(196,76,56)));
        pancakeStack.push(new Pancake(19, new Color(196,76,56)));
        pancakeStack.push(new Pancake(20, new Color(196,76,56)));


        PancakeGUI gui = new PancakeGUI();
        gui.setBounds(100, 100, 500, 350);
        gui.setBackground(new Color(255, 255, 255));

        JFrame frame = new JFrame("Pancake Sort Algorithm");

        gui.drawing(0);

        JButton reset = new JButton("Reset");
        reset.setBounds(125, 250, 100, 20);
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Pancake> newArray = new ArrayList<>();
                while(pancakeStack.arrayStack.size() > 0) {
                    int index = (int) (Math.random() * pancakeStack.arrayStack.size());
                    newArray.add(pancakeStack.arrayStack.get(index));
                    pancakeStack.arrayStack.remove(index);
                }
                pancakeStack.arrayStack = newArray;
                gui.drawing(0);
            }
        });

        JButton resolve = new JButton("Resolve");
        resolve.setBounds(275, 250, 100, 20);
        resolve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.drawing(1);
            }
        });



        frame.add(reset);
        frame.add(resolve);

        frame.add(gui);


        frame.pack();
        frame.setSize(500, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

}
