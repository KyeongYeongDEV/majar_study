import turtle
t = turtle.Turtle()
t.shape("turtle")
t.speed(0)
t.color("red")
s = turtle.Screen()
s.bgcolor("green")


def circle():
    t.begin_fill()
    t.circle(100)
    t.end_fill()


def click(x,y):
    t.up()
    t.goto(x,y)
    t.down()

    circle()

s.onscreenclick(click)

turtle.mainloop()