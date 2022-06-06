from platform import release
from tkinter import*

window= Tk()
canvas = Canvas(window, width = 400, height=400)
canvas.grid(row=0,column=0,columnspan=5)

color = "black"
lastx = None
lasty = None
def paint(event):
    global color, lastx, lasty

    if lastx and lasty :
        canvas.create_line(lastx,lasty,event.x,event.y,width= var.get(), fill=color)
        lastx = event.x
        lasty = event.y

def act_paint(event):
    global lastx,lasty
    lastx = event.x
    lasty = event.y

def red():
    global color
    color = "red"
def blue():
    global color
    color = 'blue'
def yellow():
    global color
    color = "yellow"
def black():
    global color
    color = "black"
def delete():
    canvas.delete("all")

var = DoubleVar()
scale = Scale(window,from_=1,to=15,variable = var,orient=VERTICAL)
scale.set(5)
scale.grid(row=0,column=6,sticky=N+S)

canvas.bind("<B1-Motion>",paint)
canvas.bind("<ButtonPress>",act_paint)
canvas.bind("<ButtonRelease>",release)

Button(window,text = "red", command= red).grid(row=1,column=0)
Button(window,text = "blue",command=blue).grid(row=1,column=1)
Button(window,text= "yellow",command=yellow).grid(row=1,column=2)
Button(window,text ="black",command=black).grid(row=1,column=3)
Button(window,text = "clear",command=delete).grid(row=1,column=4)

window.mainloop()