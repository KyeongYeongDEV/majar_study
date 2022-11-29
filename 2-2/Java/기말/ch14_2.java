import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ch14_2 extends JFrame{
    ImageIcon icon = null;
    Image image = null;

    public ch14_2(){
        JMenuBar mb = new JMenuBar();
        JMenu fileMenu  = new JMenu("파일");
        mb.add(fileMenu);

        JMenuItem open = new JMenuItem("열기");
        fileMenu.add(open);

        setJMenuBar(mb);

        open.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JFileChooser chooser = new JFileChooser();

                FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg","gif","png");
                chooser.setFileFilter(filter);

                int ret = chooser.showOpenDialog(null);
                
                if(ret == JFileChooser.APPROVE_OPTION){
                    String path = chooser.getSelectedFile().getPath();
                    icon = new ImageIcon(path +"/");
                    image = icon.getImage();

                    repaint();
                }
            }
        });

        backImage bi  = new backImage();
        setContentPane(bi);

        setTitle("이미지 불러오기");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,300);
    }

    class backImage extends JPanel{
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    }


    public static void main(String[] args){
        new ch14_2();
    }
}