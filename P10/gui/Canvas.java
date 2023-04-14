package gui;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.BasicStroke;
import java.awt.image.BufferedImage;
import java.awt.Font;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.border.EmptyBorder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.InputMismatchException; 
import java.util.NoSuchElementException;
import java.io.File;
import java.io.IOException;

class Line {
    public Line(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    public int x1, y1, x2, y2;
}

public class Canvas extends JPanel {
    public Canvas(String imageFile) {
        setBorder(new EmptyBorder(0,0,0,0));
        
        // Load image
        try {
            image = ImageIO.read(new File(imageFile));
        } catch (IOException e) {
            System.err.println("Abort in About screen: Unable to load " + imageFile + "\n" + e);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(640, 640);
    } 

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics); 
        Graphics2D g = (Graphics2D) graphics.create();
       
        java.awt.Rectangle size = getBounds();
        int xOffset = size.width / 2;
        int yOffset = size.height/2;
        g.translate(xOffset, yOffset);
        
        double maxRadius = (double) Math.max(xOffset, yOffset);
        final int numRays = 32;
        int green = (int) (Math.random() * 256);
        int gDelta = 2048 / numRays;
        g.setStroke(new BasicStroke(3));
        for(int i = 0; i < numRays; ++i ) {
            double angle = Math.toRadians(((double) i / numRays) * 360.0);
            green += gDelta;
            if(green > 255) {green = 510-green; gDelta = -(Math.abs(gDelta));}
            if(green <   0) {green =    -green; gDelta =  (Math.abs(gDelta));}
            g.setColor(new Color(255, green, 0));
            g.drawLine(0, 0, (int) (Math.cos(angle) * maxRadius), (int) (Math.sin(angle) * maxRadius));
        }

        g.drawImage(image, -image.getWidth() /2, 
                           -image.getHeight()/2, this);
                           
        g.setColor(Color.BLUE);
        g.setFont(new Font("Helvetica", Font.BOLD, 20)); 
        g.drawString("The Computers for the Best of Us™", -240, 240);
        
   }
    
    private BufferedImage image;
    
}
