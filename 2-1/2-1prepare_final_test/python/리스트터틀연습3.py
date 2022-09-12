from operator import length_hint
import turtle, random
t = turtle.Turtle()
t.shape("turtle")
t.speed(0)
s = turtle.Screen()
s.bgcolor("black")

color_list = ["blue", "pink", "red", "green","yellow", "purple","skyblue"] #7가지 색

def star(length,x,y,c):
    t.up()
    t.goto(x,y)
    t.down()

    t.color(color_list[c])
    t.begin_fill()

    t.forward(length)
    t.left(78)
    t.forward(length)
    t.right(150)
    t.forward(length)

    for i in range(3):
        t.left(78)
        t.forward(length)
        t.right(150)
        t.forward(length)
    t.left(78)
    t.forward(length)
    t.end_fill()

for i in range(15):
    length = random.randint(50,100)
    x = random.randint(-200,200)
    y = random.randint(-200,200)
    c = random.randint(0,6)

    star(length,x,y,c)

turtle.mainloop()