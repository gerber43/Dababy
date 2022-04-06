import java.util.*;
import java.awt.*;
import java.io.*;
import javax.sound.sampled.*;
import java.awt.event.*;
import javax.swing.*;
import java.time.*;

public class Dababy extends JFrame implements ActionListener{

    Random random = new Random();

    JButton yeah = new JButton();
    JButton noCap = new JButton();
    JButton lesGo = new JButton();
    JButton pullUp = new JButton();
    JButton convert = new JButton();
    JButton suge = new JButton();
    JButton rockstar = new JButton();
    JButton stop = new JButton();
    JButton sugeFull = new JButton();
    JButton chipmunk = new JButton();
    JButton jetson = new JButton();
    JButton clock = new JButton();
    JButton sound = new JButton();
    JButton hit = new JButton();
    JButton custom = new JButton();



    JButton left = new JButton();
    JButton right = new JButton();
    JButton up = new JButton();
    JButton down = new JButton();




    JLabel daSoundText = new JLabel();
    JLabel daClockText = new JLabel();
    JLabel daClock = new JLabel();

    JLabel daIcon = new JLabel();
    JLabel daFood = new JLabel();






    Container c = this.getContentPane();
    JLabel label = new JLabel();

    Dimension size = label.getPreferredSize();

    public String filePath() {
        String filePath = System.getProperty("user.dir");
        return filePath;
    }

    String asset = filePath() + "/Assets/Graphics/";
    public void buttonMaker(JButton name, int x, int y, int width, int height, String text) {
        name.setBounds(x, y, width, height);
        name.addActionListener(this);
        name.setText(text);
        name.setForeground(new Color(35, 219, 191));
        name.setFont(new Font("Serif", Font. BOLD, 40));
        this.add(name);
    }
    Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
    int x = 50 * ((screenDimension.width - 50)/100);
    int y = 0;

    Dababy(){

        label.setIcon(new ImageIcon(asset + "welcome.png"));
        daIcon.setIcon(new ImageIcon(asset + "right.png"));
        daFood.setIcon(new ImageIcon(asset + "left.png"));




        daSoundText.setFont(new Font("Serif", Font. BOLD, 80));
        daSoundText.setBounds(375, 0, 1000, 90);
        daSoundText.setForeground(Color.RED);
        daSoundText.setText("Dababy Soundboard");
        this.add(daSoundText);

        scoreReader();
        daClockText.setFont(new Font("Serif", Font. BOLD, 80));
        daClockText.setBounds(300, 0, 1000, 90);
        daClockText.setForeground(Color.RED);
        daClockText.setText("Score : " + score + " Highscore : " + highScore);
        this.add(daClockText);
        daClockText.setVisible(false);



        buttonMaker(yeah, 150, 100, 250, 100,"Yeah Yeah");
        buttonMaker(noCap, 450, 100, 250, 100,"No Cap");
        buttonMaker(lesGo, 750, 100, 250, 100,"Let's Go");
        buttonMaker(pullUp, 1050, 100, 250, 100,"I Pull Up");
        buttonMaker(convert, 150, 250, 250, 100,"Convertible");
        buttonMaker(suge, 150, 400, 250, 100,"Suge Intro");
        buttonMaker(rockstar, 150, 550, 250, 100,"Rockstar");
        buttonMaker(sugeFull, 1050, 250, 250, 100,"Suge");
        buttonMaker(chipmunk, 1050, 400, 250, 100,"SUGE");
        buttonMaker(jetson, 1050, 550, 250, 100,"Oh Lord!");
        buttonMaker(hit, 1050, 700, 250, 100,"HIT HIT");
        buttonMaker(custom, 150, 700, 250, 100,"Custom");



        left.setBounds(50, 600, 100, 100);
        left.addActionListener(this);
        left.setText("Left");
        left.setForeground(new Color(35, 219, 191));
        left.setFont(new Font("Serif", Font. BOLD, 20));
        this.add(left);
        left.setVisible(false);

        right.setBounds(150, 600, 100, 100);
        right.addActionListener(this);
        right.setText("Right");
        right.setForeground(new Color(35, 219, 191));
        right.setFont(new Font("Serif", Font. BOLD, 20));
        this.add(right);
        right.setVisible(false);

        up.setBounds(100, 500, 100, 100);
        up.addActionListener(this);
        up.setText("Up");
        up.setForeground(new Color(35, 219, 191));
        up.setFont(new Font("Serif", Font. BOLD, 20));
        this.add(up);
        up.setVisible(false);

        down.setBounds(100, 700, 100, 100);
        down.addActionListener(this);
        down.setText("Down");
        down.setForeground(new Color(35, 219, 191));
        down.setFont(new Font("Serif", Font. BOLD, 20));
        this.add(down);
        down.setVisible(false);


        stop = new JButton(new ImageIcon(asset +"stopSign.png"));
        stop.setBounds(700, 775, 50, 50);
        stop.addActionListener(this);
        this.add(stop);

        clock = new JButton(new ImageIcon(asset +"clock.png"));
        clock.setBounds(800, 775, 50, 50);
        clock.addActionListener(this);
        this.add(clock);

        sound = new JButton(new ImageIcon(asset +"soundboard.png"));
        sound.setBounds(600, 775, 50, 50);
        sound.addActionListener(this);
        this.add(sound);
        sound.setVisible(false);



        label.setBounds(475, 50, screenDimension.width, screenDimension.height);
        c.add(label);
        daIcon.setBounds(x, y, screenDimension.width, screenDimension.height);
        c.add(daIcon);

        daFood.setBounds(getRandomX(), getRandomY(), screenDimension.width, screenDimension.height);
        c.add(daFood);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(screenDimension.width,screenDimension.height);
        this.setVisible(true);
        this.getContentPane().setBackground(Color.BLUE);


        daClock.setFont(new Font("Serif", Font. BOLD, 80));
        daClock.setBounds(600, 650, 1000, 90);
        daClock.setForeground(Color.RED);
        daClock.setText((String.valueOf(LocalTime.now())).substring(0,(String.valueOf(LocalTime.now())).indexOf('.')));
        this.add(daClock);
        daClock.setVisible(false);
        daFood.setVisible(false);



    }
    ArrayList<Clip> clip = new ArrayList<>();

    int xRand = 0;
    int yRand = 0;
    int score = 0;
    int direction = 0;
    int highScore = 0;
    
    public void scoreWriter() {
        try {

            if (highScore <= score) {
                BufferedWriter writer = new BufferedWriter(new FileWriter("score.txt",false)); //write
                writer.write(String.valueOf(score));
                highScore = score;
                writer.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        daClockText.setText("Score : " + score + " Highscore : " + highScore);

    }
    
    public void scoreReader() {
        String line = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader("score.txt"));
            highScore = Integer.valueOf(reader.readLine());
            reader.close();





        } catch (Exception e) {
            highScore = 0;

        } finally {

        }
    }


    public int getRandomX() {
        xRand = 50 * ((random.nextInt((screenDimension.width - 50)/50)));
        return xRand;
    }
    public int getRandomY() {
        yRand = 50 * (((random.nextInt((screenDimension.height)/50)) - ((screenDimension.height-50)/50)/2)) ;
        return yRand;
    }

    public void changeDirection() {
        direction = random.nextInt(3);
        switch (direction) {
            case 0:
                daFood.setIcon(new ImageIcon(asset + "left.png"));
                break;
            case 1:
                daFood.setIcon(new ImageIcon(asset + "right.png"));
                break;
            case 2:
                daFood.setIcon(new ImageIcon(asset + "up.png"));
                break;
            case 3:
                daFood.setIcon(new ImageIcon(asset + "down.png"));

        }

    }


    public void playAudio(String fileName) {
        try {
            String soundName = filePath() + "/Assets/Audio/" + fileName;
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).
                    getAbsoluteFile());
            clip.add(AudioSystem.getClip());
            (clip.get(clip.size()-1)).open(audioInputStream);
            (clip.get(clip.size()-1)).start();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    public void stop(){
        for (int i = 0; i < clip.size(); i++) {
            try {
                (clip.get(i)).stop();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        clip.clear();
        System.out.println(x+","+y+","+xRand+","+yRand);
        changeDirection();
    }

    public void buttonAction(ActionEvent e, JButton button,String audio, String image) {
        if(e.getSource() == button) {
            playAudio(audio);
            label.setIcon(new ImageIcon(asset + image));
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        buttonAction(e, yeah, "yeah.wav","yeah.png");
        buttonAction(e, noCap,"noCap.wav", "noCap.png");
        buttonAction(e, lesGo,"lesGo.wav", "lesGo.gif");
        buttonAction(e, pullUp,"pullUp.wav", "pullUp.png");
        buttonAction(e, convert,"convert.wav", "convert.gif");
        buttonAction(e, suge,"suge.wav", "suge.png");
        buttonAction(e, rockstar,"rockstar.wav", "rockstar.png");
        buttonAction(e, chipmunk,"chipmunk.wav", "chipmunk.png");
        buttonAction(e, jetson,"jetson.wav", "jetson.png");
        buttonAction(e, sugeFull,"sugeFull.wav", "sugeFull.gif");
        buttonAction(e, hit,"hit.wav", "hit.png");
        buttonAction(e, custom,"custom.wav", "custom.png");



        if(e.getSource() == stop) {
            stop();
            label.setIcon(new ImageIcon(asset + "stop.png"));
            daFood.setBounds(getRandomX(), getRandomY(), screenDimension.width, screenDimension.height);

        }
        if(e.getSource() == clock) {
            c.add(daIcon);
            c.add(daFood);
            sound.setVisible(true);
            clock.setVisible(false);
            daIcon.setVisible(true);
            daFood.setVisible(true);
            left.setVisible(true);
            right.setVisible(true);
            up.setVisible(true);
            down.setVisible(true);
            yeah.setVisible(false);
            noCap.setVisible(false);
            lesGo.setVisible(false);
            pullUp.setVisible(false);
            convert.setVisible(false);
            suge.setVisible(false);
            rockstar.setVisible(false);
            chipmunk.setVisible(false);
            jetson.setVisible(false);
            sugeFull.setVisible(false);
            label.setVisible(false);
            daSoundText.setVisible(false);
            daClockText.setVisible(true);
            daClock.setVisible(true);
            hit.setVisible(false);
            custom.setVisible(false);





        }


        if(e.getSource() == sound) {
            daIcon.setVisible(false);
            daFood.setVisible(false);


            left.setVisible(false);
            right.setVisible(false);
            up.setVisible(false);
            down.setVisible(false);


            yeah.setVisible(true);
            noCap.setVisible(true);
            lesGo.setVisible(true);
            pullUp.setVisible(true);
            convert.setVisible(true);
            suge.setVisible(true);
            rockstar.setVisible(true);
            chipmunk.setVisible(true);
            jetson.setVisible(true);
            sugeFull.setVisible(true);
            label.setVisible(true);
            daSoundText.setVisible(true);
            daClockText.setVisible(false);
            daClock.setVisible(false);
            sound.setVisible(false);
            clock.setVisible(true);
            hit.setVisible(true);
            custom.setVisible(true);



        }
        if(e.getSource() == left) {
            x = x - 50;
            motionControl();
            daIcon.setIcon(new ImageIcon(asset + "left.png"));
            if ((direction == 0) && (y == yRand) && (x == xRand)) {
                score++;
                daFood.setBounds(getRandomX(), getRandomY(), screenDimension.width, screenDimension.height);
                changeDirection();
                scoreWriter();
            }

        }
        if(e.getSource() == right) {
            x = x + 50;
            motionControl();
            daIcon.setIcon(new ImageIcon(asset + "right.png"));
            if ((direction == 1) && (y == yRand) && (x == xRand)) {
                score++;
                daFood.setBounds(getRandomX(), getRandomY(), screenDimension.width, screenDimension.height);
                changeDirection();
                scoreWriter();
            }

        }
        if(e.getSource() == up) {
            y = y - 50;


            motionControl();


            daIcon.setIcon(new ImageIcon(asset + "up.png"));

            if ((direction == 2) && (y == yRand) && (x == xRand)) {
                score++;

                daFood.setBounds(getRandomX(), getRandomY(), screenDimension.width, screenDimension.height);
                changeDirection();
                scoreWriter();



            }



        }

        if(e.getSource() == down) {
            y = y + 50;
            motionControl();

            daIcon.setIcon(new ImageIcon(asset + "down.png"));


            if ((direction == 3) && (y == yRand) && (x == xRand)) {
                score++;

                daFood.setBounds(getRandomX(), getRandomY(), screenDimension.width, screenDimension.height);
                changeDirection();
                scoreWriter();

            }

        }


    }

    public void clicker() {
        while (true) {
            try {
                daClock.setText((String.valueOf(LocalTime.now())).substring(0, 8));
            } catch (Exception e) {
                daClock.setText((String.valueOf(LocalTime.now())).substring(0, 5));


            }

        }
    }

    public void motionControl() {
        x = 50 * (x/50);
        y = 50 * (y/50);

        if (x < -50) {
            x = screenDimension.width - 50;
        }

        if (x > screenDimension.width) {
            x = -50;
        }

        if (y < (-1 * (screenDimension.height)/2)) {
            y = ((screenDimension.height)/2 - 50);
        }

        if (y > ((screenDimension.height)/2) - 50) {
            y = ((-1 * (screenDimension.height)/2));
        }
        daIcon.setBounds(x, y , screenDimension.width, screenDimension.height);
        c.add(daIcon);

    }

    public void keyTyped(KeyEvent e) {
        System.out.println(e);
    }


    public static void main(String[] args) {
        Dababy dababy = new Dababy();
        Thread thread = new Thread();
        dababy.clicker();




    }
}
