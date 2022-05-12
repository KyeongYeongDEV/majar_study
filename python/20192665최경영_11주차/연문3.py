from tkinter import *
import random

window = Tk()
num =0
betNum = random.randint(1,100)

def run():
    global num
    global betNum

    num = int(e.get())

    if num < betNum:
        firstLabel['text'] = "너무 낮아요!!"
    elif num>betNum:
        firstLabel['text'] = "너무 높아요!!"
    else:
        firstLabel['text'] = "정답입니다."

def reset():
    global num
    global betNum

    e.delete(0,END)
    secondLabel.config(text="")
    betNum = random.randint(1,100)
    num =0

firstLabel = Label(window, text = "1에서 100 사이의 수를 입력하세요")
secondLabel = Label(window,)
thridLabel = Label(window,)

firstLabel.grid(row =1, column=0, columnspan=2)
secondLabel.grid(row =2, column=0, columnspan=2)
thridLabel.grid(row =4, column=0, columnspan=2)

e = Entry(window)
e.grid(row=3, column=0, columnspan= 2)

firstBtn = Button(window, texdt = "숫자를 입력", command=run)
secondBtn = Button(window, texdt = "개임을 다시 실행", command=run)

firstBtn.grid(row=5,column=0)
secondBtn.grid(row=5, column=1)

window.mainloop()