from tkinter import*
window = Tk()

#빨,녹,노,파. 전체 지우기, 
mycolor = "white"

def paint(event):
    x1,y1 = (event.x-1),(event.y+1)
    x2,y2 = (event.x-1),(event.y+1)
    canvas.create_oval(x1,y1,x2,y2,fill = mycolor)

def red_color():
    global mycolor
    mycolor = "red"

def green_color():
    global mycolor
    mycolor = "green"

def blue_color():
    global mycolor
    mycolor = "blue"

def yellow_color():
    global mycolor
    mycolor = "yellow"

def delete_():
    canvas.delete("all")



canvas = Canvas(window)
canvas.grid(row=0,column=0,columnspan=5)
canvas.bind("<B1-Motion>",paint)

button1= Button(window, text="빨간색", command = red_color).grid(row=1, column=0)
button2 = Button(window, text = "녹색", command =green_color).grid(row=1, column=1)
button3 = Button(window, text = "파란색", command = blue_color).grid(row=1, column=2)
button4 = Button(window,text = "노란색", command =yellow_color).grid(row=1, column=3)
button5 = Button(window,text = "전체 지우기", command = delete_).grid(row=1, column=4)

window.mainloop()