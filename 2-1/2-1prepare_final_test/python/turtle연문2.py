import turtle
t = turtle.Turtle()
t.shape("turtle")
t.speed(0)

def hexagon():
    for i in range(6):
        t.forward(50)
        t.left(360/6)

for i in range(6):
    t.forward(50)
    t.right(60)
    hexagon()
    
turtle.mainloop()