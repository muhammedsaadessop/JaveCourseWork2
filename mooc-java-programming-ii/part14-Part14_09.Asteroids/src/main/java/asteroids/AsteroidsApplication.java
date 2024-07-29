package asteroids;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class AsteroidsApplication {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int SHIP_SIZE = 30;
    private static final int ASTEROID_SIZE = 50;
    private static final int PROJECTILE_SIZE = 5;

    private static JFrame frame;
    private static GamePanel panel;
    private static Ship ship;
    private static ArrayList<Asteroid> asteroids;
    private static ArrayList<Projectile> projectiles;
    private static int score = 0;

    public static void main(String[] args) {
        frame = new JFrame("Asteroids Game");
        panel = new GamePanel();
        frame.add(panel);
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        ship = new Ship(WIDTH / 2, HEIGHT / 2);
        asteroids = new ArrayList<>();
        projectiles = new ArrayList<>();
        generateAsteroids();

        Timer timer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update();
                panel.repaint();
            }
        });
        timer.start();
    }

    private static void update() {
        ship.move();
        for (Projectile projectile : projectiles) {
            projectile.move();
        }
        for (Asteroid asteroid : asteroids) {
            asteroid.move();
        }
        checkCollisions();
        removeOffScreenObjects();
    }

    private static void generateAsteroids() {
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            asteroids.add(new Asteroid(random.nextInt(WIDTH), random.nextInt(HEIGHT)));
        }
    }

    private static void checkCollisions() {
        ArrayList<Asteroid> asteroidsToRemove = new ArrayList<>();
        ArrayList<Projectile> projectilesToRemove = new ArrayList<>();

        for (Asteroid asteroid : asteroids) {
            if (ship.getBounds().intersects(asteroid.getBounds())) {
                gameOver();
            }
            for (Projectile projectile : projectiles) {
                if (projectile.getBounds().intersects(asteroid.getBounds())) {
                    asteroidsToRemove.add(asteroid);
                    projectilesToRemove.add(projectile);
                    score += 10;
                }
            }
        }

        asteroids.removeAll(asteroidsToRemove);
        projectiles.removeAll(projectilesToRemove);
        if (asteroids.isEmpty()) {
            generateAsteroids();
        }
    }

    private static void removeOffScreenObjects() {
        projectiles.removeIf(p -> p.getX() < 0 || p.getX() > WIDTH || p.getY() < 0 || p.getY() > HEIGHT);
        asteroids.removeIf(a -> a.getX() < 0 || a.getX() > WIDTH || a.getY() < 0 || a.getY() > HEIGHT);
    }

    private static void gameOver() {
        JOptionPane.showMessageDialog(frame, "Game Over! Your score: " + score);
        System.exit(0);
    }

    public static int partsCompleted() {
        return 4;
    }

    static class GamePanel extends JPanel {

        public GamePanel() {
            setBackground(Color.BLACK);
            setFocusable(true);
            addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {}

                @Override
                public void keyPressed(KeyEvent e) {
                    ship.keyPressed(e);
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    ship.keyReleased(e);
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            ship.draw(g);
            for (Asteroid asteroid : asteroids) {
                asteroid.draw(g);
            }
            for (Projectile projectile : projectiles) {
                projectile.draw(g);
            }
        }
    }

    static class Ship {

        private int x, y, dx, dy;
        private boolean up, left, right, shoot;

        public Ship(int x, int y) {
            this.x = x;
            this.y = y;
            this.dx = 0;
            this.dy = 0;
        }

        public void move() {
            x += dx;
            y += dy;
            if (x < 0) x = WIDTH;
            if (x > WIDTH) x = 0;
            if (y < 0) y = HEIGHT;
            if (y > HEIGHT) y = 0;

            if (shoot) {
                projectiles.add(new Projectile(x, y));
                shoot = false;
            }
        }

        public void draw(Graphics g) {
            g.setColor(Color.WHITE);
            g.fillPolygon(new int[]{x, x - SHIP_SIZE, x + SHIP_SIZE}, new int[]{y, y + SHIP_SIZE, y + SHIP_SIZE}, 3);
        }

        public Rectangle getBounds() {
            return new Rectangle(x - SHIP_SIZE / 2, y - SHIP_SIZE / 2, SHIP_SIZE, SHIP_SIZE);
        }

        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    dy = -5;
                    break;
                case KeyEvent.VK_DOWN:
                    dy = 5;
                    break;
                case KeyEvent.VK_LEFT:
                    dx = -5;
                    break;
                case KeyEvent.VK_RIGHT:
                    dx = 5;
                    break;
                case KeyEvent.VK_SPACE:
                    shoot = true;
                    break;
            }
        }

        public void keyReleased(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                case KeyEvent.VK_DOWN:
                    dy = 0;
                    break;
                case KeyEvent.VK_LEFT:
                case KeyEvent.VK_RIGHT:
                    dx = 0;
                    break;
                case KeyEvent.VK_SPACE:
                    shoot = false;
                    break;
            }
        }
    }

    static class Asteroid {

        private int x, y, dx, dy;

        public Asteroid(int x, int y) {
            this.x = x;
            this.y = y;
            this.dx = new Random().nextInt(5) - 2;
            this.dy = new Random().nextInt(5) - 2;
        }

        public void move() {
            x += dx;
            y += dy;
        }

        public void draw(Graphics g) {
            g.setColor(Color.GRAY);
            g.fillOval(x, y, ASTEROID_SIZE, ASTEROID_SIZE);
        }

        public Rectangle getBounds() {
            return new Rectangle(x, y, ASTEROID_SIZE, ASTEROID_SIZE);
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    static class Projectile {

        private int x, y, dx, dy;

        public Projectile(int x, int y) {
            this.x = x;
            this.y = y;
            this.dx = 0;
            this.dy = -10;
        }

        public void move() {
            x += dx;
            y += dy;
        }

        public void draw(Graphics g) {
            g.setColor(Color.RED);
            g.fillOval(x, y, PROJECTILE_SIZE, PROJECTILE_SIZE);
        }

        public Rectangle getBounds() {
            return new Rectangle(x, y, PROJECTILE_SIZE, PROJECTILE_SIZE);
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
