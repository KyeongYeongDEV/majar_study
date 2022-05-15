import turtle
t=turtle.Turtle()
t.shape("turtle")

x1 = int(turtle.textinput("","첫 번쨰 점의 x좌표 x1"))
y1 = int(turtle.textinput("","첫 번쨰 점의 y좌표 y1"))
x2 = int(turtle.textinput("","두 번쨰 점의 x좌표 x2"))
y2 = int(turtle.textinput("","두 번쨰 점의 y좌표 y2"))


t.up
t.goto(x1,y1)
t.down()
t.goto(x2,y2)
t.down()

t.setheading(0)
t.right(90)
t.goto(x2,y1)


t.goto(x1,y1)

turtle.done()