from tkinter import*

window = Tk()
entry = Entry(window,bg="black",fg="yellow")
entry.grid(row=0,column=0,columnspan=5)

def click(key):
    if key == '=':
        result = int(eval(entry.get()))
        entry.insert(END, "= "+str(result))
    elif key == 'C':
        entry.delete(0,END)
    else:
        entry.insert(END,key)

bt_list = [
    '7','8','9','/','C',
    '4','5','6','*',' ',
    '1','2','3','-',' ',
    '0','.','=','+',' '
]
r=1
c=0
for bt in bt_list:
    def process(t = bt):
        click(t)
    
    
    Button(window,text = bt,command=process).grid(row=r,column=c)
    c+=1
    if c == 5:
        c =0
        r+=1

window.mainloop()