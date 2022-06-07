from pydoc import cli
from tkinter import*

window = Tk()
window.title("계산기")
entry = Entry(window,bg="black",fg="white")
entry.grid(row=0,column=0,columnspan=5)


def click(key):
    if key == '=':
        num = eval(entry.get())
        entry.insert(END, "= "+str(num))
    elif key == 'C':
        entry.delete(0,END)
    else:
        entry.insert(END,key)

button_list =[
    '7','8','9','/','C',
    '4','5','6','*',' ',
    '1','2','3','-',' ',
    '0','.','=','+',' '
]

c=0
r=1
for bt in button_list:
    def press(t = bt):
        click(t)
    
    Button(window, text= bt,command=press).grid(row=r,column=c)
    c+=1
    if c == 5:
        c = 0
        r +=1

window.mainloop()