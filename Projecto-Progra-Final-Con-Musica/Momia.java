import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Momia here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Momia extends Actor
{
    private int counter = 0;

    public Momia ()
    {
        GreenfootImage myImage = getImage();
        int myNewHeight = (int)myImage.getHeight()/15;
        int myNewWidth = (int)myImage.getWidth()/15;
        myImage.scale(myNewWidth, myNewHeight);
    }
    int rightSideOfScreen;
    int bottomOfScreen;

    public void addedToWorld(World grass)
    {
        rightSideOfScreen = grass.getWidth() - 1;
        bottomOfScreen = grass.getWidth() - 1;
    }

    public void act()
    {
        move(3);
        if(Greenfoot.getRandomNumber(20)==1)
        {
            setRotation(Greenfoot.getRandomNumber(360));
        }

        int x = getX();
        int y = getY();

        if(x<=0 || y<=0 || x>= rightSideOfScreen || y>= bottomOfScreen)
        {
            turn(180);
        }
        counter = counter +1;
        if (counter == 500)
        {
            ((MyWorld)getWorld()).removeObject(this);
        }

    }

}

