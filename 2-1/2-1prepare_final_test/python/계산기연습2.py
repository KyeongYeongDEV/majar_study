from pydoc import cli
from tkinter import*
from turtle import window_width

window = Tk()
window.title("계산기")
entry= Entry(window,bg = "white",width=40,fg = "red")
entry.grid(row=0,column=0,columnspan=5)

list_button = [
    '7','8','9','/','C',
    '4','5','6','*',' ',
    '1','2','3','-',' ',
    '0','.','=','+',' '
]

def click(key):
    if key == '=':
        result  = eval(entry.get())
        entry.insert(END, "= "+str(result))
    elif key == 'C':
        entry.delete("0",END)
    else:
        entry.insert(END,key)

c=0
r=1
for bt in list_button:
    def process(t = bt):
        click(t)
    Button(window,text = bt,width=5,command= process).grid(row=r, column=c)
    c+=1
    if c == 5:
        c= 0
        r+=1
window.mainloop()
    