package com.mycompany.linearequation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class intersectGUI extends JFrame {
    private JTextField[] fields = new JTextField[8];
    private JLabel result = new JLabel("Result:");

    public intersectGUI() {
        setTitle("Intersection");
        setSize(400, 450);
        setLayout(null);

        String[] labels = {"x1", "y1", "x2", "y2", "x3", "y3", "x4", "y4"};
        for (int i = 0; i < 8; i++) {
            JLabel l = new JLabel(labels[i]);
            l.setBounds(20, 20 + i * 35, 30, 25);
            JTextField tf = new JTextField();
            tf.setBounds(60, 20 + i * 35, 100, 25);
            fields[i] = tf;
            add(l);
            add(tf);
        }

        JButton btn = new JButton("find intersection 👆");
        btn.setBounds(60, 310, 180, 30);
        add(btn);

        result.setBounds(60, 350, 300, 30);
        add(result);

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                findIntersectionRslt();
            }
        });

        setVisible(true);
    }

    private void findIntersectionRslt() {
        double[] v = new double[8];
        for (int i = 0; i < 8; i++) {
            String text = fields[i].getText();
            if (text.isEmpty()) {
                result.setText("Please fill all fields.");
                return;
            }
            v[i] = Double.parseDouble(text);
        }

        double a = v[1] - v[3];
        double b = v[2] - v[0];
        double c = v[5] - v[7];
        double d = v[6] - v[4];
        double e = a * v[0] + b * v[1];
        double f = c * v[4] + d * v[5];

        double det = a * d - b * c;

        if (det == 0) {
            result.setText("The lines do not intersect.");
        } else {
            double x = (e * d - b * f) / det;
            double y = (a * f - e * c) / det;
            result.setText("Intersection: (" + x + ", " + y + ")");
        }
    }

    public static void main(String[] args) {
        new intersectGUI();
    }
}
