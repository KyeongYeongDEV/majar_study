import turtle
t = turtle.Turtle()
t.shape("turtle")
t.speed(0)
s = turtle.Screen()
s.bgcolor("skyblue")

def star():
    for i in range(5):
        t.forward(100)
        t.right(145)


def draw(x,y):
    t.up()
    t.goto(x,y)
    t.down()

    star()


s.onscreenclick(draw)
turtle.mainloop()