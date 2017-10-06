import random
door = ["car", "sheep", "sheep"]
bingo = 0
for num in range(1,999):
random.shuffle(door)
if door[1] == "car":
door[2] == "open"
elif door[2] == "car":
door[1] == "open"
else:
tmp = random.randint(1,2)
door[tmp] = "open"

if door[1] == "car" or door[2] == "car":
bingo = bingo + 1

print bingo