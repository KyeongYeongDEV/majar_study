import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class StoneDraw implements MouseListener {
    JPanel contentPane = null;
    final int STONE_SIZE = 26;
    Color StoneColor = Color.BLACK;

    int scoreB = 0;
    int scoreW = 0;

    int OmockBoard[][] = new int[15][15];

    public StoneDraw(JPanel c) {
        super();
        contentPane = c;
        for (int i = 0; i > 15; i++)
            for (int j = 0; j < 15; j++)
                OmockBoard[i][j] = 0;
        OmockBoard[7][7] = 1;
    }

    //scoreVarEstimation(x, y,2)
    //-scoreVarEstimation(x, y,1)
 
    public int scoreVarEstimation(int x, int y, int c) {
        int score_var = 0;
        // for (int i = 2; i < 5; i++) {
        //     score_var = (checkMinLineWithBlank(x, y, c, i) - checkBlockedNinLineWithBlank(x, y, c, i, 1)
        //             - checkBlockedNinLineWithBlank(x, y, c, i, 2)) * i * 10;
        //     score_var += checkBlockedNinLineWithBlank(x, y, c, i, 1) * i * 3;
        // }

        // if (checkMinLine(x, y, c, 3) == 2
        //         && checkBlockedNinLine(x, y, c, 3, 1) + checkBlockedNinLine(x, y, c, 3, 2) == 0)
        //     score_var = 100000;

        // if (checkMinLineWithBlank(x, y, c, 3) == 2
        //         && checkBlockedNinLineWithBlank(x, y, c, 3, 1) + checkBlockedNinLineWithBlank(x, y, c, 3, 2) == 0)
        //     score_var = 100000;

        // if (checkMinLine(x, y, c, 5) > 1) score_var = checkMinLine(x, y, c, 5) * 100000000;

        for (int i = 2; i < 5; i++) {
            int line = checkMinLine(x, y, c, i);
            if (line > 0) score_var += line * i * 10;
        }

        if (checkMinLine(x, y, c, 5) > 1)
            score_var = checkMinLine(x, y, c, 5) * 1000000;

        return score_var;
    }

    class P {
        public int i = -1;
        public int j = -1;

        int MAX = -Integer.MIN_VALUE;
        int MIN = -Integer.MAX_VALUE;

        public P(int _i, int _j) {
            i = _i;
            j = _j;
        }

        public P() {

        }
    }

    public P GameTree(int c, int limit) {

        return getPositionForMax(c, limit, 0);
    }

    private StoneDraw.P getPositionForMax(int c, int limit, int cur_score) {
        // min 중에 max 찾기
        P r_val = new P();

        if(limit == 0) {
            r_val.MAX = cur_score;
            return r_val;
        }
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if (this.OmockBoard[i][j] == 0) {
                    this.OmockBoard[i][j] = c;

                    if (checkMinLine(i, j, OmockBoard[i][j], 5) > 0) {
                        r_val.MAX = cur_score + scoreVarEstimation(i, j, c)- scoreVarEstimation(i, j, 3 - c);
                        r_val.i = i;
                        r_val.j = j;
                        this.OmockBoard[i][j] = 0;

                        return r_val;
                    }

                    P temp = getPositionForMin(3 - c, limit - 1, cur_score + scoreVarEstimation(i, j, c));

                    if (r_val.MAX < temp.MIN) {
                        r_val.MAX = temp.MIN;
                        r_val.i = i;
                        r_val.j = j;
                    }
                    this.OmockBoard[i][j] = 0;
                }
            }
        }

        return r_val;
    }
    // TODO :
    private StoneDraw.P getPositionForMin(int c, int limit, int cur_score) {
        // Max 중에 min  찾기

        P r_val = new P();

        if(limit == 0) {
            r_val.MIN = cur_score;
            return r_val;
        }

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if (this.OmockBoard[i][j] == 0) {
                    this.OmockBoard[i][j] = c;
                    if (checkMinLine(i, j, OmockBoard[i][j], 5) > 0) {
                        r_val.MIN = cur_score - scoreVarEstimation(i, j, c);// scoreVarEstimation(i, j, 3 - c);
                        r_val.i = i;
                        r_val.j = j;
                        this.OmockBoard[i][j] = 0;
                        return r_val;
                    }

                    P temp = getPositionForMax(3 - c, limit - 1, cur_score - scoreVarEstimation(i, j, c));
                    if (r_val.MIN > temp.MAX) {
                        r_val.MIN = temp.MAX;
                        r_val.i = i;
                        r_val.j = j;
                    }
                    this.OmockBoard[i][j] = 0;
                }
            }
        }

        return r_val;
    }

    public void AIStoneDraw() {
        int color = 2;
        if (StoneColor.equals(Color.BLACK)) {
            StoneColor = Color.WHITE;
            color = 2;
            //OmockBoard[i][j] = 2;
        } else {
            StoneColor = Color.BLACK;
            color = 1;
            //OmockBoard[i][j] = 2;
        }

        P next_P = GameTree(color, 1);


        int i = next_P.i;
        int j = next_P.j;
        OmockBoard[i][j] = color;

        System.out.println("AI :(" + i + "," + j + "):" + next_P.MAX);
        Graphics g = contentPane.getGraphics();

        g.setColor(StoneColor);  

        int x = i * 30 + 10 - STONE_SIZE / 2;  
        int y = j * 30 + 10 - STONE_SIZE / 2;
        g.fillOval(x, y, STONE_SIZE, STONE_SIZE);

        if (checkMinLine(i, j, OmockBoard[i][j], 5) > 0) {
            if (StoneColor.equals(Color.BLACK)) JOptionPane.showMessageDialog(null, "Black Win");
            else JOptionPane.showMessageDialog(null, "White Win");
            System.exit(0);

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Graphics g = contentPane.getGraphics();

        int i = (e.getX() - 10 + 15) / 30;
        int j = (e.getY() - 10 + 15) / 30;

        System.out.println(i + "," + j);

        if (OmockBoard[i][j] != 0) return;

        if (StoneColor.equals(Color.BLACK)) {
            StoneColor = Color.WHITE;
            OmockBoard[i][j] = 2;
        } else {
            StoneColor = Color.BLACK;
            OmockBoard[i][j] = 2;
        }
        g.setColor(StoneColor);

        int x = i * 30 + 10 - STONE_SIZE / 2;
        int y = j * 30 + 10 - STONE_SIZE / 2;
        g.fillOval(x, y, STONE_SIZE, STONE_SIZE);

        if (checkMinLine(i, j, OmockBoard[i][j], 5) > 0) {
            if (StoneColor.equals(Color.BLACK)) JOptionPane.showMessageDialog(null, "Black Win");
            else JOptionPane.showMessageDialog(null, "White Win");
            System.exit(0);

        }

        AIStoneDraw();

/*
        Robot r;
        try {
            r = new Robot();
            r.mouseMove(300, 300);
            r.mousePress(InputEvent.BUTTON1_MASK);
            r.mouseRelease(InputEvent.BUTTON1_MASK);
        }
        catch (AWTException el){
            el.printStackTrace();
        }
*/
    }
    

    public int checkMinLine(int x, int y, int c, int n) {
        int noOfNinLine = 0;
        //흰 2  검 1

        int h = 1;
        int xNextWhite =0; 
        boolean check = false;
        for (int i = x + 1; i >= 0 && i < 15 && c == OmockBoard[i][y]; i++) { // 오른쪽 수평
            if(i + 1 <15) xNextWhite = i+1;

            if(n != 5 && OmockBoard[xNextWhite][y] == 2){ //만약 다음다음에 있는 돌이 사용자가 놓은 돌이면
                check = true;
                break; //사용자가 놓은 돌을 만나면 더 좋은 수가 있지 않으니 break
            }

            h++;
        }
        for (int i = x - 1; i >= 0 && i < 15 && c == OmockBoard[i][y]; i--) {
            if(i - 1 >= 0) xNextWhite = i-1;

            if(n != 5 && OmockBoard[xNextWhite][y] == 2){
                check = true;
                break;
            }
            h++;
        }

        if (h == n) {
            //돌을 놓았을 때 상대의 돌이 있다면 점수를 적게 주고 
            if(check){ 
                noOfNinLine++;
            }
            else{ // 없다면 점수를 많이 준다
                noOfNinLine += 2;
            }
        }


        int v = 1;
        int yNextWhite = 0;
        for (int i = y + 1; i >= 0 && i < 15 && c == OmockBoard[x][i]; i++){

            if(i + 1 <15) yNextWhite = i+1;

            if(n != 5 && OmockBoard[x][yNextWhite] == 2){
                check = true;
                break;
            }
            v++;
        }
        for (int i = y - 1; i >= 0 && i < 15 && c == OmockBoard[x][i]; i--){
            if(i - 1 >= 0) yNextWhite = i-1;

            if(n != 5 && OmockBoard[x][yNextWhite] == 2){
                check = true;
                break;
            }
            v++;
        }
        if (v == n) {
            if(check){
                noOfNinLine++;
            }
            else{
                noOfNinLine += 2;
            }
        }
        //대각선
        int ld = 1;
        for (int i = 1; x + i >= 0 && x + i < 15 && y + i >= 0 && y + i < 15 && c == OmockBoard[x + i][y + i]; i++){
            if(x+ i + 1 <15 && x + i + 1 >= 0 && y + i +1 < 15 && y + i + 1 >= 0) {
                xNextWhite = x + i +1;
                yNextWhite = y + i +1;
            }

            if(n != 5 && OmockBoard[xNextWhite][yNextWhite]  == 2){
                check = true;
                break;
            }

            ld++;
        }
            
        for (int i = 1; x - i >= 0 && x - i < 15 && y - i >= 0 && y - i < 15 && c == OmockBoard[x - i][y - i]; i++){
            if(x - i - 1 >= 0 && x - i -1 < 15 && y - i - 1 >= 0 && y - i -1 < 15) {
                xNextWhite = x - i - 1;
                yNextWhite = y - i - 1;
            }

            if(n != 5 && OmockBoard[xNextWhite][yNextWhite] == 2){
                check = true;
                break;
            }

            ld++;
        }
            
        if (ld == n){
            if(check){
                noOfNinLine++;
            }
            else{
                noOfNinLine += 2;
            }
        } 

        int rd = 1;
        for (int i = 1; x - i >= 0 && x - i < 15 && y + i >= 0 && y + i < 15 && c == OmockBoard[x - i][y + i]; i++){
            if(x - i - 1 >= 0 && x - i - 1 < 15 && y + i + 1 < 15 && y + i +1 >= 0) {
                xNextWhite = x - i - 1;
                yNextWhite = y + i + 1;
            }

            if(n != 5 && OmockBoard[xNextWhite][yNextWhite] == 2){
                check = true;
                break;
            }

            rd++;
        }
        
            
        for (int i = 1; x + i >= 0 && x + i < 15 && y - i >= 0 && y - i < 15 && c == OmockBoard[x + i][y - i]; i++){
            if(x + i + 1 < 15 && x + i + 1 >= 0 && y - i - 1 >= 0 && y - i -1 < 15) {
                xNextWhite = x + i + 1;
                yNextWhite = y - i - 1;
            }

            if(n != 5 && OmockBoard[xNextWhite][yNextWhite] == 2){
                check = true;
                break;
            }

            rd++;
        }
            
        if (rd == n){
            if(check){
                noOfNinLine++;
            }
            else{
                noOfNinLine += 2;
            }
        }

        return noOfNinLine;
    }
    

    public int checkMinLineWithBlank(int x, int y, int c, int n) {
        int noOfNinLine = 0;

        int blank = 1;

        int h = 1;
        for (int i = x + 1; i >= 0 && i < 15; i++) {
            if (c == OmockBoard[i][y]) h++;
            else if (blank == 1) {
                blank--;
            } else break;
        }
        for (int i = x - 1; i >= 0 && i < 15; i--) {
            if (c == OmockBoard[i][y]) h++;
            else if (blank == 1) {
                blank--;
            } else break;
        }
        if (h == n) noOfNinLine++;

        blank = 1;
        int v = 1;
        for (int i = y + 1; i >= 0 && i < 15; i++) {
            if (c == OmockBoard[x][i]) v++;
            else if (blank == 1) {
                blank--;
            } else break;
        }
        ;
        for (int i = y - 1; i >= 0 && i < 15; i--) {
            if (c == OmockBoard[x][i]) v++;
            else if (blank == 1) {
                blank--;
            } else break;
        }
        ;
        if (v == n) noOfNinLine++;

        blank = 1;
        int ld = 1;
        for (int i = 1; x + i >= 0 && x + i < 15 && y + i >= 0 && y + i < 15; i++) {
            if (c == OmockBoard[x + i][y + i]) ld++;
            else if (blank == 1) {
                blank--;
            } else break;
        }
        for (int i = 1; x - i >= 0 && x - i < 15 && y - i >= 0 && y - i < 15; i++) {
            if (c == OmockBoard[x - i][y - i]) ld++;
            else if (blank == 1) {
                blank--;
            } else break;

        }
        if (ld == n) noOfNinLine++;

        blank = 1;
        int rd = 1;
        for (int i = 1; x - i >= 0 && x - i < 15 && y + i >= 0 && y + i < 15; i++) {
            if (c == OmockBoard[x - i][y + i]) rd++;
            else if (blank == 1) {
                blank--;
            } else break;
        }
        rd++;
        for (int i = 1; x + i >= 0 && x + i < 15 && y - i >= 0 && y - i < 15; i++) {
            if (c == OmockBoard[x + i][y - i]) rd++;
            else if (blank == 1) {
                blank--;
            } else break;
        }
        if (rd == n) noOfNinLine++;

        return noOfNinLine;
    }

    public int checkBlockedNinLineWithBlank(int x, int y, int c, int n, int b) {
        int noOfNinLine = 0;
        //수직수평
        int blank = 1;

        int h = 1, hb = 0;
        for (int i = x + 1; i >= 0 && i < 15; i++) {
            if (c == OmockBoard[i][y]) h++;
            else if (blank == 1) {
                blank--;
            } else if (OmockBoard[i][y] != 0) {
                hb++;
                break;
            } else break;
        }
        for (int i = x - 1; i >= 0 && i < 15; i--) {
            if (c == OmockBoard[i][y]) h++;
            else if (blank == 1) {
                blank--;
            } else if (OmockBoard[i][y] != 0) {
                hb++;
                break;
            } else break;
        }
        if (h == n && b == hb) noOfNinLine++;

        
        blank = 1;
        int v = 1, vb = 0;
        for (int i = y + 1; i >= 0 && i < 15; i++) {
            if (c == OmockBoard[x][i]) v++;
            else if (blank == 1) {
                blank--;
            } else if (OmockBoard[i][y] != 0) {
                vb++;
                break;
            } else break;
        }
        ;
        for (int i = y - 1; i >= 0 && i < 15; i--) {
            if (c == OmockBoard[x][i]) v++;
            else if (blank == 1) {
                blank--;
            } else if (OmockBoard[i][y] != 0) {
                vb++;
                break;
            } else break;
        }
        ;
        if (v == n && b == vb) noOfNinLine++;


        //대각선
        blank = 1;
        int ld = 1, ldb = 0;
        for (int i = 1; x + i >= 0 && x + i < 15 && y + i >= 0 && y + i < 15; i++) {
            if (c == OmockBoard[x + i][y + i]) ld++;
            else if (blank == 1) {
                blank--;
            }
            if (OmockBoard[x + i][y + i] != 0) {
                ldb++;
                break;
            } else break;
        }
        for (int i = 1; x - i >= 0 && x - i < 15 && y - i >= 0 && y - i < 15; i++) {
            if (c == OmockBoard[x - i][y - i]) ld++;
            else if (blank == 1) {
                blank--;
            }
            if (OmockBoard[x - i][y - i] != 0) {
                ldb++;
                break;
            } else break;

        }
        if (ld == n && ldb == b) noOfNinLine++;

        blank = 1;
        int rd = 1, rdb = 0;
        for (int i = 1; x - i >= 0 && x - i < 15 && y + i >= 0 && y + i < 15; i++) {
            if (c == OmockBoard[x - i][y + i]) rd++;
            else if (blank == 1) {
                blank--;
            }
            if (OmockBoard[x - i][y + i] != 0) {
                rdb++;
                break;
            } else break;
        }
        rd++;
        for (int i = 1; x + i >= 0 && x + i < 15 && y - i >= 0 && y - i < 15; i++) {
            if (c == OmockBoard[x + i][y - i]) rd++;
            else if (blank == 1) {
                blank--;
            }
            if (OmockBoard[x + i][y - i] != 0) {
                rdb++;
                break;
            } else break;
        }
        if (rd == n && b == rdb) noOfNinLine++;

        return noOfNinLine;
    }

    public int checkBlockedNinLine(int x, int y, int c, int n, int b) {
        int noOfNinLine = 0;

        int h = 1, hb = 0;
        for (int i = x + 1; i >= 0 && i < 15; i++) {
            if (c == OmockBoard[i][y])
                h++;
            else if (OmockBoard[i][y] != 0) {
                hb++;
                break;
            } else break;
        }
        for (int i = x - 1; i >= 0 && i < 15; i--) {
            if (c == OmockBoard[i][y])
                h++;
            else if (OmockBoard[i][y] != 0) {
                hb++;
                break;
            } else break;
        }
        if (h == n && hb == b)
            noOfNinLine++;

        int v = 1, vb = 0;
        for (int i = y + 1; i >= 0 && i < 15; i++) {
            if (c == OmockBoard[x][i])
                v++;
            else if (OmockBoard[x][i] != 0) {
                vb++;
                break;
            } else break;
        }
        for (int i = y - 1; i >= 0 && i < 15; i--) {
            if (c == OmockBoard[x][i])
                v++;
            else if (OmockBoard[x][i] != 0) {
                vb++;
                break;
            } else break;
        }
        ;
        if (v == n && vb == b)
            noOfNinLine++;

        int ld = 1, ldb = 0;
        for (int i = 1; x + i >= 0 && x + i < 15 && y + i >= 0 && y + i < 15; i++) {
            if (c == OmockBoard[x + i][y + i])
                ld++;
            else if (OmockBoard[x + i][y + i] != 0) {
                ldb++;
                break;
            } else break;
        }
        for (int i = 1; x - i >= 0 && x - i < 15 && y - i >= 0 && y - i < 15; i++) {
            if (c == OmockBoard[x - i][y - i])
                ld++;
            else if (OmockBoard[x - i][y - i] != 0) {
                ldb++;
                break;
            } else break;
        }
        if (ld == n && ldb == b)
            noOfNinLine++;

        int rd = 1, rdb = 0;
        for (int i = 1; x - i >= 0 && x - i < 15 && y + i >= 0 && y + i < 15; i++) {
            if (c == OmockBoard[x - i][y + i])
                rd++;
            else if (OmockBoard[x - i][y + i] != 0) {
                rdb++;
                break;
            } else break;
        }
        for (int i = 1; x + i >= 0 && x + i < 15 && y - i >= 0 && y - i < 15; i++) {
            if (c == OmockBoard[x + i][y - i])
                rd++;
            else if (OmockBoard[x + i][y - i] != 0) {
                rdb++;
                break;
            } else break;
        }
        if (rd == n && rdb == b)
            noOfNinLine++;

        return noOfNinLine;
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

public class Omock extends JFrame {
    private JPanel jpan;
    final int STONE_SIZE = 26;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Omock frame = new Omock();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Omock() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 460, 480);
        jpan = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);

                g.setColor(Color.BLACK);
                for (int i = 10; i < 450; i = i + 30) {
                    g.drawLine(10, i, 460 - 30, i);
                    g.drawLine(i, 10, i, 460 - 30);
                }

                int X = 7 * 30 + 10 - STONE_SIZE / 2;
                int Y = 7 * 30 + 10 - STONE_SIZE / 2;
                g.fillOval(X, Y, STONE_SIZE, STONE_SIZE);
            }
        };
        jpan.addMouseListener(new StoneDraw(jpan));
        jpan.setBackground(new Color(184, 134, 11));
        //jpan.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(jpan);
        //jpan.setLayout(new BorderLayout(0, 0));

    }
}
