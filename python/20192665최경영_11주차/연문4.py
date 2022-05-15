def changedInch():
    inch = int(e.get())
    centi = inch * 2.54
    forthLabel.configure(text = str(centi)+ "센티미터")

from tkinter import *
window = Tk()

firstLabel = Label(window, text = "인치를 센티미터로 변환하는 프로그램")
firstLabel.grid(row=0,column=0,columnspan=2)

secondLabel = Label(window,text = "인치를 입력하시오")
secondLabel.grid(row=1,column=0)

e = Entry()
e.grid(row=1,column=1)

thirdLabel = Label(window, text = "변환결과")
thirdLabel.grid(row=2, column=0)

forthLabel = Label(window,text = "0 센티미터")
forthLabel.grid(row=2,column=1)

changeBtn = Button(window, text = "변환!", command = changedInch)

window.mainloop() 