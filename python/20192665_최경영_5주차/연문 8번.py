import turtle
t = turtle.Turtle()
t.shape("turtle")

list = []

xy = int(input("x1 :"))
list.append(xy)
xy = int(input("y1 :"))
list.append(xy)
xy = int(input("x2 :"))
list.append(xy)
xy = int(input("y2 :"))
list.append(xy)
xy =int( input("x3 :"))
list.append(xy)
xy = int(input("y3 :"))
list.append(xy)

t.goto(list[0],list[1])

t.goto(list[2],list[3])

t.goto(list[4],list[5])