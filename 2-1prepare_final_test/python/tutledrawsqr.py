import turtle
import random
t = turtle.Turtle()
t.shape("turtle")
t.speed(0)

list = ["blue", "red", "yellow"]

def square(length): #기본 문제
    for i in range(4): #4번 반복
        t.forward(length)
        t.left(90)

def any_shape(num): #도전 문제
    col = random.randint(0,2)
    t.color(list[col])
    t.begin_fill()
    
    for i in range(num):
        t.forward(100)
        t.left(360/num)
        
    t.end_fill()

t.up()
t.goto(-200,0)
t.down()
square(100)

t.up()
t.goto(0,0)
t.down()
any_shape(8)

t.up()
t.goto(200,0)
t.down()
any_shape(3)

turtle.mainloop()