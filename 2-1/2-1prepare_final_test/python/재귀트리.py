import turtle
import random
t= turtle.Turtle()
t.shape("turtle")
t.speed(0)


def tree(length):
    if length > 5:
        t.forward(length)
        t.right(20)
        rand_num = random.randrange(15,20)
        tree(length-rand_num)
        t.left(40)
        rand_num = random.randrange(15,20)
        tree(length-rand_num)
        t.right(20)
        t.backward(length)

t.left(90)

t.color("green")
tree(90)

turtle.mainloop()