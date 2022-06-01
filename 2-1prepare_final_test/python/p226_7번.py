def circleArea(radius):
    global PI
    return round(PI * radius * radius, 2)


def circleCircumference(radius):
    global PI
    return round(PI * radius*2, 3)

PI = 3.1415

radius = int(input("반지름은? >>"))

print("반지름이 ",radius, "인 원의 면적: " , circleArea(radius))
print("반지름이 ",radius,"인 원의 둘레 ", circleCircumference(radius))