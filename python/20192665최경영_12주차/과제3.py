from tkinter import *
import random

def change_image(x):
    y = random.randint(1,3)
    change1(x) #change1 함수를 통해 사용자가 선택한 것으로 사진을 바꿔 줌
    change2(y) #change2 함수를 통해 랜덤으로 돌린 숫자로 사진을 바꿔 줌
    game(x,y) #결과값을 보여주는 함수

def change1(x): #사용자 사진 교체
    photo1 = A[x]
    label1.configure(image=photo1)
    label1.image = photo1

def change2(x): #컴퓨터 사진 교체
    photo2 = A[x]
    label3.configure(image=photo2)
    label3.image = photo2

def game(x,y):
    def win(): #사용자가 가위바위보를 이겼을 경우
        label2.configure(text=">>>>>")
        label4.configure(text="사용자 승!")
    def lose(): #사용자가 졌을 경우
        label2.configure(text="<<<<<")
        label4.configure(text="사용자 패배!")
    def draw(): #비겼을 경우
        label2.configure(text="=====")
        label4.configure(text="비겼습니다!")

    if x==1: #사용자가 주먹을 냈을 때
        if y==1:draw()
        elif y==2:lose()
        else:win()
    elif x==2: #사용자가 가위를 냈을 때
        if y==1:win()
        elif y==2:draw()
        else:lose()
    else: #사용자가 보를 냈을 때
        if y==1:lose()
        elif y==2:win()
        else:draw()

window = Tk()
font1 = ("굴림체",30,"bold") #폰트 설정
font2 = ("굴림체",20,"bold") #폰트 설정

rock_image = PhotoImage(file = "rock.png")
scissors_image = PhotoImage(file = "scissors.png")
paper_image = PhotoImage(file = "paper.png")

A = {1:rock_image,2:scissors_image,3:paper_image}  

photo1 = A[3]
photo2 = A[3]

label1 = Label(window, image=photo1)
label2 = Label(window, text = "=====",font=font1)
label3 = Label(window, image=photo2)
label1.grid(row=0, column=0)
label2.grid(row=0, column=1, padx=50)
label3.grid(row=0, column=2)

label4 = Label(window, text = "무승부!",font=font2,fg="green")
label4.grid(row=1, column=1)

button1 = Button(window,text="바위",command=lambda: change_image(1))
#바위 버튼을 누르면 change_image함수에 1의 값을 넣어 실행함
button2 = Button(window,text="보",command=lambda: change_image(2))
#보 버튼을 누르면 change_image함수에 2의 값을 넣어 실행함
button3 = Button(window,text="가위",command=lambda: change_image(3))
#가위 버튼을 누르면 change_image함수에 3의 값을 넣어 실행함
button1.grid(row=2,column=0,ipadx=50)
button2.grid(row=2,column=1,ipadx=50)
button3.grid(row=2,column=2,ipadx=50)

window.mainloop()