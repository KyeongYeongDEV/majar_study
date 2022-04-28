import turtle
t = turtle.Turtle()
t.shape("turtle")


def draw_snowman(x,y):
    t.color("black","white")

    t.up()
    t.goto(x,y)
    t.down()
    t.begin_fill()
    t.circle(20)
    t.end_fill()

    t.goto(x,y-25)
    t.setheading(135)
    t.fd(50)
    t.backward(50)

    t.setheading(30)
    t.forward(50)
    t.backward(50)

    t.setheading(0)
    t.begin_fill()
    t.circle(15)
    t.end_fill()

    t.goto(x,y-70)
    t.begin_fill()
    t.circle(30)
    t.end_fill()




s= turtle.Screen()
s.bgcolor("skyblue")
s.onscreenclick(draw_snowman)
turtle.mainloop()