import turtle
import random
t= turtle.Turtle()
t.shape("turtle")
t.speed(0)

color_list = ["blue", "pink", "red", "green","yellow", "purple","skyblue"] #7가지 색

def square(x, y, c):
    t.color(c)
    t.up()
    t.goto(x,y)
    t.down()

    t.begin_fill()
    for i in range(4):
        t.forward(100)
        t.left(90)
    t.end_fill()

for c in color_list:
    x = random.randint(-150,150)
    y = random.randint(-150,150)

    square(x,y,c)

turtle.mainloop()