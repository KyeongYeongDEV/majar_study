from tkinter import*

color = "yellow"

def paint(event):
    global color
    x1,y1 = (event.x-1), (event.y-1)
    x2,y2 = (event.x+1),(event.y+1)
    canvas.create_line(x1,y1,x2,y2, fill= color)

def red():
    global color
    color = "red"

def blue():
    global color
    color = "blue"

def green():
    global color
    color = "green"

def black():
    global color
    color = "black"

def easer():
    canvas.delete()

window = Tk()    
canvas = Canvas()
canvas.grid(row=0,column=0,columnspan=5)
canvas.bind("<B1-Motion>",paint)

Button(window,text = "red",command= red).grid(row=1,column=0)
Button(window, text ="blue",command=blue).grid(row=1, column=1)
Button(window, text = "green", command= green).grid(row=1,column=2)
Button(window, text = "black", command = black).grid(row=1,column=3)
Button(window, text = "easer", command = easer).grid(row=1,column=4)

window.mainloop()