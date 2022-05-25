import turtle
t=turtle.Turtle()
t.shape("turtle")

radius = 50

t.circle(radius)

t.up()
t.goto(100,0)
t.down()
radius+=50
t.circle(radius)

t.up()
t.goto(200,0)
t.down()
radius+=50
t.circle(radius)