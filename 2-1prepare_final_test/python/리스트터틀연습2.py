import turtle, random

t = turtle.Turtle()
t.shape("turtle")
t.speed(0)

color_list = ["blue", "pink", "red", "green","yellow", "purple","skyblue"] #7가지 색

def draw_shape(x,y,c,n, length):
    t.color(color_list[c])
    t.up()
    t.goto(x,y)
    t.down()

    t.begin_fill()
    for i in range(n):
        t.forward(length)
        t.left(360/n)
    t.end_fill()

num = 15

while num >= 0:
    x = random.randint(-200,200)
    y = random.randint(-200,200)
    length = random.randint(50,100)
    n  =random.randint(3,8)
    c= random.randint(0,6)

    draw_shape(x,y,c,n,length)
    num-=1

turtle.mainloop()