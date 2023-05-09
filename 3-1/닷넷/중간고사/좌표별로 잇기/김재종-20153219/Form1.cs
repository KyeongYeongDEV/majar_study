using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Collections;
using System.IO;
using System.Runtime.Serialization.Formatters.Binary;
namespace _20153219
{
    public partial class Form1 : Form
    {
        CMyPoint p;
        ArrayList ar;
        private int x, y;
        private int iCrrentWidth;
        private Color iCrrentColor;
        private LinkedList<CMyPoint> total_lines;
        public Form1()
        {
            InitializeComponent();
            total_lines = new LinkedList<CMyPoint>();
            iCrrentWidth = 2;
            iCrrentColor = Color.FromArgb(0, 0, 0);
            x = 0;
            y = 0;
            ar = new ArrayList();
        }

        private void Form1_MouseDown(object sender, MouseEventArgs e)
        {
            Random Random = new Random();
            if (e.Button == MouseButtons.Left)
            {

                p = new CMyPoint(new Point(e.X, e.Y), iCrrentColor, iCrrentWidth); 
                Pen pen = new Pen(p.p_color, p.p_width);
                Graphics G = CreateGraphics();
                G.DrawLine(pen, x, y, e.X, e.Y);
                x = e.X;
                y = e.Y;
                G.Dispose();
                ar.Add(p);
                total_lines.AddLast(p);
            }
        }

        private void Form1_Paint(object sender, PaintEventArgs e)
        {
            int Old_X = 0;
            int Old_y = 0;
            foreach (CMyPoint cData in total_lines)
            {
                Pen pen = new Pen(cData.p_color, cData.p_width);
                    e.Graphics.DrawLine(pen, Old_X, Old_y, cData.p_point.X, cData.p_point.Y);
                Old_X = cData.p_point.X;
                Old_y = cData.p_point.Y;

            }
        }

        private void 대화상자ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form2 dlg = new Form2();
            dlg.penWidth = iCrrentWidth;
            dlg.penColor = iCrrentColor;
            if (dlg.ShowDialog() == DialogResult.OK)
            {
                iCrrentWidth = dlg.penWidth;
                iCrrentColor = dlg.penColor;
            }
            dlg.Dispose();
        }

        private void 저장ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            saveFileDialog1.Filter = "봉|*.bong|모든파일|*.*";
            if (saveFileDialog1.ShowDialog() == DialogResult.OK)
            {
                FileStream fs = new FileStream(saveFileDialog1.FileName, FileMode.Create, FileAccess.Write);
                BinaryFormatter bf = new BinaryFormatter();
                bf.Serialize(fs, total_lines);
                fs.Close();
                MessageBox.Show(saveFileDialog1.FileName + "파일에 저장하였습니다.");
            }
        }

        private void 불러오기ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            openFileDialog1.Filter = "봉|*.bong|모든파일|*.*";
            if (openFileDialog1.ShowDialog() == DialogResult.OK)
            {
                FileStream fs = new FileStream(openFileDialog1.FileName, FileMode.OpenOrCreate, FileAccess.Read);
                BinaryFormatter bf = new BinaryFormatter();
                total_lines = (LinkedList<CMyPoint>)bf.Deserialize(fs);
                fs.Close();
                Invalidate();
            }
        }
    }

        [Serializable]
    class CMyPoint
    {

        public CMyPoint(Point p, Color c, int width)
        {
            this.p_point = p;
            this.p_color = c;
            this.p_width = width;
        }

        public Point p_point
        {
            get;
            set;
        }

        public Color p_color
        {
            get;
            set;
        }

        public int p_width
        {
            get;
            set;
        }
    }
}
