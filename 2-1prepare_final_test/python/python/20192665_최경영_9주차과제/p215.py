import turtle
t = turtle.Turtle()
t.shape("turtle")

def circle(length):
    t.circle(length)

def drawit(x,y):
    t.penup()
    t.goto(x,y)
    t.pendown()
    t.begin_fill()
    t.color("green")
    circle(50)
    t.end_fill()

s = turtle.Screen() #그림이 그려지는 화면을 얻는다.
s.onscreenclick(drawit) #마우스 클릭 이벤트 처림 함수를 등록한다.
turtle.mainloop()