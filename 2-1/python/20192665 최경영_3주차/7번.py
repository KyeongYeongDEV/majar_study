import turtle
t=turtle.Turtle()
t.shape("turtle")

side = 80
angle = 90

t.forward(side)
t.left(angle)
t.forward(side)
t.left(angle)
t.forward(side)
t.left(angle)
t.forward(side)
t.left(angle)

t.forward(side)
t.right(angle)
t.forward(side)
t.right(angle)
t.forward(side)
t.right(angle)
t.forward(side)
t.right(angle)

t.up()
t.goto(-80,0)
t.down()

t.forward(side)
t.left(angle)
t.forward(side)
t.left(angle)
t.forward(side)
t.left(angle)
t.forward(side)
t.left(angle)

t.forward(side)
t.right(angle)
t.forward(side)
t.right(angle)
t.forward(side)
t.right(angle)
t.forward(side)
t.right(angle)

t.up()
t.goto(0,0)
t.down()
