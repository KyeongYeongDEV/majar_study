import turtle
t = turtle.Turtle()
t.shape("turtle")

x1 = int(turtle.textinput("","첫 번쨰 점의 x좌표 x1"))
y1 = int(turtle.textinput("","첫 번쨰 점의 x좌표 y1"))
x2 = int(turtle.textinput("","두 번쨰 점의 x좌표 x2"))
y2 = int(turtle.textinput("","두 번쨰 점의 x좌표 y2"))

dist = ((x1-x2)**2 + (y1-y2)**2)**0.5 #두 점 사이의 거리

t.up()
t.goto(x1,y1)
t.down()
t.goto(x2,y2)
t.up()

s = "두 점 사이의 길이는 : " 
t.write(s + str(dist))

turtle.done()
  