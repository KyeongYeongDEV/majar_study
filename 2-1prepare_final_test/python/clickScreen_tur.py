import turtle
t = turtle.Turtle()
t.shape("turtle")
t.speed(0)
s = turtle.Screen()
s.bgcolor("black")
t.color("red","white")

def square():
    t.begin_fill()
    for i in range(4):
        t.forward(100)
        t.left(90)
    t.end_fill()

def click(x,y):
    t.up()
    t.goto(x,y)
    t.down()
    square()






s.onscreenclick(click)

turtle.mainloop()