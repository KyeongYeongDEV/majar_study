from tkinter import*

window =Tk()
entry = Entry(window,bg="black", fg="white")
def click(key):
    if key == '=':
        result = eval(entry.get())
        entry.insert(END,'= '+str(result))
    elif key == 'C':
        entry.delete(0,END)
    else:
        entry.insert(END,key)

list_bt=[
    '7','8','9','C',
    '4','5','6','*',
    '1','2','3','/',
    '0','-','+','='
]
c=0
r=1
for bt in list_bt:
    def press(t= bt):
        click(t)

    Button(window,text = bt,command=press).grid(row=r,column=c)
    c+=1
    if c == 4:
        r+=1
        c=0


entry.grid(row=0,column=0,columnspan=4)

window.mainloop()