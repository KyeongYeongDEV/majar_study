import turtle
import random

t= turtle.Turtle()
t.shape("turtle")
t.speed(0)

s = turtle.Screen()
s.bgcolor("black")
color_list=['red','yellow','white', 'green','skyblue','orange']#6개

def draw_circle(x,y,length,color):
    t.up()
    t.goto(x,y)
    t.down()
    t.color(color)
    t.begin_fill()
    t.circle(length)
    t.end_fill()


def click(x,y):
    rand_num= random.randint(0,5)
    rand_length = int(random.randrange(10,100))

    draw_circle(x,y,rand_length,color_list[rand_num])

s.onscreenclick(click)
turtle.mainloop()