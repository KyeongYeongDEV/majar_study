import turtle
t = turtle.Turtle()
t.shape("turtle")
t.speed(0)

list = ["red", "yellow","blue" ]
x = -200

def square(length):
    for i in range(4):
        t.fd(length)
        t.left(90)

t.up()
t.goto(-200,0)
t.down()
t.color(list[0])
t.begin_fill()
square(100)
t.end_fill()

t.up()
t.goto(0,0)
t.down()
t.color(list[1])
t.begin_fill()
square(100)
t.end_fill()

t.up()
t.goto(200,0)
t.down()
t.color(list[2])
t.begin_fill()
square(100)
t.end_fill()

turtle.mainloop()