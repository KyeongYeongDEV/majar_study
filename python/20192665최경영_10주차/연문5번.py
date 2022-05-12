import turtle
import random
t = turtle.Turtle()
t.shape("turtle")
t.speed(0)

color = ["red", "green", "blue", "yellow", "gray", "pink"]

def draw_shape(c,length,sides,x,y):
    t.up()
    t.goto(x,y)
    t.down()
    
    t.color(c)
    t.begin_fill()
    for i in range(sides):
        t.forward(length)
        t.left(360/sides)
    t.end_fill()


for i in range(0,10) :
    sides = random.randint(3,8) #몇 각형 랜덤
    x = random.randint(-300,300)
    y = random.randint(-300,300)
    length = random.randint(20,150)
    c = color[random.randint(0,5)]

    draw_shape(c, length,sides,x,y)
    
turtle.mainloop()



     
