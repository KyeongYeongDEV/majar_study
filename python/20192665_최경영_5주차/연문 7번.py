import turtle
t = turtle.Turtle()
t.shape("turtle")

list = []

color = input("색상 #1을 입력하시오 : ")
list.append(color)

color = input("색상 2을 입력하시오 : ")
list.append(color)

color = input("색상 #3을 입력하시오 : ")
list.append(color)

t.up()
t.goto(-100,0)
t.down()
t.fillcolor(list[0])
t.begin_fill()
t.circle(50)
t.end_fill()

t.up()
t.goto(0,0)
t.down()
t.fillcolor(list[1])
t.begin_fill()
t.circle(50)
t.end_fill()

t.up()
t.goto(100,0)
t.down()
t.fillcolor(list[2])
t.begin_fill()
t.circle(50)
t.end_fill()

turtle.mainloop()