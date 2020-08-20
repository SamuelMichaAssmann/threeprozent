import pygame
import random
import time
import math

def deleteCircle(circle_pos):
    pygame.draw.circle(screen, (0, 0, 0), (circle_pos[0], circle_pos[1]), radius)


def createRandomCircle():
    circle_x = random.randint(radius, x - radius)
    circle_y = random.randint(radius, y - radius)
    pygame.draw.circle(screen, (255, 255, 255), (circle_x, circle_y), radius)
    return circle_x, circle_y

def updateCircle(circle_pos):
    global score
    #clear screen
    screen.fill((0, 0, 0))
    #write new picture
    font = pygame.font.Font(None, 32)
    txt_surface = font.render(f"Score: {score}", True, (0, 0, 255))
    screen.blit(txt_surface, (int(x/2-40), 7))
    circle_pos = createRandomCircle()
    return circle_pos

def initialize():
    pygame.init()
    screen = pygame.display.set_mode((x, y))
    pygame.display.set_caption("Circle-Klicker")
    screen.fill((0, 0, 0))
    return screen

def timer():
   now = time.localtime(time.time())
   return now[4:6]

def timeNotOver(beginTime):
    currentTime = timer()
    if(currentTime[0]<beginTime[0]):
        currentTime[0]=currentTime[0]+60
    if(currentTime[0]==beginTime[0]+1 and currentTime[1]==beginTime[1]):
        print("Time is up!")
        return False
    return True

#Zähler für die Treffer, Misses und Clicks (um die Trefferquote zu berechnen) des Spielers
score = 0
misses = 0
clicks = 0

#Rundenzähler um zeitabhängige Aktionen durchzuführen
ticks = 0

#der Radius eines Kreises ist wichtig, damit der Kreis komplett auf dem Bildschirm angezeigt wird
#wird nach und nach kleiner
radius = 10

#Länge und Breite der Oberfläche
x = 1000
y = 500

#um zu checken, ob ein Kreis gerade angeklickt wurde
#circleIsSet = False

screen = initialize()
beginTime = timer()
print(beginTime)

circle_pos = createRandomCircle()

while(timeNotOver(beginTime)):
    #jede Sekunde wird der Kreis auf eine neue Position gesetzt -> man muss schnell sein, um ihn zu erwischen
    if(ticks%14==0):
        circle_pos = updateCircle(circle_pos)
        misses += 1
    #bevor der Kreis neu gesetzt wird, verschwindet er kurz
    if (ticks % 14 == 13):
        deleteCircle(circle_pos)
    #Aktionen des Spielers
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
        if event.type == pygame.MOUSEBUTTONUP:
            clicks += 1
            mouse_pos = pygame.mouse.get_pos()
            #Satz des Pythagoras um den Abstand der Mitte des Kreises zum angeklickten Punkt zu bestimmen
            difference = math.sqrt(pow(circle_pos[0]-mouse_pos[0],2)+pow(circle_pos[1]-mouse_pos[1],2))
            #wenn der Abstand kleiner als der Radius ist, dann hat der Spieler den Kreis getroffen
            if(difference<10):
                #Spieler hat einen Treffer gelandet
                print(difference)
                score = score+1
                ticks = 0
                circle_pos = updateCircle(circle_pos)

    #update alle 100 Millisekunden
    pygame.time.delay(100)
    pygame.display.update()
    ticks+=1

#wenn Zeit zu Ende gelaufen ist, schließt sich das Fenster
pygame.quit()
print(f"Score: {score} || Misses: {misses} || Trefferquote: {score/clicks}")