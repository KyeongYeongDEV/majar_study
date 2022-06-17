from audioop import lin2adpcm
from operator import mod
from sys import last_value
from tkinter import*
from tkinter import filedialog
from tkinter import messagebox

window = Tk()
textbox = Text(window)
textbox.pack()
menu = Menu(window)
window.config(menu=menu)

def open():
    file = filedialog.askopenfile(parent=window,mode='r')
    if file != None:
        line = file.read()
        textbox.insert(1.0,line)
        file.close()
def save():
    file = filedialog.asksaveasfile(parent=window,mode='w')
    if file != None:
        line = textbox.get(1.0,END)
        file.write(line)
        file.close()
def exit():
    if messagebox.askokcancel("Quit","종료하실?") :
        window.destroy()



def copy():
    global es
    es = textbox.get(SEL_FIRST,SEL_LAST)
def cut():
    global es
    es = textbox.get(SEL_FIRST,SEL_LAST)
    textbox.delete(SEL_FIRST,SEL_LAST)
def paste():
    global es
    textbox.insert()
def delete():
    textbox.delete(SEL_FIRST,SEL_LAST)

def about():
    label = messagebox.showinfo("About","메모장프로그램")

filemenu = Menu(window)
menu.add_cascade(label="file",menu=filemenu)
filemenu.add_command(label="open",command=open)
filemenu.add_command(label="save",command=save)
filemenu.add_command(label="exit",command=exit)

editmenu = Menu(window)
menu.add_cascade(label="edit",menu = editmenu)
editmenu.add_command(label="copy",command=copy)
editmenu.add_command(label="cut",command=cut)
editmenu.add_command(label= "paste",command=paste)
editmenu.add_command(label="delete",command=delete)

helpmenu = Menu(window)
menu.add_cascade(label="help",menu = helpmenu)
helpmenu.add_command(label="hlep",command=helpmenu)

window.mainloop()