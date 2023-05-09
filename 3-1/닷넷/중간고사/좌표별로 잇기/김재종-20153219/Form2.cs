using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace _20153219
{
    public partial class Form2 : Form
    {
        private int iDialogWidth;
        private Color iDialogColor;

        public int penWidth
        {
            get
            {
                if (radioButton1.Checked) iDialogWidth = 2;
                if (radioButton2.Checked) iDialogWidth = 4;
                if (radioButton3.Checked) iDialogWidth = 6;
                if (radioButton4.Checked) iDialogWidth = 8;
                return iDialogWidth;
            }
            set
            {
                iDialogWidth = value;
                if (iDialogWidth == 2) radioButton1.Checked = true;
                if (iDialogWidth == 4) radioButton2.Checked = true;
                if (iDialogWidth == 6) radioButton3.Checked = true;
                if (iDialogWidth == 8) radioButton4.Checked = true;
            }
        }

        public Color penColor
        {
            get
            {
                iDialogColor = Color.FromArgb(hScrollBar1.Value, hScrollBar2.Value, hScrollBar3.Value);
                return iDialogColor;

            }
            set
            {
                iDialogColor = value;
                hScrollBar1.Value = iDialogColor.R;
                hScrollBar2.Value = iDialogColor.G;
                hScrollBar3.Value = iDialogColor.B;
            }
        }

        public Form2()
        {
            InitializeComponent();
        }

        private void hScrollBar_Scroll(object sender, ScrollEventArgs e)
        {
            iDialogColor = Color.FromArgb(hScrollBar1.Value, hScrollBar2.Value, hScrollBar3.Value);
            label1.Invalidate();
        }

        private void radioButton_CheckedChanged(object sender, EventArgs e)
        {
            if (radioButton1.Checked) iDialogWidth = 2;
            if (radioButton2.Checked) iDialogWidth = 4;
            if (radioButton3.Checked) iDialogWidth = 6;
            if (radioButton4.Checked) iDialogWidth = 8;
            label1.Invalidate();
        }

        private void label1_Paint(object sender, PaintEventArgs e)
        {
            Pen pen = new Pen(iDialogColor, iDialogWidth);
            e.Graphics.DrawLine(pen, 0, (label1.Height / 2), (label1.Width), (label1.Height / 2));
        }

    }
}
