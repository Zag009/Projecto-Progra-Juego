import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bat extends Actor
{
    private int counter = 0;
    public Bat ()
    {
        GreenfootImage myImage = getImage();
        int myNewHeight = (int)myImage.getHeight()/12;
        int myNewWidth = (int)myImage.getWidth()/12;
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
        move(12);
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
        if (counter == 600)
        {
            ((MyWorld)getWorld()).removeObject(this);
        }
    }
}
