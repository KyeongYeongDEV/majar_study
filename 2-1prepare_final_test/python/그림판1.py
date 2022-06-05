from tkinter import *
from platform import release

window = Tk()
lastx = None#
lasty = None#
mycolor = "black"
def paint(event):#
    global lastx, lasty, mycolor
    if lastx and lasty:
        canvas.create_line(lastx, lasty, event.x, event.y, width=var.get(), fill=mycolor)
        lastx = event.x
        lasty = event.y
def act_paint(event):#
    global lastx, lasty, mycolor
    lastx = event.x
    lasty = event.y
def red():
    global mycolor
    mycolor = "red"
def green():
    global mycolor
    mycolor = "green"
def yellow():
    global mycolor
    mycolor = "yellow"
def black():
    global mycolor
    mycolor = "black"
def clear():
    global canvas
    canvas.delete('all')
canvas = Canvas(window, width= 840, height= 640)
canvas.grid(row = 1, column= 1 , columnspan= 4 , sticky= EW)
var = DoubleVar()
scale = Scale(window, from_=1, to=15, variable= var , orient=VERTICAL)
scale.set(5)
scale.grid(row=1, column=7 , sticky= N + S)

canvas.bind('<B1-Motion>', paint)#
canvas.bind('<ButtonPress>', act_paint)#
canvas.bind('<ButtonRelease>', release) #

b1 = Button(window, text = "빨간색", command= red).grid(row=2, column=1 , sticky=EW)
b1 = Button(window, text = "녹색", command= green).grid(row=2, column=2 , sticky=EW)
b1 = Button(window, text = "노란색", command= yellow).grid(row=2, column=3 , sticky=EW)
b1 = Button(window, text = "검정색", command= black).grid(row=2, column=4 , sticky=EW)
b1 = Button(window, text = "전체지우기", command= clear).grid(row=2, column=5 , sticky=EW)
window.mainloop()