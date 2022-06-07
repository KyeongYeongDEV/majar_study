from os import environ
from platform import release
from sqlite3 import Row
from tkinter import*

window = Tk()
canvas=Canvas(window,width=400,height=500)
canvas.grid(row=0,column=0,columnspan=5)

lastx = None
lasty = None
color = "black"

def paint(event):
    global color,lastx,lasty

    if lastx and lasty:
        canvas.create_line(lastx,lasty,event.x,event.y,width=var.get(),fill = color)
        lastx = event.x
        lasty= event.y

def process(event):
    global lastx,lasty
    lastx = event.x
    lasty = event.y

def red():
    global color
    color = "red"
def yellow():
    global color
    color = "yellow"
def blue():
    global color
    color = "blue"
def black():
    global color
    color  = "black"
def clear():
    canvas.delete("all")

var = DoubleVar()

scale= Scale(window,from_=1,to=15,variable=var,orient = VERTICAL)
scale.set(5)
scale.grid(row=0,column=6,sticky=N + S)

canvas.bind("<B1-Motion>",paint)
canvas.bind("<ButtonPress>",process)
canvas.bind("ButtonRelease",release)

Button(window, text = "red",command= red).grid(row=2,column=0)
Button(window,text = "yellow",command= yellow).grid(row=2,column=1)
Button(window,text = "blue",command= blue).grid(row=2,column=2)
Button(window,text = "black",command= black).grid(row=2,column=3)
Button(window,text = "clear",command= clear).grid(row=2,column=4)

window.mainloop()