import turtle
t= turtle.Turtle()
t.shape("turtle")
t.color("blue")
t.speed(0)

t.left(30)
for i in range(6):
    t.left(360/6)
    t.forward(100)
    t.forward(-30)
    t.left(30)
    t.forward(30)
    t.forward(-30)
    t.right(60)
    t.forward(30)
    t.forward(-30)
    t.left(30)
    t.forward(-70)
t.left(60)

turtle.mainloop()