from tkinter import messagebox
from tkinter import*
from tkinter import filedialog

window  = Tk()
text = Text(window)
text.pack()
menu = Menu(window)
window.config(menu=menu)

def open():
    file = filedialog.askopenfile(parent=window, mode= 'r')
    if file != None:
        line = file.read()
        text.insert(1.0,line)
        file.close()
def save():
    file = filedialog.asksaveasfile(parent=window, mode='w')
    if file != None:
        line = text.get(1.0,END)
        file.write(line)
        file.close()
def exit():
    if messagebox.askokcancel("Quit","종료하시겠습니까?"):
        window.destroy()

def copy():
    global es
    es = text.get(SEL_FIRST,SEL_LAST)
def cut():
    global es
    es =text.get(SEL_FIRST,SEL_LAST)
    text.delete(SEL_FIRST,SEL_LAST)
def paste():
    global es
    text.insert(END,es)
def delete():
    text.delete(SEL_FIRST,SEL_LAST)

filemenu = Menu(menu)
menu.add_cascade(label= "file", menu= filemenu)
filemenu.add_command(label='open',command=open)
filemenu.add_command(label='save',command=save)
filemenu.add_command(label='exit',command=exit)

editmenu = Menu(menu)
menu.add_cascade(label='edit',menu =editmenu)
editmenu.add_command(label='copy',command=copy)
editmenu.add_command(label='cut',command=cut)
editmenu.add_command(label='paste',command=paste)
editmenu.add_command(label ='delete',command=delete)

helpmenu = Menu(menu)
menu.add_cascade(label='Help')

window.mainloop()