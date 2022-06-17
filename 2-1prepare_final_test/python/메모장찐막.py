from email import message
from tkinter import*
from tkinter import filedialog
from tkinter import messagebox

window = Tk()
menu = Menu(window)
text = Text(window)
window.config(menu=menu)
text.pack()

def open():
    file = filedialog.askopenfile(parent=window, mode='r')
    if file != None:
        line = file.read()
        text.insert(1.0,line)
        file.close()
def save():
    file = filedialog.asksaveasfile(parent=window,mode='w')
    if file != None:
        line = text.get(1.0, END)
        file.write(line)
        file.close()
def exit():
    if messagebox.askokcancel("Quit","종료 ㅇㅋ?"):
        window.destroy()

