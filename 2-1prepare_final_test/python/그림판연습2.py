from tkinter import*

window = Tk()
canvas = Canvas(window)

color = 'black'

def red():
    global color
    color = "red"

def blue():
    global color
    color = 'blue'

def green():
    global color
    color = 'green'

def black():
    global color
    color = 'black'

def delete():
    canvas.delete()

canvas.grid(row=0, column=0,columnspan=5)

Button(window, text= "red", command=red).grid(row=1,column=0)
Button(window, text = "blue", command=blue).grid(row=1,column=1)
Button(window, text = 'green',command = green).grid(row=1,column=2)
Button(window, text = "black",command= black).grid(row=1,column=3)
Button(window, text = "delete",command= delete).grid(row=1,column=4)