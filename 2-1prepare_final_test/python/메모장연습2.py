
from tkinter import*
from tkinter import filedialog
from tkinter import messagebox
#메모장
#파일 (열기 저장하기 종료 )
#편집 (cut, copy, paste, delete)


window = Tk()
textbox = Text(window,width=70,height=50)
textbox.pack()
menu = Menu(window)
window.config(menu=menu)

def open():
    file = filedialog.askopenfile(parent=window,mode='r')
    if file != None:
        lines = file.read()
        textbox.insert('1.0', lines)
        file.close()
def save():
    file = filedialog.asksaveasfile(parent=window,mode ='w')
    if file != None:
        lines = textbox.get("1.0",END + '-1c')
        file.write(lines)
        file.close()

def exit():
    if messagebox.askokcancel("Quit", "종료하시겠습니까?"):
        window.destroy()
    
def cut():
    global es
    es = textbox.get(SEL_FIRST,SEL_LAST)
    textbox.delete(SEL_FIRST,SEL_LAST)

def copy():
    global es
    es = textbox.get(SEL_FIRST,SEL_LAST)

def paste():
    global es
    textbox.insert(INSERT,es)

def delete():
    textbox.delete(SEL_FIRST,SEL_LAST)


filemenu = Menu(menu)
menu.add_cascade(label = "파일", menu = filemenu)
filemenu.add_command(label = "열기", command= open)
filemenu.add_command(label = "저장", command = save)
filemenu.add_command(label="종료", command= exit)

editmenu = Menu(menu)
menu.add_cascade(label ="edit",menu = editmenu)
editmenu.add_command(label= "cut", command=cut)
editmenu.add_command(label="copy",command=copy)
editmenu.add_command(label="paste",command= paste)
editmenu.add_command(label="delete",command=delete)



window.mainloop()