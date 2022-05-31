import turtle
t = turtle.Turtle()
t.shape("turtle")
t.speed(0)

def square(length):
    for i in range(4):
        t.forward(length)
        t.left(90)

def circle(length):
    t.circle(length)

def drawit(x,y):
    t.up()
    t.goto(x,y)
    t.down()
    t.begin_fill()
    t.color("green")
    square(50)
    circle(20)
    t.end_fill()

s= turtle.Screen()
s.onscreenclick(drawit)

turtle.mainloop()