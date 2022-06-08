from tkinter import*
from tkinter import filedialog
from tkinter import messagebox

window  = Tk()
textbox = Text(window,width=70,height=50)
textbox.pack()
menu = Menu(window)
window.config(menu=menu)

def open():
    file = filedialog.askopenfile(parent=window, mode='r')
    if file != None:
        lines = file.read 
        textbox.insert('1.0',lines)
        file.close()

def save():
    file = filedialog.asksaveasfile(parent=window,mode='w')
    if file != None:
        lines = textbox.get('1.0',END+'-1c')
        file.write(lines)
        file.close()
def exit():
    if messagebox.askokcancel("Quit","종료하시겠습니까?"):
        window.destroy()


def cut():
    global es
    es = textbox.get(SEL_FIRST,SEL_FIRST)
    textbox.delete(SEL_FIRST,SEL_LAST)

def copy():
    global es
    es = textbox.get(SEL_FIRST,SEL_LAST)

def paste():
    global es
    textbox.insert(INSERT,es)

def delete():
    textbox.delete(SEL_FIRST,SEL_LAST)

def about():
    label = messagebox.showinfo("About", "메모장프로그램")

filemenu = Menu(window)
menu.add_cascade(label="파일", menu=filemenu)
filemenu.add_command(label="열기",command=open)
filemenu.add_cascade(label="저장하기",command= save)
filemenu.add_cascade(label="종료",command= exit)

editmenu = Menu(window)
menu.add_cascade(label="편집",menu=editmenu)
editmenu.add_command(label="자르기",command=cut)
editmenu.add_command(label="복사",command=copy)
editmenu.add_cascade(label="붙여넣기",command=paste)
editmenu.add_cascade(label= "삭제",command=delete)

helpmenu = Menu(menu)
menu.add_cascade(label="도움말", menu=helpmenu)
helpmenu.add_command(label="프로그램 정보", command=about)

window.mainloop()