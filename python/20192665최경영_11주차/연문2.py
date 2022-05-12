
def update_add():
    update("add")

def update_minus():
    update("minus")

def update_Init():
    update("Init")

def update(method):
    global total
    if method == "add":
        total = total+ int(entry.get())
    elif method == "minus":
        total = total - int(entry.get())
    else:
        total=100
    sum["text"] = str(total)
    entry.delete(0,END)

from tkinter import *
window = Tk()
total = 100

first_label =Label(window, text = "현재합계     ")
second_label =Label(window, text =total)

first_label.grid(row=0,column=0)
second_label.grid(row=0,column=1)

entry = Entry(window)
entry.grid(row =1, column=0, columnspan=3)

plus_button = Button(window, text = "더하기(+).")
minus_button = Button(window,text = "빼기(-)")
Init_button = Button(window,text = "초기화")


plus_button.grid(row =2, column =0)
minus_button.grid(row =2, column =1)
Init_button.grid(row =2, column =2)

plus_button(window, Command = update_add())
minus_button(window, Command = update_minus())
Init_button(window, Command = update_Init())


window.mainloop()
