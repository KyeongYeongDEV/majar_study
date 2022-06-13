from tkinter import*
window = Tk()
entry = Entry(window)

sum = 0

label1 = Label(window,text = "현재 합계: ")
label2 = Label(window,text="0")

def add():
    global sum
    sum += int(entry.get())
    label2['text'] = str(sum)

def minus():
    global sum
    sum -= int(entry.get())
    label2["text"] = str(sum)

def clear():
    entry.delete(0,END)
    label2["text"] = '0'

label1.grid(row=0,column=0)
label2.grid(row=0,column=1)
entry.grid(row=1,columnspan=3)

Button(window, text = "add",command=add).grid(row=2,column=0)
Button(window,text = "minus",command=minus).grid(row=2,column=1)
Button(window,text = "clear",command=clear).grid(row=2,column=2)

window.mainloop()