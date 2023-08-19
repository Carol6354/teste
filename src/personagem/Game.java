package personagem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.util.ArrayList;
import java.util.List;

public class Game extends JPanel {
    private int spriteX;
    private int spriteY;
    private List<Image> spriteImages;
    private int currentFrame;
    private boolean movingLeft;
    private boolean movingRight;
    private boolean movingUp;
    private boolean movingDown;

    public Game() {
        spriteX = 100;
        spriteY = 100;
        spriteImages = new ArrayList<>();
        currentFrame = 0;
        movingLeft = false;
        movingRight = false;
        movingUp = false;
        movingDown = false;

        // Adicione as imagens dos frames da animação para cada direção
        spriteImages.add(new ImageIcon("C:\\Users\\anamo\\Downloads\\JumpShoot (1).png").getImage());
        spriteImages.add(new ImageIcon("C:\\Users\\anamo\\Downloads\\Idle (1).png").getImage());
        spriteImages.add(new ImageIcon("C:\\\\Users\\\\anamo\\\\Downloads\\\\Idle (1).png").getImage());
        spriteImages.add(new ImageIcon("C:\\\\Users\\\\anamo\\\\Downloads\\\\Idle (1).png").getImage());
        spriteImages.add(new ImageIcon("C:\\\\Users\\\\anamo\\\\Downloads\\\\Idle (1).png").getImage());
        spriteImages.add(new ImageIcon("C:\\\\\\\\Users\\\\\\\\anamo\\\\\\\\Downloads\\\\\\\\Idle (1).png").getImage());
        spriteImages.add(new ImageIcon("C:\\\\\\\\Users\\\\\\\\anamo\\\\\\\\Downloads\\\\\\\\Idle (1).png").getImage());
        spriteImages.add(new ImageIcon("C:\\\\\\\\Users\\\\\\\\anamo\\\\\\\\Downloads\\\\\\\\Idle (1).png").getImage());

        startAnimation();
    }

    private void startAnimation() {
        Thread animationThread = new Thread(() -> {
            while (true) {
                if (movingLeft) {
                    currentFrame = 0;
                } else if (movingRight) {
                    currentFrame = 2;
                } else if (movingUp) {
                    currentFrame = 4;
                } else if (movingDown) {
                    currentFrame = 6;
                }

                // Inverte o frame para criar a animação
                if (currentFrame % 2 == 0) {
                    currentFrame++;
                } else {
                    currentFrame--;
                }

                repaint();

                try {
                    Thread.sleep(200); // Ajuste a velocidade da animação conforme necessário
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        animationThread.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int spriteWidth = spriteImages.get(currentFrame).getWidth(null);
        int spriteHeight = spriteImages.get(currentFrame).getHeight(null);

        g.drawImage(spriteImages.get(currentFrame), spriteX, spriteY, null);

        // Desenha um retângulo delimitando o sprite para fins de visualização
        g.setColor(Color.RED);
        g.drawRect(spriteX, spriteY, spriteWidth, spriteHeight);
    }

    public void moveSprite(int dx, int dy) {
        spriteX += dx;
        spriteY += dy;

        if (dx < 0) {
            movingLeft = true;
            movingRight = false;
        } else if (dx > 0) {
            movingLeft = false;
            movingRight = true;
        } else {
            movingLeft = false;
            movingRight = false;
        }

        if (dy < 0) {
            movingUp = true;
            movingDown = false;
        } else if (dy > 0) {
            movingUp = false;
            movingDown = true;
        } else {
            movingUp = false;
            movingDown = false;
        }

        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final Game game = new Game();
        frame.getContentPane().add(game);
        frame.pack();
        frame.setVisible(true);

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch (keyCode) {
                    case KeyEvent.VK_LEFT:
                        game.moveSprite(-10, 0);
                        break;
                    case KeyEvent.VK_RIGHT:
                        game.moveSprite(10, 0);
                        break;
                    case KeyEvent.VK_UP:
                        game.moveSprite(0, -10);
                        break;
                    case KeyEvent.VK_DOWN:
                        game.moveSprite(0, 10);
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch (keyCode) {
                    case KeyEvent.VK_LEFT:
                    case KeyEvent.VK_RIGHT:
                        game.moveSprite(0, 0);
                        break;
                    case KeyEvent.VK_UP:
                    case KeyEvent.VK_DOWN:
                        game.moveSprite(0, 0);
                        break;
                }
            }
        });
    }
}

