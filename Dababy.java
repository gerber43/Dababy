import java.util.*;
import java.awt.*;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.event.*;
import javax.swing.*;
import java.time.*;




public class Dababy extends JFrame implements ActionListener{

    JButton yeah;
    JButton noCap;
    JButton lesGo;
    JButton pullUp;
    JButton convert;
    JButton suge;
    JButton rockstar;
    JButton stop;
    JButton sugeFull;
    JButton chipmunk;
    JButton jetson;


    JLabel daText;

    public String filePath() {
        String filePath = System.getProperty("user.dir");
        return filePath;

    }

    String asset = filePath() + "/Assets/Graphics/";

    Dababy(){

        System.out.println(LocalTime.now());

        daText = new JLabel();
        daText.setFont(new Font("Serif", Font. BOLD, 80));
        daText.setBounds(350, 0, 1000, 90);
        daText.setForeground(Color.RED);
        daText.setText("Dababy Soundboard");

        yeah = new JButton();
        yeah.setBounds(150, 100, 250, 100);
        yeah.addActionListener(this);
        yeah.setText("Yeah Yeah");
        yeah.setForeground(new Color(35, 219, 191));
        yeah.setFont(new Font("Serif", Font. BOLD, 40));

        noCap = new JButton();
        noCap.setBounds(450, 100, 250, 100);
        noCap.addActionListener(this);
        noCap.setText("No Cap");
        noCap.setForeground(new Color(35, 219, 191));
        noCap.setFont(new Font("Serif", Font. BOLD, 40));

        lesGo = new JButton();
        lesGo.setBounds(750, 100, 250, 100);
        lesGo.addActionListener(this);
        lesGo.setText("Let's Go");
        lesGo.setForeground(new Color(35, 219, 191));
        lesGo.setFont(new Font("Serif", Font. BOLD, 40));

        pullUp = new JButton();
        pullUp.setBounds(1050, 100, 250, 100);
        pullUp.addActionListener(this);
        pullUp.setText("I Pull Up");
        pullUp.setForeground(new Color(35, 219, 191));
        pullUp.setFont(new Font("Serif", Font. BOLD, 40));

        convert = new JButton();
        convert.setBounds(150, 250, 250, 100);
        convert.addActionListener(this);
        convert.setText("Convertible");
        convert.setForeground(new Color(35, 219, 191));
        convert.setFont(new Font("Serif", Font. BOLD, 40));

        suge = new JButton();
        suge.setBounds(150, 400, 250, 100);
        suge.addActionListener(this);
        suge.setText("Suge Intro");
        suge.setForeground(new Color(35, 219, 191));
        suge.setFont(new Font("Serif", Font. BOLD, 40));

        rockstar = new JButton();
        rockstar.setBounds(150, 550, 250, 100);
        rockstar.addActionListener(this);
        rockstar.setText("Rockstar");
        rockstar.setForeground(new Color(35, 219, 191));
        rockstar.setFont(new Font("Serif", Font. BOLD, 40));

        sugeFull = new JButton();
        sugeFull.setBounds(1050, 250, 250, 100);
        sugeFull.addActionListener(this);
        sugeFull.setText("Suge");
        sugeFull.setForeground(new Color(35, 219, 191));
        sugeFull.setFont(new Font("Serif", Font. BOLD, 40));

        chipmunk = new JButton();
        chipmunk.setBounds(1050, 400, 250, 100);
        chipmunk.addActionListener(this);
        chipmunk.setText("SUGE");
        chipmunk.setForeground(new Color(35, 219, 191));
        chipmunk.setFont(new Font("Serif", Font. BOLD, 40));

        jetson = new JButton();
        jetson.setBounds(1050, 550, 250, 100);
        jetson.addActionListener(this);
        jetson.setText("Oh Lord!");
        jetson.setForeground(new Color(35, 219, 191));
        jetson.setFont(new Font("Serif", Font. BOLD, 40));

        stop = new JButton(new ImageIcon(asset +"stopSign.png"));
        stop.setBounds(700, 775, 50, 50);
        stop.addActionListener(this);
        this.add(stop);

        Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(screenDimension.width,screenDimension.height);
        this.setVisible(true);
        this.getContentPane().setBackground(Color.BLUE);
        this.add(yeah);
        this.add(noCap);
        this.add(lesGo);
        this.add(pullUp);
        this.add(convert);
        this.add(suge);
        this.add(rockstar);
        this.add(sugeFull);
        this.add(daText);
        this.add(chipmunk);
        this.add(jetson);

        Container c = this.getContentPane(); //Gets the content layer
        JLabel label = new JLabel(); //JLabel Creation
        Dimension size = label.getPreferredSize(); //Gets the size of the image





        yeah.addActionListener(e -> label.setIcon(new ImageIcon(asset +"dababy1.png")));
        noCap.addActionListener(e -> label.setIcon(new ImageIcon(asset + "dababy.png")));
        lesGo.addActionListener(e -> label.setIcon(new ImageIcon(asset+ "obama.gif")));
        pullUp.addActionListener(e -> label.setIcon(new ImageIcon(asset+ "dababy3.png")));
        convert.addActionListener(e -> label.setIcon(new ImageIcon(asset +"dababy2.gif")));
        suge.addActionListener(e -> label.setIcon(new ImageIcon(asset +"dababy4.png")));
        stop.addActionListener(e -> label.setIcon(new ImageIcon(asset +"stop.png")));
        rockstar.addActionListener(e -> label.setIcon(new ImageIcon(asset +"rockstar.png")));
        sugeFull.addActionListener(e -> label.setIcon(new ImageIcon(asset +"sugeFull.gif")));
        chipmunk.addActionListener(e -> label.setIcon(new ImageIcon(asset +"chipmunk.png")));
        jetson.addActionListener(e -> label.setIcon(new ImageIcon(asset +"jetson.png")));



        label.setBounds(475, 50, screenDimension.width, screenDimension.height); //Sets the location of the image
        c.add(label); //Adds objects to the container


    }
    ArrayList<Clip> clip = new ArrayList<>();

    public void playAudio(String fileName) {
        try {
            String soundName = filePath() + "/Assets/Audio/" + fileName;
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
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

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == yeah) {
            playAudio("yeah.wav");
        }
        if(e.getSource() == noCap) {
            playAudio("nocap.wav");
        }
        if(e.getSource() == lesGo) {
            playAudio("lesGo.wav");
        }
        if(e.getSource() == pullUp) {
            playAudio("pullUp.wav");
        }
        if(e.getSource() == convert) {
            playAudio("convert.wav");
        }
        if(e.getSource() == suge) {
            playAudio("suge.wav");
        }
        if(e.getSource() == rockstar) {
            playAudio("rockstar.wav");
        }
        if(e.getSource() == stop) {
            stop();
        }
        if(e.getSource() == sugeFull) {
            playAudio("sugeFull.wav");
        }
        if(e.getSource() == chipmunk) {
            playAudio("chipmunk.wav");
        }
        if(e.getSource() == jetson) {
            playAudio("jetson.wav");
        }

    }

    public static void main(String[] args) {
        Dababy dababy = new Dababy();
    }
}
